/*
Copyright 2011 Damian Murphy <murff@warlock.org>

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
import java.util.Properties;

/**
 * Simple configurator implementation based on a given properties instance.
 * Allows the internal properties to be re-set.
 *
 * @author Damian Murphy <murff@warlock.org>
 */
public class ResettablePropertiesConfigurator
        extends Configurator {

    private ArrayList<ConfigurationListener> listeners = null;

    ResettablePropertiesConfigurator() {
        super();
        listeners = new ArrayList<>();
    }

    @Override
    public synchronized void setProperties(Properties p) throws Exception {
        properties = p;
    }

    @Override
    public void clear()
            throws Exception {
        if (properties == null) {
            throw new Exception("Nothing to clear");
        }
        properties.clear();
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public void removeConfiguration(String key) {
        if (properties.containsKey(key)) {
            properties.remove(key);
        }
    }

    @Override
    public void registerConfigurationListener(ConfigurationListener l) {
        listeners.add(l);
    }

    @Override
    public String getConfiguration(String key) {
        return properties.getProperty(key);
    }

    /**
     *
     * @param regex
     * @return
     */
    @Override
    public HashMap getConfigurationMap(String regex) {
        HashMap<String,String> h = new HashMap<>();
        for (Object p : properties.keySet()) {
            if (p.toString().matches(regex)) {
                h.put(p.toString(), (String) properties.get(p));
            }
        }
        return h;
    }

    /**
     * Not supported in system properties.
     *
     * @param key
     * @return
     */
    @Override
    public ArrayList getConfigurationList(String key) {
        return null;
    }

}
