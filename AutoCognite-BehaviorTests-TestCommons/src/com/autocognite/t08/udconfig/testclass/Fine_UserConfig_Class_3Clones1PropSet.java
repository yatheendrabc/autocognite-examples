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
package com.autocognite.t08.udconfig.testclass;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.assertions.Assertions;

@TestClass
@Clone(count=3, properties = {"my.prop=value1"})
public class Fine_UserConfig_Class_3Clones1PropSet{
	private UserDefinedConfig myConfig = null;
	
	public Fine_UserConfig_Class_3Clones1PropSet(UserDefinedConfig config){
		System.err.println(config.props());
		this.myConfig = config;
	}

}