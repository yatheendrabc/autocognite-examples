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
package com.autocognite.t04.ddt.emptysource;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import com.autocognite.testcommons.annotations.TestClass;
import com.autocognite.testcommons.annotations.ddt.Data;
import com.autocognite.testcommons.annotations.ddt.DriveWithData;
import com.autocognite.testcommons.annotations.ddt.DriveWithDataArray;

@TestClass
public class DDTProblemVaritants{

	
//	@DriveWithData({})
//	public void testEmpty(String left, String right, String expected) throws Exception{
//		String actual = String.format("%s::%s", left, right);
//		assertEquals(actual, expected);
//	}
//	
	
//	@DriveWithDataArray({})
//	public void testEmpty(String left, String right, String expected) throws Exception{
//		String actual = String.format("%s::%s", left, right);
//		assertEquals(actual, expected);
//	}
	
//	@DriveWithDataArray({@Data({})})
//	public void testEmpty(String left, String right, String expected) throws Exception{
//		String actual = String.format("%s::%s", left, right);
//		assertEquals(actual, expected);
//	}
	
	@DriveWithData("test")
	public void testString(String left, String right, String expected) throws Exception{
		String actual = String.format("%s::%s", left, right);
		assertEquals(actual, expected);
	}

}

