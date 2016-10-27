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
package com.autocognite.t10.dataref.method;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;

import com.autocognite.batteries.config.UserDefinedConfig;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.batteries.databroker.DataReference;
import com.autocognite.testcommons.annotations.*;
import com.autocognite.testcommons.annotations.ddt.Data;
import com.autocognite.testcommons.annotations.ddt.DataMethod;
import com.autocognite.testcommons.annotations.ddt.DriveWithData;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataArray;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataFile;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataMethod;
import com.autocognite.testcommons.annotations.ddt.FileDataReference;
import com.autocognite.testcommons.assertions.Assertions;
import com.autocognite.testcommons.enums.DataFormat;

@TestClass
public class Wrong_DDT_DataRefANDUserConfig_Method_WrongDataArgs{
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData({"1","2","1::2"})
	public void testDDT1(UserDefinedConfig config, DataReference dataRef) throws Exception{
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData({"1","2","1::2"})
	public void testDDT2(UserDefinedConfig config, DataReference dataRef, String a, String b, String c, String d) throws Exception{
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData({"1","2","1::2"})
	public void testDDT3(UserDefinedConfig config, DataReference dataRef, int a, int b, int c) throws Exception{
	}

	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"1","2","1::2"}, format=DataFormat.LIST)
	public void testDDT4(UserDefinedConfig config, DataReference dataRef) throws Exception{
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"1","2","1::2"}, format=DataFormat.LIST)
	public void testDDT5(UserDefinedConfig config, DataReference dataRef, DataRecord record, String left) throws Exception{
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"1","2","1::2"}, format=DataFormat.LIST)
	public void testDDT6(UserDefinedConfig config, DataReference dataRef, String left) throws Exception{
	}
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"a=1","b=2","c=1::2"}, format=DataFormat.MAP)
	public void testDDT7(UserDefinedConfig config, DataReference dataRef) throws Exception{
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"a=1","b=2","c=1::2"}, format=DataFormat.MAP)
	public void testDDT8(UserDefinedConfig config, DataReference dataRef, DataRecord record, String left) throws Exception{
	}	
	
	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithData(record={"a=1","b=2","c=1::2"}, format=DataFormat.MAP)
	public void testDDT9(UserDefinedConfig config, DataReference dataRef, String left) throws Exception{
	}
	
	@DataMethod
	public Object[][] getData(){
		Object[][] records = {
				{1,2,"1::2"},
				{4,5,"4::6"},
		};
		return records;
	}

	@Clone(properties = {"a=b"})
	@FileDataReference("dataref.xls")
	@DriveWithDataMethod("getData")
	public void testWithLocalDataMethod1(UserDefinedConfig config, DataReference dataRef, int left) throws Exception{
	}

}
