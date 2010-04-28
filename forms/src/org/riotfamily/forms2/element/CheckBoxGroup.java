/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.riotfamily.forms2.element;

import java.util.List;

import org.riotfamily.forms2.client.Html;
import org.riotfamily.forms2.element.support.MultiSelectElement;
import org.riotfamily.forms2.element.support.OptionState;

public class CheckBoxGroup extends MultiSelectElement {

	public class State extends MultiSelectElement.State {
		
		@Override
		protected void buildOptionsDom(List<OptionState> options, Html html) {
			for (OptionState option : options) {
				html.input("checkbox", option.getValue());
				html.labelPrev(option.getLabel());
			}
		}
	}

}
