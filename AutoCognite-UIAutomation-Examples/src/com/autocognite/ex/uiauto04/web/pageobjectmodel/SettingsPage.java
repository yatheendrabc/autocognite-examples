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
package com.autocognite.ex.uiauto04.web.pageobjectmodel;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import com.autocognite.user.configurator.api.RunConfiguration;
import com.autocognite.user.uiautomator.api.UiDriver;

public class SettingsPage extends DashBoardPage {
	public SettingsPage (UiDriver uiDriver) throws Exception{
		super("Settings", uiDriver);
	}
	
	public void tweakSettings() throws Exception {
		element("BLOG_NAME").enterText("Hello");
		element("BLOG_NAME").enterText("Hello");
		element("BLOG_NAME").setText("Hello");
		
		element("MEMBERSHIP").check();
		
		element("ROLE").selectLabel("Author");
		assertTrue(element("ROLE").hasSelectedLabel("Author"));
		element("ROLE").selectIndex(0);
		assertTrue(element("ROLE").hasSelectedIndex(0));
		element("ROLE").selectValue("author");
		assertTrue(element("ROLE").hasSelectedValue("author"));
	}
}
