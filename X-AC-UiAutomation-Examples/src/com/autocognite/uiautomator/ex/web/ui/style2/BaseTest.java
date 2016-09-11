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

import com.autocognite.uiautomator.api.StandalonePage;
import com.autocognite.uiautomator.api.UiDriver;
import com.autocognite.uiautomator.lib.factory.UiDriverFactory;
import com.autocognite.user.testcore.lib.test.Test;

public abstract class BaseTest extends Test{
	private UiDriver uiDriver = null;

	public void setUpClass() throws Exception{
		uiDriver = UiDriverFactory.getWebUiDriver(getRunConfig());
	}
	
	public void tearDownClass() throws Exception{
		uiDriver.close();
	}
	
	public UiDriver getUiDriver(){
		return uiDriver;
	}
	
	public StandalonePage getPage(String pageName) throws Exception{
		return WordPress.getPage(this, pageName);
	}
}
