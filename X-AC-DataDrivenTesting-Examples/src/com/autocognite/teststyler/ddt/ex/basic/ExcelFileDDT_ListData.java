package com.autocognite.teststyler.ddt.ex.basic;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.databroker.DataBroker;
import com.autocognite.databroker.api.datarecord.ListDataRecord;
import com.autocognite.ddtstyler.lib.DDTestSuiteForListData;

public class ExcelFileDDT_ListData extends DDTestSuiteForListData {

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	public void init() throws Exception {
		setDataSource(getRunConfig().get(DataBroker.DATA_DIR) + "/input.xls");
	}
		
	public void repeat(ListDataRecord record) throws Exception {
		int left = strToInt(record.get(0));
		int right = strToInt(record.get(1));
		int expectedSum = strToInt(record.get(2));
		assertEquals(expectedSum, left+right);
	}
}

