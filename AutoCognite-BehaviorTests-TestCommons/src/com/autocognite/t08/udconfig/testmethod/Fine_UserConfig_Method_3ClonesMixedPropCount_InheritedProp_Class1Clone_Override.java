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
package com.autocognite.t08.udconfig.testmethod;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.assertions.Assertions;

@TestClass
@Clone(properties = {"class.common=classLevelValue"})
public class Fine_UserConfig_Method_3ClonesMixedPropCount_InheritedProp_Class1Clone_Override{
	private UserDefinedConfig classConfig = null;

	public Fine_UserConfig_Method_3ClonesMixedPropCount_InheritedProp_Class1Clone_Override(UserDefinedConfig config){
		System.err.println(config.props());
		this.classConfig = config;
	}
	
	@Clone(count=3, properties = {"same.for.all=value1", "diff12.same23=value1,value2", "diff.for.all=value1,value2,value3"})
	public void testEx(UserDefinedConfig config){
		System.err.println(config.props());
	}
	
	
	@Clone(count=3, properties = {"same.for.all=value1", "diff12.same23=value1,value2", "diff.for.all=value1,value2,value3", "class.common=overriden1,overriden2"})
	public void testEx2(UserDefinedConfig config){
		System.err.println(config.props());
	}
}