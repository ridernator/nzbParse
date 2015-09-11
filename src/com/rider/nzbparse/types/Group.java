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
     * Constructor for this class
     */
    public Group() {
        // Do nothing
    }

    /**
     * Constructor for this class
     *
     * @param name The name to set
     */
    public Group(final String name) {
        setName(name);
    }

    /**
     * Copy constructor
     *
     * @param group The group to copy from
     */
    public Group(final Group group) {
        setName(group.getName());
    }

    @Override
    public boolean equals(final Object other) {
        boolean returnVal = false;

        if (other instanceof Group) {
            if (((Group) other).getName().equals(getName())) {
                returnVal = true;
            }
        }

        return returnVal;
    }

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
