package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.Segment;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the SegmentComparator class.
 *
 * @author Ciaron Rider
 */
public class SegmentComparatorTest {
    /**
     * Test of compare method, of class SegmentComparator.
     */
    @Test
    public void testCompare() {
        final Segment first = new Segment();
        final Segment second = new Segment();
        final SegmentComparator segmentComparator = new SegmentComparator();

        first.setIndex(1);
        second.setIndex(2);
        Assert.assertEquals(-1, segmentComparator.compare(first, second));
        Assert.assertEquals(1, segmentComparator.compare(second, first));
        Assert.assertEquals(0, segmentComparator.compare(first, first));
        Assert.assertEquals(0, segmentComparator.compare(second, second));

        first.setIndex(2);
        second.setIndex(2);
        Assert.assertEquals(0, segmentComparator.compare(first, second));
    }

    /**
     * Test of compare method, of class SegmentComparator. This time with nulls.
     */
    @Test
    public void testCompareWithNulls() {
        final Segment segment = new Segment();
        final SegmentComparator segmentComparator = new SegmentComparator();

        Assert.assertEquals(1, segmentComparator.compare(segment, null));
        Assert.assertEquals(-1, segmentComparator.compare(null, segment));
        Assert.assertEquals(0, segmentComparator.compare(null, null));
    }
}
