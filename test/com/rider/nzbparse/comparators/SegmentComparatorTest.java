package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.Segment;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the SegmentComparator class
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

        first.setNumber(1);
        second.setNumber(2);
        Assert.assertEquals(-1, segmentComparator.compare(first, second));
        Assert.assertEquals(1, segmentComparator.compare(second, first));
        Assert.assertEquals(0, segmentComparator.compare(first, first));
        Assert.assertEquals(0, segmentComparator.compare(second, second));

        first.setNumber(2);
        second.setNumber(2);
        Assert.assertEquals(0, segmentComparator.compare(first, second));
        
        Assert.assertEquals(1, segmentComparator.compare(first, null));
        Assert.assertEquals(-1, segmentComparator.compare(null, second));
        Assert.assertEquals(0, segmentComparator.compare(null, null));
    }
}
