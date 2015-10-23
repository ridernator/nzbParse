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
        Assert.assertEquals("Constructor in \"Group\" does not set \"name\"", "testName", group.getName());

        group.setName("otherTestName");
        Assert.assertEquals("\"setName\" or \"getName\" error in \"Group\"", "otherTestName", group.getName());
    }

    /**
     * Test of copy constructor, of class Group.
     */
    @Test
    public void testCopy() {
        final Group group = new Group("testName");
        Group copyTo = new Group(group);

        Assert.assertEquals("Copy constructor in \"Group\" does not set \"name\"", "testName", copyTo.getName());

        try {
            copyTo = new Group((Group)null);
            Assert.fail("Passing null to copy constructor of \"Group\" did not throw NullPointerException");
        } catch (final NullPointerException exception) {
            // Expected
        }
    }

    /**
     * Test of equals, of class Group.
     */
    @Test
    public void testEquals() {
        final Group group = new Group("testName");
        final Group group2 = new Group("testName");
        final Group group3 = new Group("testName2");

        Assert.assertEquals("Error in \"equals\" method of \"Group\"", group, group2);
        Assert.assertNotSame("Error in \"equals\" method of \"Group\"", group, group3);
    }
}
