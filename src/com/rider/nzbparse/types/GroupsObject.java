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
 * Groups object which contains a list of groups. Never needs to be seen by the
 * end user
 *
 * @author Ciaron Rider
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class GroupsObject {
    /**
     * The list of groups.
     */
    @XmlElement(name = "group")
    private List<Group> groups;

    /**
     * Protected constructor. Users never need see this
     */
    protected GroupsObject() {
        // Do nothing
    }

    /**
     * Get the list of groups (Never returns null).
     *
     * @return The list of groups
     */
    protected List<Group> getGroups() {
        if (groups == null) {
            groups = new ArrayList<>();
        }

        return Collections.unmodifiableList(groups);
    }

    /**
     * Add a group to the list of groups.
     *
     * @param group The group to add
     */
    protected void addGroup(final Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }

        groups.add(group);
    }

    /**
     * Add groups to the list of groups.
     *
     * @param newGroups The new groups to add
     */
    protected void addGroups(final Collection<? extends Group> newGroups) {
        if (groups == null) {
            groups = new ArrayList<>();
        }

        groups.addAll(newGroups);
    }

    /**
     * Remove a group from the list of groups.
     *
     * @param group The group to remove
     */
    protected void removeGroup(final Group group) {
        if (groups == null) {
            groups.remove(group);
        }
    }

    /**
     * Remove all groups from the list of groups.
     */
    protected void clearGroups() {
        if (groups == null) {
            groups.clear();
        }
    }
}
