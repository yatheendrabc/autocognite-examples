package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.batteries.api.enums.FileFormat;
import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.UiMapper;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.DefaultCompositePage;
import com.autocognite.uiautomator.lib.ext.factories.UiMapperFactory;

public abstract class BasePage extends DefaultCompositePage {
	LeftNavigationSubPage leftNavigation = null;
	public static final String web = "web";
	private AutomationContext context = null;
	UiDriver uiDriver = null;
	
	private String getIniMapFilePath(){
		return  runConfig.get(UiAutomator.UI_MAPS_DIR) + "/wordpress-pages" + "/" + getName() + ".ini";
	}
	
	private void initialize() throws Exception{
		UiMapper mapper = UiMapperFactory.getFileMapper(FileFormat.INI, getIniMapFilePath());
		populate(mapper);		
	}

	public BasePage(String entityName, RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super(entityName, runConfig);
		this.uiDriver = uiDriver;
		this.registerPage(web, this.uiDriver);
		this.context = ContextProcessor.getCurrentContext(runConfig);
		initialize();
	}
	
	protected UiDriver getUiDriver(){
		return this.uiDriver;
	}
	
	public LeftNavigationSubPage getLeftNavigation() throws Exception{
		if (leftNavigation == null){
			return new LeftNavigationSubPage(runConfig, this.getUiDriver());
		} else {
			return leftNavigation;
		}
	}
	
	protected boolean isInMobileWebContext(){
		return context == AutomationContext.MOBILE_WEB;
	}
	
	protected boolean isInPCWebContext(){
		return context == AutomationContext.PC_WEB;
	}
}