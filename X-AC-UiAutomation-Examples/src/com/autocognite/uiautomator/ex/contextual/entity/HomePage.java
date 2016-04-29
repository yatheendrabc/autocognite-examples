package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;

public class HomePage extends BasePage {
	public HomePage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("HomePage", runConfig, uiDriver);
		this.goToBaseUrl();
	}
	
	public void goToBaseUrl() throws Exception{
		page(web).goTo(WordPressConfiguration.getAdminUrl());
	}
	
	public void login() throws Exception{
		page(web).element("LOGIN").waitForPresence();
		page(web).element("LOGIN").enterText("user");
		page(web).element("PASSWORD").enterText("bitnami");
		page(web).element("SUBMIT").click();
	}
	
	public void logout() throws Exception{
		page(web).goTo(WordPressConfiguration.getLogoutUrl());
		page(web).element("LOGOUT_CONFIRM").click();
	}
}
