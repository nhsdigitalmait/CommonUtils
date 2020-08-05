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

package uk.nhs.digital.mait.commonutils.util;
import java.util.ArrayList;
/**
 * Convenience class wrapping ConfigurationStringTokeniser to return the
 * tokens as a string array.
 * 
 * @author Damian Murphy murff@warlock.org
 */
public class ConfigurationTokenSplitter {
    
    private ConfigurationStringTokeniser tokeniser = null;
    private boolean addFinalEmptyToken = false;
    
    /**
     * public constructor default delimiter is space
     * @param line String to be tokenised
     */
    public ConfigurationTokenSplitter(String line) {
        tokeniser = new ConfigurationStringTokeniser(line);
    }

    /**
     * public constructor
     * @param line String to be tokenised
     * @param d character to use as delimiter
     */
    public ConfigurationTokenSplitter(String line, char d) {
        tokeniser = new ConfigurationStringTokeniser(line, d);
        if (line.charAt(line.length() -1) == d) {
            addFinalEmptyToken = true;
        }
    }
    
    /**
     * Build a string array of tokens (preprocessing defaulted to false)
     * @return String array of tokens
     * @throws Exception 
     */
    public String[] split()
            throws Exception
    {
        return split(false);
    }
    
    /**
     * Build a string array of tokens
     * @param preprocessing boolean to indicate whether preprocessing has occurred 
     * @return String array of tokens
     * @throws Exception 
     */
    public String[] split(boolean preprocessing) 
            throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        while (tokeniser.hasMoreTokens()) {
            String s = tokeniser.nextToken();
            if (!preprocessing) {
                if (s.endsWith("\"")) {
                    s = s.substring(0, s.length() - 1);
                }
                if (s.startsWith("\"")) {
                    s = s.substring(1);
                }
            }
            list.add(s);
        }
        if (addFinalEmptyToken)
            list.add("");
        String[] a = new String[list.size()];
        a = list.toArray(a);
        return a;
    }
}
