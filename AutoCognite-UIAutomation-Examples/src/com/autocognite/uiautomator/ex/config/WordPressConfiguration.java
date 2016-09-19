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
package com.autocognite.uiautomator.ex.config;

public class WordPressConfiguration {

	// For demonstration focus on UI Automation, these properties have been kept here.
	// Not an ideal way.
	// You should look at using AutoCognite Configurator's property file support and keep these outside of code.
	// If you are using UI Automation with UniTEE, the same can be done directly by putting these in unitee.properties file.
	
	static String appUrl = "http://192.168.1.6";
	static String adminUrl = appUrl + "/wp-admin/";
	static String logoutUrl = appUrl + "/wp-login.php?action=logout";
	
	public static String getAdminUrl(){
		return adminUrl;
	}
	
	public static String getLogoutUrl(){
		return logoutUrl;
	}
}
