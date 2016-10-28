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
package com.autocognite.t06.invoker;

import static com.autocognite.testcommons.assertions.Assertions.*;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.annotations.ddt.Data;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataArray;
import com.autocognite.testcommons.enums.DataFormat;
//
@Clone(3)
@TestClass
public class DDTMultiInvokeExample{
	
	public void setUpClass(){
		System.out.println("" + ": Called setUpClass");
	}
	
	public void setUpMethod(){
		System.out.println("" + ": Called setUpMethod");
	}
	
	public void setUpTest(){
		System.out.println("" + ": Called setUpTest");
	}
	
	public void tearDownTest(){
		System.out.println("" + ": Called testDownTest");
	}
	
	public void tearDownMethod(){
		System.out.println("" + ": Called tearDownMethod");
	}
	
	public void tearDownClass(){
		System.out.println("" + ": Called tearDownClass");
	}

	@Clone(5)
	public void testMethod1() throws Exception{
		System.out.println("" + ": Called testMethod 1");
		assertEquals(1,1);
	}
	
	public void testMethod2() throws Exception{
		System.out.println("" + ": Called testMethod 2");
		assertEquals(3,4);
	}
	
	@Clone(5)
	@DriveWithDataArray(
	headers = {"left", "right", "expected"},
	records = {
			@Data({"1","2","1::2"}), 
			@Data({"4","5","4::6"})
			},
	format = DataFormat.MAP
	)
	public void testWithDataArrayMapFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
}
