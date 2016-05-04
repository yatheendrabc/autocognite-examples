package com.autocognite.teststyler.ex.fixtures;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.teststyler.lib.TestCase;

public class TestCaseWithAllFixtures extends TestCase{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
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
