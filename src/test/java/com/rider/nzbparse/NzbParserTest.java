package com.rider.nzbparse;

import com.rider.nzbparse.types.FileItem;
import com.rider.nzbparse.types.Group;
import com.rider.nzbparse.types.MetaDatum;
import com.rider.nzbparse.types.Nzb;
import com.rider.nzbparse.types.Segment;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

/**
 * Test of the NzbParser class
 *
 * @author Ciaron Rider
 */
public class NzbParserTest {
    /**
     * Test of marshal / unmarshal, of class NzbParser.
     */
    @Test
    public void testMarshal() {
        try {
            final NzbParser parser = new NzbParser();

            final Nzb nzbOut = new Nzb();
            final FileItem file1 = new FileItem("subject1", "poster1", 1);
            final FileItem file2 = new FileItem("subject2", "poster2", 2);
            final Segment segment1 = new Segment(0, "seg1", 10);
            final Segment segment2 = new Segment(1, "seg2", 20);
            final Segment segment3 = new Segment(0, "seg3", 30);
            final Segment segment4 = new Segment(1, "seg4", 40);
            final Group group1 = new Group("group1");
            final Group group2 = new Group("group2");
            final MetaDatum metadatum1 = new MetaDatum("key1", "value1");

            file1.addGroup(group1);
            file1.addSegment(segment1);
            file1.addSegment(segment2);

            file2.addGroup(group2);
            file2.addSegment(segment3);
            file2.addSegment(segment4);

            nzbOut.addFile(file1);
            nzbOut.addFile(file2);

            nzbOut.addMetaDatum(metadatum1);

            parser.marshal(nzbOut, "nzb.nzb");

            final Nzb nzbIn = parser.unmarshal("nzb.nzb");

            Assert.assertEquals("nzb file read in differs fron nzb file written out", nzbOut, nzbIn);
        } catch (final ParserConfigurationException exception) {
            Assert.fail("ParserConfigurationException while testing \"marshal\" in \"NzbParser\"");
        } catch (final SAXNotSupportedException exception) {
            Assert.fail("SAXNotSupportedException while testing \"marshal\" in \"NzbParser\"");
        } catch (final SAXException exception) {
            Assert.fail("SAXException while testing \"marshal\" in \"NzbParser\"");
        } catch (final JAXBException exception) {
            Assert.fail("JAXBException while testing \"marshal\" in \"NzbParser\"");
        } catch (final FileNotFoundException exception) {
            Assert.fail("FileNotFoundException while testing \"marshal\" in \"NzbParser\"");
        }
    }
}
