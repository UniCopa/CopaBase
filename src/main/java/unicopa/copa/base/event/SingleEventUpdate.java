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

import java.util.Date;

/**
 * An update on a fixed date of an event (SingleEvent).
 * 
 * @author Felix Wiemuth
 */
public class SingleEventUpdate {

    private SingleEvent updatedSingleEvent;
    private int oldSingleEventID;
    private Date updateDate;
    private String creatorName;
    private String comment;

    /**
     * Create a new SingleEventUpdate. If the update should be a creation or
     * cancellation of a SingleEvent, use the correspondent constructors.
     * 
     * @param updatedSingleEvent
     *            the new version of the SingleEvent, or null if the update
     *            should be a cancellation of the former SingleEvent
     * @param oldSingleEventID
     *            the ID of the SingleEvent that should be updated, or 0 if this
     *            update should be a creation of a SingleEvent
     * @param updateDate
     *            the date of the update
     * @param creatorName
     *            the name of the person who introduced the update
     * @param comment
     *            a text to describe the update
     */
    public SingleEventUpdate(SingleEvent updatedSingleEvent,
	    int oldSingleEventID, Date updateDate, String creatorName,
	    String comment) {
	this.updatedSingleEvent = updatedSingleEvent;
	this.oldSingleEventID = oldSingleEventID;
	this.updateDate = updateDate;
	this.creatorName = creatorName;
	this.comment = comment;
    }

    /**
     * Create a SingleEventUpdate that is a creation of a SingleEvent.
     * 
     * @param newSingleEvent
     *            the SingleEvent to be added to the event
     * @param updateDate
     *            the date of the update
     * @param comment
     *            a text to describe the reason for the action or give further
     *            information
     */
    public SingleEventUpdate(SingleEvent newSingleEvent, Date updateDate,
	    String comment) {
	this(newSingleEvent, 0, null, null, comment);
    }

    /**
     * Create a SingleEventUpdate that is a cancellation of a SingleEvent.
     * 
     * @param oldSingleEventID
     *            the ID of the SingleEvent to be cancelled
     * @param updateDate
     *            the date of the update
     * @param comment
     *            a text to describe the reason for the action or give further
     *            information
     */
    public SingleEventUpdate(int oldSingleEventID, Date updateDate,
	    String comment) {
	this(null, oldSingleEventID, null, null, comment);
    }

    /**
     * Get the updated SingleEvent or null if the SingleEvent was cancelled.
     * Compare attributes to the old object to see changes.
     * 
     * @return the new SingleEvent object, or null if the fixed date was
     *         cancelled and there is no new SingelEvent
     */
    public SingleEvent getUpdatedSingleEvent() {
	return updatedSingleEvent;
    }

    /**
     * Get the ID of the SingleEvent that was updated and replaced by the new
     * one.
     * 
     * @return the ID of the SingleEvent that was updated or 0 if this update
     *         indicates a creation of a new SingleEvent
     */
    public int getOldSingleEventID() {
	return oldSingleEventID;
    }

    /**
     * Get the date of when the update was submitted.
     * 
     * @return
     */
    public Date getUpdateDate() {
	return updateDate;
    }

    /**
     * Get the name of the person who created the update.
     * 
     * @return
     */
    public String getCreatorName() {
	return creatorName;
    }

    /**
     * Get the comment the creator of the update added to give further
     * information.
     * 
     * @return
     */
    public String getComment() {
	return comment;
    }

    /**
     * Check whether this update stands for a creation of a SingleEvent.
     * 
     * @return true if the update stands for a creation of a SingleEvent
     */
    public boolean isSingleEventCreation() {
	return oldSingleEventID == 0;
    }

    /**
     * Check Check whether this update stands for a cancellation of a
     * SingleEvent.
     * 
     * @return true if this update stands for a cancellation of a SingleEvent.
     */
    public boolean isCancellation() {
	return updatedSingleEvent == null;
    }
}