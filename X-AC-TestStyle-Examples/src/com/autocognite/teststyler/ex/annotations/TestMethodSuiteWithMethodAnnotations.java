package com.autocognite.teststyler.ex.annotations;

import static com.autocognite.validator.lib.Assertions.assertEquals;
import static com.autocognite.validator.lib.Assertions.error;

import com.autocognite.testcommons.api.annotate.TestProperties;
import com.autocognite.teststyler.lib.TestMethodSuite;

@TestProperties(name="Custom name", category="Some-Category")
public class TestMethodSuiteWithMethodAnnotations extends TestMethodSuite{

	@TestProperties(id="Custom id-1")
	public void testMethodPass() throws Exception{	
		assertEquals(1,1);
	}
	
	@TestProperties(id="Custom id-2")
	public void testMethodFail() throws Exception{
		assertEquals(1,2);
	}
	
	@TestProperties(id="Custom id-3")
	public void testMethodError() throws Exception{
		error();
	}

}
