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
public class DefaultSystemPropertiesConfiguratorTest {

    private DefaultSystemPropertiesConfigurator instance;
    
    public DefaultSystemPropertiesConfiguratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new DefaultSystemPropertiesConfigurator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of removeConfiguration method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testRemoveConfiguration() {
        System.out.println("removeConfiguration");
        String key = "";
        instance.removeConfiguration(key);
    }

    /**
     * Test of clear method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        instance.clear();
    }

    /**
     * Test of setConfiguration method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testSetConfiguration() {
        System.out.println("setConfiguration");
        String key = "testkey";
        String value = "value";
        instance.setConfiguration(key, value);
    }

    /**
     * Test of registerConfigurationListener method, of class DefaultSystemPropertiesConfigurator.
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
     * Test of getConfiguration method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testGetConfiguration() {
        System.out.println("getConfiguration");
        String key = "user.country";
        String expResult = "GB";
        String result = instance.getConfiguration(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationMap method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationMap() {
        System.out.println("getConfigurationMap");
        String key = "";
        // this has been implemented so it now returns an empty map
        HashMap expResult = new HashMap<>();
        HashMap result = instance.getConfigurationMap(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationList method, of class DefaultSystemPropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationList() {
        System.out.println("getConfigurationList");
        String key = "";
        // this has not been implemented so it returns null so the users dont thionk it has worked when it hasn't
        ArrayList expResult = null;
        ArrayList result = instance.getConfigurationList(key);
        assertEquals(expResult, result);
    }
    
}
