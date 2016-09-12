/*******************************************************************************
 * Copyright 2016 Rahul Verma (Web: www.AutoCognite.com, Email: RV@autocognite.com)
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
package com.autocognite.teststyler.ddt.ex;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.user.testcore.lib.annotate.Data;
import com.autocognite.user.testcore.lib.annotate.DataArray;
import com.autocognite.user.testcore.lib.annotate.DataSourceFile;
import com.autocognite.user.testcore.lib.annotate.DataFormat;
import com.autocognite.user.testcore.lib.test.Test;
import com.autocognite.utils.lib.DataBatteries;
//Test
public class DataDrivenTestExamples extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	public void init() throws Exception {
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input.xls");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input.csv", ",");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input.ini");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input.ini");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input.txt");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input_exclude_option.xls");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input_exclude_option.ini");
		//setDataSource(getRunConfig().get(DataBroker.DATA_SOURCES_DIR) + "/input_exclude_option.txt");
	}
		
	
	// To pass a single data record. Argument must be a String[]
	// You would need to take care of the data conversion in the test body.
	// Can be used to place data outside of test method or of test methods take arguments.
	@Data({"1","2","3"})
	public void testWithSingleDataRecordPass(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}
	
	@Data({"1","2","4"})
	public void testWithSingleDataRecordFail(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}
	
	// However sometimes you have a large number of array items. Becomes more evident later when we move to file based DDT.
	// In such cases you might want to retain consistent test signatures and process the arrays that contain
	// different number of items.
	// Note the arguments of Annotation as well as the test method.
	@Data(record={"1","2","3"}, format=DataFormat.LIST)
	public void testWithSingleDataRecordListFormatPass(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	// There is still another use case especially with more data arguments.
	// You don't want the test code to be brittle by referring to arguments by position.
	// Note the arguments of Annotation as well as the test method.
	@Data(record={"left=1","right=2","expected=3"}, format=DataFormat.MAP)
	public void testWithSingleDataRecordMapFormatPass(DataRecord record) throws Exception{
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		//you also get case insensitivity
		int es = strToInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	
	
	// What we have done so far is good for one record.
	// What happens when we need more?
	// You can use the DataArray annotation.
	// The test method would run as many times as the number of records provided.
	// Formats work as expected.
	@DataArray(
			{
				@Data({"1","2","3"}), 
				@Data({"3","4","10"})
			}
	)
	public void testWithDataArray(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}

	@DataArray(
	records = {
				@Data({"1","2","3"}), 
				@Data({"3","4","10"})
			},
	format = DataFormat.LIST
	)
	public void testWithDataArrayListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}
	
	@DataArray(
	records = {
				@Data({"left=1","right=2","expected=3"}), 
				@Data({"left=3","right=4","expected=10"})
			},
	format = DataFormat.MAP
	)
	public void testWithDataArrayMapFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	
	// This could soon grow in complexity as you come up with more and more interesting data to drive tests.
	// An easy way to get this managed is by putting data in external files.
	// If you provide a full file path, that is considered, else it is considered relative to default data directory.
	
	@DataSourceFile("/Users/rahulverma/Documents/coding_workbench/temp/data/input.xls")
	public void testWithXlsDataFile(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	@DataSourceFile(location="/Users/rahulverma/Documents/coding_workbench/temp/data/input.xls", format=DataFormat.LIST)
	public void testWithXlsDataFileListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DataSourceFile(location="/Users/rahulverma/Documents/coding_workbench/temp/data/input.xls", format=DataFormat.MAP)
	public void testWithTSVDataFileMapFormat(DataRecord record) throws Exception{
		logger.debug(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
	// You can use a tab delimited file in the same manner
	@DataSourceFile("/Users/rahulverma/Documents/coding_workbench/temp/data/input.txt")
	public void testWithTSVDataFile(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	@DataSourceFile(location="/Users/rahulverma/Documents/coding_workbench/temp/data/input.txt", format=DataFormat.LIST)
	public void testWithTSVDataFileListFormat(DataRecord record) throws Exception{
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DataSourceFile(location="/Users/rahulverma/Documents/coding_workbench/temp/data/input.txt", format=DataFormat.MAP)
	public void testWithXlsDataFileMapFormat(DataRecord record) throws Exception{
		logger.debug(DataBatteries.flatten(record.map()));
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("SUM"));
		assertEquals(es, l + r);
	}
	
}

