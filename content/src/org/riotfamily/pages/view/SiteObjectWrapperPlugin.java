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
package org.riotfamily.pages.view;

import org.riotfamily.common.freemarker.ObjectWrapperPlugin;
import org.riotfamily.common.freemarker.PluginObjectWrapper;
import org.riotfamily.common.web.support.RequestHolder;
import org.riotfamily.components.view.ContentFacadeTemplateModel;
import org.riotfamily.pages.model.Site;

import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * ObjectWrapperPlugin that creates a {@link SiteFacade} for a given 
 * {@link Site} and wraps it inside a {@link ContentFacadeTemplateModel}.
 * 
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.5
 */
public class SiteObjectWrapperPlugin implements ObjectWrapperPlugin {

	public boolean supports(Object obj) {
		return obj instanceof Site;
	}

	public TemplateModel wrapSupportedObject(Object obj, 
			PluginObjectWrapper wrapper) 
			throws TemplateModelException {
		
		Site site = (Site) obj;
		SiteFacade facade = new SiteFacade(site, RequestHolder.getRequest());
		return new ContentFacadeTemplateModel(facade, wrapper);
	}

}
