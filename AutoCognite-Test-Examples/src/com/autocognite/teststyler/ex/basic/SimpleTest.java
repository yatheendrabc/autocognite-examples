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
package com.autocognite.teststyler.ex.basic;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;
import static com.autocognite.user.validator.lib.Assertions.error;

import com.autocognite.user.testcore.lib.Test;

public class SimpleTest extends Test{

	public void testMethodPass() throws Exception{	
		assertEquals(1,1);
	}
	
	public void testMethodFail() throws Exception{
		assertEquals(1,2);
	}
	
	public void testMethodError() throws Exception{
		error();
	}

}
