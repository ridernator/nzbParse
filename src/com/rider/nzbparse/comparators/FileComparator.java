package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.File;
import java.util.Comparator;

/**
 * Compare two File objects by comparing their dates
 *
 * @author Ciaron Rider
 */
public class FileComparator implements Comparator<File> {
    @Override
    public int compare(final File first,
                       final File second) {
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
            // If first and second are not null, then compare their dates as longs
            returnVal = Long.compare(first.getDate(), second.getDate());
        }

        return returnVal;
    }
}
