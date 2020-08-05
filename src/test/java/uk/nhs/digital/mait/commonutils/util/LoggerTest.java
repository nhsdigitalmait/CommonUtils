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
// $Id: LoggerTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util;

import java.util.logging.Level;
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
public class LoggerTest {

    private Logger instance;
    
    public LoggerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = Logger.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDate method, of class Logger.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String expResult = "20";
        String result = Logger.getDate();
        assertTrue(result.startsWith(expResult));
        int expIntResult = 14;
        assertEquals(expIntResult,result.length());
    }

    /**
     * Test of log method, of class Logger.
     */
    @Test
    public void testLog_String_String() {
        System.out.println("log");
        String location = "";
        String message = "";
        instance.log(location, message);
    }

    /**
     * Test of warn method, of class Logger.
     */
    @Test
    public void testWarn() {
        System.out.println("warn");
        String location = "";
        String message = "";
        instance.warn(location, message);
    }

    /**
     * Test of info method, of class Logger.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        String location = "";
        String message = "";
        instance.info(location, message);
    }

    /**
     * Test of error method, of class Logger.
     */
    @Test
    public void testError() {
        System.out.println("error");
        String location = "";
        String message = "";
        instance.error(location, message);
    }

    /**
     * Test of log method, of class Logger.
     */
    @Test
    public void testLog_3args() {
        System.out.println("log");
        Level l = Level.FINE;
        String location = "";
        String message = "";
        instance.log(l, location, message);
    }

    /**
     * Test of getInstance method, of class Logger.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Logger result = Logger.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of close method, of class Logger.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        instance.close();
    }

    /**
     * Test of setAppName method, of class Logger.
     */
    @Test
    public void testSetAppName() {
        System.out.println("setAppName");
        String name = "name";
        String ldir = "test/logdir";
        instance.setAppName(name, ldir);
    }

    /**
     * Test of log method, of class Logger.
     */
    @Test
    public void testLog_String() {
        System.out.println("log");
        String string = "";
        instance.log(string);
    }
    
}
