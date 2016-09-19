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
package com.autocognite.ex.uiauto01.web.uidriver;

import static com.autocognite.user.validator.lib.Assertions.assertTrue;

import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.uiautomator.api.UiDriver;
import com.autocognite.user.uiautomator.api.UiElement;
import com.autocognite.user.uiautomator.lib.factory.UiDriverFactory;

public class WebTestAutomationWithUiDriver extends Test{
	//change ip as per your install
	static String appUrl = "http://10.10.1.32";
	static String adminUrl = appUrl + "/wp-admin/";
	static String logoutUrl = appUrl + "/wp-login.php?action=logout";
	
	public void test() throws Exception{
		UiDriver uiDriver = UiDriverFactory.getWebUiDriver(getRunConfig());
		uiDriver.goTo(adminUrl);		

		uiDriver.elementWithId("user_login").waitForPresence();
		uiDriver.elementWithId("user_login").enterText("user");
		uiDriver.elementWithId("user_pass").enterText("bitnami");
		uiDriver.elementWithId("wp-submit").click();
		
		uiDriver.elementWithCss(".dashicons-admin-post").hoverAndClickElement(uiDriver.elementWithLinkText("Categories"));
		uiDriver.elementWithName("delete_tags[]").getInstanceAtOrdinal(2).check();
		uiDriver.elementWithName("delete_tags[]").getInstanceAtIndex(1).uncheck();
		
		for (UiElement element: uiDriver.elementWithName("delete_tags[]").getAllInstances()){
			element.check();
			element.uncheck();
		}
		
		// Tests for alternate instance methods
		uiDriver.elementWithName("delete_tags[]").getFirstInstance().check();
		uiDriver.elementWithName("delete_tags[]").getFirstInstance().uncheck();
		
		uiDriver.elementWithName("delete_tags[]").identifyAll().getLastInstance().check();
		uiDriver.elementWithName("delete_tags[]").identifyAll().getLastInstance().uncheck();
		
		
		uiDriver.elementWithName("delete_tags[]").identifyAll().getRandomInstance().check();
		uiDriver.elementWithName("delete_tags[]").identifyAll().getRandomInstance().uncheck();
	
		uiDriver.elementWithCss(".dashicons-admin-settings").click();
		uiDriver.elementWithId("blogname").enterText("Hello");
		uiDriver.elementWithId("blogname").enterText("Hello");
		uiDriver.elementWithId("blogname").setText("Hello");
		uiDriver.elementWithId("users_can_register").check();

		// Experiments with Select control - Selection using different attributes
		uiDriver.elementWithId("default_role").selectLabel("Author");
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedLabel("Author"));
		uiDriver.elementWithId("default_role").selectIndex(0);
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedIndex(0));
		uiDriver.elementWithId("default_role").selectValue("author");
		assertTrue(uiDriver.elementWithId("default_role").hasSelectedValue("author"));
		
		uiDriver.goTo(logoutUrl);
		uiDriver.close();
	}
}
