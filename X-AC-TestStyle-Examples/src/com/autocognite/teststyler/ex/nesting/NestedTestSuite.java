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
package com.autocognite.teststyler.ex.nesting;

import com.autocognite.teststyler.ex.basic.SimpleTestCase;
import com.autocognite.teststyler.ex.basic.SimpleTestCaseFail;
import com.autocognite.teststyler.ex.basic.SimpleTestMethodSuite;
import com.autocognite.teststyler.ex.suite.CustomTestSuite;
import com.autocognite.teststyler.lib.TestSuite;

public class NestedTestSuite extends TestSuite{
	
	public void init() throws Exception{
		add(new CustomTestSuite());
		
		add(new SimpleTestCase());
		add(new SimpleTestCaseFail());
		
		add(new SimpleTestMethodSuite());
	}
}
