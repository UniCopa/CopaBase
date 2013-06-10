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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 * Serializes Exceptions in a very simple way, only using their message.
 * 
 * @author Felix Wiemuth
 */
public class SimpleExceptionSerializer implements JsonSerializer<Exception> {

    @Override
    public JsonElement serialize(Exception src, Type typeOfSrc,
	    JsonSerializationContext context) {
	JsonObject jsonObject = new JsonObject();
	jsonObject.add("message", new JsonPrimitive(src.getMessage()));
	return jsonObject;
    }
}
