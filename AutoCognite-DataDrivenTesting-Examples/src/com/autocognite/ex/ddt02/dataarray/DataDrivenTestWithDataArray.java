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
package com.autocognite.ex.ddt02.dataarray;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.*;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class DataDrivenTestWithDataArray{
	
	// What we have done so far is good for one record.
	// What happens when we need more?
	// You can use the DataArray annotation.
	// The test method would run as many times as the number of records provided.
	// Formats work as expected.
	@DriveWithDataArray(
			{
				@Data({"1","2","1::2"}), 
				@Data({"4","5","4::6"})
			}
	)
	public void testWithDataArray(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}

	@DriveWithDataArray(
	records = {
			@Data({"1","2","1::2"}), 
			@Data({"4","5","4::6"})
			},
	format = DataFormat.LIST
	)
	public void testWithDataArrayListFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
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

