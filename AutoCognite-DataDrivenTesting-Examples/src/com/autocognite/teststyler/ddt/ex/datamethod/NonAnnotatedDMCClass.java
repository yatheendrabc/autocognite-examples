package com.autocognite.teststyler.ddt.ex.datamethod;

import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethod;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethodContainer;

// This example demonstrates using any class and its static methods as Data methods.

public class NonAnnotatedDMCClass{

	public static DataRecordContainer dataGen(){
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{4,5,"45"},
				{4,5,"50"}
		};
		container.addAll(records);
		return container;
	}
}
