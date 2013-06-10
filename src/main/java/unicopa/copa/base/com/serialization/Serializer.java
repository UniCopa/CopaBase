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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import unicopa.copa.base.com.exception.APIException;
import unicopa.copa.base.com.exception.InternalErrorException;
import unicopa.copa.base.com.exception.PermissionException;
import unicopa.copa.base.com.exception.RequestNotPracticableException;

/**
 * A serializer to serialize/deserialize objects in a way used by the system
 * using GSON. Note that standard GSON serialization is used to convert an
 * instance to JSON for all types where no type adapter is registered. If
 * special treatment is needed, it has to be added to this class.
 * 
 * @author Felix Wiemuth
 */
public class Serializer {

    protected static final JsonParser parser = new JsonParser();
    protected static final Gson gson = new GsonBuilder()
	    .registerTypeAdapter(RequestNotPracticableException.class,
		    new SimpleExceptionSerializer())
	    .registerTypeAdapter(InternalErrorException.class,
		    new SimpleExceptionSerializer())
	    .registerTypeAdapter(APIException.class,
		    new SimpleExceptionSerializer())
	    .registerTypeAdapter(PermissionException.class,
		    new SimpleExceptionSerializer()).create();

    public static String serialize(Object object) {
	JsonElement je = gson.toJsonTree(object);
	JsonObject jo = new JsonObject();
	jo.addProperty("type", object.getClass().getSimpleName());
	jo.add("data", je);
	return jo.toString();
    }

    protected static Object deserialize(String json, String packagePrefix)
	    throws APIException {
	try {
	    JsonObject jo = parser.parse(json).getAsJsonObject();
	    JsonElement dataClassJE = jo.get("type");
	    if (dataClassJE == null) {
		throw new APIException(
			"The JSON object does not contain the required \"type\" attribute.");
	    }
	    Class dataClass = Class.forName(packagePrefix.concat(dataClassJE
		    .getAsString()));
	    JsonElement dataJE = jo.get("data");
	    if (dataJE == null) {
		throw new APIException(
			"The JSON object does not contain the required \"data\" attribute.");
	    }
	    Object data = gson.fromJson(dataJE, dataClass);
	    return data;
	} catch (JsonParseException ex) {
	    // assuming the exception is either JsonSyntaxException, because
	    // JsonIOException will not occur (no input streams used)
	    throw new APIException(
		    "The JSON string is malformatted (contains syntax errors).");
	} catch (ClassNotFoundException ex) { // this exception occurs if the
					      // "type" attribute in the JSON
					      // object does not represent a
					      // Request or Response class
	    throw new APIException(
		    "Attribute \"type\" in the JSON string does not contain a class name known to the system.");
	}
    }
}
