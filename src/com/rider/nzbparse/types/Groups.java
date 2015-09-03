package com.rider.nzbparse.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Groups object which contains a list of groups.
 *
 * @author Ciaron Rider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "group"
})
@XmlRootElement(name = "groups")
public class Groups {
    /**
     * The list of groups.
     */
    private List<Group> group;

    /**
     * Get the list of groups (Never returns null).
     *
     * @return The list of groups
     */
    public List<Group> getGroups() {
        if (group == null) {
            group = new ArrayList<>();
        }

        return Collections.unmodifiableList(group);
    }

    /**
     * Add a group to the list of groups.
     *
     * @param group The group to add
     */
    public void addGroup(final Group group) {
        if (this.group == null) {
            this.group = new ArrayList<>();
        }

        this.group.add(group);
    }
}
