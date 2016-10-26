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
package com.autocognite.t08.udconfig;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.assertions.Assertions;

@TestClass(methodThreads=3)
@Invoke(count=5, properties = {"my.prop=value1,value2,value3,value4,value5"})
public class UserConfigExample2{
	private UserDefinedConfig myConfig = null;
	
	public UserConfigExample2(UserDefinedConfig config){
		System.err.println(config.props());
		this.myConfig = config;
	}

	public void setUpClass() throws Exception{
		Assertions.assertEquals(myConfig.value("my.prop"), "hoho");
	}
	
	public void testEx() throws Exception{	
		
	}
}
