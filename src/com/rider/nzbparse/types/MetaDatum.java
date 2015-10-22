package com.rider.nzbparse.types;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A metadatum concerning a nzb.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "meta")
public final class MetaDatum {
    /**
     * The type (The Name in the Name->Value pair).
     */
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String type;

    /**
     * The value (The Value in the Name->Value pair).
     */
    @XmlValue
    private String value;

    /**
     * Constructor for this class
     */
    public MetaDatum() {
        // Do nothing
    }

    /**
     * Constructor for this class
     *
     * @param name The value to set
     * @param value The value to set
     */
    public MetaDatum(final String name,
                     final String value) {
        setName(name);
        setValue(value);
    }

    /**
     * Copy constructor
     *
     * @param metaDatum The metaDatum to copy from
     */
    public MetaDatum(final MetaDatum metaDatum) {
        if (metaDatum != null) {
            setName(metaDatum.getName());
            setValue(metaDatum.getValue());
        }
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof MetaDatum)) {
            return false;
        }

        final MetaDatum otherMetaDatum = (MetaDatum) other;

        if (getName() == null) {
            if (otherMetaDatum.getName() != null) {
                return false;
            }
        } else {
            if (!getName().equals(otherMetaDatum.getName())) {
                return false;
            }
        }

        if (getValue() == null) {
            if (otherMetaDatum.getValue() != null) {
                return false;
            }
        } else {
            if (!getValue().equals(otherMetaDatum.getValue())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Get the name in the Name->Value pair.
     *
     * @return The name in the Name->Value pair
     */
    public String getName() {
        return type;
    }

    /**
     * Get the name in the Name->Value pair.
     *
     * @param name The name to set
     */
    public void setName(final String name) {
        type = name;
    }

    /**
     * Get the value in the Name->Value pair.
     *
     * @return The value in the Name->Value pair
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the value in the Name->Value pair.
     *
     * @param value The value to set
     */
    public void setValue(final String value) {
        this.value = value;
    }
}
