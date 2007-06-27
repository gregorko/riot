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
 * Portions created by the Initial Developer are Copyright (C) 2007
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Felix Gnass [fgnass at neteye dot de]
 *
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.common.web.util;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.web.context.ServletContextAware;


/**
 * Service class that can be used to add the servlet-prefix or suffix to a
 * path without having a request object.
 *
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.4
 */
public class PathCompleter implements ServletContextAware, InitializingBean {

	private static final Log log = LogFactory.getLog(PathCompleter.class);

	private String servletName;

	private String servletMapping;

	private ServletContext servletContext;

	private String servletPrefix;

	private String servletSuffix;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setServletMapping(String servletMapping) {
		this.servletMapping = servletMapping;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public void afterPropertiesSet() throws Exception {
		if (servletMapping == null) {
			Assert.notNull(servletName, "Either servletMapping or "
					+ "servletName must be set.");

			servletMapping = ServletUtils.getServletMapping(servletName,
					servletContext);

			Assert.notNull(servletMapping, "Could not determine mapping "
					+ "for servlet '" + servletName + "'.");

			log.info("Servlet '" + servletName + "' is mapped to "
					+ servletMapping + " in web.xml");
		}
		servletSuffix = "";
		servletPrefix = "";
		int i = servletMapping.indexOf('*');
		if (i == 0) {
			servletSuffix = servletMapping.substring(1);
		}
		if (i > 0) {
			servletPrefix = servletMapping.substring(0, i);
		}
		log.info("Servlet prefix: '" + servletPrefix + "'");
		log.info("Servlet suffix: '" + servletSuffix + "'");
	}

	public String addServletMapping(String path) {
		int i = path.indexOf('?');
		if (i != -1 && servletSuffix.length() > 0) {
			return path.substring(0, i) + servletSuffix + path.substring(i);
		}
		return servletPrefix + path + servletSuffix;
	}

	public void addServletMapping(StringBuffer path) {
		path.insert(0, servletPrefix);
		if (servletSuffix.length() > 0) {
			int i = path.indexOf("?");
			if (i != -1) {
				path.insert(i, servletSuffix);
			}
			else {
				path.append(servletSuffix);
			}
		}
	}

}
