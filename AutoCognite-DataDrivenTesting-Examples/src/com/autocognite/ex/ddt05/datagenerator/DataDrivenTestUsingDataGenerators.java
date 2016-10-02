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
package com.autocognite.ex.ddt05.datagenerator;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.testcommons.annotate.TestClass;
import com.autocognite.testcommons.annotate.ddt.DriveWithDataGenerator;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class DataDrivenTestUsingDataGenerators{
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
	
	@DriveWithDataGenerator(generatorClass = NonAnnotatedDG.class, format=DataFormat.MAP)
	public void testNonAnnotatedDG(DataRecord record) throws Exception{
		int l = (int) record.objectOf("left");
		int r = (int) record.objectOf("right");
		String es = (String) record.objectOf("printStr");
		assertEquals(es, String.format("%d::%d", l, r));
	}	


}

