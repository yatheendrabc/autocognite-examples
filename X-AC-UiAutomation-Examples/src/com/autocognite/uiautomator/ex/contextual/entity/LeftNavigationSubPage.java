package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.core.UiDriver;

public class LeftNavigationSubPage extends BasePage {
	public LeftNavigationSubPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("LeftNavigation", runConfig, uiDriver);
	}
	
	public SettingsPage getSettingsPage() throws Exception {
		toggleMenu();
		ui(web).element("SETTINGS").identify().click();
		ui(web).element("GENERAL").identify().click();
		return new SettingsPage(runConfig, this.getUiDriver());
	}
	
	public CategoriesPage getCategoriesPage() throws Exception{
		toggleMenu();
		ui(web).element("POSTS").click();
		ui(web).element("CATEGORIES").click();
		return new CategoriesPage(runConfig, this.getUiDriver());
	}
	
	public void toggleMenu() throws Exception{
		if (this.isInMobileWebContext()){
			ui(web).element("MENU_TOGGLE").identify().click();
		}
	}
}
