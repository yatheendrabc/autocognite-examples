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
package com.autocognite.uiautomator.ex.web.ui.style1;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.PageMapper;
import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.UiElement;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;
import com.autocognite.uiautomator.lib.factory.PageFactory;
import com.autocognite.uiautomator.lib.factory.PageMapperFactory;
import com.autocognite.uiautomator.lib.factory.UiDriverFactory;
import com.autocognite.user.testcore.lib.test.Test;
import com.autocognite.utils.api.enums.FileFormat;

public class WebTestAutomationWithUiStyle1 extends Test{
	UiDriver uiDriver = null;
	StandalonePage ui = null;
	
	public void setUpClass() throws Exception{
		// Create UiDriver
		uiDriver = UiDriverFactory.getWebUiDriver(getRunConfig());
		// Create Ui Mapper
		PageMapper mapper = PageMapperFactory.getFileMapper(FileFormat.INI, getIniMapFilePath(getRunConfig()));
		// Create Ui
		ui = PageFactory.getPage(getRunConfig(), uiDriver, mapper, AutomationContext.PC_WEB);
	}
	
	private static String getIniMapFilePath(RunConfiguration runConfig){
		return  runConfig.get(UiAutomator.UI_MAPS_DIR) + "/wordpress_single_ui" + "/" + "WordPress.ini";
	}
	
	private void goToHomePage() throws Exception{
		ui.goTo(WordPressConfiguration.getAdminUrl());		
	}
	
	private void login() throws Exception{
		ui.element("Home_LOGIN").waitForPresence();
		ui.element("Home_LOGIN").enterText("user");
		ui.element("Home_PASSWORD").enterText("bitnami");
		ui.element("Home_SUBMIT").click();	
	}
	
	private void goToCategoriesPage() throws Exception{
		ui.element("LeftNav_POSTS").hoverAndClickElement(ui.element("LeftNav_CATEGORIES"));		
	}
	
	private void tweakCategories() throws Exception{
		ui.element("Categories_CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		ui.element("Categories_CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
		
		for (UiElement element: ui.element("Categories_CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}	
	}
	
	private void goToSettingsPage() throws Exception{
		ui.element("LeftNav_SETTINGS").click();	
	}
	
	private void tweakSettings() throws Exception{
		ui.element("Settings_BLOG_NAME").enterText("Hello");
		ui.element("Settings_BLOG_NAME").enterText("Hello");
		ui.element("Settings_BLOG_NAME").setText("Hello");
		ui.element("Settings_MEMBERSHIP").check();

		// Experiments with Select control - Selection using different attributes
		ui.element("Settings_ROLE").selectLabel("Author");
		assertTrue(ui.element("Settings_ROLE").hasSelectedLabel("Author"));
		ui.element("Settings_ROLE").selectIndex(0);
		assertTrue(ui.element("Settings_ROLE").hasSelectedIndex(0));
		ui.element("Settings_ROLE").selectValue("author");
		assertTrue(ui.element("Settings_ROLE").hasSelectedValue("author"));
		
		// Experiments with Radio Button
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
		ui.element("Settings_DATE_FORMAT").selectLabel(today);
		assertTrue(ui.element("Settings_DATE_FORMAT").hasSelectedLabel(today));
		ui.element("Settings_DATE_FORMAT").selectIndex(0);
		ui.element("Settings_DATE_FORMAT").selectValue("m/d/Y");
		assertTrue(ui.element("Settings_DATE_FORMAT").hasSelectedValue("m/d/Y"));		
	}
	
	private void logout() throws Exception{
		ui.goTo(WordPressConfiguration.getLogoutUrl());
		ui.element("Home_LOGOUT_CONFIRM").click();
	}
	
	public void test() throws Exception{
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
