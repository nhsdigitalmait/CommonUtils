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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
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
public class ResettablePropertiesConfiguratorTest {

    private ResettablePropertiesConfigurator instance;
    
    public ResettablePropertiesConfiguratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ResettablePropertiesConfigurator();
        instance.setProperties(new Properties());
        instance.setConfiguration("testprop1","testval1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setProperties method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testSetProperties() {
        System.out.println("setProperties");
        Properties p = new Properties();
        instance.setProperties(p);
    }

    /**
     * Test of clear method, of class ResettablePropertiesConfigurator.
     * @throws java.lang.Exception
     */
    @Test
    public void testClear() throws Exception {
        System.out.println("clear");
        instance.clear();
    }

    /**
     * Test of setConfiguration method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testSetConfiguration() {
        System.out.println("setConfiguration");
        String key = "testprop2";
        String value = "testval2";
        instance.setConfiguration(key, value);
    }

    /**
     * Test of removeConfiguration method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testRemoveConfiguration() {
        System.out.println("removeConfiguration");
        String key = "testprop1";
        instance.removeConfiguration(key);
    }

    /**
     * Test of registerConfigurationListener method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testRegisterConfigurationListener() {
        System.out.println("registerConfigurationListener");
        ConfigurationListener l = new ConfigurationListener() {
            @Override
            public String[] listenProperties() {
                return new String[]{};
            }

            @Override
            public void notifyConfigurationChange() {
            }

            @Override
            public void notifyConfigurationChange(String[] changed) {
            }
        };
        instance.registerConfigurationListener(l);
    }

    /**
     * Test of getConfiguration method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testGetConfiguration() {
        System.out.println("getConfiguration");
        String key = "testprop1";
        String expResult = "testval1";
        String result = instance.getConfiguration(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationMap method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationMap() {
        System.out.println("getConfigurationMap");
        String regex = "^.*$";
        HashMap expResult = new HashMap<>();
        expResult.put("testprop1","testval1");
        HashMap result = instance.getConfigurationMap(regex);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationList method, of class ResettablePropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationList() {
        System.out.println("getConfigurationList");
        String key = "testprop1";
        ArrayList expResult = null;
        ArrayList result = instance.getConfigurationList(key);
        assertEquals(expResult, result);
    }
    
}
