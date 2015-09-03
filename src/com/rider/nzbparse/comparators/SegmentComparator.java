package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.Segment;
import java.util.Comparator;

/**
 * Compare two Segment objects by comparing their number fields.
 *
 * @author Ciaron Rider
 */
public class SegmentComparator implements Comparator<Segment> {
    @Override
    public int compare(final Segment first,
                       final Segment second) {
        int returnVal;

        if (first == null) {
            if (second == null) {
                returnVal = 0; // If both first and second are null
            } else {
                returnVal = -1; // If first is null but second isn't
            }
        } else if (second == null) {
            returnVal = 1; // If second is null but first isn't
        } else {
            // If first and second are not null, then compare their numbers as longs
            returnVal = Long.compare(first.getIndex(), second.getIndex());
        }

        return returnVal;
    }
}
