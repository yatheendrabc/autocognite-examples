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
package com.autocognite.ex.ddt06.fixtures;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.testcommons.annotate.TestClass;
import com.autocognite.testcommons.annotate.ddt.DataMethod;
import com.autocognite.testcommons.annotate.ddt.DriveWithDataMethod;

@TestClass
public class FixturesWithDDT{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	public void setUpClass(){
		logger.info("Called setUpClass");
	}
	
	public void setUpMethod(){
		logger.info("Called setUp");
	}
	
	public void setUpTest(){
		logger.info("Called setUpTest");
	}
	
	public void testDownTest(){
		logger.info("Called testDownTest");
	}
	
	public void tearDownMethod(){
		logger.info("Called tearDown");
	}
	
	public void tearDownClass(){
		logger.info("Called tearDownClass");
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

