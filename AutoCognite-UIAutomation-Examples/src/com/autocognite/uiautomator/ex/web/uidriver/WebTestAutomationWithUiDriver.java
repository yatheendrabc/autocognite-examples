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
package com.autocognite.uiautomator.ex.web.uidriver;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.UiElement;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;
import com.autocognite.uiautomator.lib.factory.UiDriverFactory;
import com.autocognite.user.testcore.lib.test.Test;

public class WebTestAutomationWithUiDriver extends Test{
	UiDriver uiDriver = null;
	
	public void setUpClass() throws Exception{
		uiDriver = UiDriverFactory.getMobileWebUiDriver(getRunConfig());
	}

	private void goToHomePage() throws Exception{
		uiDriver.goTo(WordPressConfiguration.getAdminUrl());		
	}
	
	private void login() throws Exception{
		uiDriver.elementWithId("user_login").waitForPresence();
		uiDriver.elementWithId("user_login").enterText("user");
		uiDriver.elementWithId("user_pass").enterText("bitnami");
		uiDriver.elementWithId("wp-submit").click();		
	}
	
	private void goToCategoriesPage() throws Exception{
		uiDriver.elementWithCss(".dashicons-admin-post").hoverAndClickElement(uiDriver.elementWithLinkText("Categories"));		
	}
	
	private void tweakCategories() throws Exception{
		uiDriver.elementWithName("delete_tags[]").getInstanceAtOrdinal(2).check();
		uiDriver.elementWithName("delete_tags[]").getInstanceAtIndex(1).uncheck();
		
		for (UiElement element: uiDriver.elementWithName("delete_tags[]").getAllInstances()){
			element.check();
			element.uncheck();
		}
		
		// Tests for alternate instance methods
		uiDriver.elementWithName("delete_tags[]").getFirstInstance().check();
		uiDriver.elementWithName("delete_tags[]").getFirstInstance().uncheck();
		
		uiDriver.elementWithName("delete_tags[]").identifyAll().getLastInstance().check();
		uiDriver.elementWithName("delete_tags[]").identifyAll().getLastInstance().uncheck();
		
		
		uiDriver.elementWithName("delete_tags[]").identifyAll().getRandomInstance().check();
		uiDriver.elementWithName("delete_tags[]").identifyAll().getRandomInstance().uncheck();
	}
	
	private void goToSettingsPage() throws Exception{
		uiDriver.elementWithCss(".dashicons-admin-settings").click();		
	}
	
	private void tweakSettings() throws Exception{
		uiDriver.elementWithId("blogname").enterText("Hello");
		uiDriver.elementWithId("blogname").enterText("Hello");
		uiDriver.elementWithId("blogname").setText("Hello");
		uiDriver.elementWithId("users_can_register").check();

		// Experiments with Select control - Selection using different attributes
		uiDriver.elementWithId("default_role").selectLabel("Author");
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedLabel("Author"));
		uiDriver.elementWithId("default_role").selectIndex(0);
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedIndex(0));
		uiDriver.elementWithId("default_role").selectValue("author");
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedValue("author"));
		
		// Experiments with Radio Button
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
		uiDriver.elementWithName("date_format").selectLabel(today);
		assertTrue(uiDriver.elementWithName("date_format").hasSelectedLabel(today));
		uiDriver.elementWithName("date_format").selectIndex(0);
		assertTrue(uiDriver.elementWithName("date_format").hasSelectedIndex(0));
		uiDriver.elementWithName("date_format").selectValue("m/d/Y");
		assertTrue(uiDriver.elementWithName("date_format").hasSelectedValue("m/d/Y"));		
	}
	
	private void logout() throws Exception{
		uiDriver.goTo(WordPressConfiguration.getLogoutUrl());
		uiDriver.elementWithLinkText("log out").click();
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

	public void tearDownClass() throws Exception{
		uiDriver.close();
	}
}