package com.rider.nzbparse.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Head object which contains a list of metaData.
 *
 * @author Ciaron Rider
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Head {
    /**
     * The list of metaData.
     */
    @XmlElement(name = "meta")
    private List<MetaDatum> metaData;

    /**
     * Protected constructor. Users never need see this
     */
    protected Head() {
        // Do nothing
    }

    /**
     * Get the list of metaData (Never returns null).
     *
     * @return The list of metaData
     */
    protected List<MetaDatum> getMetaData() {
        if (metaData == null) {
            metaData = new ArrayList<>();
        }

        return Collections.unmodifiableList(metaData);
    }

    /**
     * Add a metaDatum to the list of metaData.
     *
     * @param metaDatum The metaDatum to add
     */
    protected void addMetaDatum(final MetaDatum metaDatum) {
        if (metaData == null) {
            metaData = new ArrayList<>();
        }

        metaData.add(metaDatum);
    }

    /**
     * Add metaData to the list of metaData.
     *
     * @param newMetaData The metaData to add
     */
    protected void addMetaData(final Collection<? extends MetaDatum> newMetaData) {
        if (metaData == null) {
            metaData = new ArrayList<>();
        }

        metaData.addAll(newMetaData);
    }

    /**
     * Remove a metaDatum from the list of metaData.
     *
     * @param metaDatum The metaDatum to remove
     */
    protected void removeMetaDatum(final MetaDatum metaDatum) {
        if (metaData != null) {
            metaData.remove(metaDatum);
        }
    }

    /**
     * Remove all metaData from the list of metaData.
     */
    protected void clearMetaData() {
        if (metaData != null) {
            metaData.clear();
        }
    }
}
