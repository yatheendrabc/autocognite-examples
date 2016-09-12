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
package com.autocognite.ddtstyler.ex;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import com.autocognite.databroker.DataBroker;
import com.autocognite.databroker.api.datarecord.ListDataRecord;
import com.autocognite.databroker.api.datarecord.MapDataRecord;
import com.autocognite.user.testcore.lib.test.Test;
//Test
public class DataDrivenTest extends Test {

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
		
	public void repeat(ListDataRecord record) throws Exception {
		int left = strToInt(record.get(0));
		int right = strToInt(record.get(1));
		int expectedSum = strToInt(record.get(2));
		assertEquals(expectedSum, left+right);
	}
	
	public void repeat(MapDataRecord map) throws Exception {
		int left = strToInt(map.get("Left"));
		int right = strToInt(map.get("Right"));
		int expectedSum = strToInt(map.get("Sum"));
		assertEquals(expectedSum, left+right);
	}
	
	public void repeat(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}
}

