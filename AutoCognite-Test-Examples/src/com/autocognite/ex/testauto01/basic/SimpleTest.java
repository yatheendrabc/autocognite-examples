/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
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
package com.autocognite.ex.testauto01.basic;

import static com.autocognite.testcommons.assertions.Assertions.assertEquals;
import static com.autocognite.testcommons.assertions.Assertions.error;

import org.apache.log4j.Logger;

import com.autocognite.Batteries;
import com.autocognite.batteries.config.RunConfig;
import com.autocognite.batteries.util.DataBatteries;
import com.autocognite.testcommons.annotate.TestClass;

@TestClass
public class SimpleTest{
	private static Logger logger = Batteries.getCentralLogger();
	
	public void testMethodPass() throws Exception{	
		logger.debug(DataBatteries.flatten(RunConfig.props()));
		assertEquals(1,1);
	}
	
	public void testMethodFail() throws Exception{
		assertEquals(1,2);
	}
	
	public void testMethodError() throws Exception{
		error();
	}

}
