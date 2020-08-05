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

import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FileLockerTest {

    private FileLocker instance;
    
    private static final String TESTTESTLOCKFILE = "src/test/resources/testlockfile";

    public FileLockerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            try (FileWriter fw = new FileWriter(TESTTESTLOCKFILE)) {
                fw.write("aa");
            }
            instance = new FileLocker(TESTTESTLOCKFILE);
        } catch (Exception ex) {
            Logger.getLogger(FileLockerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        try {
            if (FileLocker.hasLock(TESTTESTLOCKFILE)) {
                instance.unlock();
            }
            new File(TESTTESTLOCKFILE).delete();
        } catch (Exception ex) {
            Logger.getLogger(FileLockerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of unlock method, of class FileLocker.
     */
    @Test
    public void testUnlock() throws Exception {
        System.out.println("unlock");
        instance.unlock();
    }

    /**
     * Test of hasLock method, of class FileLocker.
     */
    @Test
    public void testHasLock() throws Exception {
        System.out.println("hasLock");
        String fileToCheck = TESTTESTLOCKFILE;
        boolean expResult = true;
        boolean result = FileLocker.hasLock(fileToCheck);
        assertEquals(expResult, result);
        
        instance.unlock();
        expResult = false;
        result = FileLocker.hasLock(fileToCheck);
        assertEquals(expResult, result);
    }

    /**
     * Test of close method, of class FileLocker.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        instance.close();
    }
    
}
