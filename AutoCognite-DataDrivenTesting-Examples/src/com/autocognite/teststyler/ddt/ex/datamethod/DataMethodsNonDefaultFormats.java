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
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	@DataMethod
	public Object[][] getData(){
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		return records;
	}

	@DriveWithDataMethod("getData")
	public void testWithLocalDataMethod1(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}	
	
	
	@DataMethod("A User Friendly Name")
	public Object[][] getData2(){
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
		return records;
	}

	@DriveWithDataMethod("A User Friendly Name")
	public void testWithLocalDataMethod2(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}


//	
//	@DriveWithDataMethod(name="DGWithActualDataType", format=DataFormat.LIST) // This would use dataGen() as the data generator.
//	public void testWithLocalNamedGeneratorMethodListFormat(DataRecord record) throws Exception{
//		int l = (int) record.objectAt(0);
//		int r = (int) record.objectAt(1);
//		int es = (int) record.objectAt(2);
//		assertEquals(es, l + r);
//	}	
//
//	@DataMethod("DGForMapFormat")
//	public DataRecordContainer mapDataGen(){
//		DataRecordContainer container = new DataRecordContainer();
//		// Create headers and assign to container
//		String[] names = {"left", "right", "sum"};
//		container.setHeaders(names);
//		//Rest is same
//		Object[][] records = {
//				{4,5,9},
//				{4,5,10}
//		};
//		container.addAll(records);
//		return container;
//	}
//
//	@DriveWithDataMethod(name="DGForMapFormat", format=DataFormat.MAP) // This would use dataGen() as the data generator.
//	public void testWithLocalNamedGeneratorMethodMapFormat(DataRecord record) throws Exception{
//		DataBatteries.print(record.map());
//		int l = (int) record.objectOf("left");
//		int r = (int) record.objectOf("right");
//		int es = (int) record.objectOf("SUM");
//		assertEquals(es, l + r);
//	}	
//	
//	@DataMethod("DGWithMixDataType")
//	public DataRecordContainer dataGenWithMixData(){
//		DataRecordContainer container = new DataRecordContainer();
//		Object[][] records = {
//				{4,5,"45"},
//				{4,5,"50"}
//		};
//		container.addAll(records);
//		return container;
//	}
//	
//	@DriveWithDataMethod("DGWithMixDataType") // This would use dataGen() as the data generator.
//	public void testWithLocalNamedGeneratorMethodMixData(int leftOp, int rightOp, String expectedString) throws Exception{
//		// Here you do not need type conversion
//		int l = leftOp;
//		int r = rightOp;
//		String es = expectedString;
//		assertEquals(es, String.format("%d%d", l,r));
//	}

}

