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

/**
 * A request for the events that belong to the eventgroup.
 * 
 * The resulting events can be filtered by categories, that is the ID of the
 * node from the class CategoryNode
 * 
 * @author Philip Wendland
 */
public class GetEventsRequest extends AbstractRequest {

    private int eventGroupID;
    private int categoryNodeID;

    /**
     * 
     * @param eventGroupID
     * @param categoryNodeID
     */
    public GetEventsRequest(int eventGroupID, int categoryNodeID) {
	this.categoryNodeID = categoryNodeID;
	this.eventGroupID = eventGroupID;

    }

    public int getEventGroupID() {
	return this.eventGroupID;
    }

    public int getCategoryNodeID() {
	return this.categoryNodeID;
    }

}