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
package com.autocognite.t10.dataref.method;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.batteries.databroker.DataReference;
import com.autocognite.testcommons.annotations.Clone;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DriveWithData;
import com.autocognite.testcommons.annotations.ddt.FileDataReference;

@TestClass
public class Wrong_DataRef_DDTMethod_WithUserProps_WrongArgOrder{

	@FileDataReference("dataref.xls")
	@Clone(properties={"a=b"})
	@DriveWithData({"1","2","1::2"})
	public void test(DataReference dataRef, UserDefinedConfig config, String left, String right, String expected){
	}
}
