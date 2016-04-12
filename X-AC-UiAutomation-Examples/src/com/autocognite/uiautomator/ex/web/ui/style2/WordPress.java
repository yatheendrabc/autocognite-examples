package com.autocognite.uiautomator.ex.web.ui.style2;

import com.autocognite.batteries.api.enums.FileFormat;
import com.autocognite.configurator.api.config.RunConfiguration;
import com.autocognite.configurator.lib.property.Properties;
import com.autocognite.uiautomator.api.core.Ui;
import com.autocognite.uiautomator.api.core.UiMapper;
import com.autocognite.uiautomator.api.enums.AutomationContext;
import com.autocognite.uiautomator.lib.ext.factories.UiFactory;
import com.autocognite.uiautomator.lib.ext.uiautomator.UiMapperFactory;

public class WordPress {
	
	private static String getIniMapFilePath(RunConfiguration runConfig, String pageName){
		return  runConfig.get(Properties.UI_MAPS_DIR) + "/wordpress-pages" + "/" + pageName + ".ini";
	}
	
	public static Ui getPage(BaseTest test, String pageName) throws Exception{
		// Create Ui Mapper
		UiMapper mapper = UiMapperFactory.getFileMapper(
												FileFormat.INI, 
												getIniMapFilePath(test.getRunConfiguration(), pageName));
		// Create Ui
		Ui ui = UiFactory.getUi(test.getRunConfiguration(), test.getUiDriver(), mapper, AutomationContext.PC_WEB);
		return ui;
	}
}
