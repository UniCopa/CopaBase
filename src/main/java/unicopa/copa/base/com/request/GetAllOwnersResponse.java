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

/**
 * Answer to GetAllOwnsersRequest.
 * 
 * Contains the names of the owners of the event from the request.
 * 
 * @author Philip Wendland
 */
public class GetAllOwnersResponse extends AbstractResponse {

    private List<String> names;

    /**
     * 
     * @param names
     */
    public GetAllOwnersResponse(List<String> names) {
	this.names = names;
    }

    public List<String> getNames() {
	return this.names;
    }
}