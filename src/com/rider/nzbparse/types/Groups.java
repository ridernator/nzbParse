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
 * Groups object which contains a list of groups. Never needs to be seen by the
 * end user
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
     * Protected constructor. Users never need see this
     */
    protected Groups() {
        // Do nothing
    }

    /**
     * Get the list of groups (Never returns null).
     *
     * @return The list of groups
     */
    protected List<Group> getGroups() {
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
    protected void addGroup(final Group group) {
        if (this.group == null) {
            this.group = new ArrayList<>();
        }

        this.group.add(group);
    }

    /**
     * Add groups to the list of groups.
     *
     * @param groups The group to add
     */
    protected void addGroups(final Collection<? extends Group> groups) {
        if (group == null) {
            group = new ArrayList<>();
        }

        group.addAll(groups);
    }

    /**
     * Remove a group from the list of groups.
     *
     * @param group The group to remove
     */
    protected void removeGroup(final Group group) {
        if (this.group == null) {
            this.group.remove(group);
        }
    }

    /**
     * Remove all groups from the list of groups.
     */
    protected void clearGroups() {
        if (this.group == null) {
            this.group.clear();
        }
    }
}
