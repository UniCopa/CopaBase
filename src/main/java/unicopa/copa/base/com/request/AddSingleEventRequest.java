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
package unicopa.copa.base.com.request;

import unicopa.copa.base.event.SingleEvent;

/**
 * Add a new SingleEvent to an Event.
 * 
 * @author Felix Wiemuth
 */
public class AddSingleEventRequest extends AbstractRequest {
    private int eventID;
    private SingleEvent newSingleEvent;
    private String comment;

    /**
     * Create the request.
     * 
     * @param eventID
     *            the ID of the event where to add the SingleEvent
     * @param newSingleEvent
     *            the SingleEvent to add (the ID is ignored)
     * @param comment
     *            the comment that shall be displayed in the resulting
     *            SingleEventUpdate
     */
    public AddSingleEventRequest(int eventID, SingleEvent newSingleEvent,
	    String comment) {
	throw new UnsupportedOperationException();
    }

    public int getEventID() {
	return this.eventID;
    }

    public SingleEvent getNewSingleEvent() {
	return this.newSingleEvent;
    }

    public String getComment() {
	return this.comment;
    }
}
