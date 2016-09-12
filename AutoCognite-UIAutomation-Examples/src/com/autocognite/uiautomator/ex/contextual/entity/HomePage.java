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

import com.autocognite.configurator.api.RunConfiguration;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.ex.config.WordPressConfiguration;

public class HomePage extends BasePage {
	public HomePage (RunConfiguration runConfig, UiDriver uiDriver) throws Exception{
		super("HomePage", runConfig, uiDriver);
		this.goToBaseUrl();
	}
	
	public void goToBaseUrl() throws Exception{
		page(web).goTo(WordPressConfiguration.getAdminUrl());
	}
	
	public void login() throws Exception{
		page(web).element("LOGIN").waitForPresence();
		page(web).element("LOGIN").enterText("user");
		page(web).element("PASSWORD").enterText("bitnami");
		page(web).element("SUBMIT").click();
	}
	
	public void logout() throws Exception{
		page(web).goTo(WordPressConfiguration.getLogoutUrl());
		page(web).element("LOGOUT_CONFIRM").click();
	}
}
