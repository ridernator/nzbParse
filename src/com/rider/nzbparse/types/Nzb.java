package com.rider.nzbparse.types;

import com.rider.nzbparse.comparators.FileItemComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Class which models an NZB file.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "head",
    "file"
})
@XmlRootElement(name = "nzb")
public class Nzb {
    /**
     * xmlns field.
     */
    @XmlAttribute(name = "xmlns")
    private String xmlns = "http://www.newzbin.com/DTD/2003/nzb";

    /**
     * Head object of the NZB which contains the metadata.
     */
    private Head head;

    /**
     * List of files which makes up the nzb.
     */
    private List<FileItem> file;

    /**
     * Used for comparing files
     */
    @XmlTransient
    private FileItemComparator fileComparator;

    /**
     * Get the metadata for this nzb.
     *
     * @return The metadata for this nzb
     */
    public List<MetaDatum> getMetadata() {
        if (head == null) {
            head = new Head();
        }

        return head.getMetadata();
    }

    /**
     * Add a metadatum to the nzb.
     *
     * @param metadatum The metadatum to add
     */
    public void addMetaDatum(final MetaDatum metadatum) {
        if (head == null) {
            head = new Head();
        }

        head.addMetaDatum(metadatum);
    }

    /**
     * Add metadata to the nzb.
     *
     * @param metadata The metadata to add
     */
    public void addMetaDatum(final Collection<? extends MetaDatum> metadata) {
        if (head == null) {
            head = new Head();
        }

        head.addMetaData(metadata);
    }

    /**
     * Remove a metadatum from the nzb.
     *
     * @param metadatum The metadatum to remove
     */
    public void removeMetaDatum(final MetaDatum metadatum) {
        if (head != null) {
            head.removeMetaDatum(metadatum);
        }
    }

    /**
     * Remove all metadata from the nzb.
     */
    public void clearMetaData() {
        if (head != null) {
            head.clearMetaData();
        }
    }

    /**
     * Get the list of files which makes up the nzb.
     *
     * @return The list of files
     */
    public List<FileItem> getFiles() {
        if (file == null) {
            file = new ArrayList<>();
        }

        return Collections.unmodifiableList(file);
    }

    /**
     * Add a file to the list of files.
     *
     * @param file The file to add
     */
    public void addFile(final FileItem file) {
        if (this.file == null) {
            this.file = new ArrayList<>();
        }

        this.file.add(file);
    }

    /**
     * Add files to the list of files.
     *
     * @param files The files to add
     */
    public void addFiles(final Collection<? extends FileItem> files) {
        if (file == null) {
            file = new ArrayList<>();
        }

        this.file.addAll(files);
    }

    /**
     * Remove a file from the list of files.
     *
     * @param file The file to remove
     */
    public void removeFile(final FileItem file) {
        if (this.file != null) {
            this.file.remove(file);
        }
    }

    /**
     * Remove all files from the list of files.
     */
    public void clearFiles() {
        if (this.file != null) {
            this.file.clear();
        }
    }

    /**
     * Organise the nzb so that its contents are sorted by date.
     */
    public void sort() {
        if (fileComparator == null) {
            fileComparator = new FileItemComparator();
        }

        // Sort files
        Collections.sort(file, fileComparator);

        // Sort segments of all files
        for (final FileItem file : getFiles()) {
            file.sort();
        }
    }

    /**
     * Calculate the size of the files that the nzb points to.
     *
     * @return The size of the files that the nzb points to
     */
    public long calculateSize() {
        long returnVal = 0;

        // For each file
        for (final FileItem file : getFiles()) {
            // If the file has any segments
            if (file.getSegments() != null) {
                // For each segment in the file
                for (final Segment segment : file.getSegments()) {
                    // Add the number of bytes in the segment to the total
                    returnVal += segment.getSizeInBytes();
                }
            }
        }

        return returnVal;
    }

    /**
     * Calculate the published date the oldest or newest item in the nzb.
     *
     * @param oldest If set to true then find the oldest, else find the newest
     * @return The published date (in ms since 1970) of the oldest or newest
     * item in the nzb
     */
    private long calculatePublishDateInMs(final boolean oldest) {
        long returnVal = 0;

        // If the nzb has some files
        if (!getFiles().isEmpty()) {
            // Set oldest date to the first file's date
            returnVal = getFiles().get(0).getDate();

            // For each file in the nzb
            for (final FileItem file : getFiles()) {
                if (oldest) { // Are we looking for the oldest
                    // If the files date is older than our stored date then set our stores date to the file's date
                    returnVal = Math.max(returnVal, file.getDate());
                } else { // Or the newest
                    // If the files date is newwe than our stored date then set our stores date to the file's date
                    returnVal = Math.min(returnVal, file.getDate());
                }
            }
        }

        // Convert from s to ms
        return returnVal * 1000;
    }

    /**
     * Calculate the age of the oldest item in an nzb.
     *
     * @return The age (in ms since 1970) of the oldest item in the nzb
     */
    public long calculateOldestAgeInMs() {
        return System.currentTimeMillis() - calculateOldestPublishDateInMs();
    }

    /**
     * Calculate the age of the oldest item in an nzb.
     *
     * @return The age (in ms since 1970) of the oldest item in the nzb
     */
    public long calculateNewestAgeInMs() {
        return System.currentTimeMillis() - calculateOldestPublishDateInMs();
    }

    /**
     * Calculate the published date the oldest item in the nzb.
     *
     * @return The published date (in ms since 1970) of the oldest item in the
     * nzb
     */
    public long calculateOldestPublishDateInMs() {
        return calculatePublishDateInMs(true);
    }

    /**
     * Calculate the published date the newest item in the nzb.
     *
     * @return The published date (in ms since 1970) of the newest item in the
     * nzb
     */
    public long calculateNewestPublishDateInMs() {
        return calculatePublishDateInMs(false);
    }

    /**
     * Calculate the published date the oldest item in the nzb.
     *
     * @return The published date of the oldest item in the nzb
     */
    public Date calculateOldestPublishDate() {
        return new Date(calculateOldestPublishDateInMs());
    }

    /**
     * Calculate the published date the newest item in the nzb.
     *
     * @return The published date of the newest item in the nzb
     */
    public Date calculateNewestPublishDate() {
        return new Date(calculateNewestPublishDateInMs());
    }
}
