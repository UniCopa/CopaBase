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

/**
 * Represents a node in the category tree.
 * 
 * The category tree starts with one CategoryNode
 * 
 * @author Felix Wiemuth
 */
public interface CategoryNode {

    /**
     * Get the ID of this node.
     * 
     * @return
     */
    int getId();

    /**
     * Get the name of this node. The name represents the category.
     * 
     * @return
     */
    String getName();

    /**
     * Get all category nodes that are children of this node in the category
     * tree. If the list is empty, this category node is a leaf.
     * 
     * @return
     */
    List<? extends CategoryNode> getChildren();

}