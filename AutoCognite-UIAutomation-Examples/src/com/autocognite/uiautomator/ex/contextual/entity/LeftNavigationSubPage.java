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

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.api.UiDriver;

public class LeftNavigationSubPage extends BasePage {
	public LeftNavigationSubPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("LeftNavigation", runConfig, uiDriver);
	}
	
	public SettingsPage getSettingsPage() throws Exception {
		toggleMenu();
		page(web).element("SETTINGS").identify().click();
		page(web).element("GENERAL").identify().click();
		return new SettingsPage(getRunConfig(), this.getUiDriver());
	}
	
	public CategoriesPage getCategoriesPage() throws Exception{
		toggleMenu();
		page(web).element("POSTS").click();
		page(web).element("CATEGORIES").click();
		return new CategoriesPage(getRunConfig(), this.getUiDriver());
	}
	
	public void toggleMenu() throws Exception{
		if (this.isInMobileWebContext()){
			page(web).element("MENU_TOGGLE").identify().click();
		}
	}
}
