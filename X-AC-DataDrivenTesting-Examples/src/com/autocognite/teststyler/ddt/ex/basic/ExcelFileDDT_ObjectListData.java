package com.autocognite.teststyler.ddt.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.databroker.DataBroker;
import com.autocognite.ddtstyler.lib.DDTestSuiteForObjectListData;

public class ExcelFileDDT_ObjectListData extends DDTestSuiteForObjectListData{

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	public void init() throws Exception {
		setDataSource(runConfig.get(DataBroker.DATA_DIR) + "/input.xls");
	}
		
	public void repeat(String leftOp, String rightOp, String expectedSum) throws Exception{
		int l = strToInt(leftOp);
		int r = strToInt(rightOp);
		int es = strToInt(expectedSum);
		assertEquals(es, l + r);
	}
}

