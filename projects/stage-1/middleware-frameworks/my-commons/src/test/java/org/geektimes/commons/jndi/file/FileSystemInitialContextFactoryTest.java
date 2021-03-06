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
package org.geektimes.commons.jndi.file;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * {@link FileSystemInitialContextFactory}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class FileSystemInitialContextFactoryTest {

    public static String INITIAL_CONTEXT_FACTORY_IMPL_CLASS_NAME =
            "org.geektimes.commons.jndi.file.FileSystemInitialContextFactory";

    /***
     * 代码配置 javax.naming.spi.InitialContextFactory 实现
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        Hashtable<String, Object> environment = new Hashtable<String, Object>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY_IMPL_CLASS_NAME);

        InitialContext context = new InitialContext(environment);
        String name = "def";
        Object value = "2021";
        Context envContext = (Context) context.lookup("java:comp/env");
        envContext.bind(name, value);

        assertEquals(value, envContext.lookup(name));

        envContext.unbind(name);
        assertNull(envContext.lookup(name));
    }
}
