/*
 Copyright 2015  Simon Farrow simon.farrow1@hscic.gov.uk

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

package uk.nhs.digital.mait.commonutils.util.xpath;

import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import static javax.xml.xpath.XPathFactory.DEFAULT_OBJECT_MODEL_URI;
import javax.xml.xpath.XPathFactoryConfigurationException;
import uk.nhs.digital.mait.commonutils.util.CfHNamespaceContext;
import org.xml.sax.InputSource;

/**
 * Manager class for providing access to the saxon XPathFactory. During OSGi
 * development work it was realised that using System properties to specify
 * xpath and xslt engines is unreliable because each OSGi bundle uses a
 * separate class loader. This class centralises creation of factory objects in
 * a more specific manner which does not rely on apparently "global" system property values.
 *
 * @author Simon Farrow simon.farrow1@hscic.gov.uk
 */
public class XPathManager {

    /**
     * private constructor
     */
    private XPathManager() {
    }

    /**
     * This is default behaviour.
     *
     * @return new instance of saxon xpath factory
     * @throws XPathFactoryConfigurationException
     */
    public static XPathFactory newInstance() throws XPathFactoryConfigurationException {
        // explicitly forces use of the saxon factory
        return new net.sf.saxon.xpath.XPathFactoryImpl();
    }

    /**
     * This is a workaround for a known Saxon defect.
     *
     * Some invocations use this signature (providing a factory uri) but there
     * is a known defect with saxon if you call the newInstance with a
     * parameter.
     *
     * TKW code only ever invokes this with XPathConstants.DOM_OBJECT_MODEL
     * which resolves to the String http://java.sun.com/jaxp/xpath/dom. This is the same
     * value as the java constant DEFAULT_OBJECT_MODEL_URI which is the default
     * if you invoke newInstance without a parameter. So we check that we are
     * specifying what is the default anyway and then just remove the parameter.
     *
     * Throws an exception if the uri is different from the default.
     *
     * @param uri object model
     * @return saxon instance of factory
     * @throws XPathFactoryConfigurationException
     */
    public static XPathFactory newInstance(String uri) throws XPathFactoryConfigurationException {
        if (uri.equals(DEFAULT_OBJECT_MODEL_URI)) {
            return newInstance();
        } else {
            throw new IllegalArgumentException("Unsupported object model " + uri);
        }
    }

    /**
     * extract a string from the passed xml using the given xpath includes known
     * cfh namespaces
     *
     * @param xpath String
     * @param xml string
     * @return extracted String
     * @throws XPathExpressionException
     * @throws XPathFactoryConfigurationException
     */
    public static String xpathExtractor(String xpath, String xml) throws XPathExpressionException, XPathFactoryConfigurationException {
        XPathExpression extractor = getXpathExtractor(xpath);
        return (String) extractor.evaluate(new InputSource(new StringReader(xml)), XPathConstants.STRING);
    }

    /**
     * return a compiled XpathExpression given the xpath string
     * automatically adds the cfh namespace contexts
     * @param xpath
     * @return compiled XPathExpression
     * @throws XPathFactoryConfigurationException
     * @throws XPathExpressionException 
     */
    public static XPathExpression getXpathExtractor(String xpath) throws XPathFactoryConfigurationException, XPathExpressionException {
        XPath xp = XPathManager.newInstance().newXPath();
        xp.setNamespaceContext(CfHNamespaceContext.getXMLNamespaceContext());
        return xp.compile(xpath);
    }
}
