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
// $Id: UtilSuite.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author simonfarrow
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({uk.nhs.digital.mait.commonutils.util.xsltransform.XsltransformSuite.class, uk.nhs.digital.mait.commonutils.util.ConfigurationTokenSplitterTest.class, uk.nhs.digital.mait.commonutils.util.CfHNamespaceContextTest.class, uk.nhs.digital.mait.commonutils.util.configurator.ConfiguratorSuite.class, uk.nhs.digital.mait.commonutils.util.XMLNamespaceContextTest.class, uk.nhs.digital.mait.commonutils.util.CommonUtilsTest.class, uk.nhs.digital.mait.commonutils.util.ConfigurationStringTokeniserTest.class, uk.nhs.digital.mait.commonutils.util.dsig.DsigSuite.class, uk.nhs.digital.mait.commonutils.util.SpineCfHNamespaceContextTest.class, uk.nhs.digital.mait.commonutils.util.xpath.XpathSuite.class, uk.nhs.digital.mait.commonutils.util.FileLockerTest.class, uk.nhs.digital.mait.commonutils.util.LoggerTest.class})
public class UtilSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
