/*******************************************************************************
 * Copyright 2016 AutoCognite Testing Research Pvt Ltd (Web: www.AutoCognite.com, Email: support [at] autocognite.com)
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
package com.autocognite.teststyler.ddt.ex.data;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.databroker.lib.datarecord.DataRecord;
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
	
	// However sometimes you have a large number of array items. Becomes more evident later when we move to file based DDT.
	// In such cases you might want to retain consistent test signatures and process the arrays that contain
	// different number of items.
	// Note the arguments of Annotation as well as the test method.
	@DriveWithData(record={"1","2","3"}, format=DataFormat.LIST)
	public void testWithSingleDataRecordListFormatPass(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueAt(0));
		int r = Integer.parseInt(record.valueAt(1));
		int es = Integer.parseInt(record.valueAt(2));
		assertEquals(es, l + r);
	}	
	
	// There is still another use case especially with more data arguments.
	// You don't want the test code to be brittle by referring to arguments by position.
	// Note the arguments of Annotation as well as the test method.
	@DriveWithData(record={"left=1","right=2","expected=3"}, format=DataFormat.MAP)
	public void testWithSingleDataRecordMapFormatPass(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueOf("left"));
		int r = Integer.parseInt(record.valueOf("right"));
		//you also get case insensitivity
		int es = Integer.parseInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
	
	// You can also separate headers and values
	// This is the suggested way as it is consistent with other advanced annotations
	@DriveWithData(
			headers = {"left", "right", "expected"},
			record={"1","2","3"},
			format=DataFormat.MAP
	)
	public void testWithSingleDataRecordMapFormatSepHeaders(DataRecord record) throws Exception{
		int l = Integer.parseInt(record.valueOf("left"));
		int r = Integer.parseInt(record.valueOf("right"));
		//you also get case insensitivity
		int es = Integer.parseInt(record.valueOf("EXPECTED"));
		assertEquals(es, l + r);
	}
}

