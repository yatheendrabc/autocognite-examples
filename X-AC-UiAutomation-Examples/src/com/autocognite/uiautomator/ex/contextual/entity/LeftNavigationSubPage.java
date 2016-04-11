package com.autocognite.uiautomator.ex.contextual.entity;

import javax.security.auth.login.Configuration;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.core.UiDriver;

public class LeftNavigationSubPage extends BasePage {
	public LeftNavigationSubPage (RunConfiguration runConfig, UiDriver automator) throws Exception{
		super("LeftNavigation", runConfig, automator);
	}
	
	public SettingsPage getSettingsPage() throws Exception {
		toggleMenu();
		ui(web).element("SETTINGS").identify().click();
		ui(web).element("GENERAL").identify().click();
		return new SettingsPage(runConfig, this.getAutomator());
	}
	
	public CategoriesPage getCategoriesPage() throws Exception{
		toggleMenu();
		ui(web).element("POSTS").click();
		ui(web).element("CATEGORIES").click();
		return new CategoriesPage(runConfig, this.getAutomator());
	}
	
	public void toggleMenu() throws Exception{
		if (this.isInMobileWebContext()){
			ui(web).element("MENU_TOGGLE").identify().click();
		}
	}
}
