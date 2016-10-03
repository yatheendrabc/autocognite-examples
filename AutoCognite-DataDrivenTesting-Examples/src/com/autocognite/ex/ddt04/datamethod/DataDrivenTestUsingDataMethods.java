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
package com.autocognite.ex.ddt04.datamethod;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DataMethod;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataMethod;

@TestClass
public class DataDrivenTestUsingDataMethods{

	@DataMethod
	public Object[][] getData(){
		Object[][] records = {
				{1,2,"1::2"},
				{4,5,"4::6"},
		};
		return records;
	}

	@DriveWithDataMethod("getData")
	public void testWithLocalDataMethod1(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
	
	
	@DataMethod("User defined data method name")
	public Object[][] getData2(){
		Object[][] records = {
				{1,2,"1::2"},
				{4,5,"4::6"},
		};
		return records;
	}

	@DriveWithDataMethod("User defined data method name")
	public void testWithLocalDataMethod2(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}

}

