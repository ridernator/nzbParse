package com.rider.nzbparse.types;

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
public class MetaDatum {
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
    public void setType(final String name) {
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
