package com.autocognite.teststyler.ddt.ex.datamethod;

import static com.autocognite.user.validator.lib.Assertions.assertEquals;

import com.autocognite.user.testcore.lib.annotate.DriveWithDataMethod;

public class InheritedDataMethodDemo extends DataDrivenTestingUsingDataMethod{
	// A simple strategy could be create data generator methods and keep them
	// inside a base Test class that you have created.
	
	// For example here the DGWithMixDataType is present in the base class, but used here.
	@DriveWithDataMethod("DGWithMixDataType")
	public void testInheritedDataGeneratorMethod(int leftOp, int rightOp, String expectedString) throws Exception{
		// Here you do not need type conversion
		int l = leftOp;
		int r = rightOp;
		String es = expectedString;
		assertEquals(es, String.format("%d%d", l,r));
	}

}
