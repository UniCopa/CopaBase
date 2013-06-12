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

import java.util.List;
import unicopa.copa.base.event.SingleEvent;

/**
 * Answer to GerCurrentSingleEventsRequest.
 * 
 * Contains a list of up-to-date single events scheduled after the date and
 * belonging to the event specified in the request.
 * 
 * 
 * @author Philip Wendland
 */
public class GetCurrentSingleEventsResponse extends AbstractResponse {

    private List<SingleEvent> singleEvents;

    /**
     * 
     * @param singleEvents
     */
    public GetCurrentSingleEventsResponse(List<SingleEvent> singleEvents) {
	this.singleEvents = singleEvents;
    }

    public List<SingleEvent> getSingleEvents() {
	return this.singleEvents;
    }

}