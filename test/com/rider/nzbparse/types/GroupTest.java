package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the Group class
 *
 * @author Ciaron Rider
 */
public class GroupTest {
    /**
     * Test of getName and setName methods, of class Group.
     */
    @Test
    public void testGetName() {
        final Group group = new Group("testName");
        Assert.assertEquals("testName", group.getName());

        group.setName("otherTestName");
        Assert.assertEquals("otherTestName", group.getName());
    }

    /**
     * Test of copy constructor, of class Group.
     */
    @Test
    public void testCopy() {
        final Group group = new Group("testName");
        final Group group2 = new Group(group);

        Assert.assertEquals("testName", group2.getName());
    }

    /**
     * Test of equals, of class Group.
     */
    @Test
    public void testEquals() {
        final Group group = new Group("testName");
        final Group group2 = new Group("testName");

        Assert.assertEquals(group, group2);
    }
}
