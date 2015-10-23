package com.rider.nzbparse.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Segment object which represents 1 segment of a file.
 *
 * @author Ciaron Rider
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public final class Segment {
    /**
     * The number of bytes in the segment.
     */
    @XmlAttribute
    private long bytes;

    /**
     * The index of this segment in its file.
     */
    @XmlAttribute
    private long number;

    /**
     * The name of the segment.
     */
    @XmlValue
    private String value;

    /**
     * Constructor for this class
     */
    public Segment() {
        // Do nothing
    }

    /**
     * Constructor for this class
     *
     * @param index The value to set for index
     * @param name The value to set for name
     * @param sizeInBytes The value to set for sizeInBytes
     */
    public Segment(final long index,
                   final String name,
                   final long sizeInBytes) {
        setIndex(index);
        setName(name);
        setSizeInBytes(sizeInBytes);
    }

    /**
     * Copy constructor
     *
     * @param segment The segment to copy from
     */
    public Segment(final Segment segment) {
        if (segment != null) {
            setIndex(segment.getIndex());
            setName(segment.getName());
            setSizeInBytes(segment.getSizeInBytes());
        }
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Segment)) {
            return false;
        }

        final Segment otherSegment = (Segment) other;

        if (otherSegment.getIndex() != getIndex()) {
            return false;
        }

        if (otherSegment.getSizeInBytes() != getSizeInBytes()) {
            return false;
        }

        if (getName() == null) {
            if (otherSegment.getName() != null) {
                return false;
            }
        } else {
            if (!getName().equals(otherSegment.getName())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Get the size of the segment in bytes.
     *
     * @return The size of the segment in bytes
     */
    public long getSizeInBytes() {
        return bytes;
    }

    /**
     * Set the size of the segment in bytes.
     *
     * @param size The size to set
     */
    public void setSizeInBytes(final long size) {
        bytes = size;
    }

    /**
     * Get the index of the segment in its file.
     *
     * @return The index of the segment in its file
     */
    public long getIndex() {
        return number;
    }

    /**
     * Sets the index of the segment in its file.
     *
     * @param index The index to set
     */
    public void setIndex(final long index) {
        number = index;
    }

    /**
     * Get the name of the segment.
     *
     * @return The name of the segment
     */
    public String getName() {
        return value;
    }

    /**
     * Set the name of the segment.
     *
     * @param name The name to set
     */
    public void setName(final String name) {
        value = name;
    }
}
