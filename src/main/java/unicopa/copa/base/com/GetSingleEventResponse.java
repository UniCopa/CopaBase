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
package unicopa.copa.base.com;

import unicopa.copa.base.event.SingleEvent;

/**
 * 
 * @author Felix Wiemuth
 */
public class GetSingleEventResponse extends AbstractResponse {
    private SingleEvent singleEvent;

    public GetSingleEventResponse(SingleEvent singleEvent) {
	this.singleEvent = singleEvent;
    }

    public SingleEvent getSingleEvent() {
	return singleEvent;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 89 * hash
		+ (this.singleEvent != null ? this.singleEvent.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final GetSingleEventResponse other = (GetSingleEventResponse) obj;
	if (this.singleEvent != other.singleEvent
		&& (this.singleEvent == null || !this.singleEvent
			.equals(other.singleEvent))) {
	    return false;
	}
	return true;
    }

}
