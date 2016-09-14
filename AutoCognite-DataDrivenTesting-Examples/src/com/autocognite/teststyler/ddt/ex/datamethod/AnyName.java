package com.autocognite.teststyler.ddt.ex.datamethod;

import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.DataMethod;
import com.autocognite.user.testcore.lib.annotate.DataMethodContainer;

@DataMethodContainer("SampleDataMethodContainer")
public class AnyName{

	// This must be a STATIC method
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
