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
