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

import static com.autocognite.user.validator.lib.Assertions.fail;

import org.apache.log4j.Logger;
import static com.autocognite.user.validator.lib.Assertions.*;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.AfterTestClass;
import com.autocognite.user.testcore.lib.annotate.AfterTestMethod;
import com.autocognite.user.testcore.lib.annotate.BeforeTestClass;
import com.autocognite.user.testcore.lib.annotate.BeforeTestMethod;
import com.autocognite.user.testcore.lib.annotate.TestMethod;
import com.autocognite.user.testcore.lib.annotate.TestProperties;

@TestProperties(
		name="Custom name", 
		customProps={"my1=3"}
)
public class AnnotationMixWithFixtureIssues extends Test{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@BeforeTestClass
	public void createTestFiles() throws Exception{
		logger.info("Custom Set Up class executed");
		fail("Simulating an issue in setUpClass");
	}
	
	@BeforeTestMethod
	public void launchTool(){
		logger.info("Custom Set Up executed");
	}
	
	@AfterTestMethod
	public void stopTool(){
		logger.info("Custom Tear Down executed");
	}
	
	@AfterTestClass
	public void deleteTestFiles() throws Exception{
		logger.info("Custom Tear Down Class executed");
		fail("Simulating an issue in setUpClass");
	}
	
	@TestMethod
	@TestProperties(id="Custom id-2", name="b")
	public void deleteFile() throws Exception{	
		logger.info("Custom Test Method delete File executed.");
	}
	
	@TestMethod
	@TestProperties(id="Custom id-3", customProps={"my1=5","POLICY Name = Hoho", "qh_prop=c", "tags=abc"})
	public void createFile() throws Exception{	
		logger.info("Custom Test Method create File executed.");
		// Simulate failure
		fail("Simulated Failure");
	}
	
	@TestMethod
	@TestProperties(id="Custom id-5", customProps={"POLICY Name = Hoho2", "name=f", "tags=xyz"})
	public void updateFile() throws Exception{	
		logger.info("Custom Test Method create File executed.");
		// Simulate failure
		error("Simulated Error");
	}

}
