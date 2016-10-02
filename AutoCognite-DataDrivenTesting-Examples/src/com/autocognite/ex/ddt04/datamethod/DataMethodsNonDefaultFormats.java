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
package com.autocognite.ex.ddt04.datamethod;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.batteries.databroker.DataRecordContainer;
import com.autocognite.batteries.util.DataBatteries;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.DataMethod;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataMethod;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class DataMethodsNonDefaultFormats{	
	
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
		assertEquals(es, String.format("%d::%d", l, r));
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
		assertEquals(es, String.format("%d::%d", l, r));
	}	
	
	@DataMethod("DG2")
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

	@DriveWithDataMethod(name="DG2", format=DataFormat.MAP) 
	public void testWithLocalNamedGeneratorMethodMapFormat(DataRecord record) throws Exception{
		DataBatteries.print(record.map());
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l, r));
	}	
	
}

