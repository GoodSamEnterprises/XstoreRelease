/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * INT-92               260817    Customer Integration
 *== ================================================================
 */

package caw.rest.services;

import org.apache.log4j.Logger;

import dtv.util.config.*;

/**
 * Containing data parsed for tag RestRequest in file RestRequestConfig.xml
 */
public class CawRestConfig
        extends AbstractParentConfig implements ICascadableConfig {

    private static final long   serialVersionUID  = 6894222410771885221L;

    private static final Logger _logger           = Logger
            .getLogger(CawRestConfig.class);

    private static final String SEQUENCE_NAME_TAG = "Name";

    private static final String REFERENCE_TAG     = "Ref";

    private static final String BODY_TAG          = "Body";

    private String              _restName         = null;

    private String              _body             = null;

    private String              _reference        = null;

    @Override
    public void cascadeValues(IConfigObject argSource) {

        if (!(argSource instanceof CawRestConfig)) {
            _logger.error("Attempted to cascade from invalid configuration object::"
                    + getSourceDescription(argSource) + "-->"
                    + getSourceDescription());
            return;
        }
    }

    public String getRestName() {

        return _restName;
    }

    /**
     * @return the send request time out.
     */
    public String getBody() {

        return _body;
    }

    public String getReference() {

        return _reference;
    }

    @Override
    public void setConfigObject(String argKey, IConfigObject argValue) {

        if (SEQUENCE_NAME_TAG.equalsIgnoreCase(argKey)) {
            _restName = argValue.toString();
        } else if (BODY_TAG.equalsIgnoreCase(argKey)) {
            _body = argValue.toString();
        } else if (REFERENCE_TAG.equalsIgnoreCase(argKey)) {
            _reference = argValue.toString();
        }
        setClean();
    }

    /**
     * Sets the value of the destination field.
     * 
     * @param argDestination
     *            the new value for the field
     */
    public void setBody(String argBody) {

        _body = argBody;
        setDirty();
    }

    /**
     * Sets the value of the soapName field.
     * 
     * @param argSoapName
     *            the new value for the field
     */
    public void setSoapName(String argSoapName) {

        _restName = argSoapName;
        setDirty();
    }

    /**
     * Sets the value of the Reference field.
     * 
     * @param argReference
     *            the new value for the field
     */
    public void setReference(String argReference) {

        _reference = argReference;
        setDirty();
    }
}