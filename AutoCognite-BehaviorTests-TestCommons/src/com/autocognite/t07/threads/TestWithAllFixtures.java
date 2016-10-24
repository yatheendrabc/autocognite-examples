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
package com.autocognite.t07.threads;

import static com.autocognite.testcommons.assertions.Assertions.*;
import com.autocognite.testcommons.annotations.*;

@Invoke(3)
@TestClass(methodThreads=3)
public class TestWithAllFixtures{
	
	public void setUpClass(){
		System.out.println("" + ": Called setUpClass");
	}
	
	public void setUpMethod(){
		System.out.println("" + ": Called setUpMethod");
	}
	
	public void setUpTest(){
		System.out.println("" + ": Called setUpTest");
	}
	
	public void tearDownTest(){
		System.out.println("" + ": Called testDownTest");
	}
	
	public void tearDownMethod(){
		System.out.println("" + ": Called tearDownMethod");
	}
	
	public void tearDownClass(){
		System.out.println("" + ": Called tearDownClass");
	}

	@Invoke(5)
	public void testMethod1() throws Exception{
		System.out.println("" + ": Called testMethod 1");
		assertEquals(1,1);
	}
	
	public void testMethod2() throws Exception{
		System.out.println("" + ": Called testMethod 2");
		assertEquals(3,4);
	}
}
