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
 * Roles for users of the system which grant access to different functions.
 * 
 * @author Felix Wiemuth
 */
public enum UserRole {

    USER(0), RIGHTHOLDER(1), DEPUTY(2), OWNER(3), ADMINISTRATOR(4);
    private int level;

    UserRole(int level) {
	this.level = level;
    }

    public int level() {
	return level;
    }
}
