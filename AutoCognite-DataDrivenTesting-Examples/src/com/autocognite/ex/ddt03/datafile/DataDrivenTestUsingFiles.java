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
package com.autocognite.ex.ddt03.datafile;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataFile;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class DataDrivenTestUsingFiles{

	// The arguments is an absolute path or path inside/relative to default data sources (/data/sources) directory.
	// For these examples, the files are assumed to be present inside the default directory
	
	@DriveWithDataFile("input.xls")
	public void testWithXLSDataFile(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}	

	@DriveWithDataFile(location="input.xls", format=DataFormat.LIST)
	public void testWithXLSDataFileListFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
	@DriveWithDataFile(location="input.xls", format=DataFormat.MAP)
	public void testWithXLSDataFileMapFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	// You can use a tab delimited file in the same manner
	@DriveWithDataFile("input.txt")
	public void testWithTSVDataFile(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}

	@DriveWithDataFile(location="input.txt", format=DataFormat.LIST)
	public void testWithTSVDataFileListFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
	@DriveWithDataFile(location="input.txt", format=DataFormat.MAP)
	public void testWithTSVDataFileMapFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	// You can use a CSV file or any other delimited file by specifying delimiter
	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ","
	)
	public void testWithCSVDataFile(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}	

	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ",", 
			format=DataFormat.LIST
	)
	public void testWithCSVDataFileListFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueAt(0), record.valueAt(1));
		assertEquals(actual, record.valueAt(2));
	}	
	
	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ",", 
			format=DataFormat.MAP
	)
	public void testWithCSVDataFileMapFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
	// You can also use INI file.
	// As the section data inside an INI file is unordered, don't use it for positional reading.
	// This means that the INI format should only be used for Map data format.	
	@DriveWithDataFile(
			location = "input.ini",
			format=DataFormat.MAP
	)
	public void testWithINIDataFileMapFormat(DataRecord record) throws Exception{
		String actual = String.format("%s::%s", record.valueOf("left"), record.valueOf("right"));
		assertEquals(actual, record.valueOf("EXPECTED"));
	}
	
}

