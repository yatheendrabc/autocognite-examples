package com.autocognite.teststyler.ex.nesting;

import com.autocognite.teststyler.ex.basic.SimpleTestCase;
import com.autocognite.teststyler.ex.basic.SimpleTestCaseFail;
import com.autocognite.teststyler.ex.basic.SimpleTestMethodSuite;
import com.autocognite.teststyler.ex.suite.CustomTestSuite;
import com.autocognite.teststyler.lib.TestSuite;

public class NestedTestSuite extends TestSuite{
	
	public void init() throws Exception{
		add(new CustomTestSuite());
		
		add(new SimpleTestCase());
		add(new SimpleTestCaseFail());
		
		add(new SimpleTestMethodSuite());
	}
}
