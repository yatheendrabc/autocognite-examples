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
package com.autocognite.teststyler.ddt.ex.datagenerator;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.user.batteries.Batteries;
import com.autocognite.user.databroker.lib.datarecord.DataRecord;
import com.autocognite.user.testcore.api.enums.DataFormat;
import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataGenerator;


public class DataDrivenTestUsingDataGenerators extends Test {
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());

	@DriveWithDataGenerator(name="DataGenerator-1", format=DataFormat.MAP)
	public void testGreedy(DataRecord record) throws Exception{
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l, r));
	}	
	
	@DriveWithDataGenerator(name="Lazy", format=DataFormat.MAP)
	public void testLazy(DataRecord record) throws Exception{
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l, r));
	}	
	
	@DriveWithDataGenerator(klass = NonAnnotatedDG.class, format=DataFormat.MAP)
	public void testNonAnnotatedDG(DataRecord record) throws Exception{
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l, r));
	}	


}

