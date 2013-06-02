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
package unicopa.copa.base.event;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Felix Wiemuth
 */
public class CategoryNodeImplTest {

    /**
     * Test of addChildNode method, of class CategoryNodeImpl.
     */
    @Test
    public void testAddChildNode() {
	CategoryNodeImpl node1 = new CategoryNodeImpl(7, "Category_1-1");
	CategoryNodeImpl node2 = new CategoryNodeImpl(8, "Category_1-2");
	CategoryNodeImpl node3 = new CategoryNodeImpl(9, "Category_1-3");
	CategoryNodeImpl instance = new CategoryNodeImpl(0, "root");
	instance.addChildNode(node1);
	instance.addChildNode(node2);
	instance.addChildNode(node3);
	List<CategoryNodeImpl> children = instance.getChildren();
	assertEquals(node1, children.get(0));
	assertEquals(node2, children.get(1));
	assertEquals(node3, children.get(2));
    }
}