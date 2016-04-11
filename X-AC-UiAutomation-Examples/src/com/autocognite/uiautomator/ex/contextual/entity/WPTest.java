package com.autocognite.uiautomator.ex.contextual.entity;

public class WPTest extends BaseTest {

	public void testBasicInteractions() throws Exception{
		HomePage home = createHomePage();
		home.login();
		LeftNavigationSubPage left = home.getLeftNavigation();
		CategoriesPage categories = left.getCategoriesPage();
		categories.tweakCategories();
		SettingsPage settings = left.getSettingsPage();
		settings.tweakSettings();
		home.logout();
	}

}
