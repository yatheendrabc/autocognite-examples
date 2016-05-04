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
package com.autocognite.uiautomator.ex.web.ui.style2;

import static com.autocognite.validator.lib.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.UiElement;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;

public class WebTestAutomationWithUiStyle2 extends BaseTest{
	StandalonePage home = null;
	StandalonePage leftNav = null;
	
	private void goToHomePage() throws Exception{
		home = getPage("HomePage");
		home.goTo(WordPressConfiguration.getAdminUrl());		
	}
	
	private void login() throws Exception{
		home.element("LOGIN").waitForPresence();
		home.element("LOGIN").enterText("user");
		home.element("PASSWORD").enterText("bitnami");
		home.element("SUBMIT").click();		
	}
	
	private void goToCategoriesPage() throws Exception{
		leftNav = getPage("LeftNavigation");
		leftNav.element("POSTS").hoverAndClickElement(leftNav.element("CATEGORIES"));	
	}
	
	private void tweakCategories() throws Exception{
		StandalonePage categories = getPage("Categories");
		categories.element("CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		categories.element("CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
		
		for (UiElement element: categories.element("CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}
	}
	
	private void goToSettingsPage() throws Exception{
		leftNav.element("SETTINGS").click();
	}
	
	private void tweakSettings() throws Exception{
		StandalonePage settings = getPage("Settings");
		
		settings.element("BLOG_NAME").enterText("Hello");
		settings.element("BLOG_NAME").enterText("Hello");
		settings.element("BLOG_NAME").setText("Hello");
		settings.element("MEMBERSHIP").check();

		// Experiments with Select control - Selection using different attributes
		settings.element("ROLE").selectLabel("Author");
		assertTrue(settings.element("ROLE").hasSelectedLabel("Author"));
		settings.element("ROLE").selectIndex(0);
		assertTrue(settings.element("ROLE").hasSelectedIndex(0));
		settings.element("ROLE").selectValue("author");
		assertTrue(settings.element("ROLE").hasSelectedValue("author"));
		
		// Experiments with Radio Button
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
		settings.element("DATE_FORMAT").selectLabel(today);
		assertTrue(settings.element("DATE_FORMAT").hasSelectedLabel(today));
		settings.element("DATE_FORMAT").selectIndex(0);
		settings.element("DATE_FORMAT").selectValue("m/d/Y");
		assertTrue(settings.element("DATE_FORMAT").hasSelectedValue("m/d/Y"));	
	}
	
	private void logout() throws Exception{
		home.goTo(WordPressConfiguration.getLogoutUrl());
		home.element("LOGOUT_CONFIRM").click();
	}
	
	public void run() throws Exception{
		goToHomePage();
		login();
		goToCategoriesPage();
		tweakCategories();
		goToSettingsPage();
		tweakSettings();
		logout();
	}
	
}
