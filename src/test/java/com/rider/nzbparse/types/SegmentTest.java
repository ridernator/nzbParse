package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the Segment class
 *
 * @author Ciaron Rider
 */
public class SegmentTest {
    /**
     * Test of getSizeInBytes and setSizeInBytes methods, of class Segment.
     */
    @Test
    public void testGetSizeInBytes() {
        final Segment segment = new Segment(1, "testName", 2);
        Assert.assertEquals("Constructor in \"Segment\" does not set \"sizeInBytes\"", 2, segment.getSizeInBytes());

        segment.setSizeInBytes(10);
        Assert.assertEquals("Error in \"getSizeInBytes\" or \"setSizeInBytes\" in \"Segment\"", 10, segment.getSizeInBytes());
    }

    /**
     * Test of getIndex and setIndex methods, of class Segment.
     */
    @Test
    public void testGetIndex() {
        final Segment segment = new Segment(1, "testName", 2);
        Assert.assertEquals("Constructor in \"Segment\" does not set \"index\"", 1, segment.getIndex());

        segment.setIndex(10);
        Assert.assertEquals("Error in \"getIndex\" or \"setIndex\" in \"Segment\"", 10, segment.getIndex());
    }

    /**
     * Test of getName and setName methods, of class Segment.
     */
    @Test
    public void testGetName() {
        final Segment segment = new Segment(1, "testName", 2);
        Assert.assertEquals("Constructor in \"Segment\" does not set \"name\"", "testName", segment.getName());

        segment.setName("otherTestName");
        Assert.assertEquals("Error in \"getName\" or \"setName\" in \"Segment\"", "otherTestName", segment.getName());
    }

    /**
     * Test of copy constructor, of class Segment.
     */
    @Test
    public void testCopy() {
        final Segment segment = new Segment(1, "testName", 2);
        Segment copyTo = new Segment(segment);

        Assert.assertEquals("Copy constructor in \"Segment\" does not set \"index\"", 1, copyTo.getIndex());
        Assert.assertEquals("Copy constructor in \"Segment\" does not set \"name\"", "testName", copyTo.getName());
        Assert.assertEquals("Copy constructor in \"Segment\" does not set \"sizeInBytes\"", 2, copyTo.getSizeInBytes());

        try {
            copyTo = new Segment(null);
            Assert.fail("Passing null to copy constructor of \"Segment\" did not throw NullPointerException");
        } catch (final NullPointerException exception) {
            // Expected
        }
    }

    /**
     * Test of equals, of class Segment.
     */
    @Test
    public void testEquals() {
        final Segment segment = new Segment(1, "testName", 2);
        final Segment segment2 = new Segment(1, "testName", 2);

        Assert.assertEquals("Error in \"equals\" method of \"Segment\"", segment, segment2);

        Segment segment3 = new Segment(1, "testName", 3);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", segment, segment3);

        segment3 = new Segment(3, "testName", 2);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", segment, segment3);

        segment3 = new Segment(1, "testName2", 2);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", segment, segment3);
    }
}
