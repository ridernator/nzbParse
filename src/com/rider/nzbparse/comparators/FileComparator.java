package com.rider.nzbparse.comparators;

import com.rider.nzbparse.types.File;
import java.util.Comparator;

/**
 *
 * @author rider
 */
public class FileComparator implements Comparator<File> {
    @Override
    public int compare(final File first,
                       final File second) {
        return Long.compare(Long.valueOf(first.getDate()), Long.valueOf(second.getDate()));
    }
}
