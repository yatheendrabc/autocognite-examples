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
package com.autocognite.t05.dependencies;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.batteries.config.RunConfig;
import com.autocognite.testcommons.annotations.DependsOn;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.assertions.Assertions;

@TestClass
public class SecondTestClass{
	private static Logger logger = Logger.getLogger(RunConfig.getCentralLogName());

	public void test1() throws Exception{
		logger.debug("Executed");
	}
	
	@DependsOn({"com.autocognite.t05.dependencies.ThirdTestClass.testEx"})
	public void testEx(){
		logger.debug("Executed");
	}
}

