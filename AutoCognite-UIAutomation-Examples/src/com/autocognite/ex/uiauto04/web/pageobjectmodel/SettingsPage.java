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

import static com.autocognite.testcommons.assertions.Assertions.assertTrue;

import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.UiElement;

public class SettingsPage extends DashBoardPage {
	public SettingsPage (UiDriver uiDriver) throws Exception{
		super("Settings", uiDriver);
	}
	
	public void tweakSettings() throws Exception {
		UiElement blogName = element("BLOG_NAME");
		blogName.enterText("Hello");
		blogName.enterText("Hello");
		blogName.setText("Hello");
		
		element("MEMBERSHIP").check();
		
		UiElement role = element("ROLE");
		role.selectLabel("Author");
		assertTrue(role.hasSelectedLabel("Author"));
		role.selectIndex(0);
		assertTrue(role.hasSelectedIndex(0));
		role.selectValue("author");
		assertTrue(role.hasSelectedValue("author"));
	}
}
