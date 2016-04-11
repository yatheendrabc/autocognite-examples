package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.teststyler.lib.ext.TestMethodSuite;
import com.autocognite.uiautomator.api.core.UiDriver;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.ext.factories.UiDriverFactory;

public abstract class BaseTest extends TestMethodSuite{
	private AutomationContext context = null;
	private UiDriver automator = null;

	public void setUpClass() throws Exception{ 
		this.context = ConfigSingleton.getCurrentContext(runConfig);
		switch(context){
		case PC_WEB: automator = UiDriverFactory.getUiDriver(runConfig, AutomationContext.PC_WEB); break;
		case MOBILE_WEB: automator = UiDriverFactory.getUiDriver(runConfig, AutomationContext.MOBILE_WEB); break;
		default: break;
		}
	}
	
	public void tearDownClass() throws Exception{
		automator.close();
	}
	
	public UiDriver getAutomator(){
		return automator;
	}
	
	public HomePage createHomePage() throws Exception{
		return new HomePage(this.getRunConfiguration(), this.getAutomator());	
	}
}
