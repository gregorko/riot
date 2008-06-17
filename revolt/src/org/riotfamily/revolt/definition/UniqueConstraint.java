/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 * 
 * The Original Code is Riot.
 * 
 * The Initial Developer of the Original Code is
 * Neteye GmbH.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * the Initial Developer. All Rights Reserved.
 * 
 * Contributor(s):
 *   Felix Gnass [fgnass at neteye dot de]
 * 
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.revolt.definition;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Felix Gnass [fgnass at neteye dot de]
 */
public class UniqueConstraint extends Identifier {

	private Collection<Identifier> columns;

	public UniqueConstraint() {
	}

	public UniqueConstraint(String name) {
		super(name);
	}
	
	public UniqueConstraint(String name, String[] columnNames) {
		super(name);
		setColumnNames(columnNames);
	}

	public Collection<Identifier> getColumns() {
		return this.columns;
	}

	public void setColumnNames(String[] names) {
		columns = new ArrayList<Identifier>();
		for (int i = 0; i < names.length; i++) {
			columns.add(new Identifier(names[i]));
		}
	}

}
