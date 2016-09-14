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
package com.autocognite.teststyler.ddt.ex.datamethod;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.DriveWithData;
import com.autocognite.user.testcore.lib.annotate.DriveWithDataArray;
import com.autocognite.user.testcore.lib.annotate.DriveWithDataFile;
import com.autocognite.user.testcore.lib.annotate.DataMethod;
import com.autocognite.user.testcore.lib.annotate.DriveWithDataMethod;
import com.autocognite.utils.lib.DataBatteries;
//Test
public class DataDrivenTestingUsingDataMethod extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}

	// There can be situations you either generate data on the fly or inquire a dynamic source of data like Web API
	// This means that you would want to associate a test method with code that can provide such data.
	// This code is referred to as a Data Generator.
	// Here we see the first form form of a Data Generator: A Data Generator method

	// You can create the method within the current class itself.
	public DataRecordContainer getData(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{"1","2","3"},
				{"1","2","4"},
				{"1","2","Wrong"}
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod("getData")
	public void testWithLocalDataMethod(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	

	// You can also used named generator methods

	@DataMethod("SomeName")
	public DataRecordContainer dataGen(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{"4","5","9"},
				{"4","5","10"},
				{"2","3","Wrong"}
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod("SomeName") // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethod(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}	
	
	// Another key point to note is that now we are not confined on data types because of Java annotation limitations.
	// When the data is directly supplied by Java Annotation, we could have anything like Object[] or Object[][]
	// Because of this we had to fall into the trap of writing data conversion methods. Let's make it simple.
	// Let's take the previous example again
	@DataMethod("DGWithActualDataType")
	public DataRecordContainer dataGenWithNonStringData(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{4,5,9},
				{4,5,10}
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod("DGWithActualDataType") // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethodActualDataType(int leftOp, int rightOp, int expectedSum) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		int es = expectedSum;
		assertEquals(es, l + r);
	}
	
	// You can get the same benefit for DataRecord by using object* API instead of value* API.
	// For consistency amongst annotations, value* API returns gives strings.
	
	// Another thing to keep in mind is how you populate the data.
	// What you need to keep in mind is how you plan to use it.
	// For example the dataGen() above is good for a List data format.
	@DriveWithDataMethod(name="DGWithActualDataType", format=DataFormat.LIST) // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethodListFormat(DataRecord record) throws Exception{
		int l = (int) record.objectAt(0);
		int r = (int) record.objectAt(1);
		int es = (int) record.objectAt(2);
		assertEquals(es, l + r);
	}	

	// However if you want name based retrieval, you must populate the data in the same fasion as well:
	@DataMethod("DGForMapFormat")
	public DataRecordContainer mapDataGen(){
		DataRecordContainer container = new DataRecordContainer();
		// Create headers and assign to container
		String[] names = {"left", "right", "sum"};
		container.setHeaders(names);
		//Rest is same
		Object[][] records = {
				{4,5,9},
				{4,5,10}
		};
		container.addAll(records);
		return container;
	}

	@DriveWithDataMethod(name="DGForMapFormat", format=DataFormat.MAP) // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethodMapFormat(DataRecord record) throws Exception{
		DataBatteries.print(record.map());
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		int es = (int) record.objectOf("SUM");
		assertEquals(es, l + r);
	}	
	
	// And you are not confined to one type of data, of course
	// Let's take the previous example again
	@DataMethod("DGWithMixDataType")
	public DataRecordContainer dataGenWithMixData(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{4,5,"45"},
				{4,5,"50"}
		};
		container.addAll(records);
		return container;
	}
	
	@DriveWithDataMethod("DGWithMixDataType") // This would use dataGen() as the data generator.
	public void testWithLocalNamedGeneratorMethodMixData(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}

}

