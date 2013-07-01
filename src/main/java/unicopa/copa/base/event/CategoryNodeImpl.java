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

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of the CategoryNode interface.
 * 
 * @author Felix Wiemuth
 */
public class CategoryNodeImpl implements CategoryNode {

    private int id;
    private String name;
    private List<CategoryNodeImpl> children = new ArrayList<CategoryNodeImpl>();

    /**
     * Create a new category node.
     * 
     * @param id
     * @param name
     */
    public CategoryNodeImpl(int id, String name) {
	this.id = id;
	this.name = name;
    }

    /**
     * Add a new child category to this category.
     * 
     * @param node
     */
    public void addChildNode(CategoryNodeImpl node) {
	children.add(node);
    }

    /**
     * Merge the given path into the subtree denoted by this CategoryNode.
     * 
     * @param path
     *            the path to insert
     * @return the created and inserted node (last node of the path)
     */
    public CategoryNode insertNode(List<String> path) {
	if (path.isEmpty()) {
	    return this;
	} else {
	    CategoryNodeImpl found = null;
	    String current = path.get(0);
	    for (CategoryNodeImpl child : children) {
		if (child.getName().equals(current)) {
		    found = child;
		    break;
		}
	    }
	    if (found == null) {
		CategoryNodeImpl node = new CategoryNodeImpl(0, current);
		children.add(node);
		return node.insertNode(path.subList(1, path.size()));
	    } else {
		return found.insertNode(path.subList(1, path.size()));
	    }
	}
    }

    @Override
    public int getId() {
	return this.id;
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public List<CategoryNodeImpl> getChildren() {
	return this.children;
    }

    /**
     * Set the name of this node.
     * 
     * @param name
     */
    public void setName(String name) {
	this.name = name;
    }
}