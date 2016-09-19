/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
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
package com.autocognite.ex.uiauto03.web.app;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.uiautomator.api.App;
import com.autocognite.user.uiautomator.api.StandalonePage;
import com.autocognite.user.uiautomator.api.UiDriver;
import com.autocognite.user.uiautomator.api.UiElement;
import com.autocognite.user.uiautomator.lib.factory.UiFactory;
import com.autocognite.user.uiautomator.lib.factory.UiDriverFactory;

public class WebTestAutomationWithUiApp extends Test{
	static String appUrl = "http://10.10.1.32";
	static String adminUrl = appUrl + "/wp-admin/";
	static String logoutUrl = appUrl + "/wp-login.php?action=logout";
	
	public void test() throws Exception{
		UiDriver uiDriver = UiDriverFactory.getWebUiDriver(getRunConfig());
		uiDriver.goTo(adminUrl);
		
		App wordpress = UiFactory.getSimpleApp("wordpress", uiDriver, "/wordpress");		

		wordpress.page("HomePage").element("LOGIN").waitForPresence();
		wordpress.page("HomePage").element("LOGIN").enterText("user");
		wordpress.page("HomePage").element("PASSWORD").enterText("bitnami");
		wordpress.page("HomePage").element("SUBMIT").click();		
	
		wordpress.page("LeftNavigation").element("POSTS").hoverAndClickElement(wordpress.page("LeftNavigation").element("CATEGORIES"));	

		wordpress.page("Categories").element("CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		wordpress.page("Categories").element("CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
			
		for (UiElement element: wordpress.page("Categories").element("CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}

		wordpress.page("LeftNavigation").element("SETTINGS").click();
			
		wordpress.page("Settings").element("BLOG_NAME").enterText("Hello");
		wordpress.page("Settings").element("BLOG_NAME").enterText("Hello");
		wordpress.page("Settings").element("BLOG_NAME").setText("Hello");
		wordpress.page("Settings").element("MEMBERSHIP").check();

		// Experiments with Select control - Selection using different attributes
		wordpress.page("Settings").element("ROLE").selectLabel("Author");
		assertTrue(wordpress.page("Settings").element("ROLE").hasSelectedLabel("Author"));
		wordpress.page("Settings").element("ROLE").selectIndex(0);
		assertTrue(wordpress.page("Settings").element("ROLE").hasSelectedIndex(0));
		wordpress.page("Settings").element("ROLE").selectValue("author");
		assertTrue(wordpress.page("Settings").element("ROLE").hasSelectedValue("author"));

		uiDriver.goTo(logoutUrl);

		uiDriver.close();
	}
}
