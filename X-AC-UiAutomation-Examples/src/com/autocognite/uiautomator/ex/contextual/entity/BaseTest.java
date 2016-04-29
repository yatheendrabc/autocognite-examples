package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.teststyler.lib.TestMethodSuite;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.ext.factories.UiDriverFactory;

public abstract class BaseTest extends TestMethodSuite{
	private AutomationContext context = null;
	private UiDriver uiDriver = null;

	public void setUpClass() throws Exception{ 
		this.context = ContextProcessor.getCurrentContext(runConfig);
		switch(context){
		case PC_WEB: uiDriver = UiDriverFactory.getUiDriver(runConfig, AutomationContext.PC_WEB); break;
		case MOBILE_WEB: uiDriver = UiDriverFactory.getUiDriver(runConfig, AutomationContext.MOBILE_WEB); break;
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
		return new HomePage(this.getRunConfiguration(), this.getUiDriver());	
	}
}
