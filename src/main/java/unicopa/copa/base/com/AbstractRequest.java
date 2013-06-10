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

import unicopa.copa.base.com.exception.APIException;
import unicopa.copa.base.com.serialization.ServerSerializer;
import unicopa.copa.base.UserRole;

/**
 * A request to be created by the client and sent to and received by the server.
 * 
 * @author Felix Wiemuth
 */
public abstract class AbstractRequest extends CommunicationItem {
    // TODO required???
    protected static UserRole requiredPermissionLevel = UserRole.ADMINISTRATOR; // initialize
										// with
										// highest
										// permission
										// level

    public static UserRole getRequiredPermissionLevel() {
	return requiredPermissionLevel;
    }

    public static AbstractRequest deserialize(String json) throws APIException {
	return ServerSerializer.deserializeRequest(json);
    }
}
