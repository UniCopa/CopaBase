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
package unicopa.copa.base.util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import unicopa.copa.base.event.SingleEvent;
import unicopa.copa.base.event.SingleEventUpdate;

/**
 * 
 * @author Felix Wiemuth
 */
public class UtilTest {

    public UtilTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sortUpdates method, of class Util.
     */
    @Test
    public void testSortUpdates() {
	SingleEvent a = new SingleEvent(10, 0, null, null, null, 120);
	SingleEvent a1 = new SingleEvent(11, 0, null, null, null, 120);
	SingleEvent a2 = new SingleEvent(12, 0, null, null, null, 120);
	SingleEvent b = new SingleEvent(20, 0, null, null, null, 120);
	SingleEvent c = new SingleEvent(30, 0, null, null, null, 120);
	SingleEvent c1 = new SingleEvent(31, 0, null, null, null, 120);
	SingleEvent d = new SingleEvent(40, 0, null, null, null, 120);
	SingleEvent e = new SingleEvent(50, 0, null, null, null, 120);

	SingleEventUpdate[] u = new SingleEventUpdate[7];

	u[0] = new SingleEventUpdate(e.getSingleEventID(), new Date(10), "");
	u[1] = new SingleEventUpdate(a, new Date(1000), "");
	u[2] = new SingleEventUpdate(a1, a.getSingleEventID(), new Date(1150),
		"Mr. Y", "");
	u[3] = new SingleEventUpdate(a2, a1.getSingleEventID(), new Date(1200),
		"Mr. X", "");
	u[4] = new SingleEventUpdate(c1, c.getSingleEventID(), new Date(
		777777777), "Mr. X", "");
	u[5] = new SingleEventUpdate(d, new Date(1001), "");
	u[6] = new SingleEventUpdate(d.getSingleEventID(), new Date(20000), "");

	List<SingleEventUpdate> updates = Arrays.asList(u);
	List<List<SingleEventUpdate>> sorted = Util
		.sortUpdatesAsChains(updates);
	assertEquals(4, sorted.size());
	assertTrue(sorted.contains(Arrays.asList(u[0])));
	assertTrue(sorted.contains(Arrays.asList(u[1], u[2], u[3])));
	assertTrue(sorted.contains(Arrays.asList(u[4])));
	assertTrue(sorted.contains(Arrays.asList(u[5], u[6])));
    }
}