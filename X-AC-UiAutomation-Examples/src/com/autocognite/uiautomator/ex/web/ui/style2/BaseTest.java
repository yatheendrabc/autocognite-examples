package com.autocognite.uiautomator.ex.web.ui.style2;

import com.autocognite.teststyler.lib.ext.TestCase;
import com.autocognite.uiautomator.api.core.Ui;
import com.autocognite.uiautomator.api.core.UiDriver;
import com.autocognite.uiautomator.lib.ext.factories.UiDriverFactory;

public abstract class BaseTest extends TestCase{
	protected UiDriver uiDriver = null;

	public void setUpClass() throws Exception{
		uiDriver = UiDriverFactory.getWebUiDriver(runConfig);
	}
	
	public void tearDownClass() throws Exception{
		uiDriver.close();
	}
	
	public UiDriver getUiDriver(){
		return uiDriver;
	}
	
	public Ui getPage(String pageName) throws Exception{
		return WordPress.getPage(this, pageName);
	}
}
