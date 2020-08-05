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
// $Id: URIDereferenceReporterTest.java 26 2018-11-26 17:21:18Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.dsig;

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
public class URIDereferenceReporterTest {
    
    public URIDereferenceReporterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of report method, of class URIDereferenceReporter.
     */
    @Test
    public void testReport() {
        System.out.println("report");
        String s = "report";
        URIDereferenceReporter instance = new URIDereferenceReporterImpl();
        instance.report(s);
    }

    public class URIDereferenceReporterImpl implements URIDereferenceReporter {

        @Override
        public void report(String s) {
            System.out.println(s);
        }
    }
    
}
