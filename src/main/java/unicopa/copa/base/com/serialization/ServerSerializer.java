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
package unicopa.copa.base.com.serialization;

import unicopa.copa.base.com.exception.APIException;
import unicopa.copa.base.com.AbstractRequest;

/**
 * The serializer to be used by the server.
 * 
 * @author Felix Wiemuth
 */
public class ServerSerializer extends Serializer {
    private static final String packagePrefixRequest = AbstractRequest.class
	    .getPackage().getName().concat(".");

    public static AbstractRequest deserializeRequest(String json)
	    throws APIException {
	Object data = deserialize(json, packagePrefixRequest);
	try {
	    return (AbstractRequest) data;
	} catch (ClassCastException ex) {
	    throw new APIException(
		    "The received object is of unexpected type (expected AbstractRequest or exception).");
	}
    }

}
