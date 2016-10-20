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
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.deps.DependsOn;

@TestClass
public class SameClassMethodDeps{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	public void test2(){
		logger.debug("Should be executed 1st.");
	}
	
	@DependsOn("test3")
	public void test1(){
		logger.debug("Should be executed 3rd.");
	}

	@DependsOn("test7")
	public void test3(){
		logger.debug("Should be executed 2nd.");
	}
	
	@DependsOn({"test1"})//, "test3", "test2"})
	public void test7(){
		logger.debug("Should be executed 4th.");
	}
}

