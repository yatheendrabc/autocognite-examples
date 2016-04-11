package com.autocognite.teststyler.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.testcommons.api.test.Test;
import com.autocognite.teststyler.lib.ext.TestCase;

public class SimpleTestCaseFail extends TestCase{
	
	public void setUpClass() throws Exception{
		logger.debug("Called hhhhhh");
	}
	public void run() throws Exception{
		this.logger.debug("reached here");
		assertEquals(1,2);
	}
}
