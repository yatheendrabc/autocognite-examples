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
package com.autocognite.t09.dataref;

import com.autocognite.batteries.databroker.DataReference;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.FileDataReference;
import com.autocognite.testcommons.assertions.Assertions;

@FileDataReference("dataref.xls")
@TestClass
public class Right_DataRef_Class1{
	private DataReference dataRef = null;
	
	public Right_DataRef_Class1(DataReference dataRef){
		this.dataRef = dataRef;
	}

	public void testEx() throws Exception{	
		Assertions.assertEquals(dataRef.getRecord("Bronze").valueOf("user"), "B1");
	}
}
