package com.autocognite.uiautomator.ex.config;

public class WordPressConfiguration {

	// For demonstration focus on UI Automation, these properties have been kept here.
	// Not an ideal way.
	// You should look at using AutoCognite Configurator's property file support and keep these outside of code.
	// If you are using UI Automation with UniTEE, the same can be done directly by putting these in unitee.properties file.
	
	static String appUrl = "http://192.168.56.101";
	static String adminUrl = appUrl + "/wp-admin/";
	static String logoutUrl = appUrl + "/wp-login.php?action=logout";
	
	public static String getAdminUrl(){
		return adminUrl;
	}
	
	public static String getLogoutUrl(){
		return logoutUrl;
	}
}
