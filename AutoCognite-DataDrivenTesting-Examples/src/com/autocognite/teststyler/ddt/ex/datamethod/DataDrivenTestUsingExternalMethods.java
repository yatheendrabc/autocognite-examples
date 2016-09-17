/*******************************************************************************
 * Copyright 2016 AutoCognite Testing Research Pvt Ltd (Web: www.AutoCognite.com, Email: support [at] autocognite.com)
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
package com.autocognite.teststyler.ddt.ex.datamethod;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataMethod;

public class DataDrivenTestUsingExternalMethods extends Test{
	@DriveWithDataMethod(
			name = "User defined method name",
			containerClass = MethodContainer.class
	)
	public void testByProvidingClass(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}
	
	
	@DriveWithDataMethod(
			name = "User defined method name",
			containerClass = AnnotatedMethodContainer.class
	)
	public void testByProvidingClass2(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}
	
	@DriveWithDataMethod(
			name = "User defined method name",
			container = "AnnotatedMethodContainer"
	)
	public void testByProvidingClassName1(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}
	
	@DriveWithDataMethod(
			name = "User defined method name",
			container = "User friendly method container name."
	)
	public void testByProvidingClassName2(int left, int right, String expected) throws Exception{
		String actual = String.format("%d::%d", left, right);
		assertEquals(actual, expected);
	}

}
