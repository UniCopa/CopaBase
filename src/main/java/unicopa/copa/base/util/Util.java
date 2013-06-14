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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import unicopa.copa.base.event.SingleEventUpdate;

/**
 * A collection of utility methods related to the base classes.
 * 
 * @author Felix Wiemuth
 */
public class Util {

    /**
     * Sort a list of updates into chains of associated updates. If update B
     * updates a SingleEvent of another update A in the list 'updates', the
     * resulting list will contain a list with A-B in it. All updates that
     * origin at one SingleEvent will get into the same list, ordered by their
     * data of occurence. The outer list is not sorted.
     * 
     * @param updates
     *            the list of updates to sort
     * @return
     */
    public static List<List<SingleEventUpdate>> sortUpdatesAsChains(
	    List<SingleEventUpdate> updates) {
	List<List<SingleEventUpdate>> sorted = new ArrayList<List<SingleEventUpdate>>();
	outer: for (SingleEventUpdate update : updates) {
	    for (List<SingleEventUpdate> list : sorted) { // there are no empty
		// lists in here
		SingleEventUpdate last = list.get(list.size() - 1);
		if (last.isCancellation()) {
		    continue; // there cannot be any predecessor update, because
		    // this was a deletion
		}
		// check whether the update is a successor of an update already
		// sorted
		if (update.getOldSingleEventID() == last
			.getUpdatedSingleEvent().getSingleEventID()) {
		    // predecessor found - add to the list of it
		    list.add(update);
		    continue outer;
		}
	    }
	    // no predecessor found - add to new list
	    sorted.add(new ArrayList<SingleEventUpdate>());
	    sorted.get(sorted.size() - 1).add(update);
	}
	return sorted;
    }

    /**
     * Sort a list of updates by their creation date.
     * 
     * @param updates
     *            the list of updates to sort
     */
    public static void sortUpdatesByDate(List<SingleEventUpdate> updates) {
	Collections.sort(updates, new Comparator<SingleEventUpdate>() {
	    @Override
	    public int compare(SingleEventUpdate o1, SingleEventUpdate o2) {
		return o1.getUpdateDate().compareTo(o2.getUpdateDate());
	    }
	});
    }
}
