package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.FileItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the FileItemComparator class.
 *
 * @author Ciaron Rider
 */
public class FileComparatorTest {
    /**
     * Test of compare method, of class FileItemComparator.
     */
    @Test
    public void testCompare() {
        final FileItem first = new FileItem();
        final FileItem second = new FileItem();
        final FileItemComparator fileComparator = new FileItemComparator();

        first.setDate(1);
        second.setDate(2);
        Assert.assertEquals(-1, fileComparator.compare(first, second));
        Assert.assertEquals(1, fileComparator.compare(second, first));
        Assert.assertEquals(0, fileComparator.compare(first, first));
        Assert.assertEquals(0, fileComparator.compare(second, second));

        first.setDate(2);
        second.setDate(2);
        Assert.assertEquals(0, fileComparator.compare(first, second));
    }

    /**
     * Test of compare method, of class FileItemComparator. This time with
     * nulls.
     */
    @Test
    public void testCompareWithNulls() {
        final FileItem file = new FileItem();
        final FileItemComparator fileComparator = new FileItemComparator();

        Assert.assertEquals(1, fileComparator.compare(file, null));
        Assert.assertEquals(-1, fileComparator.compare(null, file));
        Assert.assertEquals(0, fileComparator.compare(null, null));
    }
}
