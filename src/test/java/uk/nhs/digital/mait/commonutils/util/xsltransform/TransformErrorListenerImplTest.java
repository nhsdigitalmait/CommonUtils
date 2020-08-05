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
// $Id: TransformErrorListenerImplTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.xsltransform;

import javax.xml.transform.TransformerException;
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
public class TransformErrorListenerImplTest {

    private TransformErrorListenerImpl instance;
    
    public TransformErrorListenerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new TransformErrorListenerImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of error method, of class TransformErrorListenerImpl.
     */
    @Test
    public void testError() {
        System.out.println("error");
        TransformerException exception = new TransformerException("message");
        instance.error(exception);
    }

    /**
     * Test of fatalError method, of class TransformErrorListenerImpl.
     */
    @Test
    public void testFatalError() {
        System.out.println("fatalError");
        TransformerException exception =  new TransformerException("message");
        instance.fatalError(exception);
    }

    /**
     * Test of warning method, of class TransformErrorListenerImpl.
     */
    @Test
    public void testWarning() {
        System.out.println("warning");
        TransformerException exception =  new TransformerException("message");
        instance.warning(exception);
    }
    
}
