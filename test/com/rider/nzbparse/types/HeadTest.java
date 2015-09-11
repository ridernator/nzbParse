package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the Head class
 *
 * @author Ciaron Rider
 */
public class HeadTest {
    /**
     * Test of addMetaDatum and getMetaData methods, of class Head.
     */
    @Test
    public void testAddMetaDatum() {
        final Head head = new Head();
        Assert.assertEquals(0, head.getMetadata().size());

        final MetaDatum metaDatum1 = new MetaDatum("testName", "testValue");
        head.addMetaDatum(metaDatum1);
        Assert.assertEquals(metaDatum1, head.getMetadata().get(0));

        final MetaDatum metaDatum2 = new MetaDatum("otherTestName", "otherTestValue");
        head.addMetaDatum(metaDatum2);
        Assert.assertEquals(metaDatum1, head.getMetadata().get(0));
        Assert.assertEquals(metaDatum2, head.getMetadata().get(1));
    }
}
