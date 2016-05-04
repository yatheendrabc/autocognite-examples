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
package com.autocognite.teststyler.ex.assertions;

import static com.autocognite.validator.lib.Assertions.assertArrayEquals;
import static com.autocognite.validator.lib.Assertions.assertEquals;
import static com.autocognite.validator.lib.Assertions.assertNull;
import static com.autocognite.validator.lib.Assertions.assertSame;
import static com.autocognite.validator.lib.Assertions.assertTrue;
import static com.autocognite.validator.lib.Assertions.error;
import static com.autocognite.validator.lib.Assertions.fail;

import com.autocognite.teststyler.lib.TestMethodSuite;

public class AssertionsTestMethodSuite extends TestMethodSuite{

	/*
	 * Example Code - Basic Assertion without Message, Expected to pass
	 */
	public void testPassingAssertion() throws Exception{
		assertTrue(true);
	}
	
	/*
	 * Example Code - Basic Assertion without Message, Expected to pass
	 */
	public void testFailingAssertion() throws Exception{
		assertTrue(false);
	}
	
	/*
	 * Example Code - Basic Assertion with Message, Expected to fail
	 * Notice the usefulness of the message displayed.
	 * Imagine this assertion was used for creating a blog post
	 */
	public void testFailingAssertionWithMessage() throws Exception{
		assertTrue("Blog post should be created.", false);
	}
	
	/* 
	 * ----------------------------------------------------------
	 * All subsequent examples demonstrated with Message argument
	 * I strongly suggest this option for meaningful reports
	 * ----------------------------------------------------------
	 */
	
	/*
	 * Example code for assertEquals and assertNotEquals
	 * The method is available for char, int, long, object, string data types
	 * It is also available for float and double types, but is demonstrated
	 * separately because of the nature of assertion being different.
	 * You can use assertNotEquals for checking non-equality.
	 */
	public void testAssertEqualsPass() throws Exception{
		assertEquals("Number of comments should match the expected number.", 23,23);
	}

	public void testAssertEqualsFail() throws Exception{
		assertEquals("Number of comments should match the expected number.", 23,19);
	}
	
	/*
	 * Checking equality for floats and doubles needs additional consideration
	 * One must be able to specify 'delta' i.e. acceptable difference.
	 * Here the change in value of delta changes the behavior of assertion.
	 */
	public void testAssertEqualsForDoublePass() throws Exception{
		assertEquals("Total cost must match.", 11.25, 11.23, 0.02);
	}

	public void testAssertEqualsForDoubleFail() throws Exception{
		assertEquals("Total cost must match.", 11.25, 11.23, 0.01);
	}
	
	/*
	 * Example Code - Asserting Sameness
	 * You can assert that two different variables should refer to the
	 * SAME object in memory. You can also assert that this should
	 * not be the case using assertNotSame.
	 */
	public void testAssertSamePass() throws Exception{
		// Mimicking a situation where different names point to same object
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = sb1;
		assertSame("String builders should point to the same object.", sb1,sb2);
	}

	public void testAssertSameFail() throws Exception{
		// Mimicking a situation where different names point to different objects
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		assertSame("String builders should point to the same object.", sb1,sb2);
	}
	
	/*
	 * Example Code - Assert Null
	 * You can also check an object not being null using assertNotNull
	 */
	public void testAssertNullPass() throws Exception{
		// Mimicking a situation where an object is not initialized
		StringBuilder sb = null;
		assertNull("String builder should not be initialized.", sb);
	}

	public void testAssertNullFail() throws Exception{
		// Mimicking a situation where an object has been wrongly initialized.
		StringBuilder sb = new StringBuilder();
		assertNull("String builder should not be initialized.", sb);
	}
	
	/*
	 * Example Code - Assert Array Equality
	 * Available for short, int, byte, long, string arrays
	 */
	public void testAssertArrayEqualsPass() throws Exception{
		int[] arr1={1,1};
		int[] arr2={1,1};
		assertArrayEquals("Student scores shown in web must match DB data",arr1, arr2);
	}
	
	public void testAssertArrayEqualsFail() throws Exception{
		int[] arr1={1,1};
		int[] arr2={1,2};
		assertArrayEquals("Student scores shown in web must match DB data",arr1, arr2);
	}
	
	/*
	 * You can explicitly make a test Fail/Err
	 * Typically used when you are dealing with application logic
	 * in your test automation and the decision is too complex
	 * to be represented using a basic assertion.
	 */
	public void testFail() throws Exception{
		fail("Application showed wrong behavior. Reason: <XYZ>");
	}
	
	public void testError() throws Exception{
		error("A test file is missing. Needs investigation. Terminating the test.");
	}
}
