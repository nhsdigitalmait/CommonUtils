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
package uk.nhs.digital.mait.commonutils.util.dsig;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author simonfarrow
 */
public class NodeSetDataResultTest {

    private NodeSetDataResult instance;
    
    public NodeSetDataResultTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new NodeSetDataResult();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class NodeSetDataResult.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Node n = null;
        instance.put(n);
    }

    /**
     * Test of iterator method, of class NodeSetDataResult.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        boolean expResult = false;
        Iterator result = instance.iterator();
        assertEquals(expResult, result.hasNext());
    }
    
}
