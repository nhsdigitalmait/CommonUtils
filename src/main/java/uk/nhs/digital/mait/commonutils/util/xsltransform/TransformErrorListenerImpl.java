/*
 Copyright 2012  Damian Murphy <murff@warlock.org>

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

package uk.nhs.digital.mait.commonutils.util.xsltransform;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;
import uk.nhs.digital.mait.commonutils.util.Logger;

/**
 *
 * @author Richard Dobson <richarddobson@nhs.net>
 *
 * This transform error listener is used to prevent the CDA template transform
 * reporting to standard error ambiguous match errors which don't break the
 * output that the template schema is actually applied to. The redirected errors
 * are sent to the TKW log files. It is a TEMPORARY MEASURE pending the output
 * of ongoing C&M work on improving the CDA template process, and its
 * transforms.
 *
 */
public class TransformErrorListenerImpl implements ErrorListener {

    public TransformerException e = null;

    @Override
    public void error(TransformerException exception) {
        this.e = exception;
        Logger.getInstance().log("Transform exceptions - TEMPORARY REDIRECTION: ", e.toString());
    }

    @Override
    public void fatalError(TransformerException exception) {
        this.e = exception;
        Logger.getInstance().log("Transform exceptions - TEMPORARY REDIRECTION: ", e.toString());
    }

    @Override
    public void warning(TransformerException exception) {
        this.e = exception;
        Logger.getInstance().log("Transform exceptions - TEMPORARY REDIRECTION: ", e.toString());
    }
}
