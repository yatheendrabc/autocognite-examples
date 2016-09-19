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

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.databroker.lib.datarecord.DataRecord;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.Data;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataArray;
//Test
public class DataDrivenTestWithDataArray extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
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
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
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
		int l = strToInt(record.valueAt(0));
		int r = strToInt(record.valueAt(1));
		int es = strToInt(record.valueAt(2));
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
		int l = strToInt(record.valueOf("left"));
		int r = strToInt(record.valueOf("right"));
		int es = strToInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	
}

