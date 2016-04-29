package com.autocognite.uiautomator.ex.web.ui.style2;

import com.autocognite.batteries.api.enums.FileFormat;
import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.uiautomator.UiAutomator;
import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.PageMapper;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.factory.PageFactory;
import com.autocognite.uiautomator.lib.factory.PageMapperFactory;

public class WordPress {
	
	private static String getIniMapFilePath(RunConfiguration runConfig, String pageName){
		return  runConfig.get(UiAutomator.UI_MAPS_DIR) + "/wordpress-pages" + "/" + pageName + ".ini";
	}
	
	public static StandalonePage getPage(BaseTest test, String pageName) throws Exception{
		// Create Ui Mapper
		PageMapper mapper = PageMapperFactory.getFileMapper(
												FileFormat.INI, 
												getIniMapFilePath(test.getRunConfiguration(), pageName));
		// Create Ui
		StandalonePage ui = PageFactory.getPage(test.getRunConfiguration(), test.getUiDriver(), mapper, AutomationContext.PC_WEB);
		return ui;
	}
}
