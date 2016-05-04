package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.teststyler.lib.TestMethodSuite;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.factory.UiDriverFactory;

public abstract class BaseTest extends TestMethodSuite{
	private AutomationContext context = null;
	private UiDriver uiDriver = null;

	public void setUpClass() throws Exception{ 
		this.context = ContextProcessor.getCurrentContext(getRunConfig());
		switch(context){
		case PC_WEB: uiDriver = UiDriverFactory.getUiDriver(getRunConfig(), AutomationContext.PC_WEB); break;
		case MOBILE_WEB: uiDriver = UiDriverFactory.getUiDriver(getRunConfig(), AutomationContext.MOBILE_WEB); break;
		default: break;
		}
	}
	
	public void tearDownClass() throws Exception{
		uiDriver.close();
	}
	
	public UiDriver getUiDriver(){
		return uiDriver;
	}
	
	public HomePage createHomePage() throws Exception{
		return new HomePage(this.getRunConfig(), this.getUiDriver());	
	}
}
