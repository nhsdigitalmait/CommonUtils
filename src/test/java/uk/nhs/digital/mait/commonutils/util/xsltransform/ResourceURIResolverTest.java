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
import java.io.InputStream;
import javax.xml.transform.Source;
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
public class ResourceURIResolverTest {

    private ResourceURIResolver instance;
    
    public ResourceURIResolverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ResourceURIResolver();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addResource method, of class ResourceURIResolver.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddResource() throws Exception {
        System.out.println("addResource");
        String name = "name";
        InputStream is = new ByteArrayInputStream("<a.<b>text</b></a>".getBytes());
        instance.addResource(name, is);
    }

    /**
     * Test of resolve method, of class ResourceURIResolver.
     * @throws java.lang.Exception
     */
    @Test
    public void testResolve() throws Exception {
        System.out.println("resolve");
        InputStream is = new ByteArrayInputStream("<a><b>text</b></a>".getBytes());
        instance.addResource("name", is);
        String href = "name";
        String base = ""; // ignored
        Source result = instance.resolve(href, base);
        assertNotNull(result);
    }
    
}
