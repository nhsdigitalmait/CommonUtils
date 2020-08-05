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
package uk.nhs.digital.mait.commonutils.util.xsltransform;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;
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
public class TransformManagerTest {

    private TransformManager instance;

    public TransformManagerTest() {
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
            instance = TransformManager.getInstance();
        } catch (Exception ex) {
            Logger.getLogger(TransformManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        TransformManager result = TransformManager.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of getTransformerFactory method, of class TransformManager.
     */
    @Test
    public void testGetTransformerFactory() {
        System.out.println("getTransformerFactory");
        TransformerFactory result = instance.getTransformerFactory();
        assertNotNull(result);
    }

    /**
     * Test of doTransform method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoTransform_String_InputStream() throws Exception {
        System.out.println("doTransform");
        String name = "name1";
        String filename = "src/test/resources/transform.xsl";
        instance.addTransform(name, filename);
        String tname = "name1";
        InputStream input = new ByteArrayInputStream("<a><b>testtext</b></a>".getBytes());
        String expResult = "<a>";
        String result = instance.doTransform(tname, input);
        assertTrue(result.startsWith(expResult));
    }

    /**
     * Test of doTransform method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoTransform_String_Reader() throws Exception {
        System.out.println("doTransform");
        String name = "name2";
        String filename = "src/test/resources/transform.xsl";
        instance.addTransform(name, filename);
        String tname = "name2";
        Reader input = new StringReader("<a><b>testtext</b></a>");
        String expResult = "<a>";
        String result = instance.doTransform(tname, input);
        assertTrue(result.startsWith(expResult));
    }

    /**
     * Test of doTransform method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoTransform_String_String() throws Exception {
        System.out.println("doTransform");
        String name = "name3";
        String filename = "src/test/resources/transform.xsl";
        instance.addTransform(name, filename);
        String tname = "name3";
        String input = "<a><b>testtext</b></a>";
        String expResult = "<a>";
        String result = instance.doTransform(tname, input);
        assertTrue(result.startsWith(expResult));
    }

    /**
     * Test of addTransform method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddTransform_String_InputStream() throws Exception {
        System.out.println("addTransform");
        String name = "name4";
        InputStream is = new FileInputStream("src/test/resources/transform.xsl");
        instance.addTransform(name, is);
    }

    /**
     * Test of setURIResolver method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSetURIResolver() throws Exception {
        System.out.println("setURIResolver");
        String name = "testresolver";
        instance.addTransform("testresolver", "src/test/resources/transform.xsl");
        URIResolver r = new ResourceResolver();
        instance.setURIResolver(name, r);
    }

    /**
     * Test of getFactoryURIResolver method, of class TransformManager.
     */
    @Test
    public void testGetFactoryURIResolver() {
        System.out.println("getFactoryURIResolver");
        URIResolver result = instance.getFactoryURIResolver();
        assertNotNull(result);
    }

    /**
     * Test of setFactoryURIResolver method, of class TransformManager.
     */
    @Test
    public void testSetFactoryURIResolver() {
        System.out.println("setFactoryURIResolver");
        URIResolver r = instance.getFactoryURIResolver();
        instance.setFactoryURIResolver(r);
    }

    /**
     * Test of addTransform method, of class TransformManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddTransform_String_String() throws Exception {
        System.out.println("addTransform");
        String name = "name5";
        String filename = "src/test/resources/transform.xsl";
        instance.addTransform(name, filename);
    }

    private static class ResourceResolver implements URIResolver {

        @Override
        public Source resolve(String href, String base)
                throws TransformerException {
            return null;
        } // resolve
    } // ResourceResolver
}
