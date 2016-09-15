package com.autocognite.teststyler.ddt.ex.datamethod;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import com.autocognite.user.testcore.lib.Test;
import com.autocognite.user.testcore.lib.annotate.ddt.DriveWithDataMethod;

public class DataDrivenTestUsingExternalMethods extends Test{
	// As your Data generators grow in number, providing them via inheritance
	// could be counter-intuitive. There could be related types of data generators
	// and you would want to keep them together, using them across various tests
	// which can have their own hierarchies.
	
	// For example here the DGWithMixDataType is present in the base class, but used here.
	@DriveWithDataMethod(
			name = "ExternalDGMethod",
			container = "SampleDataMethodContainer")
	public void testExternalDataGeneratorMethodLabel(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}

	// you can also specify methodName instead of DG name.
	@DriveWithDataMethod(
			name = "dataGen",
			container = "SampleDataMethodContainer")
	public void testExternalDataGeneratorMethodRawName(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}
	
	// you can also specify methodName instead of DG name.
	@DriveWithDataMethod(
			name = "dataGen",
			container = "AnnotatedDMCClass")
	public void testExternalDataGeneratorMethodRawName2(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}
	
	// you can also give the containerClass instead of container string
	@DriveWithDataMethod(
			name = "dataGen",
			containerClass = AnnotatedDMCClass.class)
	public void testExternalDataGeneratorMethodRawName3(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}
	
	// Let's try with a non-annotated class as a method container, where the method is also not annotated.
	// although this approach is not as performance efficient as annotated containers.
	@DriveWithDataMethod(
			name = "dataGen",
			containerClass = NonAnnotatedDMCClass.class)
	public void testExternalDataGenerator4(int leftOp, int rightOp, String expectedString) throws Exception{
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}
}
