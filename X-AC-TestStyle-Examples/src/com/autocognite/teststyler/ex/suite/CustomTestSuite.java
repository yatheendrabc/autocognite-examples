package com.autocognite.teststyler.ex.suite;

import com.autocognite.teststyler.ex.basic.SimpleTestCase;
import com.autocognite.teststyler.ex.basic.SimpleTestCaseFail;
import com.autocognite.teststyler.lib.TestSuite;

public class CustomTestSuite extends TestSuite{

	public void init() throws Exception{
		add(new SimpleTestCase());
		add(new SimpleTestCaseFail());
	}
}
