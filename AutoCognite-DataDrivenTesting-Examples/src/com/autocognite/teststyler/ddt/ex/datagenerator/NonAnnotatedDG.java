/*******************************************************************************
 * Copyright 2016 AutoCognite Testing Research Pvt Ltd (Web: www.AutoCognite.com, Email: support [at] autocognite.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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
		container = new DataRecordContainer();
		// Create headers and assign to container
		String[] names = {"left", "right", "printStr"};
		container.setHeaders(names);
		//Rest is same
		Object[][] records = {
				{1,2,"1::2"},
				{1,2,"1::5"},
		};
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
