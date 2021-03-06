/*
 Copyright 2016  Simon Farrow <simon.farrow1@hscic.gov.uk>

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package uk.nhs.digital.mait.commonutils.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simonfarrow
 */
public class ConfigurationTokenSplitterTest {
    
    public ConfigurationTokenSplitterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConfigurationTokenSplitter("a b c");
    }
    
    @After
    public void tearDown() {
    }

    private ConfigurationTokenSplitter instance = null;
    
    /**
     * Test of split method, of class ConfigurationTokenSplitter.
     */
    @Test
    public void testSplit() throws Exception {
        System.out.println("split");
        String[] expResult = new String[]{"a","b","c"};
        String[] result = instance.split();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of split method, of class ConfigurationTokenSplitter.
     */
    @Test
    public void testSplit_boolean() throws Exception {
        System.out.println("split");
        boolean preprocessing = false;
        String[] expResult = new String[]{"a","b","c"};
        String[] result = instance.split(preprocessing);
        assertArrayEquals(expResult, result);
    }
    
}
