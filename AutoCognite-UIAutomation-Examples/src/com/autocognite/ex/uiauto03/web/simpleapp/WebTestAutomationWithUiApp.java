/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
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
package com.autocognite.ex.uiauto03.web.simpleapp;

import static com.autocognite.testcommons.assertions.Assertions.assertTrue;

import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.user.uiautomator.api.App;
import com.autocognite.user.uiautomator.api.Page;
import com.autocognite.user.uiautomator.api.UiDriver;
import com.autocognite.user.uiautomator.api.UiElement;
import com.autocognite.user.uiautomator.lib.factory.UiDriverFactory;
import com.autocognite.user.uiautomator.lib.factory.UiFactory;

@TestClass
public class WebTestAutomationWithUiApp {
	static String appUrl = "http://10.10.1.32";
	static String adminUrl = appUrl + "/wp-admin/";
	static String logoutUrl = appUrl + "/wp-login.php?action=logout";
	
	public void test() throws Exception{
		UiDriver uiDriver = UiDriverFactory.getWebUiDriver();
		uiDriver.goTo(adminUrl);
		
		App wordpress = UiFactory.getSimpleApp("wordpress", uiDriver, "wordpress");
		Page home = wordpress.page("HomePage");	

		UiElement userTextBox = home.element("LOGIN");
		userTextBox.waitForPresence();
		userTextBox.enterText("user");
		home.element("PASSWORD").enterText("bitnami");
		home.element("SUBMIT").click();		
		
		Page leftNav = wordpress.page("LeftNavigation");	
		leftNav.element("POSTS").hoverAndClickElement(leftNav.element("CATEGORIES"));	
		
		Page categories = wordpress.page("Categories");

		UiElement tags = categories.element("CAT_CHECKBOXES");
		tags.getInstanceAtOrdinal(2).check();
		tags.getInstanceAtIndex(1).uncheck();
			
		for (UiElement element: tags.getAllInstances()){
			element.check();
			element.uncheck();
		}

		leftNav.element("SETTINGS").click();

		Page settings = wordpress.page("Settings");
			
		UiElement blogNameTextBox = settings.element("BLOG_NAME");
		blogNameTextBox.enterText("Hello");
		blogNameTextBox.enterText("Hello");
		blogNameTextBox.setText("Hello");
		
		settings.element("MEMBERSHIP").check();

		// Experiments with Select control - Selection using different attributes
		UiElement roleDropDown = settings.element("ROLE");
		roleDropDown.selectLabel("Author");
		assertTrue(roleDropDown.hasSelectedLabel("Author"));
		roleDropDown.selectIndex(0);
		assertTrue(roleDropDown.hasSelectedIndex(0));
		roleDropDown.selectValue("author");
		assertTrue(roleDropDown.hasSelectedValue("author"));

		settings.goTo(logoutUrl);

		uiDriver.close();
	}
}
