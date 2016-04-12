package com.autocognite.uiautomator.ex.contextual.entity;

import static com.autocognite.validator.lib.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.security.auth.login.Configuration;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.core.UiDriver;

public class SettingsPage extends BasePage {
	public SettingsPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("Settings", runConfig, uiDriver);
	}
	
	public void tweakSettings() throws Exception {
		ui(web).element("BLOG_NAME").enterText("Hello");
		ui(web).element("BLOG_NAME").enterText("Hello");
		ui(web).element("BLOG_NAME").setText("Hello");
		
		ui(web).element("MEMBERSHIP").check();
		
		ui(web).element("ROLE").selectLabel("Author");
		assertTrue(ui(web).element("ROLE").hasSelectedLabel("Author"));
		ui(web).element("ROLE").selectIndex(0);
		assertTrue(ui(web).element("ROLE").hasSelectedIndex(0));
		ui(web).element("ROLE").selectValue("author");
		assertTrue(ui(web).element("ROLE").hasSelectedValue("author"));
		
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
		ui(web).element("DATE_FORMAT").selectLabel(today);
		assertTrue(ui(web).element("DATE_FORMAT").hasSelectedLabel(today));
		ui(web).element("DATE_FORMAT").selectIndex(0);
		assertTrue(ui(web).element("DATE_FORMAT").hasSelectedIndex(0));
		ui(web).element("DATE_FORMAT").selectValue("m/d/Y");
		assertTrue(ui(web).element("DATE_FORMAT").hasSelectedValue("m/d/Y"));
	}
}