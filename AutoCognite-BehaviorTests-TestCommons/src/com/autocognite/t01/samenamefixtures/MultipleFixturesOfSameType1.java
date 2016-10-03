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
package com.autocognite.t01.samenamefixtures;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.testcommons.annotations.BeforeClass;
import com.autocognite.testcommons.annotations.BeforeMethod;
import com.autocognite.testcommons.annotations.TestClass;

@TestClass
public class MultipleFixturesOfSameType1{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@BeforeClass
	public void someMethod1(){
		
	}
	
	@BeforeClass
	public void someMethod2(){
		
	}
	
	@BeforeMethod
	public void someMethod3(){
		
	}
	
	@BeforeMethod
	public void someMethod4(){
		
	}

	public void test1(){
		logger.debug("Should not have happened.");
	}

}
