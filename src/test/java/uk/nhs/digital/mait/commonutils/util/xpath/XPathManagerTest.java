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
// $Id: XPathManagerTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.xpath;

import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
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
public class XPathManagerTest {
    
    public XPathManagerTest() {
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
     * Test of newInstance method, of class XPathManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstance_0args() throws Exception {
        System.out.println("newInstance");
        XPathFactory result = XPathManager.newInstance();
        assertNotNull(result);
    }

    /**
     * Test of newInstance method, of class XPathManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstance_String() throws Exception {
        System.out.println("newInstance");
        String uri = "http://java.sun.com/jaxp/xpath/dom";
        XPathFactory result = XPathManager.newInstance(uri);
        assertNotNull(result);
    }

    /**
     * Test of xpathExtractor method, of class XPathManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testXpathExtractor() throws Exception {
        System.out.println("xpathExtractor");
        String xpath = "/a/b";
        String xml = "<a><b>testtext</b></a>";
        String expResult = "testtext";
        String result = XPathManager.xpathExtractor(xpath, xml);
        assertEquals(expResult, result);
    }

    /**
     * Test of getXpathExtractor method, of class XPathManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetXpathExtractor() throws Exception {
        System.out.println("getXpathExtractor");
        String xpath = "/a/b";
        XPathExpression result = XPathManager.getXpathExtractor(xpath);
        assertNotNull(result);
    }
    
}
