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

import com.autocognite.uiautomator.api.Page;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;
import com.autocognite.uiautomator.lib.BasePageSection;

public abstract class DashBoardPage extends SimplePage {
	LeftNavigation leftNav = null;
	TopMenu topMenu = null;

	public DashBoardPage(String pageName, UiDriver uiDriver) throws Exception{
		super(pageName, uiDriver);
		this.populate("wordpress/" + pageName + ".ini");
		leftNav = new LeftNavigation(this, this.getUiDriver());
		topMenu = new TopMenu(this, this.getUiDriver());
	}
	
	public LeftNavigation getLeftNav(){
		return leftNav;
	}
	
	public LeftNavigation getTopMenu(){
		return leftNav;
	}

}

class LeftNavigation extends BasePageSection {
	public LeftNavigation (Page parent, UiDriver uiDriver) throws Exception{
		super("LeftNavigation", parent, uiDriver);
		this.populate("wordpress/LeftNavigation.ini");
	}
	
	public SettingsPage getSettingsPage() throws Exception {
		element("SETTINGS").identify().click();
		element("GENERAL").identify().click();
		return new SettingsPage(this.getUiDriver());
	}
	
	public CategoriesPage getCategoriesPage() throws Exception{
		element("POSTS").click();
		element("CATEGORIES").click();
		return new CategoriesPage(this.getUiDriver());
	}
}

class TopMenu extends BasePageSection {
	public TopMenu (Page parent, UiDriver uiDriver) throws Exception{
		super("TopMenu", parent, uiDriver);
		this.populate("wordpress/TopMenu.ini");
	}
	
	public HomePage logout() throws Exception{
		goTo(WordPressConfiguration.getLogoutUrl());
		element("LOGOUT_CONFIRM").click();
		return new HomePage(this.getUiDriver());
	}
}

