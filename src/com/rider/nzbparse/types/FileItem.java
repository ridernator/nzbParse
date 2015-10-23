package com.rider.nzbparse.types;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a file item in a NZB file.
 *
 * @author Ciaron Rider
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class FileItem {
    /**
     * The subject of the file.
     */
    @XmlAttribute
    private String subject;

    /**
     * The email address of the poster of the file.
     */
    @XmlAttribute
    private String poster;

    /**
     * The date the file was posted (in seconds since UNIX epoch).
     */
    @XmlAttribute
    private long date;

    /**
     * GroupsObject object (Contains the groups the file is posted in).
     */
    @XmlElement(name = "groups")
    private GroupsObject groupsObject;

    /**
     * SegmentsObject object (Contains all the segments of the file).
     */
    @XmlElement(name = "segments")
    private SegmentsObject segmentsObject;

    /**
     * Get the subject of the file.
     *
     * @return The subject of the file
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the subject of the file.
     *
     * @param subject The subject of the file
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Get the poster of the file.
     *
     * @return The poster of the file
     */
    public String getPoster() {
        return poster;
    }

    /**
     * Set the poster of the file.
     *
     * @param poster The poster of the file
     */
    public void setPoster(final String poster) {
        this.poster = poster;
    }

    /**
     * Get the date the file was posted.
     *
     * @return The date the file was posted
     */
    public long getDate() {
        return date;
    }

    /**
     * Set the date the file was posted.
     *
     * @param date The date the file was posted
     */
    public void setDate(final long date) {
        this.date = date;
    }

    /**
     * Get the list of groups this file file has been posted in (Will not return
     * null).
     *
     * @return The list of groups
     */
    public List<Group> getGroups() {
        if (groupsObject == null) {
            groupsObject = new GroupsObject();
        }

        return groupsObject.getGroups();
    }

    /**
     * Add a group to the list of groups this file has been posted in.
     *
     * @param group The Group to add
     */
    public void addGroup(final Group group) {
        if (groupsObject == null) {
            groupsObject = new GroupsObject();
        }

        groupsObject.addGroup(group);
    }

    /**
     * Add groups to the list of groups this file has been posted in.
     *
     * @param groups The GroupsObject to add
     */
    public void addGroups(final Collection<? extends Group> groups) {
        if (groupsObject == null) {
            groupsObject = new GroupsObject();
        }

        groupsObject.addGroups(groups);
    }

    /**
     * Remove a group from the list of groups this file has been posted in.
     *
     * @param group The Group to remove
     */
    public void removeGroup(final Group group) {
        if (groupsObject != null) {
            groupsObject.removeGroup(group);
        }
    }

    /**
     * Remove all groups from the list of groups this file has been posted in.
     */
    public void clearGroups() {
        if (groupsObject != null) {
            groupsObject.clearGroups();
        }
    }

    /**
     * Get the list of segments which make up this file (Will not return null).
     *
     * @return The list of segments which make up this file
     */
    public List<Segment> getSegments() {
        if (segmentsObject == null) {
            segmentsObject = new SegmentsObject();
        }

        return segmentsObject.getSegments();
    }

    /**
     * Add a segment to the list of segments which make up this file.
     *
     * @param segment The segment to add
     */
    public void addSegment(final Segment segment) {
        if (segmentsObject == null) {
            segmentsObject = new SegmentsObject();
        }

        segmentsObject.addSegment(segment);
    }

    /**
     * Add segments to the list of segments which make up this file.
     *
     * @param segments The segments to add
     */
    public void addSegments(final Collection<? extends Segment> segments) {
        if (segmentsObject == null) {
            segmentsObject = new SegmentsObject();
        }

        segmentsObject.addSegments(segments);
    }

    /**
     * Remove a segment from the list of segments which make up this file.
     *
     * @param segment The segment to remove
     */
    public void removeSegment(final Segment segment) {
        if (segmentsObject != null) {
            segmentsObject.removeSegment(segment);
        }
    }

    /**
     * Remove all segments from the list of segments which make up this file.
     */
    public void clearSegment() {
        if (segmentsObject != null) {
            segmentsObject.clearSegments();
        }
    }

    /**
     * Sort the segments in this file by index.
     */
    public void sort() {
        segmentsObject.sort();
    }
}
