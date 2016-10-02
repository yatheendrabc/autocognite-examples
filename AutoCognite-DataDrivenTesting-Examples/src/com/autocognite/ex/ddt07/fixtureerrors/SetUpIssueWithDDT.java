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
package com.autocognite.ex.ddt07.fixtureerrors;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import static com.autocognite.testcommons.assertions.Assertions.fail;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DataMethod;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataMethod;

@TestClass
public class SetUpIssueWithDDT{
	private Logger logger = Batteries.getCentralLogger();
	
	public void setUpClass() throws Exception{
		logger.info("UserTest: Called setUpClass");
	}
	
	public void setUpMethod() throws Exception{
		logger.info("UserTest: Called setUp");
		fail("Simulating an issue in setUp");
	}
	
	public void setUpTest() throws Exception{
		logger.info("Called setUpTest");
		fail("Simulating an issue in setUpTest");
	}
	
	public void testDownTest() throws Exception{
		logger.info("Called testDownTest");
		fail("Simulating an issue in testDownTest");
	}
	
	public void tearDownMethod() throws Exception{
		logger.info("UserTest: Called tearDown");
		fail("Simulating an issue in tearDown");
	}
	
	public void tearDownClass() throws Exception{
		logger.info("UserTest: Called tearDownClass");
		fail("Simulating an issue in tearDownClass");
	}

	@DataMethod
	public Object[][] getData(){
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		return records;
	}
	
	@DataMethod
	public Object[][] getData2(){
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		return records;
	}

	@DriveWithDataMethod("getData")
	public void test1(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
	
	@DriveWithDataMethod("getData")
	public void test2(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
	
	@DriveWithDataMethod("getData2")
	public void test3(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
	
	@DriveWithDataMethod("getData2")
	public void test4(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
}

