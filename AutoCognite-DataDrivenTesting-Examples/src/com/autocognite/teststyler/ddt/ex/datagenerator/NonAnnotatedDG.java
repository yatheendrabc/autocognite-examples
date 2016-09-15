package com.autocognite.teststyler.ddt.ex.datagenerator;

import java.util.ArrayList;
import java.util.Iterator;

import com.autocognite.databroker.api.datasource.DataSource;
import com.autocognite.databroker.api.datasource.exceptions.DataSourceFinishedException;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.ddt.DataGenerator;

/*
 * It's greedy. All values are loaded in memory.
 * OK for small set of data.
 * (Optional) Notice that we are providing header values. This makes it useful for all test signatures.
 */

public class NonAnnotatedDG implements DataSource {
	DataRecordContainer container = null;
	Iterator<DataRecord> iter = null;
	
	public NonAnnotatedDG(){
		// This code is fully under your control
		DataRecordContainer container = new DataRecordContainer();
		Object[][] records = {
				{4,5,"45"},
				{4,5,"50"}
		};
		container.setHeaders(new String[] {"Left", "Right", "Sum"});
		container.addAll(records);
		iter = container.iterator();
	}

	@Override
	public DataRecord next() throws DataSourceFinishedException, Exception {
		//This code is fully under your control as well.
		if(iter.hasNext()){
			return iter.next();
		} else {
			throw new DataSourceFinishedException("Done");
		}
	}

}
