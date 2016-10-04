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

import static com.autocognite.testcommons.assertions.Assertions.*;
import com.autocognite.testcommons.annotations.*;

@TestClass
public class FlexibleMethodsDemo{
	
	@BeforeClass
	public void createTestFiles(){
		System.out.println("Custom Set Up class executed");
	}
	
	@AfterClass
	public void deleteTestFiles(){
		System.out.println("Custom Tear Down Class executed");
	}
	
	@BeforeMethod
	public void addEnvVarForTool(){
		System.out.println("Custom Set Up Method executed");
	}
	
	@AfterMethod
	public void clearEnvVarForTool(){
		System.out.println("Custom Tear Down Method executed");
	}
	
	@BeforeTest
	public void launchTool(){
		System.out.println("Custom Set Up Test executed");
	}
	
	@AfterTest
	public void stopTool(){
		System.out.println("Custom Tear Down Test executed");
	}
	
	@TestMethod
	public void deleteFile() throws Exception{	
		System.out.println("Custom Test Method delete File executed.");
	}
	
	@TestMethod
	public void createFile() throws Exception{	
		System.out.println("Custom Test Method create File executed.");
		// Simulate failure
		fail("Simulated Failure");
	}
	
	@TestMethod
	public void updateFile() throws Exception{	
		System.out.println("Custom Test Method create File executed.");
		// Simulate failure
		error("Simulated Error");
	}

}
