package com.rider.nzbparse.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Head object which contains a list of metadata.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meta"
})
@XmlRootElement(name = "head")
public class Head {
    /**
     * The list of metadata.
     */
    private List<MetaDatum> meta;

    /**
     * Protected constructor. Users never need see this
     */
    protected Head() {
        // Do nothing
    }

    /**
     * Get the list of metadata (Never returns null).
     *
     * @return The list of metadata
     */
    protected List<MetaDatum> getMetadata() {
        if (meta == null) {
            meta = new ArrayList<>();
        }

        return Collections.unmodifiableList(meta);
    }

    /**
     * Add a metadatum to the list of metadata.
     *
     * @param metadatum The metadatum to add
     */
    protected void addMetaDatum(final MetaDatum metadatum) {
        if (meta == null) {
            meta = new ArrayList<>();
        }

        meta.add(metadatum);
    }

    /**
     * Add metadata to the list of metadata.
     *
     * @param metadata The metadata to add
     */
    protected void addMetaData(final Collection<? extends MetaDatum> metadata) {
        if (meta == null) {
            meta = new ArrayList<>();
        }

        meta.addAll(metadata);
    }

    /**
     * Remove a metadatum from the list of metadata.
     *
     * @param metadatum The metadatum to remove
     */
    protected void removeMetaDatum(final MetaDatum metadatum) {
        if (meta != null) {
            meta.remove(metadatum);
        }
    }

    /**
     * Remove all metadata from the list of metadata.
     */
    protected void clearMetaData() {
        if (meta != null) {
            meta.clear();
        }
    }
}
