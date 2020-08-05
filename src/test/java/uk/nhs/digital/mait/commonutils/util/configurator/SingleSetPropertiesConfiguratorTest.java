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
// $Id: SingleSetPropertiesConfiguratorTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.configurator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SingleSetPropertiesConfiguratorTest {

    private SingleSetPropertiesConfigurator instance;
    
    public SingleSetPropertiesConfiguratorTest() {
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
            instance = new SingleSetPropertiesConfigurator();
            Properties p = new Properties();
            p.put("testprop1","testval1");
            instance.setProperties(p);
        } catch (Exception ex) {
            Logger.getLogger(SingleSetPropertiesConfiguratorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of clear method, of class SingleSetPropertiesConfigurator.
     */
    @Test(expected=Exception.class)
    public void testClear() throws Exception {
        System.out.println("clear");
        instance.clear();
    }

    /**
     * Test of removeConfiguration method, of class SingleSetPropertiesConfigurator.
     */
    @Test(expected=Exception.class)
    public void testRemoveConfiguration() throws Exception {
        System.out.println("removeConfiguration");
        String key = "";
        instance.removeConfiguration(key);
    }

    /**
     * Test of setConfiguration method, of class SingleSetPropertiesConfigurator.
     */
    @Test(expected=Exception.class)
    public void testSetConfiguration() throws Exception {
        System.out.println("setConfiguration");
        String key = "";
        String value = "";
        instance.setConfiguration(key, value);
    }

    /**
     * Test of setProperties method, of class SingleSetPropertiesConfigurator.
     * @throws java.lang.Exception
     */
    @Test(expected=Exception.class)
    public void testSetProperties() throws Exception {
        System.out.println("setProperties");
        Properties p = null;
        instance.setProperties(p);
    }

    /**
     * Test of registerConfigurationListener method, of class SingleSetPropertiesConfigurator.
     */
    @Test
    public void testRegisterConfigurationListener() {
        System.out.println("registerConfigurationListener");
        ConfigurationListener l =new ConfigurationListener() {
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
     * Test of getConfiguration method, of class SingleSetPropertiesConfigurator.
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
     * Test of getConfigurationMap method, of class SingleSetPropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationMap() {
        System.out.println("getConfigurationMap");
        String key = "";
        HashMap expResult = null;
        HashMap result = instance.getConfigurationMap(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConfigurationList method, of class SingleSetPropertiesConfigurator.
     */
    @Test
    public void testGetConfigurationList() {
        System.out.println("getConfigurationList");
        String key = "";
        ArrayList expResult = null;
        ArrayList result = instance.getConfigurationList(key);
        assertEquals(expResult, result);
    }
    
}
