package com.rider.nzbparse;

import com.rider.nzbparse.types.Nzb;
import com.rider.nzbparse.types.Segment;
import com.rider.nzbparse.comparators.FileComparator;
import com.rider.nzbparse.comparators.SegmentComparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
 *
 * @author rider
 */
public class NzbParser {

    /**
     * @param args the command line arguments
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

    private final SAXParserFactory spf;

    private final FileComparator fileComparator;

    private final SegmentComparator segmentComparator;

    public NzbParser() {
        spf = SAXParserFactory.newInstance();
        fileComparator = new FileComparator();
        segmentComparator = new SegmentComparator();

        try {
            spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (final ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException exception) {
            System.err.println("Error turning off external DTD loading : " + exception.getMessage());
        }
    }

    public Nzb unmarshal(final File file) {
        Nzb returnVal = null;

        try {
            final XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            final InputSource inputSource = new InputSource(new FileReader("nzb.nzb"));
            final SAXSource source = new SAXSource(xmlReader, inputSource);
            final Unmarshaller unmarshaller = JAXBContext.newInstance(Nzb.class).createUnmarshaller();

            returnVal = (Nzb) unmarshaller.unmarshal(source);
        } catch (final ParserConfigurationException | SAXException | FileNotFoundException | JAXBException exception) {
            System.err.println("Error unmarshalling nzb : " + exception.getMessage());
        }

        return returnVal;
    }

    public boolean marshal(final Nzb nzb,
                           final String filename) {
        boolean returnVal = true;

        try {
            final Marshaller marshaller = JAXBContext.newInstance(Nzb.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(nzb, new File(filename));
        } catch (final JAXBException exception) {
            System.err.println("Error marshalling nzb : " + exception.getMessage());

            returnVal = false;
        }

        return returnVal;
    }

    public void organise(final Nzb nzb) {
        Collections.sort(nzb.getFile(), fileComparator);

        for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
            Collections.sort(file.getSegments().getSegment(), segmentComparator);
        }
    }

    public long calculateSize(final Nzb nzb) {
        long returnVal = 0;

        for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
            for (final Segment segment : file.getSegments().getSegment()) {
                returnVal += Long.valueOf(segment.getBytes());
            }
        }

        return returnVal;
    }

    public long calculateAge(final Nzb nzb) {
        return System.currentTimeMillis() - calculatePublishDate(nzb);
    }

    public long calculatePublishDate(final Nzb nzb) {
        long oldestDate = 0;

        if (!nzb.getFile().isEmpty()) {
            long date;

            oldestDate = Long.valueOf(nzb.getFile().get(0).getDate());

            for (final com.rider.nzbparse.types.File file : nzb.getFile()) {
                date = Long.valueOf(file.getDate());

                if (oldestDate > date) {
                    oldestDate = date;
                }
            }
        }

        // Convert from s to ms
        return oldestDate * 1000;
    }
}
