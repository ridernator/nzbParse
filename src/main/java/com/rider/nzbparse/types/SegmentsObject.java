package com.rider.nzbparse.types;

import com.rider.nzbparse.comparators.SegmentComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Object which contains a list of segments. Never needs to be seen by the end
 * user.
 *
 * @author Ciaron Rider
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class SegmentsObject {
    /**
     * Used for comparing segments of files.
     */
    private SegmentComparator segmentComparator;

    /**
     * The list of segments.
     */
    @XmlElement(name = "segment")
    private List<Segment> segments;

    /**
     * Protected constructor. Users never need see this
     */
    protected SegmentsObject() {
        // Do nothing
    }

    /**
     * Get the list of segments.
     *
     * @return The list of segments
     */
    protected List<Segment> getSegments() {
        if (segments == null) {
            segments = new ArrayList<>();
        }

        return Collections.unmodifiableList(segments);
    }

    /**
     * Add a segment to the list of segments.
     *
     * @param segment The segment to add
     */
    protected void addSegment(final Segment segment) {
        if (segments == null) {
            segments = new ArrayList<>();
        }

        segments.add(segment);
    }

    /**
     * Add segments to the list of segments.
     *
     * @param newSegments The segments to add
     */
    protected void addSegments(final Collection<? extends Segment> newSegments) {
        if (segments == null) {
            segments = new ArrayList<>();
        }

        segments.addAll(newSegments);
    }

    /**
     * Remove a segment from the list of segments.
     *
     * @param segment The segment to remove
     */
    protected void removeSegment(final Segment segment) {
        if (segments != null) {
            segments.remove(segment);
        }
    }

    /**
     * Remove all segments from the list of segments.
     */
    protected void clearSegments() {
        if (segments != null) {
            segments.clear();
        }
    }

    /**
     * Sort the segments in this segments object by index
     */
    protected void sort() {
        if (segmentComparator == null) {
            segmentComparator = new SegmentComparator();
        }

        Collections.sort(segments, segmentComparator);
    }
}
