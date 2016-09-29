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
package com.autocognite.ex.problem01.fixtures;

import org.apache.log4j.Logger;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.BeforeClass;
import com.autocognite.user.testcore.lib.annotate.BeforeMethod;

public class MultipleFixturesOfSameType2 extends Test{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@BeforeClass
	public void someMethod1(){
		
	}
	
	public void setUpClass(){
		
	}

	public void test1(){
		logger.debug("Should not have happened.");
	}

}
