package com.autocognite.teststyler.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.testcommons.api.test.Test;
import com.autocognite.teststyler.lib.TestCase;

public class SimpleTestCase extends TestCase{
	
	public void run() throws Exception{
		assertEquals(1,1);
	}

}
