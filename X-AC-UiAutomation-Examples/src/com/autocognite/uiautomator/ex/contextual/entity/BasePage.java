/*******************************************************************************
 * Copyright 2016 Rahul Verma (Web: www.AutoCognite.com, Email: RV@autocognite.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.autocognite.uiautomator.ex.contextual.entity;

import com.autocognite.batteries.api.enums.FileFormat;
import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.PageMapper;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.DefaultCompositePage;
import com.autocognite.uiautomator.lib.factory.PageMapperFactory;

public abstract class BasePage extends DefaultCompositePage {
	LeftNavigationSubPage leftNavigation = null;
	public static final String web = "web";
	private AutomationContext context = null;
	UiDriver uiDriver = null;
	
	private String getIniMapFilePath(){
		return  getRunConfig().get(UiAutomator.UI_MAPS_DIR) + "/wordpress-pages" + "/" + getName() + ".ini";
	}
	
	private void initialize() throws Exception{
		PageMapper mapper = PageMapperFactory.getFileMapper(FileFormat.INI, getIniMapFilePath());
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
			return new LeftNavigationSubPage(getRunConfig(), this.getUiDriver());
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
