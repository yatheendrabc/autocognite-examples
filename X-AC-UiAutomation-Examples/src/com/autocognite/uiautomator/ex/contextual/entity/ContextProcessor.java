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
