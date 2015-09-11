package com.rider.nzbparse.types;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the Groups class
 *
 * @author Ciaron Rider
 */
public class GroupsTest {
    /**
     * Test of addGroup and getGroups methods, of class Groups.
     */
    @Test
    public void testAddGroup() {
        final Groups groups = new Groups();
        Assert.assertEquals(0, groups.getGroups().size());

        final Group group1 = new Group("testName");
        groups.addGroup(group1);
        Assert.assertEquals(group1, groups.getGroups().get(0));

        final Group group2 = new Group("otherTestName");
        groups.addGroup(group2);
        Assert.assertEquals(group1, groups.getGroups().get(0));
        Assert.assertEquals(group2, groups.getGroups().get(1));
    }
}
