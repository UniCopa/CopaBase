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

import unicopa.copa.base.UserSettings;

/**
 * Answer to GetUserSettingsResponse.
 * 
 * Contains the current user settings.
 * 
 * @author Philip Wendland
 */
public class GetUserSettingsResponse extends AbstractResponse {

    private UserSettings userSettings;

    /**
     * 
     * @param userSettings
     */
    public GetUserSettingsResponse(UserSettings userSettings) {
	this.userSettings = userSettings;
    }

    public UserSettings getUserSettings() {
	return this.userSettings;
    }

}