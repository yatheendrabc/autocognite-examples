package com.autocognite.teststyler.ddt.ex.filter;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.databroker.DataBroker;
import com.autocognite.databroker.api.datarecord.MapDataRecord;
import com.autocognite.teststyler.lib.ext.ddt.DDTestSuiteForMapData;

public class Filter_IniFileDDT_MapData extends DDTestSuiteForMapData {

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	public void init() throws Exception {
		setDataSource(runConfig.get(DataBroker.DATA_DIR) + "/input_exclude_option.ini");
	}
		
	public void repeat(MapDataRecord map) throws Exception {
		int left = strToInt(map.get("Left"));
		int right = strToInt(map.get("Right"));
		int expectedSum = strToInt(map.get("Sum"));
		assertEquals(expectedSum, left+right);
	}
}

