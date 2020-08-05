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
package uk.nhs.digital.mait.commonutils.util.configurator;

import java.util.List;
import java.util.Map;
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
public class ConfiguratorTest {

    private ConfiguratorImpl instance;
    
    public ConfiguratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConfiguratorImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class Configurator.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Configurator result = Configurator.init();
        assertNotNull(result);
    }

    /**
     * Test of getConfigurator method, of class Configurator.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetConfigurator() throws Exception {
        System.out.println("getConfigurator");
        Configurator result = Configurator.getConfigurator();
        assertNotNull(result);
    }

    /**
     * Test of setConfiguration method, of class Configurator.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetConfiguration() throws Exception {
        System.out.println("setConfiguration");
        String key = "";
        String value = "";
        instance.setConfiguration(key, value);
    }

    /**
     * Test of clear method, of class Configurator.
     * @throws java.lang.Exception
     */
    @Test
    public void testClear() throws Exception {
        System.out.println("clear");
        instance.clear();
    }

    /**
     * Test of removeConfiguration method, of class Configurator.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveConfiguration() throws Exception {
        System.out.println("removeConfiguration");
        String key = "";
        instance.removeConfiguration(key);
    }

    /**
     * Test of registerConfigurationListener method, of class Configurator.
     */
    @Test
    public void testRegisterConfigurationListener() {
        System.out.println("registerConfigurationListener");
        ConfigurationListener l = null;
        instance.registerConfigurationListener(l);
    }

    /**
     * Test of getConfiguration method, of class Configurator.
     */
    @Test
    public void testGetConfiguration() {
        System.out.println("getConfiguration");
        String key = "";
        String expResult = "";
        String result = instance.getConfiguration(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationMap method, of class Configurator.
     */
    @Test
    public void testGetConfigurationMap() {
        System.out.println("getConfigurationMap");
        String key = "";
        Map expResult = null;
        Map result = instance.getConfigurationMap(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationList method, of class Configurator.
     */
    @Test
    public void testGetConfigurationList() {
        System.out.println("getConfigurationList");
        String key = "";
        List expResult = null;
        List result = instance.getConfigurationList(key);
        assertEquals(expResult, result);
    }

    public class ConfiguratorImpl extends Configurator {

        @Override
        public void setConfiguration(String key, String value) throws Exception {
        }

        @Override
        public void clear() throws Exception {
        }

        @Override
        public void removeConfiguration(String key) throws Exception {
        }

        @Override
        public void registerConfigurationListener(ConfigurationListener l) {
        }

        @Override
        public String getConfiguration(String key) {
            return "";
        }

        @Override
        public Map getConfigurationMap(String key) {
            return null;
        }

        @Override
        public List getConfigurationList(String key) {
            return null;
        }
    }
    
}
