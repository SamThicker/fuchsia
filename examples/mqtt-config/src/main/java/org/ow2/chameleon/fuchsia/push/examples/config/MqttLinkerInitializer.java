package org.ow2.chameleon.fuchsia.push.examples.config;

/*
 * #%L
 * OW2 Chameleon - Fuchsia Example MQTT Configuration
 * %%
 * Copyright (C) 2009 - 2014 OW2 Chameleon
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.felix.ipojo.configuration.Configuration;
import org.apache.felix.ipojo.configuration.Instance;
import org.ow2.chameleon.fuchsia.core.FuchsiaConstants;

import static org.apache.felix.ipojo.configuration.Instance.instance;
import static org.ow2.chameleon.fuchsia.core.component.ImportationLinker.FILTER_IMPORTDECLARATION_PROPERTY;
import static org.ow2.chameleon.fuchsia.core.component.ImportationLinker.FILTER_IMPORTERSERVICE_PROPERTY;

@Configuration
public class MqttLinkerInitializer {

    Instance pushLinker = instance()
            .of(FuchsiaConstants.DEFAULT_IMPORTATION_LINKER_FACTORY_NAME)
            .named("MQTTLinker")
            .with(FILTER_IMPORTDECLARATION_PROPERTY).setto("(&(id=*)(mqtt.queue=*))")
            .with(FILTER_IMPORTERSERVICE_PROPERTY).setto("(instance.name=AMQPImporter)");

    Instance pushSubscriber = instance()
            .of("org.ow2.chameleon.fuchsia.importer.mqtt.MQTTImporter")
            .named("AMQPImporter")
            .with("target").setto("(&(id=*)(mqtt.queue=*))");

}
