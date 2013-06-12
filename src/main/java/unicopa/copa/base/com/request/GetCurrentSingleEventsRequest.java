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

import java.util.Date;

/**
 * A request for up-to-date single events that beloing to the event-ID.
 * 
 * Additionally, the requested single event(s) is/are scheduled after the date
 * since.
 * 
 * @author Philip Wendland
 */
public class GetCurrentSingleEventsRequest extends AbstractRequest {

    private int eventID;
    private Date since;

    /**
     * 
     * @param eventID
     * @param since
     */
    public GetCurrentSingleEventsRequest(int eventID, Date since) {
	this.eventID = eventID;
	this.since = since;
    }

    public int getEventID() {
	return this.eventID;
    }

    public Date getSince() {
	return this.since;
    }

}