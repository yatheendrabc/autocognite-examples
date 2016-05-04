package com.autocognite.teststyler.ex.fixtures;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import org.apache.log4j.Logger;

import com.autocognite.batteries.Batteries;
import com.autocognite.teststyler.lib.TestMethodSuite;

public class TestMethodSuiteWithAllFixtures extends TestMethodSuite{
	private Logger logger = Logger.getLogger(Batteries.getCentralLogName());
	
	public void setUpClass(){
		logger.info(getClassName() + ": Called setUpClass");
	}
	
	public void setUp(){
		logger.info(getClassName() + ": Called setUp");
	}
	
	public void tearDown(){
		logger.info(getClassName() + ": Called tearDown");
	}
	
	public void tearDownClass(){
		logger.info(getClassName() + ": Called tearDownClass");
	}

	public void testMethod1() throws Exception{
		logger.info(getClassName() + ": Called testMethod 1");
		assertEquals(1,1);
	}
	
	public void testMethod2() throws Exception{
		logger.info(getClassName() + ": Called testMethod 2");
		assertEquals(3,4);
	}
}
