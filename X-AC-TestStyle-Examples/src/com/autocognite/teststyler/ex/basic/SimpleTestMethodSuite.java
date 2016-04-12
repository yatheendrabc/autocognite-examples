package com.autocognite.teststyler.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;
import static com.autocognite.validator.lib.Assertions.error;

import com.autocognite.teststyler.lib.ext.TestMethodSuite;

public class SimpleTestMethodSuite extends TestMethodSuite{

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
