package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the MetaDatum class
 *
 * @author Ciaron Rider
 */
public class MetaDatumTest {
    /**
     * Test of getName and setName methods, of class MetaDatum.
     */
    @Test
    public void testGetName() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        Assert.assertEquals("testName", metaDatum.getName());

        metaDatum.setName("otherTestName");
        Assert.assertEquals("otherTestName", metaDatum.getName());
    }

    /**
     * Test of getValue and setValue methods, of class MetaDatum.
     */
    @Test
    public void testGetValue() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        Assert.assertEquals("testValue", metaDatum.getValue());

        metaDatum.setValue("otherTestValue");
        Assert.assertEquals("otherTestValue", metaDatum.getValue());
    }

    /**
     * Test of copy constructor, of class MetaDatum.
     */
    @Test
    public void testCopy() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        final MetaDatum metaDatum2 = new MetaDatum(metaDatum);
        
        Assert.assertEquals("testName", metaDatum2.getName());
        Assert.assertEquals("testValue", metaDatum2.getValue());
    }

    /**
     * Test of equals, of class MetaDatum.
     */
    @Test
    public void testEquals() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        final MetaDatum metaDatum2 = new MetaDatum("testName", "testValue");
        
        Assert.assertEquals(metaDatum, metaDatum2);
    }
}
