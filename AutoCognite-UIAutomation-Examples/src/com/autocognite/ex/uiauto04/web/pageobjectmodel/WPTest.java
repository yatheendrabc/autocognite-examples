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

import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.uiautomator.lib.factory.UiDriverFactory;

@TestClass
public class WPTest {
	HomePage home = null;
	
	public void setUp() throws Exception{
		home = new HomePage(UiDriverFactory.getWebUiDriver());	
	}

	public void test() throws Exception{
		WelcomePage welcome = home.login();
		CategoriesPage categories = welcome.getLeftNav().getCategoriesPage();
		categories.tweakCategories();
		SettingsPage settings = categories.leftNav.getSettingsPage();
		settings.tweakSettings();
		home = settings.topMenu.logout();
	}
	
	public void tearDown() throws Exception{
		home.close();
	}

}
