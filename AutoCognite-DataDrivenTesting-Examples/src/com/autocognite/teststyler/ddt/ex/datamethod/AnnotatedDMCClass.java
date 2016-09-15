/*******************************************************************************
 * Copyright 2016 AutoCognite Testing Research Pvt Ltd (Web: www.AutoCognite.com, Email: support [at] autocognite.com)
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
package com.autocognite.teststyler.ddt.ex.datamethod;

import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethod;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethodContainer;

@DataMethodContainer("SampleDataMethodContainer")
public class AnnotatedDMCClass{

	// This must be a STATIC method. 
	// Allowing non-static would have come at a cost of complicating annotation parameters or having only one data method per Class.
	// Definitions are pre-loaded by Test Commons before testing starts
	@DataMethod("ExternalDGMethod")
	public static DataRecordContainer dataGen(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{4,5,"45"},
				{4,5,"50"}
		};
		container.addAll(records);
		return container;
	}
}
