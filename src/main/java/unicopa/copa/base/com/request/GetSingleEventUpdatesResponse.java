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
import unicopa.copa.base.event.SingleEventUpdate;

/**
 * 
 * Answer to GetSingleEventUpdatesRequest.
 * 
 * Contains a list of lists of SingleEventUpdates. The SingleEventUpdates are in
 * the lowest level (orderd by date - newest object is at the last position).
 * For every SingleEvent there is a new lower-list.
 * 
 * @author Philip Wendland
 */
public class GetSingleEventUpdatesResponse extends AbstractResponse {

    private List<List<SingleEventUpdate>> updateList;

    /**
     * 
     * @param updateList
     */
    public GetSingleEventUpdatesResponse(
	    List<List<SingleEventUpdate>> updateList) {
	this.updateList = updateList;
    }

    public List<List<SingleEventUpdate>> getUpdateList() {
	return this.updateList;
    }

}