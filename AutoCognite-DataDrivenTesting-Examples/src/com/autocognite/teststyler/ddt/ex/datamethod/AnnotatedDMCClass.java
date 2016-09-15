package com.autocognite.teststyler.ddt.ex.datamethod;

import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethod;
import com.autocognite.user.testcore.lib.annotate.ddt.DataMethodContainer;

@DataMethodContainer("SampleDataMethodContainer")
public class AnnotatedDMCClass{

	// This must be a STATIC method. 
	// Allowing non-static would have come at a cost of complicating annotation parameters or having only one data method per Class.
	// Definitions are pre-loaded by Test Commons before testing starts
	@DataMethod("ExternalDGMethod")
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
