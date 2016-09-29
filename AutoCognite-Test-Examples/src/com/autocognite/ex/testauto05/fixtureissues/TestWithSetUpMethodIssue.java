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
package com.autocognite.ex.testauto05.fixtureissues;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;
import static com.autocognite.user.validator.lib.Assertions.fail;

import org.apache.log4j.Logger;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.testcore.lib.Test;

public class TestWithSetUpMethodIssue extends Test{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	public void setUpClass() throws Exception{
		logger.info("UserTest: Called setUpClass");
	}
	
	public void setUpMethod() throws Exception{
		logger.info("UserTest: Called setUp");
		fail("Simulating an issue in setUp");
	}
	
	public void setUpInstance() throws Exception{
		logger.info(getClassName() + ": Called setUpInstance");
		fail("Simulating an issue in setUpInstance");
	}
	
	public void tearDownInstance() throws Exception{
		logger.info(getClassName() + ": Called tearDownInstance");
		fail("Simulating an issue in tearDownInstance");
	}
	
	public void tearDownMethod() throws Exception{
		logger.info("UserTest: Called tearDown");
		fail("Simulating an issue in tearDown");
	}
	
	public void tearDownClass() throws Exception{
		logger.info("UserTest: Called tearDownClass");
		fail("Simulating an issue in tearDownClass");
	}

	public void testMethod1() throws Exception{
		logger.info("UserTest: Called testMethod1");
		assertEquals(1,1);
	}
	
	public void testMethod2() throws Exception{
		logger.info("UserTest: Called testMethod2");
		assertEquals(3,4);
	}
}
