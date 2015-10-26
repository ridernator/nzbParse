package com.rider.nzbparse.types;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the FileItem class
 *
 * @author Ciaron Rider
 */
public class FileItemTest {
    /**
     * Test of getDate and setDate methods, of class FileItem.
     */
    @Test
    public void testGetDate() {
        final FileItem fileItem = new FileItem("subject", "poster", 100);
        Assert.assertEquals("Constructor in \"FileItem\" does not set \"date\"", 100, fileItem.getDate());

        fileItem.setDate(200);
        Assert.assertEquals("Error in \"getDate\" or \"setDate\" in \"FileItem\"", 200, fileItem.getDate());
    }

    /**
     * Test of getDate and setDate methods, of class FileItem.
     */
    @Test
    public void testGetPoster() {
        final FileItem fileItem = new FileItem("subject", "poster", 100);
        Assert.assertEquals("Constructor in \"FileItem\" does not set \"poster\"", "poster", fileItem.getPoster());

        fileItem.setPoster("newPoster");
        Assert.assertEquals("Error in \"getPoster\" or \"setPoster\" in \"FileItem\"", "newPoster", fileItem.getPoster());
    }

    /**
     * Test of getDate and setDate methods, of class FileItem.
     */
    @Test
    public void testGetSubject() {
        final FileItem fileItem = new FileItem("subject", "poster", 100);
        Assert.assertEquals("Constructor in \"FileItem\" does not set \"subject\"", "subject", fileItem.getSubject());

        fileItem.setSubject("newSubject");
        Assert.assertEquals("Error in \"getSubject\" or \"setSubject\" in \"FileItem\"", "newSubject", fileItem.getSubject());
    }

    /**
     * Test of addGroup, of class FileItem.
     */
    @Test
    public void testAddGroup() {
        final FileItem fileItem = new FileItem();
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");

        fileItem.addGroup(group1);
        Assert.assertTrue("Error in \"addGroup\" in \"FileItem\"", fileItem.getGroups().contains(group1));

        fileItem.addGroup(group2);
        Assert.assertTrue("Error in \"addGroup\" in \"FileItem\"", fileItem.getGroups().contains(group2));
    }

    /**
     * Test of addGroups, of class FileItem.
     */
    @Test
    public void testAddGroups() {
        final FileItem fileItem = new FileItem();
        final List<Group> groups = new ArrayList<>();
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");

        groups.add(group1);
        groups.add(group2);

        fileItem.addGroups(groups);
        Assert.assertTrue("Error in \"addGroups\" in \"FileItem\"", fileItem.getGroups().contains(group1));
        Assert.assertTrue("Error in \"addGroups\" in \"FileItem\"", fileItem.getGroups().contains(group2));
    }

    /**
     * Test of removeGroup, of class FileItem.
     */
    @Test
    public void testRemoveGroup() {
        final FileItem fileItem = new FileItem();
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");

        fileItem.addGroup(group1);
        fileItem.addGroup(group2);

        fileItem.removeGroup(group1);
        Assert.assertFalse("Error in \"removeGroup\" in \"FileItem\"", fileItem.getGroups().contains(group1));
        Assert.assertTrue("Error in \"removeGroup\" in \"FileItem\"", fileItem.getGroups().contains(group2));

        fileItem.removeGroup(group2);
        Assert.assertFalse("Error in \"removeGroup\" in \"FileItem\"", fileItem.getGroups().contains(group2));
    }

    /**
     * Test of clearGroups, of class FileItem.
     */
    @Test
    public void testClearGroups() {
        final FileItem fileItem = new FileItem();
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");

        fileItem.addGroup(group1);
        fileItem.addGroup(group2);

        fileItem.clearGroups();
        Assert.assertFalse("Error in \"clearGroups\" in \"FileItem\"", fileItem.getGroups().contains(group1));
        Assert.assertFalse("Error in \"clearGroups\" in \"FileItem\"", fileItem.getGroups().contains(group2));
        Assert.assertEquals("Error in \"clearGroups\" in \"FileItem\"", 0, fileItem.getGroups().size());
    }

    /**
     * Test of addSegment, of class FileItem.
     */
    @Test
    public void testAddSegment() {
        final FileItem fileItem = new FileItem();
        final Segment segment1 = new Segment(1, "segment1", 2);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem.addSegment(segment1);
        Assert.assertTrue("Error in \"addSegment\" in \"FileItem\"", fileItem.getSegments().contains(segment1));

        fileItem.addSegment(segment2);
        Assert.assertTrue("Error in \"addSegment\" in \"FileItem\"", fileItem.getSegments().contains(segment2));
    }

    /**
     * Test of addSegments, of class FileItem.
     */
    @Test
    public void testAddSegments() {
        final FileItem fileItem = new FileItem();
        final List<Segment> segments = new ArrayList<>();
        final Segment segment1 = new Segment(1, "segment1", 1);
        final Segment segment2 = new Segment(2, "segment2", 2);

        segments.add(segment1);
        segments.add(segment2);

        fileItem.addSegments(segments);
        Assert.assertTrue("Error in \"addSegments\" in \"FileItem\"", fileItem.getSegments().contains(segment1));
        Assert.assertTrue("Error in \"addSegments\" in \"FileItem\"", fileItem.getSegments().contains(segment2));
    }

    /**
     * Test of removeSegment, of class FileItem.
     */
    @Test
    public void testRemoveSegment() {
        final FileItem fileItem = new FileItem();
        final Segment segment1 = new Segment(1, "segment1", 1);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem.addSegment(segment1);
        fileItem.addSegment(segment2);

        fileItem.removeSegment(segment1);
        Assert.assertFalse("Error in \"removeSegment\" in \"FileItem\"", fileItem.getSegments().contains(segment1));
        Assert.assertTrue("Error in \"removeSegment\" in \"FileItem\"", fileItem.getSegments().contains(segment2));

        fileItem.removeSegment(segment2);
        Assert.assertFalse("Error in \"removeSegment\" in \"FileItem\"", fileItem.getSegments().contains(segment2));
    }

    /**
     * Test of clearSegments, of class FileItem.
     */
    @Test
    public void testClearSegments() {
        final FileItem fileItem = new FileItem();
        final Segment segment1 = new Segment(1, "segment1", 1);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem.addSegment(segment1);
        fileItem.addSegment(segment2);

        fileItem.clearSegments();
        Assert.assertFalse("Error in \"clearSegments\" in \"FileItem\"", fileItem.getSegments().contains(segment1));
        Assert.assertFalse("Error in \"clearSegments\" in \"FileItem\"", fileItem.getSegments().contains(segment2));
        Assert.assertEquals("Error in \"clearSegments\" in \"FileItem\"", 0, fileItem.getSegments().size());
    }

    /**
     * Test of copy constructor, of class FileItem.
     */
    @Test
    public void testCopy() {
        final FileItem fileItem = new FileItem("subject", "poster", 100);
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");
        final Segment segment1 = new Segment(1, "segment1", 2);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem.addGroup(group1);
        fileItem.addGroup(group2);

        fileItem.addSegment(segment1);
        fileItem.addSegment(segment2);

        FileItem copyTo = new FileItem(fileItem);

        Assert.assertEquals("Copy constructor in \"FileItem\" does not set \"subject\"", "subject", copyTo.getSubject());
        Assert.assertEquals("Copy constructor in \"FileItem\" does not set \"poster\"", "poster", copyTo.getPoster());
        Assert.assertEquals("Copy constructor in \"FileItem\" does not set \"date\"", 100, copyTo.getDate());
        Assert.assertTrue("Copy constructor in \"FileItem\" does not set \"groups\" properly", copyTo.getGroups().contains(group1));
        Assert.assertTrue("Copy constructor in \"FileItem\" does not set \"groups\" properly", copyTo.getGroups().contains(group2));
        Assert.assertTrue("Copy constructor in \"FileItem\" does not set \"segments\" properly", copyTo.getSegments().contains(segment1));
        Assert.assertTrue("Copy constructor in \"FileItem\" does not set \"segments\" properly", copyTo.getSegments().contains(segment2));

        try {
            copyTo = new FileItem(null);
            Assert.fail("Passing null to copy constructor of \"FileItem\" did not throw NullPointerException");
        } catch (final NullPointerException exception) {
            // Expected
        }
    }

    /**
     * Test of sort, of class FileItem.
     */
    @Test
    public void testSort() {
        final FileItem fileItem = new FileItem("subject", "poster", 100);
        final Segment segment1 = new Segment(1, "segment1", 1);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem.addSegment(segment1);
        fileItem.addSegment(segment2);

        fileItem.sort();

        Assert.assertEquals("\"sort\" method in \"FileItem\" does not sort segments properly", segment1, fileItem.getSegments().get(0));
        Assert.assertEquals("\"sort\" method in \"FileItem\" does not sort segments properly", segment2, fileItem.getSegments().get(1));

        fileItem.clearSegments();
        fileItem.addSegment(segment2);
        fileItem.addSegment(segment1);

        fileItem.sort();

        Assert.assertEquals("\"sort\" method in \"FileItem\" does not sort segments properly", segment1, fileItem.getSegments().get(0));
        Assert.assertEquals("\"sort\" method in \"FileItem\" does not sort segments properly", segment2, fileItem.getSegments().get(1));
    }

    /**
     * Test of equals, of class FileItem.
     */
    @Test
    public void testEquals() {
        final FileItem fileItem1 = new FileItem("subject1", "poster1", 1);
        FileItem fileItem2 = new FileItem("subject1", "poster1", 1);
        final Group group1 = new Group("group1");
        final Group group2 = new Group("group2");
        final Segment segment1 = new Segment(1, "segment1", 2);
        final Segment segment2 = new Segment(2, "segment2", 2);

        fileItem1.addGroup(group1);
        fileItem1.addGroup(group2);

        fileItem1.addSegment(segment1);
        fileItem1.addSegment(segment2);

        fileItem2.addGroup(group1);
        fileItem2.addGroup(group2);

        fileItem2.addSegment(segment1);
        fileItem2.addSegment(segment2);

        Assert.assertEquals("Error in \"equals\" method of \"FileItem\"", fileItem1, fileItem2);

        fileItem2.removeGroup(group2);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", fileItem1, fileItem2);

        fileItem2.addGroup(group2);
        Assert.assertEquals("Error in \"equals\" method of \"FileItem\"", fileItem1, fileItem2);

        fileItem2.removeSegment(segment2);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", fileItem1, fileItem2);

        fileItem2.addSegment(segment2);
        Assert.assertEquals("Error in \"equals\" method of \"FileItem\"", fileItem1, fileItem2);

        fileItem2 = new FileItem("subject2", "poster1", 1);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", fileItem1, fileItem2);

        fileItem2 = new FileItem("subject1", "poster2", 1);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", fileItem1, fileItem2);

        fileItem2 = new FileItem("subject1", "poster1", 2);
        Assert.assertNotSame("Error in \"equals\" method of \"Segment\"", fileItem1, fileItem2);
    }
}
