package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.FileItem;
import java.util.Comparator;

/**
 * Compare two FileItem objects by comparing their dates.
 *
 * @author Ciaron Rider
 */
public class FileItemComparator implements Comparator<FileItem> {
    @Override
    public int compare(final FileItem first,
                       final FileItem second) {
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
