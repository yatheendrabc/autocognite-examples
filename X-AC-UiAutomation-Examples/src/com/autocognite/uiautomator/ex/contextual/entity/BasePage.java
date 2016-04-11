package com.autocognite.uiautomator.ex.contextual.entity;

import javax.security.auth.login.Configuration;

import com.autocognite.batteries.api.enums.FileFormat;
import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.configurator.lib.property.Properties;
import com.autocognite.uiautomator.api.core.UiDriver;
import com.autocognite.uiautomator.api.core.UiMapper;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.ext.uiautomator.DefaultUiEntity;
import com.autocognite.uiautomator.lib.ext.uiautomator.UiMapperFactory;

public abstract class BasePage extends DefaultUiEntity {
	LeftNavigationSubPage leftNavigation = null;
	public static final String web = "web";
	private AutomationContext context = null;
	UiDriver automator = null;
	
	private String getIniMapFilePath(){
		return  runConfig.get(Properties.UI_MAPS_DIR) + "/wordpress-pages" + "/" + getName() + ".ini";
	}
	
	private void initialize() throws Exception{
		UiMapper mapper = UiMapperFactory.getFileMapper(FileFormat.INI, getIniMapFilePath());
		populate(mapper);		
	}

	public BasePage(String entityName, RunConfiguration runConfig, UiDriver automator) throws Exception{
		super(entityName, runConfig);
		this.automator = automator;
		this.registerAutomator(web, this.automator);
		this.context = ConfigSingleton.getCurrentContext(runConfig);
		initialize();
	}
	
	protected UiDriver getAutomator(){
		return this.automator;
	}
	
	public LeftNavigationSubPage getLeftNavigation() throws Exception{
		if (leftNavigation == null){
			return new LeftNavigationSubPage(runConfig, this.getAutomator());
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