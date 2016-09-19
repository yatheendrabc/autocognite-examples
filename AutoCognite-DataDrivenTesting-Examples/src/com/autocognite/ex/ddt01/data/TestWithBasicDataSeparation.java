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

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.databroker.lib.datarecord.DataRecord;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithData;

public class TestWithBasicDataSeparation extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	@DriveWithData({"1","2","3"})
	public void testWithSingleDataRecordPass(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = Integer.parseInt(leftOp);
		int r = Integer.parseInt(rightOp);
		int es = Integer.parseInt(expectedSum);
		assertEquals(es, l + r);
	}
	
	@DriveWithData({"1","2","4"})
	public void testWithSingleDataRecordFail(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = Integer.parseInt(leftOp);
		int r = Integer.parseInt(rightOp);
		int es = Integer.parseInt(expectedSum);
		assertEquals(es, l + r);
	}
	
	@DriveWithData(record={"1","2","3"}, format=DataFormat.LIST)
	public void testWithSingleDataRecordListFormatPass(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueAt(0));
		int r = Integer.parseInt(record.valueAt(1));
		int es = Integer.parseInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	@DriveWithData(record={"left=1","right=2","expected=3"}, format=DataFormat.MAP)
	public void testWithSingleDataRecordMapFormatPass(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueOf("left"));
		int r = Integer.parseInt(record.valueOf("right"));
		int es = Integer.parseInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	@DriveWithData(
			headers = {"left", "right", "expected"},
			record={"1","2","3"},
			format=DataFormat.MAP
	)
	public void testWithSingleDataRecordMapFormatSepHeaders(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueOf("left"));
		int r = Integer.parseInt(record.valueOf("right"));
		int es = Integer.parseInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
}

