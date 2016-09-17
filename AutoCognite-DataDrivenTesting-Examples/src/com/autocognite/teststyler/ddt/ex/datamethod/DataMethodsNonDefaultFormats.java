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
package com.autocognite.teststyler.ddt.ex.datamethod;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethod;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataMethod;
import com.autocognite.utils.lib.DataBatteries;
//Test
public class DataMethodsNonDefaultFormats extends Test {	
	
	@DataMethod("DG1")
	public Object[][] getObjectsArray(){
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		return records;
	}

	@DriveWithDataMethod("DG1")
	public void testDefault(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}
	
	@DriveWithDataMethod(name="DG1", format=DataFormat.LIST)
	public void testWithLocalNamedGeneratorMethodListFormat1(DataRecord record) throws Exception{
		int l = (int) record.objectAt(0);
		int r = (int) record.objectAt(1);
		String es = (String) record.objectAt(2);
		assertEquals(es, String.format("%d::%d", l + r));
	}	
	
	@DataMethod("DG2")
	public DataRecordContainer getListData(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod(name="DG1", format=DataFormat.LIST)
	public void testWithLocalNamedGeneratorMethodListFormat2(DataRecord record) throws Exception{
		int l = (int) record.objectAt(0);
		int r = (int) record.objectAt(1);
		String es = (String) record.objectAt(2);
		assertEquals(es, String.format("%d::%d", l + r));
	}	
	
	@DataMethod("DG3")
	public DataRecordContainer getMapData(){
		DataRecordContainer container = new DataRecordContainer();
		// Create headers and assign to container
		String[] names = {"left", "right", "printStr"};
		container.setHeaders(names);
		//Rest is same
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod(name="DG2", format=DataFormat.MAP) // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethodMapFormat(DataRecord record) throws Exception{
		DataBatteries.print(record.map());
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l + r));
	}	
	
}

