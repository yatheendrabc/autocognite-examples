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
package com.autocognite.ex.ddt01.data;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DriveWithData;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class TestWithBasicDataSeparation{

	
	@DriveWithData({"1","2","1::2"})
	public void testWithSingleDataRecordPass(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}
	
	@DriveWithData({"1","2","1::3"})
	public void testWithSingleDataRecordFail(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}
	
	@DriveWithData(record={"1","2","1::2"}, format=DataFormat.LIST)
	public void testWithSingleDataRecordListFormatPass(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
	@DriveWithData(record={"left=1","right=2","expected=1::2"}, format=DataFormat.MAP)
	public void testWithSingleDataRecordMapFormatPass(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	@DriveWithData(
			headers = {"left", "right", "expected"},
			record={"1","2","1::2"},
			format=DataFormat.MAP
	)
	public void testWithSingleDataRecordMapFormatSepHeaders(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
}

