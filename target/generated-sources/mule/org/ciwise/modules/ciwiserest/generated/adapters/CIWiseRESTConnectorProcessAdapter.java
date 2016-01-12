
package org.ciwise.modules.ciwiserest.generated.adapters;

import javax.annotation.Generated;
import org.ciwise.modules.ciwiserest.CIWiseRESTConnector;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>CIWiseRESTConnectorProcessAdapter</code> is a wrapper around {@link CIWiseRESTConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.8.0", date = "2016-01-11T11:15:52-05:00", comments = "Build UNNAMED.2762.e3b1307")
public class CIWiseRESTConnectorProcessAdapter
    extends CIWiseRESTConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<CIWiseRESTConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, CIWiseRESTConnectorCapabilitiesAdapter> getProcessTemplate() {
        final CIWiseRESTConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,CIWiseRESTConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, CIWiseRESTConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, CIWiseRESTConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
