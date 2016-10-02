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

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.batteries.util.DataBatteries;
import com.autocognite.testcommons.annotate.TestClass;
import com.autocognite.testcommons.annotate.ddt.DriveWithDataFile;
import com.autocognite.testcommons.enums.DataFormat;
//Test
@TestClass
public class DataDrivenTestUsingFiles{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	// Using Data Arrays becomes cumbersome as you come up with more and more interesting data to drive tests.
	// An easy way to get this managed is by putting data in external files.
	// If you provide a full file path, that is considered, else it is considered relative to default data directory.
	@DriveWithDataFile("/Users/rahulverma/Documents/coding_workbench/temp/data/input.xls")
	public void testWithXLSDataFile1(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	
	
	
	// If you place the data file in the default data directory (<root>/data/sources), the path can ommitted as it is
	// calculated relative to the default directory.
	@DriveWithDataFile("input.xls")
	public void testWithXLSDataFile2(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	@DriveWithDataFile(location="input.xls", format=DataFormat.LIST)
	public void testWithXLSDataFileListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DriveWithDataFile(location="input.xls", format=DataFormat.MAP)
	public void testWithXLSDataFileMapFormat(DataRecord record) throws Exception{
		logger.debug(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
	// You can use a tab delimited file in the same manner
	@DriveWithDataFile("input.txt")
	public void testWithTSVDataFile(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	@DriveWithDataFile(location="input.txt", format=DataFormat.LIST)
	public void testWithTSVDataFileListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DriveWithDataFile(location="input.txt", format=DataFormat.MAP)
	public void testWithTSVDataFileMapFormat(DataRecord record) throws Exception{
		logger.debug(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
	// You can use a CSV file or any other delimited file by specifying delimiter
	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ","
	)
	public void testWithCSVDataFile(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ",", 
			format=DataFormat.LIST
	)
	public void testWithCSVDataFileListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DriveWithDataFile(
			location = "input.csv",
			delimiter = ",", 
			format=DataFormat.MAP
	)
	public void testWithCSVDataFileMapFormat(DataRecord record) throws Exception{
		logger.info(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
	// You can also use INI file.
	// As the section data inside an INI file is unordered, don't use it for positional reading.
	// This means that the INI format should only be used for Map data format.	
	@DriveWithDataFile(
			location = "input.ini",
			format=DataFormat.MAP
	)
	public void testWithINIDataFileMapFormat(DataRecord record) throws Exception{
//		logger.info(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
}

