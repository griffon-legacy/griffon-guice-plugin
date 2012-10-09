/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 */

import com.google.inject.Injector;
import griffon.core.GriffonApplication;
import griffon.plugins.guice.GuiceInjectorHolder;
import griffon.util.ApplicationHolder;
import griffon.util.ConfigUtils;
import griffon.util.RunnableWithArgs;
import griffon.util.RunnableWithArgsClosure;
import groovy.lang.Closure;
import groovy.util.ConfigObject;
import org.codehaus.griffon.runtime.core.AbstractGriffonAddon;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Andres Almiray
 */
public class GuiceGriffonAddon extends AbstractGriffonAddon {
    private static final String GUICE_CONFIG_NAME = "GuiceConfig";
    private static final String INJECTOR = "injector";

    public GuiceGriffonAddon() {
        super(ApplicationHolder.getApplication());
    }

    public void addonInit(GriffonApplication app) {
        ConfigObject config = ConfigUtils.loadConfigWithI18n(GUICE_CONFIG_NAME);
        GuiceInjectorHolder.setInjector((Injector) config.getProperty(INJECTOR));
    }

    public Map<String, Closure> getEvents() {
        Map<String, Closure> events = new LinkedHashMap<String, Closure>();

        events.put(GriffonApplication.Event.NEW_INSTANCE.getName(), new RunnableWithArgsClosure(new RunnableWithArgs() {
            public void run(Object[] args) {
                Object instance = args[2];
                GuiceInjectorHolder.getInjector().injectMembers(instance);
            }
        }));

        return events;
    }
}
