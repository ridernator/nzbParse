package com.rider.nzbparse.types;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents a file item in a NZB file.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "groups",
    "segments"
})
@XmlRootElement(name = "file")
public class FileItem {
    /**
     * The subject of the file.
     */
    @XmlAttribute(name = "subject", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String subject;

    /**
     * The email address of the poster of the file.
     */
    @XmlAttribute(name = "poster")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String poster;

    /**
     * The date the file was posted (in seconds since UNIX epoch).
     */
    @XmlAttribute(name = "date")
    private long date;

    /**
     * Groups object (Contains the groups the file is posted in).
     */
    private Groups groups;

    /**
     * Segments object (Contains all the segments of the file).
     */
    private Segments segments;

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
        if (groups == null) {
            groups = new Groups();
        }

        return groups.getGroups();
    }

    /**
     * Add a group to the list of groups this file has been posted in.
     *
     * @param group The Group to add
     */
    public void addGroup(final Group group) {
        if (groups == null) {
            groups = new Groups();
        }

        groups.addGroup(group);
    }

    /**
     * Get the list of segments which make up this file (Will not return null).
     *
     * @return The list of segments which make up this file
     */
    public List<Segment> getSegments() {
        if (segments == null) {
            segments = new Segments();
        }

        return segments.getSegments();
    }

    /**
     * Add a segment to the list of segments which make up this file.
     *
     * @param segment The segment to add
     */
    public void addSegment(final Segment segment) {
        if (segments == null) {
            segments = new Segments();
        }

        segments.addSegment(segment);
    }

    /**
     * Sort the segments in this file by index.
     */
    public void sort() {
        segments.sort();
    }
}
