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
package com.autocognite.ex.testauto04.annotations;

import static com.autocognite.testcommons.assertions.Assertions.*;
import com.autocognite.testcommons.annotations.*;

@Exclude
@TestClass
public class ExclusionExample2{

	public void testMethodPass() throws Exception{	
		assertEquals(1,1);
	}
	
	public void testMethodFail() throws Exception{
		assertEquals(1,2);
	}
	
	public void testMethodError() throws Exception{
		error();
	}

}
