/*
 * Copyright (C) 2013 UniCoPA
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package unicopa.copa.base.event;

import java.util.List;

/**
 * An event that can have multiple fixed dates (SingleEvents).
 * 
 * @author Felix Wiemuth
 */
public class Event {

    private int eventID;
    private int eventGroupID;
    private String eventName;
    private List<Integer> categories;

    /**
     * Create a new Event object.
     * 
     * @param eventID
     * @param eventGroupID
     * @param eventName
     * @param categories
     */
    public Event(int eventID, int eventGroupID, String eventName,
	    List<Integer> categories) {
	this.eventID = eventID;
	this.eventGroupID = eventGroupID;
	this.eventName = eventName;
	this.categories = categories;
    }

    public Event() {
    }

    /**
     * Get the ID of this event. It is guaranteed to be unique under all
     * available Event objects in use of the system.
     * 
     * @return
     */
    public int getEventID() {
	return eventID;
    }

    /**
     * Get the ID of the group this event belongs to.
     * 
     * @return
     */
    public int getEventGroupID() {
	return eventGroupID;
    }

    /**
     * Get the name of this event.
     * 
     * @return
     */
    public String getEventName() {
	return eventName;
    }

    /**
     * Get all categories associated with this event. The categories are leaves
     * of the category tree.
     * 
     * @return the IDs of all leaves of the category tree this event is
     *         associated with
     */
    public List<Integer> getCategories() {
	return categories;
    }
}