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
package com.autocognite.ex.testauto04.annotations;

import org.apache.log4j.Logger;
import static com.autocognite.user.validator.lib.Assertions.*;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.AfterClass;
import com.autocognite.user.testcore.lib.annotate.AfterMethod;
import com.autocognite.user.testcore.lib.annotate.BeforeClass;
import com.autocognite.user.testcore.lib.annotate.BeforeMethod;
import com.autocognite.user.testcore.lib.annotate.TestMethod;

public class FlexibleMethodsDemo extends Test{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@BeforeClass
	public void createTestFiles(){
		logger.info("Custom Set Up class executed");
	}
	
	@BeforeMethod
	public void launchTool(){
		logger.info("Custom Set Up executed");
	}
	
	@AfterMethod
	public void stopTool(){
		logger.info("Custom Tear Down executed");
	}
	
	@AfterClass
	public void deleteTestFiles(){
		logger.info("Custom Tear Down Class executed");
	}
	
	@TestMethod
	public void deleteFile() throws Exception{	
		logger.info("Custom Test Method delete File executed.");
	}
	
	@TestMethod
	public void createFile() throws Exception{	
		logger.info("Custom Test Method create File executed.");
		// Simulate failure
		fail("Simulated Failure");
	}
	
	@TestMethod
	public void updateFile() throws Exception{	
		logger.info("Custom Test Method create File executed.");
		// Simulate failure
		error("Simulated Error");
	}

}
