/*******************************************************************************
 * Copyright 2016 Rahul Verma (Web: www.AutoCognite.com, Email: RV@autocognite.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.autocognite.uiautomator.ex.contextual.entity;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.api.UiDriver;

public class SettingsPage extends BasePage {
	public SettingsPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("Settings", runConfig, uiDriver);
	}
	
	public void tweakSettings() throws Exception {
		page(web).element("BLOG_NAME").enterText("Hello");
		page(web).element("BLOG_NAME").enterText("Hello");
		page(web).element("BLOG_NAME").setText("Hello");
		
		page(web).element("MEMBERSHIP").check();
		
		page(web).element("ROLE").selectLabel("Author");
		assertTrue(page(web).element("ROLE").hasSelectedLabel("Author"));
		page(web).element("ROLE").selectIndex(0);
		assertTrue(page(web).element("ROLE").hasSelectedIndex(0));
		page(web).element("ROLE").selectValue("author");
		assertTrue(page(web).element("ROLE").hasSelectedValue("author"));
		
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
		page(web).element("DATE_FORMAT").selectLabel(today);
		assertTrue(page(web).element("DATE_FORMAT").hasSelectedLabel(today));
		page(web).element("DATE_FORMAT").selectIndex(0);
		assertTrue(page(web).element("DATE_FORMAT").hasSelectedIndex(0));
		page(web).element("DATE_FORMAT").selectValue("m/d/Y");
		assertTrue(page(web).element("DATE_FORMAT").hasSelectedValue("m/d/Y"));
	}
}
