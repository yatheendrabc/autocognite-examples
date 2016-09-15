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
package com.autocognite.teststyler.ddt.ex.datagenerator;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethod;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataGenerator;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataMethod;
import com.autocognite.utils.lib.DataBatteries;
//Test
public class DataDrivenTestUsingDataGenerators extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}

	// Data Sources can be greedy or non greedy.
	// They can either populate data up front or calculate them as and when needed.
	// AutoCognite tries to use the optimum strategy internally. E.g. most file based sources are non-greedy.
	
	// However, at times, you would want to take control in your hands.
	// Also, using sources provided by AutoCognite and other annotation approaches may not be as powerful.
	
	// Time to explore the final and the most powerful way of DDT provided by AutoCognite.
	// We would start create two data sources of each kind: Greedy and Lazy (Non Greedy).
	
	// Greedy is easy. Let's try that first.
	
	// Steps for creating a Data Generator
	/*
	 * 1. Create a class.
	 * 2. Annotate it with DataGenerator
	 * 3. Implement DataSource interface
	 * 		A Data Source must have a next() method. Framework calls this method iteratively.
	 * 		!!!CAUTION!!! When Data Source is done, it should raise DataSourceFinishedException, else it would result in infinite loop.
	 * 4. Rest is your logic. Enjoy!
	 */
	
	// If you are wondering what a Data Source and how is it different from Data Generator, it's sufficient
	// to comprehend that All Data Generators are Data Sources, while the reverse is not true.
	// Most of the annotations which you used earlier, were converted to Data Sources internally.
	
	//Look at the GreedyDataGenerator class in this test package to see implementation.
	
	// Here we annotate the test.

	@DriveWithDataGenerator("DataGenerator-1")
	public void testGreedy(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}	

	// check LazyDataGenerator for implementation
	// Here goes the lay one

	@DriveWithDataGenerator("DataGenerator-2")
	public void testLazy(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}	
	
	// What if you have any Data Source class without annotation of DataGenerator?
	@DriveWithDataGenerator(klass = NonAnnotatedDG.class)
	public void testNonAnnotatedDG(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}	


}

