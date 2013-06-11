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
import unicopa.copa.base.com.AbstractResponse;
import unicopa.copa.base.com.exception.InternalErrorException;
import unicopa.copa.base.com.exception.PermissionException;
import unicopa.copa.base.com.exception.RequestNotPracticableException;

/**
 * The serializer to be used by the client.
 * 
 * @author Felix Wiemuth
 */
public class ClientSerializer extends Serializer {
    private static final String packagePrefixResponse = "unicopa.copa.base.com.request.";
    private static final String packagePrefixException = "unicopa.copa.base.com.exception.";

    public static AbstractResponse deserializeResponse(String json)
	    throws APIException, PermissionException,
	    RequestNotPracticableException, InternalErrorException {
	Object data = deserialize(json, packagePrefixResponse,
		packagePrefixException);
	// NOTE the possible types for data are ... //TODO specify
	if (data instanceof APIException) {
	    throw (APIException) data;
	} else if (data instanceof PermissionException) {
	    throw (PermissionException) data;
	} else if (data instanceof RequestNotPracticableException) {
	    throw (RequestNotPracticableException) data;
	} else if (data instanceof InternalErrorException) {
	    throw (InternalErrorException) data;
	} else {
	    try {
		// Tried all exceptions, now type should be AbstractResponse.
		// If not, the server sent wrong data.
		return (AbstractResponse) data;
	    } catch (ClassCastException ex) {
		throw new APIException(
			"The received object is of unexpected type (expected AbstractResponse or exception).");
	    }
	}
    }
}
