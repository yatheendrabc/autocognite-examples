package com.autocognite.teststyler.ex.fixtures;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.testcommons.api.test.Test;
import com.autocognite.teststyler.lib.TestCase;

public class TestCaseWithAllFixtures extends TestCase{
	public void setUpClass(){
		logger.info(getClassName() + ": Called setUpClass");
	}
	
	public void tearDownClass(){
		logger.info(getClassName() + ": Called tearDownClass");
	}

	public void run() throws Exception{
		logger.info("running the test");
		assertEquals(1,1);
	}

}
