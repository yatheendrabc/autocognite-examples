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

import static com.autocognite.testcommons.assertions.Assertions.error;
import static com.autocognite.testcommons.assertions.Assertions.fail;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.testcommons.annotate.AfterClass;
import com.autocognite.testcommons.annotate.AfterMethod;
import com.autocognite.testcommons.annotate.BeforeClass;
import com.autocognite.testcommons.annotate.BeforeMethod;
import com.autocognite.testcommons.annotate.TestClass;
import com.autocognite.testcommons.annotate.TestMethod;

@TestClass(
		name="Custom name", 
		customProps={"my1=3"}
)
public class AnnotationMixWithFixtureIssues{
	private static Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@BeforeClass
	public void createTestFiles() throws Exception{
		System.out.println("Custom Set Up class executed");
		fail("Simulating an issue in setUpClass");
	}
	
	@BeforeMethod
	public void launchTool(){
		System.out.println("Custom Set Up executed");
	}
	
	@AfterMethod
	public void stopTool(){
		System.out.println("Custom Tear Down executed");
	}
	
	@AfterClass
	public void deleteTestFiles() throws Exception{
		System.out.println("Custom Tear Down Class executed");
		fail("Simulating an issue in setUpClass");
	}
	
	@TestMethod(id="Custom id-2", name="b")
	public void deleteFile() throws Exception{	
		System.out.println("Custom Test Method delete File executed.");
	}
	
	@TestMethod(id="Custom id-3", customProps={"my1=5","POLICY Name = Hoho", "qh_prop=c", "tags=abc"})
	public void createFile() throws Exception{	
		System.out.println("Custom Test Method create File executed.");
		// Simulate failure
		fail("Simulated Failure");
	}
	
	@TestMethod(id="Custom id-5", customProps={"POLICY Name = Hoho2", "name=f", "tags=xyz"})
	public void updateFile() throws Exception{	
		System.out.println("Custom Test Method create File executed.");
		// Simulate failure
		error("Simulated Error");
	}

}
