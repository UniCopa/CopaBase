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
 * A request for event groups.
 * 
 * The requested event groups must match the search term and be of the category
 * specified by the Node-ID of the node from the category tree. If the search
 * term is null or empty, it will be ignored.
 * 
 * @author Philip Wendland
 */
public class GetEventGroupsRequest extends AbstractRequest {

    private int categoryNodeID;
    private String searchTerm;

    /**
     * 
     * @param categoryNodeID
     * @param searchterm
     */
    public GetEventGroupsRequest(int categoryNodeID, String searchterm) {
	this.categoryNodeID = categoryNodeID;
	this.searchTerm = searchterm;
    }

    public int getCategoryNodeID() {
	return this.categoryNodeID;
    }

    public String getSearchTerm() {
	return this.searchTerm;
    }

}