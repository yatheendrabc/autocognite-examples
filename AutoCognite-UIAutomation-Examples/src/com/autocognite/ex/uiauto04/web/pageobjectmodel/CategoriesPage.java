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

import com.autocognite.user.uiautomator.api.UiDriver;
import com.autocognite.user.uiautomator.api.UiElement;

public class CategoriesPage extends DashBoardPage {
	public CategoriesPage (UiDriver uiDriver) throws Exception{
		super("Categories", uiDriver);
	}
	
	public void tweakCategories() throws Exception {
		element("CAT_CHECKBOXES").getInstanceAtOrdinal(2).check();
		element("CAT_CHECKBOXES").getInstanceAtIndex(1).uncheck();
		for (UiElement element: element("CAT_CHECKBOXES").getAllInstances()){
			element.check();
			element.uncheck();
		}
	}
}
