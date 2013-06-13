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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Felix Wiemuth
 */
public class UserSettingsTest {

    /**
     * Test for correct behaviour of the whole class.
     */
    @Test
    public void test() {
	UserSettings settings = new UserSettings();
	assertEquals(settings.getEventSettings(3), null);
	assertEquals(settings.getEventSettings(0), null);
	assertEquals(settings.getEventSettings(-1), null);
	assertEquals(settings.hasSubscribed(3), false);
	assertEquals(settings.hasSubscribed(0), false);
	assertEquals(settings.hasSubscribed(-1), false);
	assertEquals(settings.getLanguage(), "default");
	assertEquals(settings.isEmailNotificationEnabled(), false);
	assertEquals(settings.getGCMKeys().isEmpty(), true);

	settings.addGCMKey("key1");
	settings.addGCMKey("key2");
	settings.addSubscription(23);
	settings.addSubscription(3);
	settings.enableEmailNotification();
	settings.setLanguage("english");

	UserEventSettings eventsettings = new UserEventSettings();
	eventsettings.setColorCode("testColor");

	settings.putEventSettings(4, eventsettings);
	settings.putEventSettings(5, eventsettings);

	assertEquals(settings.getEventSettings(3).getColorCode(), null);
	assertEquals(settings.getEventSettings(0), null);
	assertEquals(settings.getEventSettings(-1), null);
	assertEquals(settings.getEventSettings(4).getColorCode(), "testColor");
	assertEquals(settings.getEventSettings(5), eventsettings);
	assertEquals(settings.hasSubscribed(3), true);
	assertEquals(settings.hasSubscribed(23), true);
	assertEquals(settings.hasSubscribed(0), false);
	assertEquals(settings.hasSubscribed(-1), false);
	assertEquals(settings.getLanguage(), "english");
	assertEquals(settings.isEmailNotificationEnabled(), true);
	assertEquals(settings.getGCMKeys().isEmpty(), false);
	assertEquals(settings.getGCMKeys().contains("key2"), true);
	assertEquals(settings.getGCMKeys().contains("key1"), true);
    }
}