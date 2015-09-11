package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the Segments class
 *
 * @author Ciaron Rider
 */
public class SegmentsTest {
    /**
     * Test of addSegment and getSegments methods, of class Segments.
     */
    @Test
    public void testAddSegment() {
        final Segments segments = new Segments();
        Assert.assertEquals(0, segments.getSegments().size());

        final Segment segment1 = new Segment(1, "testName", 2);
        segments.addSegment(segment1);
        Assert.assertEquals(segment1, segments.getSegments().get(0));

        final Segment segment2 = new Segment(2, "otherTestName", 3);
        segments.addSegment(segment2);
        Assert.assertEquals(segment1, segments.getSegments().get(0));
        Assert.assertEquals(segment2, segments.getSegments().get(1));
    }
}
