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
// $Id: XMLNamespaceContextTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util;

import java.util.Iterator;
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
public class XMLNamespaceContextTest {

    private XMLNamespaceContext instance;
    
    public XMLNamespaceContextTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new XMLNamespaceContext();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of declarePrefix method, of class XMLNamespaceContext.
     */
    @Test
    public void testDeclarePrefix() {
        System.out.println("declarePrefix");
        String prefix = "test";
        String uri = "abc";
        instance.declarePrefix(prefix, uri);
    }

    /**
     * Test of getPrefix method, of class XMLNamespaceContext.
     */
    @Test
    public void testGetPrefix() {
        System.out.println("getPrefix");
        instance.declarePrefix("prefix", "uri");
        String u = "uri";
        String expResult = "prefix";
        String result = instance.getPrefix(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrefixes method, of class XMLNamespaceContext.
     */
    @Test
    public void testGetPrefixes() {
        System.out.println("getPrefixes");
        instance.declarePrefix("prefix", "uri");
        instance.declarePrefix("prefix1", "uri");
        String u = "uri";
        boolean expResult = true;
        Iterator result = instance.getPrefixes(u);
        assertEquals(expResult, result.hasNext());
        String expStrResult = "prefix";
        assertEquals(expStrResult,result.next().toString());
        expStrResult = "prefix1";
        assertEquals(expStrResult,result.next().toString());
    }

    /**
     * Test of getNamespaceURI method, of class XMLNamespaceContext.
     */
    @Test
    public void testGetNamespaceURI() {
        System.out.println("getNamespaceURI");
        instance.declarePrefix("prefix", "uri");
        String p = "prefix";
        String expResult = "uri";
        String result = instance.getNamespaceURI(p);
        assertEquals(expResult, result);
    }
    
}
