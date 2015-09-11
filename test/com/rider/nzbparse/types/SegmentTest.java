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
        Assert.assertEquals(2, segment.getSizeInBytes());

        segment.setSizeInBytes(10);
        Assert.assertEquals(10, segment.getSizeInBytes());
    }

    /**
     * Test of getIndex and setIndex methods, of class Segment.
     */
    @Test
    public void testGetIndex() {
        final Segment segment = new Segment(1, "testName", 2);
        Assert.assertEquals(1, segment.getIndex());

        segment.setIndex(10);
        Assert.assertEquals(10, segment.getIndex());
    }

    /**
     * Test of getName and setName methods, of class Segment.
     */
    @Test
    public void testGetName() {
        final Segment segment = new Segment(1, "testName", 2);
        Assert.assertEquals("testName", segment.getName());

        segment.setName("otherTestName");
        Assert.assertEquals("otherTestName", segment.getName());
    }

    /**
     * Test of copy constructor, of class Segment.
     */
    @Test
    public void testCopy() {
        final Segment segment = new Segment(1, "testName", 2);
        final Segment segment2 = new Segment(segment);
        
        Assert.assertEquals(1, segment2.getIndex());
        Assert.assertEquals("testName", segment2.getName());
        Assert.assertEquals(2, segment2.getSizeInBytes());
    }

    /**
     * Test of equals, of class Segment.
     */
    @Test
    public void testEquals() {
        final Segment segment = new Segment(1, "testName", 2);
        final Segment segment2 = new Segment(1, "testName", 2);
        
        Assert.assertEquals(segment, segment2);
    }
}
