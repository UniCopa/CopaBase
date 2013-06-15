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
 * Add a new SingleEventUpdate to a SingleEvent.
 * 
 * @author Felix Wiemuth
 */
public class AddSingleEventUpdateRequest extends AbstractRequest {
    private SingleEvent updatedSingleEvent;
    private String comment;

    /**
     * Create the request.
     * 
     * @param updatedSingleEvent
     *            the new SingleEvent that should replace an old one; the ID
     *            must be the same as of the old one
     * @param comment
     *            the comment to be displayed along with the resulting
     *            SingleEventUpdate
     */
    public AddSingleEventUpdateRequest(SingleEvent updatedSingleEvent,
	    String comment) {
	this.updatedSingleEvent = updatedSingleEvent;
	this.comment = comment;
    }

    public SingleEvent getUpdatedSingleEvent() {
	return updatedSingleEvent;
    }

    public String getComment() {
	return comment;
    }
}
