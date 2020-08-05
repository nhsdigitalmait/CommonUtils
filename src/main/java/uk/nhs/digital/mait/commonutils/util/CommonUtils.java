/*
  Copyright 2015  Simon Farrow <simon.farrow1@hscic.gov.uk>

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

package uk.nhs.digital.mait.commonutils.util;

// Rev 28 Fix for ConfigurationStringTokeniser handling multiple spaces, extra tests
// Rev 27 Mods for relative paths / jenkins builds
// Rev 26 Added getConfigurationMap to DefaultSystemPropertiesConfigurator
// Rev 25 Added build-impl.xml
// Rev 24 Added getConfigurationMap to DefaultSystemPropertiesConfigurator
// Rev 23 Enhanced and bug fixed ConfigurationStringTokeniser and ConfigurationTokenSplitter
// Rev 22 Logging a WARNING or ERROR automatically writes to System.err as well
// Rev 21 Added json namespace
// Rev 20 Added xhtml namespace
// Rev 19 Added svn keywords
// Rev 19 Added JUnit Test Suite
// Rev 18 Added JUnit test classes
// Rev 17 Implemenetd Configurator getConfigurationMap
// Rev 16 Added main class and FHIR namespace
public class CommonUtils {
     public static void main (String[] args) {
         System.out.println("TKW CommonUtils Subversion $Rev: 28 $");
     }
}
