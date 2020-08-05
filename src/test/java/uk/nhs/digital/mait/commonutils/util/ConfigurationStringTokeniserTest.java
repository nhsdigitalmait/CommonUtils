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
// $Id: ConfigurationStringTokeniserTest.java 28 2019-06-27 11:23:22Z sfarrow $
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
public class ConfigurationStringTokeniserTest {

    private ConfigurationStringTokeniser instance;
    
    public ConfigurationStringTokeniserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConfigurationStringTokeniser("a b c");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countTokens method, of class ConfigurationStringTokeniser.
     */
    @Test
    public void testCountTokens() {
        System.out.println("countTokens");
        int expResult = 3;
        int result = instance.countTokens();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextToken method, of class ConfigurationStringTokeniser.
     * @throws java.lang.Exception
     */
    @Test
    public void testNextToken() throws Exception {
        System.out.println("nextToken");
        String expResult = "a";
        String result = instance.nextToken();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasMoreTokens method, of class ConfigurationStringTokeniser.
     */
    @Test
    public void testHasMoreTokens() {
        System.out.println("hasMoreTokens");
        boolean expResult = true;
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextToken method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testSingleQuotes() throws Exception {
        System.out.println("singleQuotes");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("a ' b ' c");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "' b '";
        String resultStr = instance.nextToken();
        resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
    }
    
    /**
     * Test of nextToken method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testDoubleQuotes() throws Exception {
        System.out.println("doubleQuotes");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("a \" b \" c");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "\" b \"";
        String resultStr = instance.nextToken();
        resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
    }

    /**
     * Test of nextToken method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testSquareBrackets() throws Exception {
        System.out.println("squareBrackets");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("a [ b ] c");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "[ b ]";
        String resultStr = instance.nextToken();
        resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
    }

    /**
     * Test of nextToken method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testRoundBrackets() throws Exception {
        System.out.println("roundBrackets");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("a ( b ) c");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "( b )";
        String resultStr = instance.nextToken();
        resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
    }
 
    /**
     * Test of hasMoreTokens method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testcomplexString() throws Exception {
        System.out.println("moreComplexString");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("\"some text (with a bit in brackets) followed by more text then (a, b, c)\"");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "\"some text (with a bit in brackets) followed by more text then (a, b, c)\"";
        String resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
 }
    
    /**
     * Test of hasMoreTokens method, of class ConfigurationStringTokeniser.
     * from Damian's defect
     * @throws java.lang.Exception
     */
    @Test
    public void testevenMoreComplexString() throws Exception {
        System.out.println("evenMoreComplexString");
        boolean expResult = true;
        instance = new ConfigurationStringTokeniser("\" - NOTE:PLEASE PAGE DOWN UNTIL END OF REPORT MESSAGE -  Clin. dets.  Received:04.08.11   Authorised:15.08.11   Hepatitis A IgM   Negative     Hepatitis A IgG  POSITIVE   Hepatitis B sAg   Negative     Hep B core Ab    POSITIVE   Hepatitis C Ab    Negative                                  EBVG(EBNA) Positive  Unable to confirm recent viral hepatitis (A, B or C)  infections.  Consistent with past EBV infection,not acquired recently.  Immune to Hepatitis A virus (past infection or immunisation)                 -------    END OF REPORT    -------\"");
        boolean result = instance.hasMoreTokens();
        assertEquals(expResult, result);
        
        String expResultStr = "\" - NOTE:PLEASE PAGE DOWN UNTIL END OF REPORT MESSAGE -  Clin. dets.  Received:04.08.11   Authorised:15.08.11   Hepatitis A IgM   Negative     Hepatitis A IgG  POSITIVE   Hepatitis B sAg   Negative     Hep B core Ab    POSITIVE   Hepatitis C Ab    Negative                                  EBVG(EBNA) Positive  Unable to confirm recent viral hepatitis (A, B or C)  infections.  Consistent with past EBV infection,not acquired recently.  Immune to Hepatitis A virus (past infection or immunisation)                 -------    END OF REPORT    -------\"";
        String resultStr = instance.nextToken();
        assertEquals(expResultStr, resultStr);
    }


    /**
     * Test of countTokens method, of class ConfigurationStringTokeniser.
     * @throws java.lang.Exception
     */
    @Test
    public void testMultipleSpaces() throws Exception {
        System.out.println("multipleSpaces");
        instance = new ConfigurationStringTokeniser("a  b c");
        String expResult = "a";
        String result = instance.nextToken();
        assertEquals(expResult, result);

        expResult = "b";
        result = instance.nextToken();
        assertEquals(expResult, result);
    }
}
