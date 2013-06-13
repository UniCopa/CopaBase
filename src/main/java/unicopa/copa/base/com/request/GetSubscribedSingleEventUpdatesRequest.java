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
 * A request for all the SingleEventUpdates the user has subscribed for that
 * happened after the given date.
 * 
 * @author Philip Wendland
 */
public class GetSubscribedSingleEventUpdatesRequest extends AbstractRequest {

    private Date since;

    /**
     * 
     * @param since
     */
    public GetSubscribedSingleEventUpdatesRequest(Date since) {
	this.since = since;
    }

    public Date getSince() {
	return this.since;
    }

}