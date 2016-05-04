package com.autocognite.teststyler.ddt.ex.filevariants;

import static com.autocognite.validator.lib.Assertions.assertEquals;

import com.autocognite.databroker.DataBroker;
import com.autocognite.databroker.api.datarecord.MapDataRecord;
import com.autocognite.ddtstyler.lib.DDTestSuiteForMapData;

public class CommaDelimFileDDT_MapData extends DDTestSuiteForMapData {

	private int strToInt(Object object) {
		return Integer.parseInt((String) object);
	}
	
	public void init() throws Exception {
		setDataSource(getRunConfig().get(DataBroker.DATA_DIR) + "/input.csv", ",");
	}
		
	public void repeat(MapDataRecord map) throws Exception {
		int left = strToInt(map.get("Left"));
		int right = strToInt(map.get("Right"));
		int expectedSum = strToInt(map.get("Sum"));
		assertEquals(expectedSum, left+right);
	}
}

