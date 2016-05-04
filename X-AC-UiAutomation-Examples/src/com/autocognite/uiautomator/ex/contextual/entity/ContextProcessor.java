package com.autocognite.uiautomator.ex.contextual.entity;

import java.util.ArrayList;

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.enums.AutomationContext;

public class ContextProcessor {

	public static AutomationContext getCurrentContext(RunConfiguration runConfig) throws Exception{
		ArrayList<AutomationContext> contexts = UiAutomator.getAllowedAutomationContexts(runConfig);
		int exclusiveContextCount = 0;
		boolean webFound = false;
		boolean mobileWebFound = false;
		
		if (contexts.contains(AutomationContext.PC_WEB)){
			exclusiveContextCount += 1;
			webFound = true;
		}
		
		if (contexts.contains(AutomationContext.MOBILE_WEB)){
			exclusiveContextCount += 1;
			mobileWebFound = true;
		}
		
		if (exclusiveContextCount > 1){
			throw new Exception("You have set two mutually exclusive contexts: " + contexts);
		}
		
		if (webFound){
			return AutomationContext.PC_WEB;
		} else if (mobileWebFound){
			return AutomationContext.MOBILE_WEB;
		} else {
			return null;
		}
	}
}
