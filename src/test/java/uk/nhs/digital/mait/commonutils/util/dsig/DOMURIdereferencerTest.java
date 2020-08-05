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
// $Id: DOMURIdereferencerTest.java 19 2017-04-20 11:53:19Z sfarrow $
package uk.nhs.digital.mait.commonutils.util.dsig;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.crypto.Data;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIReference;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author simonfarrow
 */
public class DOMURIdereferencerTest {

    private Key key;

    public DOMURIdereferencerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        System.out.println("getKey");
        KeyStore ks = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();
        FileInputStream fis = new FileInputStream(System.getenv("TKWROOT") + "/config/ITK_Correspondence/certs/tls.jks");
        ks.load(fis, password);
        Enumeration<String> aliases = ks.aliases();
        while (aliases.hasMoreElements()) {
            System.out.println(aliases.nextElement());
        }
        key = ks.getKey("selfsigned", password);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of dereference method, of class DOMURIdereferencer.
     * picks an Oasis Id reference marked node from inside an xml dom tree
     * @throws java.lang.Exception
     */
    @Test
    public void testDereference() throws Exception {
        System.out.println("dereference");
        URIReference uri = new URIReference() {
            @Override
            public String getURI() {
                return "#internalref";
            }

            @Override
            public String getType() {
                return null;
            }
        };
        
        String markedPayload = "<b xmlns:oasis=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" oasis:Id=\"internalref\">xxx</b>";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setIgnoringComments(true);
        Document doc = dbf.newDocumentBuilder().parse(
                new ByteArrayInputStream(
                        ("<a>"+markedPayload+"</a>").getBytes()));
        Node node = doc.getFirstChild();

        XMLCryptoContext context = new DOMSignContext(key, node);  // this is internally cast to DOMSignContext despite being passed as an interface
        DOMURIdereferencer instance = new DOMURIdereferencer();
        
        OctetStreamData osd = (OctetStreamData) instance.dereference(uri, context);
        // get the contents of the octet stream into a String (First time I have ever seen a functional version thats better than the declarative in Java)
        // may not woprk in Windows
        try (BufferedReader br = new BufferedReader(new InputStreamReader(osd.getOctetStream()))) {
            String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
            assertEquals(markedPayload, result);
        }
    }
}
