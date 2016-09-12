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
package com.autocognite.teststyler.ex.annotations;

import static com.autocognite.user.validator.lib.Assertions.*;

import com.autocognite.dev.testcore.api.TestResultHandler;
import com.autocognite.dev.teststyler.lib.resulthandler.DefaultTestResultHandler;
import com.autocognite.user.testcore.lib.annotate.TestProperties;
import com.autocognite.user.testcore.lib.test.Test;

@TestProperties(
		name="Custom name", 
		category="Some-Category",
		customProps={"my1=3"},
		tags ="Level1,Critical,Functional")
public class TestMethodSuiteWithMethodAnnotations extends Test{

	@TestProperties(id="Custom id-1", name="a")
	public void test1MethodPass() throws Exception{	
		assertEquals(3,3).evaluate();
	}
	
	@TestProperties(id="Custom id-2", name="b")
	public void test2MethodFail() throws Exception{
		assertEquals(1,2);
	}
	
	@TestProperties(id="Custom id-3", customProps={"POLICY Name = Hoho", "qh_prop=c", "tags=abc"})
	public void test3MethodFail() throws Exception{
		assertNull("abc");
	}
	
	@TestProperties(id="Custom id-4", customProps={"POLICY Name = Hoho1", "qh_prop=d", "tags=def"})
	public void test4MethodFail() throws Exception{
		assertContains("Some purpose", "parent", "rent1");
	}

	@TestProperties(id="Custom id-5", customProps={"POLICY Name = Hoho2", "name=f", "tags=xyz"})
	public void test5methodError2() throws Exception{
		error();
	}
}
