package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.File;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the FileComparator class
 *
 * @author Ciaron Rider
 */
public class FileComparatorTest {
    /**
     * Test of compare method, of class FileComparator.
     */
    @Test
    public void testCompare() {
        final File first = new File();
        final File second = new File();
        final FileComparator fileComparator = new FileComparator();

        first.setDate(1);
        second.setDate(2);
        Assert.assertEquals(-1, fileComparator.compare(first, second));
        Assert.assertEquals(1, fileComparator.compare(second, first));
        Assert.assertEquals(0, fileComparator.compare(first, first));
        Assert.assertEquals(0, fileComparator.compare(second, second));

        first.setDate(2);
        second.setDate(2);
        Assert.assertEquals(0, fileComparator.compare(first, second));

        Assert.assertEquals(1, fileComparator.compare(first, null));
        Assert.assertEquals(-1, fileComparator.compare(null, second));
        Assert.assertEquals(0, fileComparator.compare(null, null));
    }
}
