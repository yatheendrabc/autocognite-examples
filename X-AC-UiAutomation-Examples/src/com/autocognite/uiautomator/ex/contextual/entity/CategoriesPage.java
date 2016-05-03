package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.UiElement;

public class CategoriesPage extends BasePage {
	public CategoriesPage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("Categories", runConfig, uiDriver);
	}
	
	public void tweakCategories() throws Exception {
		page(web).element("CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		page(web).element("CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
		for (UiElement element: page(web).element("CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}
	}
}