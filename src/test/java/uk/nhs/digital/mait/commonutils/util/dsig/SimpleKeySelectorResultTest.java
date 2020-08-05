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
// $Id: SimpleKeySelectorResultTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.dsig;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
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
public class SimpleKeySelectorResultTest {

    private Key key;

    public SimpleKeySelectorResultTest() {
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
            System.out.println("getKey");
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "password".toCharArray();
            try (FileInputStream fis = new FileInputStream(System.getenv("TKWROOT") + "/config/ITK_Correspondence/certs/tls.jks")) {
                ks.load(fis, password);
                Enumeration<String> aliases = ks.aliases();
                while (aliases.hasMoreElements()) {
                    System.out.println(aliases.nextElement());
                }
                key = ks.getKey("selfsigned", password);
            } catch (IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException ex) {
                Logger.getLogger(SimpleKeySelectorResultTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (KeyStoreException ex) {
            Logger.getLogger(SimpleKeySelectorResultTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getKey method, of class SimpleKeySelectorResult.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        SimpleKeySelectorResult instance = new SimpleKeySelectorResult(key);
        String expResult = "PKCS#8";
        Key result = instance.getKey();
        assertEquals(expResult, result.getFormat());
    }
}
