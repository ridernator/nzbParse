package com.rider.nzbparse;

import com.rider.nzbparse.types.Nzb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
 * Class for marshalling and unmarshalling of nzb xml files / strings.
 *
 * @author Ciaron Rider
 */
public class NzbParser {
    /**
     * Used for unmarshalling files to Nzb objects.
     */
    private final XMLReader xmlReader;

    /**
     * Used for marshalling Nzb objects to file.
     */
    private final Marshaller marshaller;

    /**
     * Used for unmarshalling to Nzb objects.
     */
    private final Unmarshaller unmarshaller;

    /**
     * Constructor for this class.
     *
     * @throws javax.xml.parsers.ParserConfigurationException Problems with the
     * SAX parser
     * @throws org.xml.sax.SAXNotRecognizedException Problems with the SAX
     * parser
     * @throws org.xml.sax.SAXNotSupportedException Problems with the SAX parser
     * @throws javax.xml.bind.JAXBException If there is a problem creating the
     * marshaller / unmarshaller
     */
    public NzbParser() throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException, SAXException, JAXBException {
        // The SAXParserFactory used to create xml readers
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Stop trying to load dtd which no longer exists
        saxParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        // Create an XMLReader
        xmlReader = saxParserFactory.newSAXParser().getXMLReader();

        // Create a Marshaller
        marshaller = JAXBContext.newInstance(Nzb.class).createMarshaller();

        // Create a Unmarshaller
        unmarshaller = JAXBContext.newInstance(Nzb.class).createUnmarshaller();

        // Make output pretty
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    /**
     * Create an Nzb object from a file.
     *
     * @param file The file to read from
     * @return A new Nzb object (Or null if there was some error)
     * @throws java.io.FileNotFoundException If the file cannot be opened
     * @throws javax.xml.bind.JAXBException If there is a problem unmarshalling
     * the NZB
     */
    public Nzb unmarshal(final File file) throws FileNotFoundException, JAXBException {
        final InputSource inputSource = new InputSource(new FileReader(file));
        final SAXSource source = new SAXSource(xmlReader, inputSource);

        return (Nzb) unmarshaller.unmarshal(source);
    }

    /**
     * Create an Nzb object from a file.
     *
     * @param filename The name of the file to read from
     * @return A new Nzb object (Or null if there was some error)
     * @throws java.io.FileNotFoundException If the file cannot be opened
     * @throws javax.xml.bind.JAXBException If there is a problem unmarshalling
     * the NZB
     */
    public Nzb unmarshal(final String filename) throws FileNotFoundException, JAXBException {
        return unmarshal(new File(filename));
    }

    /**
     * Create an Nzb object from a URL.
     *
     * @param url The name of the url to read from
     * @return A new Nzb object (Or null if there was some error)
     * @throws java.io.IOException If there is a problem opening the URL
     * @throws javax.xml.bind.JAXBException If there is a problem unmarshalling
     * the NZB
     */
    public Nzb unmarshalUrl(final URL url) throws IOException, JAXBException {
        final InputSource inputSource = new InputSource(url.openStream());
        final SAXSource source = new SAXSource(xmlReader, inputSource);

        return (Nzb) unmarshaller.unmarshal(source);
    }

    /**
     * Create an Nzb object from a URL.
     *
     * @param url The name of the url to read from
     * @return A new Nzb object (Or null if there was some error)
     * @throws java.io.IOException If it is not a valid URL or there is a
     * problem opening the URL
     * @throws javax.xml.bind.JAXBException If there is a problem unmarshalling
     * the NZB
     */
    public Nzb unmarshalUrl(final String url) throws IOException, JAXBException {
        return unmarshalUrl(new URL(url));
    }

    /**
     * Create an nzb file from an Nzb object.
     *
     * @param nzb The Nzb object to marshal
     * @param filename The name of the file to output to
     * @throws javax.xml.bind.JAXBException If there is a problem marshalling
     * the file
     */
    public void marshal(final Nzb nzb,
                        final String filename) throws JAXBException {
        marshal(nzb, new File(filename));
    }

    /**
     * Create an nzb file from an Nzb object.
     *
     * @param nzb The Nzb object to marshal
     * @param file The file to output to
     * @throws javax.xml.bind.JAXBException If there is a problem marshalling
     * the file
     */
    public void marshal(final Nzb nzb,
                        final File file) throws JAXBException {
        marshaller.marshal(nzb, file);
    }

    /**
     * Test method. Reads an nzb file, sorts it by date and then outputs it.
     *
     * @param args First argument is the input file, second is the output file
     */
    public static void main(final String[] args) {
        if (args.length == 2) {
            try {
                final NzbParser parser = new NzbParser();
                final Nzb nzb = parser.unmarshal(new File(args[0]));

                nzb.organise();
                parser.marshal(nzb, args[1]);
            } catch (final ParserConfigurationException | JAXBException | FileNotFoundException exception) {
                System.err.println("Exception : \"" + exception.getMessage() + "\"");
            } catch (final SAXNotSupportedException exception) {
                System.err.println("Exception : \"" + exception.getMessage() + "\"");
            } catch (final SAXException exception) {
                System.err.println("Exception : \"" + exception.getMessage() + "\"");
            }
        } else {
            System.err.println("Usage : nzb.jar inFile outFile");
        }
    }
}
