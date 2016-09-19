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
package com.autocognite.ex.uiauto04.web.pageobjectmodel;

import com.autocognite.uiautomator.ex.config.WordPressConfiguration;
import com.autocognite.user.configurator.api.RunConfiguration;
import com.autocognite.user.uiautomator.api.UiDriver;

public class HomePage extends SimplePage {
	public HomePage (UiDriver uiDriver) throws Exception{
		super("HomePage", uiDriver);
		this.populate("wordpress" + "/HomePage.ini");
		this.goToBaseUrl();
	}
	
	public void goToBaseUrl() throws Exception{
		goTo(WordPressConfiguration.getAdminUrl());
	}
	
	public WelcomePage login() throws Exception{
		element("LOGIN").waitForPresence();
		element("LOGIN").enterText("user");
		element("PASSWORD").enterText("bitnami");
		element("SUBMIT").click();
		return new WelcomePage(this.getRunConfig(), this.getUiDriver());
	}
	
}
