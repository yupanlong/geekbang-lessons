/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geektimes.configuration.microprofile.config.source.servlet;

import org.eclipse.microprofile.config.spi.ConfigSource;
import org.geektimes.configuration.microprofile.config.source.MapBasedConfigSource;

import javax.servlet.ServletRequest;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * {@link ServletRequest} {@link ConfigSource}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class ServletRequestConfigSource extends MapBasedConfigSource {

    protected ServletRequest request;

    protected ServletRequestConfigSource(ServletRequest request) {
        super("ServletRequestConfigSource", 650);
        this.request = request;
    }

    @Override
    protected void prepareConfigData(Map configData) throws Throwable {
        Map<String, ?> parameterMap = request.getParameterMap();
        for (String parameterName : parameterMap.keySet()) {
            configData.put(parameterName, asList(request.getParameterValues(parameterName)));
        }
    }
}
