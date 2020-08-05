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
// $Id: ConfigurationListenerTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.configurator;

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
public class ConfigurationListenerTest {

    private ConfigurationListenerImpl instance;
    
    public ConfigurationListenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConfigurationListenerImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listenProperties method, of class ConfigurationListener.
     */
    @Test
    public void testListenProperties() {
        System.out.println("listenProperties");
        String[] expResult = null;
        String[] result = instance.listenProperties();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of notifyConfigurationChange method, of class ConfigurationListener.
     */
    @Test
    public void testNotifyConfigurationChange_0args() {
        System.out.println("notifyConfigurationChange");
        instance.notifyConfigurationChange();
    }

    /**
     * Test of notifyConfigurationChange method, of class ConfigurationListener.
     */
    @Test
    public void testNotifyConfigurationChange_StringArr() {
        System.out.println("notifyConfigurationChange");
        String[] changed = null;
        instance.notifyConfigurationChange(changed);
    }

    public class ConfigurationListenerImpl implements ConfigurationListener {

        public String[] listenProperties() {
            return null;
        }

        public void notifyConfigurationChange() {
        }

        public void notifyConfigurationChange(String[] changed) {
        }
    }
    
}
