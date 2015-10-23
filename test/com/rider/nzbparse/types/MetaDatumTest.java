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
        Assert.assertEquals("Constructor in \"MetaDatum\" does not set \"name\"", "testName", metaDatum.getName());

        metaDatum.setName("otherTestName");
        Assert.assertEquals("Error in \"getName\" or \"setName\" in \"MetaDatum\"", "otherTestName", metaDatum.getName());
    }

    /**
     * Test of getValue and setValue methods, of class MetaDatum.
     */
    @Test
    public void testGetValue() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        Assert.assertEquals("Constructor in \"MetaDatum\" does not set \"value\"", "testValue", metaDatum.getValue());

        metaDatum.setValue("otherTestValue");
        Assert.assertEquals("Error in \"getValue\" or \"setValue\" in \"MetaDatum\"", "otherTestValue", metaDatum.getValue());
    }

    /**
     * Test of copy constructor, of class MetaDatum.
     */
    @Test
    public void testCopy() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        final MetaDatum metaDatum2 = new MetaDatum(metaDatum);

        Assert.assertEquals("Copy constructor in \"MetaDatum\" does not set \"name\"", "testName", metaDatum2.getName());
        Assert.assertEquals("Copy constructor in \"MetaDatum\" does not set \"value\"", "testValue", metaDatum2.getValue());
    }

    /**
     * Test of equals, of class MetaDatum.
     */
    @Test
    public void testEquals() {
        final MetaDatum metaDatum = new MetaDatum("testName", "testValue");
        final MetaDatum metaDatum2 = new MetaDatum("testName", "testValue");

        Assert.assertEquals("Error in \"equals\" method of \"MetaDatum\"", metaDatum, metaDatum2);

        MetaDatum metaDatum3 = new MetaDatum("testName", "testValue2");
        Assert.assertNotSame("Error in \"equals\" method of \"MetaDatum\"", metaDatum, metaDatum3);

        metaDatum3 = new MetaDatum("testName2", "testValue");
        Assert.assertNotSame("Error in \"equals\" method of \"MetaDatum\"", metaDatum, metaDatum3);
    }
}
