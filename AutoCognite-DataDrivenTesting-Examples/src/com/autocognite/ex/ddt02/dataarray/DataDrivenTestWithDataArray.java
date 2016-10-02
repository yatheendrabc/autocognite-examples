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

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotate.TestClass;
import com.autocognite.testcommons.annotate.ddt.Data;
import com.autocognite.testcommons.annotate.ddt.DriveWithDataArray;
import com.autocognite.testcommons.enums.DataFormat;
//
@TestClass
public class DataDrivenTestWithDataArray{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	// What we have done so far is good for one record.
	// What happens when we need more?
	// You can use the DataArray annotation.
	// The test method would run as many times as the number of records provided.
	// Formats work as expected.
	@DriveWithDataArray(
			{
				@Data({"1","2","3"}), 
				@Data({"3","4","10"})
			}
	)
	public void testWithDataArray(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = Integer.parseInt(leftOp);
		int r = Integer.parseInt(rightOp);
		int es = Integer.parseInt(expectedSum);
		assertEquals(es, l + r);
	}

	@DriveWithDataArray(
	records = {
				@Data({"1","2","3"}), 
				@Data({"3","4","10"})
			},
	format = DataFormat.LIST
	)
	public void testWithDataArrayListFormat(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueAt(0));
		int r = Integer.parseInt(record.valueAt(1));
		int es = Integer.parseInt(record.valueAt(2));
		assertEquals(es, l + r);
	}
	
	@DriveWithDataArray(
	headers = {"left", "right", "expected"},
	records = {
				@Data({"1","2","3"}), 
				@Data({"3","4","10"})
			},
	format = DataFormat.MAP
	)
	public void testWithDataArrayMapFormat(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueOf("left"));
		int r = Integer.parseInt(record.valueOf("right"));
		int es = Integer.parseInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	
}

