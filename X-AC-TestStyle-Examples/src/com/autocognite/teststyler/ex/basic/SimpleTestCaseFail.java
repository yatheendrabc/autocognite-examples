package com.autocognite.teststyler.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.teststyler.lib.TestCase;

public class SimpleTestCaseFail extends TestCase{
	
	public void run() throws Exception{
		assertEquals(1,2);
	}
}
