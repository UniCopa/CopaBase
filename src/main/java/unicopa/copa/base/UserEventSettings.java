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
package unicopa.copa.base;

/**
 * Settings of one user for an event.
 * 
 * @author Felix Wiemuth
 */
public class UserEventSettings {

    private String colorCode;
    
    /**
     * 	The default constructor
     */
    public UserEventSettings() {

    }
    
    /**
     * The constructor for UserEventSettings that is used by the Mapper
     */
    public UserEventSettings(String colorCode) {
	this.colorCode = colorCode;
    }

    public String getColorCode() {
	return this.colorCode;
    }

    /**
     * Set the color to be associated with the event in the user interface.
     * //TODO specify color format
     * 
     * @param colorCode
     */
    public void setColorCode(String colorCode) {
	this.colorCode = colorCode;
    }

}