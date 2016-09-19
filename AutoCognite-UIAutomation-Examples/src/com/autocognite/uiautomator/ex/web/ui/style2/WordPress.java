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
package com.autocognite.uiautomator.ex.web.ui.style2;

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.PageMapper;
import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.factory.PageFactory;
import com.autocognite.uiautomator.lib.factory.PageMapperFactory;
import com.autocognite.utils.api.enums.FileFormat;

public class WordPress {
	
	private static String getIniMapFilePath(RunConfiguration runConfig, String pageName){
		return  runConfig.get(UiAutomator.UI_MAPS_DIR) + "/wordpress-pages" + "/" + pageName + ".ini";
	}
	
	public static StandalonePage getPage(BaseTest test, String pageName) throws Exception{
		// Create Ui Mapper
		PageMapper mapper = PageMapperFactory.getFileMapper(
												FileFormat.INI, 
												getIniMapFilePath(test.getRunConfig(), pageName));
		// Create Ui
		StandalonePage ui = PageFactory.getPage(test.getRunConfig(), test.getUiDriver(), mapper, AutomationContext.PC_WEB);
		return ui;
	}
}
