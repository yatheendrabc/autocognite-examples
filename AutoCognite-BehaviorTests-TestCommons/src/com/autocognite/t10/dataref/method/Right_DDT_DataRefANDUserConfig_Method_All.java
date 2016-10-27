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
package com.autocognite.t10.dataref.method;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.batteries.databroker.DataReference;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.annotations.ddt.Data;
import com.autocognite.testcommons.annotations.ddt.DriveWithData;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataArray;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataFile;
import com.autocognite.testcommons.annotations.ddt.FileDataReference;
import com.autocognite.testcommons.assertions.Assertions;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class Right_DDT_DataRefANDUserConfig_Method_All{
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData({"1","2","1::2"})
	public void testWithSingleDataRecordPass(UserDefinedConfig config, DataReference dataRef, String left, String right, String expected) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
		assertEquals(config.value("a"), "b");
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData({"1","2","1::3"})
	public void testWithSingleDataRecordFail(UserDefinedConfig config, DataReference dataRef, String left, String right, String expected) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
		assertEquals(config.value("a"), "b");
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"1","2","1::2"}, format=DataFormat.LIST)
	public void testWithSingleDataRecordListFormatPass(UserDefinedConfig config, DataReference dataRef, DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"left=1","right=2","expected=1::2"}, format=DataFormat.MAP)
	public void testWithSingleDataRecordMapFormatPass(UserDefinedConfig config, DataReference dataRef, DataRecord record) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(
			headers = {"left", "right", "expected"},
			record={"1","2","1::2"},
			format=DataFormat.MAP
	)
	public void testWithSingleDataRecordMapFormatSepHeaders(UserDefinedConfig config, DataReference dataRef, DataRecord record) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithDataArray(
			{
				@Data({"1","2","1::2"}), 
				@Data({"4","5","4::6"})
			}
	)
	public void testWithDataArray(UserDefinedConfig config, DataReference dataRef, String left, String right, String expected) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}

	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithDataArray(
	records = {
			@Data({"1","2","1::2"}), 
			@Data({"4","5","4::6"})
			},
	format = DataFormat.LIST
	)
	public void testWithDataArrayListFormat(UserDefinedConfig config, DataReference dataRef, DataRecord record) throws Exception{
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithDataArray(
	headers = {"left", "right", "expected"},
	records = {
			@Data({"1","2","1::2"}), 
			@Data({"4","5","4::6"})
			},
	format = DataFormat.MAP
	)
	public void testWithDataArrayMapFormat(UserDefinedConfig config, DataReference dataRef, DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
}
