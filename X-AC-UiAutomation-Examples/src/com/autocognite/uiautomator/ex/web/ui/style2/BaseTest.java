package com.autocognite.uiautomator.ex.web.ui.style2;

import com.autocognite.teststyler.lib.TestCase;
import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.UiDriver;
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
	
	public StandalonePage getPage(String pageName) throws Exception{
		return WordPress.getPage(this, pageName);
	}
}
