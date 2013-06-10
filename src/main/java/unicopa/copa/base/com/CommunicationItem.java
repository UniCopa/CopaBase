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

import unicopa.copa.base.com.serialization.Serializer;

/**
 * A data represention of what shall be communicated between service and client.
 * This class provides API conform serialization.
 * 
 * @author Felix Wiemuth
 */
public class CommunicationItem {
    public String serialize() {
	return Serializer.serialize(this);
    }

}
