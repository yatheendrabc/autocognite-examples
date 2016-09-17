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
	
	
//	// As your Data generators grow in number, providing them via inheritance
//	// could be counter-intuitive. There could be related types of data generators
//	// and you would want to keep them together, using them across various tests
//	// which can have their own hierarchies.
//	
//	// For example here the DGWithMixDataType is present in the base class, but used here.
//	@DriveWithDataMethod(
//			name = "ExternalDGMethod",
//			container = "SampleDataMethodContainer")
//	public void testExternalDataGeneratorMethodLabel(int leftOp, int rightOp, String expectedString) throws Exception{
//		// Here you do not need type conversion
//		int l = leftOp;
//		int r = rightOp;
//		String es = expectedString;
//		assertEquals(es, String.format("%d%d", l,r));
//	}
//
//	// you can also specify methodName instead of DG name.
//	@DriveWithDataMethod(
//			name = "dataGen",
//			container = "SampleDataMethodContainer")
//	public void testExternalDataGeneratorMethodRawName(int leftOp, int rightOp, String expectedString) throws Exception{
//		// Here you do not need type conversion
//		int l = leftOp;
//		int r = rightOp;
//		String es = expectedString;
//		assertEquals(es, String.format("%d%d", l,r));
//	}
//	
//	// you can also specify methodName instead of DG name.
//	@DriveWithDataMethod(
//			name = "dataGen",
//			container = "AnnotatedDMCClass")
//	public void testExternalDataGeneratorMethodRawName2(int leftOp, int rightOp, String expectedString) throws Exception{
//		// Here you do not need type conversion
//		int l = leftOp;
//		int r = rightOp;
//		String es = expectedString;
//		assertEquals(es, String.format("%d%d", l,r));
//	}
//	
//	// you can also give the containerClass instead of container string
//	@DriveWithDataMethod(
//			name = "dataGen",
//			containerClass = AnnotatedDMCClass.class)
//	public void testExternalDataGeneratorMethodRawName3(int leftOp, int rightOp, String expectedString) throws Exception{
//		// Here you do not need type conversion
//		int l = leftOp;
//		int r = rightOp;
//		String es = expectedString;
//		assertEquals(es, String.format("%d%d", l,r));
//	}
//	
//	// Let's try with a non-annotated class as a method container, where the method is also not annotated.
//	// although this approach is not as performance efficient as annotated containers.

}
