package com.rider.nzbparse.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * A usenet group.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name"
})
@XmlRootElement(name = "group")
public class Group {
    /**
     * The name of the group.
     */
    @XmlValue
    private String name;

    /**
     * Get the name of the group.
     *
     * @return The name of the group
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the group.
     *
     * @param name The name to set
     */
    public void setName(final String name) {
        this.name = name;
    }
}
