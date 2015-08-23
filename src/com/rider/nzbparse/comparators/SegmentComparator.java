package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.Segment;
import java.util.Comparator;

/**
 * Compare two Segment objects by comparing their number fields
 *
 * @author Ciaron Rider
 */
public class SegmentComparator implements Comparator<Segment> {
    @Override
    public int compare(final Segment first,
                       final Segment second) {
        return Long.compare(Long.valueOf(first.getNumber()), Long.valueOf(second.getNumber()));
    }
}
