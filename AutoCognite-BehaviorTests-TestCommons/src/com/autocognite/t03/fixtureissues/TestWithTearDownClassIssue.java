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
package com.autocognite.t03.fixtureissues;

import static com.autocognite.testcommons.assertions.Assertions.*;
import com.autocognite.testcommons.annotations.*;

@TestClass
public class TestWithTearDownClassIssue{
	
	public void setUpClass() throws Exception{
		System.out.println("UserTest: Called setUpClass");
	}
	
	public void setUpMethod() throws Exception{
		System.out.println("UserTest: Called setUp");
	}
	
	public void setUpTest() throws Exception{
		System.out.println("" + ": Called setUpTest");
	}
	
	public void testDownTest() throws Exception{
		System.out.println("" + ": Called testDownTest");
	}
	
	public void tearDownMethod() throws Exception{
		System.out.println("UserTest: Called tearDown");
	}
	
	public void tearDownClass() throws Exception{
		System.out.println("UserTest: Called tearDownClass");
		fail("Simulating an issue in tearDownClass");
	}

	public void testMethod1() throws Exception{
		System.out.println("UserTest: Called testMethod1");
		assertEquals(1,1);
	}
	
	public void testMethod2() throws Exception{
		System.out.println("UserTest: Called testMethod2");
		assertEquals(3,4);
	}
}
