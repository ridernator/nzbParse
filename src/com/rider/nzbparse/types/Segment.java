package com.rider.nzbparse.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Segment object which represents 1 segment of a file.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "segment")
public class Segment {
    /**
     * The number of bytes in the segment.
     */
    @XmlAttribute(name = "bytes")
    private long bytes;

    /**
     * The index of this segment in its file.
     */
    @XmlAttribute(name = "number")
    private long number;

    /**
     * The name of the segment.
     */
    @XmlValue
    private String value;

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
