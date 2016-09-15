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
import java.util.Random;

import com.autocognite.databroker.api.datasource.DataSource;
import com.autocognite.databroker.api.datasource.exceptions.DataSourceFinishedException;
import com.autocognite.databroker.lib.datarecord.DataRecord;
import com.autocognite.databroker.lib.datarecord.DataRecordContainer;
import com.autocognite.user.testcore.lib.annotate.ddt.DataGenerator;

/*
 * It's a lazy (non-greedy) generator. All values are loaded in memory ONLY when generated.
 * Use this approach for large data or when you are not sure how many records are to be generated.
 * (Optional) Notice that we are providing header values. This makes it useful for all test signatures.
 */

@DataGenerator("DataGenerator-2")
public class LazyDataGenerator implements DataSource {
	int counter = -1;
	Random random = new Random();
	String[] headers = new String[] {"Left", "Right", "Sum"};
	
	public LazyDataGenerator(){
	}

	@Override
	public DataRecord next() throws DataSourceFinishedException, Exception {
		counter += 1;
		DataRecord record = null;
		ArrayList<Object> objList = new ArrayList<Object>();
		if (counter < 4 ){
			int l = random.nextInt(9);
			int r = random.nextInt(9);
			objList.add(l);
			objList.add(r);
			objList.add(String.format("%d%d",l,r));
			record = new DataRecord(this.headers, objList);
			return record;
		} else if (counter == 4 ){
			// To check behavior for assertion failure
			objList.add(1);
			objList.add(2);
			objList.add(String.format("mismatch"));
			record = new DataRecord(this.headers, objList);
			return record;			
		} else {
			throw new DataSourceFinishedException("Done");
		}
	}

}
