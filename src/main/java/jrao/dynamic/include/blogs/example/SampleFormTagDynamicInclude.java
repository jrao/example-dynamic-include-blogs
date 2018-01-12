/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package jrao.dynamic.include.blogs.example;

import com.liferay.portal.kernel.servlet.taglib.TagDynamicInclude;
import com.liferay.portal.kernel.util.PortletKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = TagDynamicInclude.class)
public class SampleFormTagDynamicInclude implements TagDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String tagClassName, String tagDynamicId, String tagPoint)
		throws IOException {

		PrintWriter printWriter = response.getWriter();

		printWriter.println(
			"<h2>Added by Blogs Dynamic Include</h2><br />");
	}

	@Override
	public void register(TagDynamicIncludeRegistry tagDynamicIncludeRegistry) {
		tagDynamicIncludeRegistry.register(
			"com.liferay.taglib.aui.BlogsFormTag", PortletKeys.BLOGS + "-loginForm",
			"doStartTag#before");

		tagDynamicIncludeRegistry.register(
			"com.liferay.taglib.aui.BlogsFormTag",
			PortletKeys.BLOGS + "-loginFormModal", "doStartTag#before");
	}

}