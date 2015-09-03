package com.rider.nzbparse.types;

import com.rider.nzbparse.comparators.SegmentComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Object which contains a list of segments.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "segment"
})
@XmlRootElement(name = "segments")
public class Segments {
    /**
     * Used for comparing segments of files.
     */
    @XmlTransient
    private SegmentComparator segmentComparator;

    /**
     * The list of segments.
     */
    private List<Segment> segment;

    /**
     * Get the list of segments.
     *
     * @return The list of segments
     */
    public List<Segment> getSegment() {
        if (segment == null) {
            segment = new ArrayList<>();
        }

        return Collections.unmodifiableList(segment);
    }

    /**
     * Add a segment to the list of segments.
     *
     * @param segment The segment to add
     */
    public void addSegment(final Segment segment) {
        if (this.segment == null) {
            this.segment = new ArrayList<>();
        }

        this.segment.add(segment);
    }

    /**
     * Sort the segments in this segments object by index
     */
    public void organise() {
        if (segmentComparator == null) {
            segmentComparator = new SegmentComparator();
        }

        Collections.sort(segment, segmentComparator);
    }
}
