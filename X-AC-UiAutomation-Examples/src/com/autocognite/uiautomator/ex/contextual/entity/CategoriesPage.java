package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.api.core.UiDriver;
import com.autocognite.uiautomator.api.core.UiElement;

public class CategoriesPage extends BasePage {
	public CategoriesPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("Categories", runConfig, uiDriver);
	}
	
	public void tweakCategories() throws Exception {
		ui(web).element("CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		ui(web).element("CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
		for (UiElement element: ui(web).element("CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}
	}
}