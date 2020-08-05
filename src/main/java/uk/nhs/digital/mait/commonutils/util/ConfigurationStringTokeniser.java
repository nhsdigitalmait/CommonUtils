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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
 /**
 * Implementation of StringTokenizer behaviour where tokens are whitespace
 * delimited, but the tokeniser is aware of, and honours, double- and single-
 * quotes, square brackets and parentheses.
 * 
 * @author Damian Murphy murff@warlock.org
 */
public class ConfigurationStringTokeniser {

    private final ArrayList<String> tokens = new ArrayList<>();
    private Iterator<String> tokenSet = null;
    private boolean defaultDelimiter = true;
    
    private char delimiter = ' ';
    
    /**
     * public constructor
     * @param s String to be tokenised
     * @param d character to use as delimitter
     */
    public ConfigurationStringTokeniser(String s, char d) {
        delimiter = d;
        defaultDelimiter = false;
        process(s);
    }
    
    /**
     * public constructor default delimiter is space
     * @param s String to be tokenised
     */
    public ConfigurationStringTokeniser(String s) {
        process(s);
    }

    @SuppressWarnings("null")
    private void process(String s) {
        char[] characters = s.trim().toCharArray();
        ArrayDeque<Character> encaps = new ArrayDeque<>();
        StringBuilder sb = null;
        char in_force_quote = 0;
        boolean endwrapping = false;
        
        for (char c : characters) {
            if ((defaultDelimiter && Character.isWhitespace(c)) || (c == delimiter)) {
                if ((in_force_quote == 0) && (encaps.isEmpty())) {
                    if (sb != null) {
                        tokens.add(sb.toString());
                        sb = null;
                    } else {
                        // spot fix for leading spaces not being ignored
                        //tokens.add("");
                    }
                } else {
                    sb.append(c);
                    if (endwrapping) {
                       tokens.add(sb.toString().trim());
                        sb = null;
                        endwrapping = false;
                    }
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(c);
                // Handle encapsulation
                // If c is a quote, the "turn off" all encapsulation processing
                if ((c == '\'') || (c == '"')) {
                    if (c == in_force_quote) {
                        in_force_quote = 0;
                    } else {
                        in_force_quote = c;
                    }
                } else {
                    // Handle nested quotes
                    // This *will* end up in a horrible mess if the input is badly-formed,
                    // but we don't need to try to analyse why there is a problem, just
                    // detect it.
                    if (in_force_quote == 0) {
                        if ((c == '[') || (c == '(')) {
                            encaps.addFirst(c);
                        } else {
                            if (!encaps.isEmpty()) {
                                if (c == ']') {
                                    if (Objects.equals(encaps.getFirst(), '[')) {
                                        encaps.removeFirst();
                                    }
                                } else {
                                    if (c == ')') {
                                        if (Objects.equals(encaps.getFirst(), '(')) {
                                            encaps.removeFirst();
                                        }
                                    }
                                }
                                if (encaps.isEmpty()) {
                                    endwrapping = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (sb != null) {
            tokens.add(sb.toString());
        }
        tokenSet = tokens.iterator();        
    }
    
    /**
     * 
     * @return  integer total number of tokens
     */
    public int countTokens() { return tokens.size(); }
    
    /**
     * 
     * @return the string containing the next token
     * @throws Exception 
     */
    public String nextToken()
        throws Exception
    {
        return tokenSet.next();
    }

    /**
     * 
     * @return boolean indicating whether more tokens are available
     */
    public boolean hasMoreTokens() {
        return tokenSet.hasNext();
    }
}
