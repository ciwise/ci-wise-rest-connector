
package org.ciwise.modules.ciwiserest.generated.adapters;

import javax.annotation.Generated;
import org.ciwise.modules.ciwiserest.CIWiseRESTConnector;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;


/**
 * A <code>CIWiseRESTConnectorCapabilitiesAdapter</code> is a wrapper around {@link CIWiseRESTConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.8.0", date = "2016-01-10T12:43:11-05:00", comments = "Build UNNAMED.2762.e3b1307")
public class CIWiseRESTConnectorCapabilitiesAdapter
    extends CIWiseRESTConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
