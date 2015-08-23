package com.rider.nzbparse;

import com.rider.nzbparse.types.Nzb;
import com.rider.nzbparse.types.Segment;
import com.rider.nzbparse.comparators.FileComparator;
import com.rider.nzbparse.comparators.SegmentComparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 * Class for marshalling and unmarshalling of nzb xml files / strings
 *
 * @author Ciaron Rider
 */
public class NzbParser {
    /**
     * Used for unmarshalling files to Nzb objects
     */
    private XMLReader xmlReader;

    /**
     * Used for marshalling Nzb objects to file
     */
    private Marshaller marshaller;

    /**
     * Used for comparing files
     */
    private final FileComparator fileComparator;

    /**
     * Used for comparing segments of files
     */
    private final SegmentComparator segmentComparator;

    /**
     * Constructor for this class
     */
    public NzbParser() {
        // Comparators used for sorting the nzb
        fileComparator = new FileComparator();
        segmentComparator = new SegmentComparator();

        // The SAXParserFactory used to create xml readers
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Stop trying to load dtd which no longer exists
        try {
            saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (final ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException exception) {
            System.err.println("Error turning off external DTD loading : \"" + exception.getMessage() + '\"');
        }

        // Create an XMLReader
        try {
            xmlReader = saxParserFactory.newSAXParser().getXMLReader();
        } catch (final ParserConfigurationException | SAXException exception) {
            System.err.println("Error creating XMLReader : \"" + exception.getMessage() + '\"');
        }

        // Create a Marshaller
        try {
            marshaller = JAXBContext.newInstance(Nzb.class).createMarshaller();
        } catch (final JAXBException exception) {
            System.err.println("Error creating marshaller : \"" + exception.getMessage() + '\"');
        }

        // Make output pretty
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (final PropertyException exception) {
            System.err.println("Error setting pretty output on marshaller : \"" + exception.getMessage() + '\"');
        }
    }

    /**
     * Create an Nzb object from a file
     *
     * @param file The file to read from
     * @return A new Nzb object (Or null if there was some error)
     */
    public Nzb unmarshal(final File file) {
        Nzb returnVal = null;

        try {
            final InputSource inputSource = new InputSource(new FileReader("nzb.nzb"));
            final SAXSource source = new SAXSource(xmlReader, inputSource);
            final Unmarshaller unmarshaller = JAXBContext.newInstance(Nzb.class).createUnmarshaller();

            returnVal = (Nzb) unmarshaller.unmarshal(source);
        } catch (final FileNotFoundException | JAXBException exception) {
            System.err.println("Error unmarshalling nzb : \"" + exception.getMessage() + '\"');
        }

        return returnVal;
    }

    /**
     * Create an nzb file from an Nzb object
     *
     * @param nzb The Nzb object to marshal
     * @param filename The name of the file to output to
     * @return True if successful or false if not
     */
    public boolean marshal(final Nzb nzb,
                           final String filename) {
        boolean returnVal = true;

        try {
            marshaller.marshal(nzb, new File(filename));
        } catch (final JAXBException exception) {
            System.err.println("Error marshalling nzb : \"" + exception.getMessage() + '\"');

            returnVal = false;
        }

        return returnVal;
    }

    /**
     * Organise an nzb so that its contents are sorted by date
     *
     * @param nzb The nzb to organise
     */
    public void organise(final Nzb nzb) {
        // Sort files
        Collections.sort(nzb.getFile(), fileComparator);

        // Sort segments of all files
        for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
            Collections.sort(file.getSegments().getSegment(), segmentComparator);
        }
    }

    /**
     * Calculate the size of the files that the nzb points to
     *
     * @param nzb The nzb to use for the calculation
     * @return The size of the files that the nzb points to
     */
    public long calculateSize(final Nzb nzb) {
        long returnVal = 0;

        // For each file
        for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
            // For each segment in the file
            for (final Segment segment : file.getSegments().getSegment()) {
                // Add the number of bytes in the segment to the total
                returnVal += Long.valueOf(segment.getBytes());
            }
        }

        return returnVal;
    }

    /**
     * Calculate the published date the oldest or newest item in the nzb
     *
     * @param nzb The nzb to use for the calculation
     * @param oldest If set to true then find the oldest, else find the newest
     * @return The published date (in ms since 1970) of the oldest or newest item in the nzb
     */
    private long calculatePublishDateInMs(final Nzb nzb,
                                          final boolean oldest) {
        long returnVal = 0;

        // If the nzb has some files
        if (!nzb.getFile().isEmpty()) {
            long date;

            // Set oldest date to the first file's date
            returnVal = Long.valueOf(nzb.getFile().get(0).getDate());

            // For each file in the nzb
            for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
                date = Long.valueOf(file.getDate());

                if (oldest) { // Are we looking for the oldest
                    // If the files date is older than our stored date then set our stores date to the file's date
                    if (returnVal > date) {
                        returnVal = date;
                    }
                } else { // Or the newest
                    // If the files date is newwe than our stored date then set our stores date to the file's date
                    if (returnVal < date) {
                        returnVal = date;
                    }
                }
            }
        }

        // Convert from s to ms
        return returnVal * 1000;
    }

    /**
     * Calculate the age of the oldest item in an nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The age (in ms since 1970) of the oldest item in the nzb
     */
    public long calculateOldestAgeInMs(final Nzb nzb) {
        return System.currentTimeMillis() - calculateOldestPublishDateInMs(nzb);
    }

    /**
     * Calculate the age of the oldest item in an nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The age (in ms since 1970) of the oldest item in the nzb
     */
    public long calculateNewestAgeInMs(final Nzb nzb) {
        return System.currentTimeMillis() - calculateOldestPublishDateInMs(nzb);
    }

    /**
     * Calculate the published date the oldest item in the nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The published date (in ms since 1970) of the oldest item in the nzb
     */
    public long calculateOldestPublishDateInMs(final Nzb nzb) {
        return calculatePublishDateInMs(nzb, true);
    }

    /**
     * Calculate the published date the newest item in the nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The published date (in ms since 1970) of the newest item in the nzb
     */
    public long calculateNewestPublishDateInMs(final Nzb nzb) {
        return calculatePublishDateInMs(nzb, false);
    }

    /**
     * Calculate the published date the oldest item in the nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The published date of the oldest item in the nzb
     */
    public Date calculateOldestPublishDate(final Nzb nzb) {
        return new Date(calculateOldestPublishDateInMs(nzb));
    }

    /**
     * Calculate the published date the newest item in the nzb
     *
     * @param nzb The nzb to use for the calculation
     * @return The published date of the newest item in the nzb
     */
    public Date calculateNewestPublishDate(final Nzb nzb) {
        return new Date(calculateNewestPublishDateInMs(nzb));
    }

    /**
     * Test method. Reads an nzb file, sorts it by date and then outputs it
     *
     * @param args First argument is the input file, second is the output file
     */
    public static void main(final String[] args) {
        if (args.length == 2) {
            final NzbParser parser = new NzbParser();
            final Nzb nzb = parser.unmarshal(new File(args[0]));

            parser.organise(nzb);
            parser.marshal(nzb, args[1]);
        } else {
            System.err.println("Usage : nzb.jar inFile outFile");
        }
    }
}
