package com.autocognite.uiautomator.ex.contextual.entity;

import javax.security.auth.login.Configuration;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.core.UiDriver;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;

public class HomePage extends BasePage {
	public HomePage (RunConfiguration runConfig, UiDriver automator) throws Exception{
		super("HomePage", runConfig, automator);
		this.goToBaseUrl();
	}
	
	public void goToBaseUrl() throws Exception{
		ui(web).goTo(WordPressConfiguration.getLoginUrl());
	}
	
	public void login() throws Exception{
		ui(web).element("LOGIN").waitForPresence();
		ui(web).element("LOGIN").enterText("user");
		ui(web).element("PASSWORD").enterText("bitnami");
		ui(web).element("SUBMIT").click();
	}
	
	public void logout() throws Exception{
		ui(web).goTo(WordPressConfiguration.getLogoutUrl());
		ui(web).element("LOGOUT_CONFIRM").click();
	}
}
