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
 * Req/Bug ID#      ddMMyy    Description
 * BZ26410          300518    [Technical] Move QAS URL from system.properties to ServiceHandlers.xml
 *===================================================================
 */

package caw.pos.common;

import dtv.servicex.impl.config.req.*;

/**
 * This class is used to get properties/parameters 
 * defined for ServiceHandlers.xml and spring.xml
 * Like XstoreJaxWsPortFactoryBean
 */
public abstract class CawAbsServiceHandler {

    private ConfigHelper  _serviceConfigHelper;

    private String        _serviceId;

    private ServiceConfig serviceConfig;

    /**
     * Required to declare init-method="init" 
     * in the bean in spring.xml
     */
    protected void init() {

        initServiceConfig();
    }

    @SuppressWarnings("cast")
    private void initServiceConfig() {

        ServiceConfig argServiceConfig = ((ServicesConfig) _serviceConfigHelper
                .getRootConfig()).getServiceConfig(_serviceId);
        setServiceConfig(argServiceConfig);
    }

    /**
     * @return the serviceConfig
     */
    public ServiceConfig getServiceConfig() {
        if (serviceConfig == null) {
            initServiceConfig();
        }
        return serviceConfig;
    }

    /**
     * @param argServiceConfig the serviceConfig to set
     */
    public void setServiceConfig(ServiceConfig argServiceConfig) {
        serviceConfig = argServiceConfig;
    }

    /**
     * @return the serviceConfigHelper
     */
    public ConfigHelper getServiceConfigHelper() {
        return _serviceConfigHelper;
    }

    /**
     * @param argServiceConfigHelper the serviceConfigHelper to set
     */
    public void setServiceConfigHelper(ConfigHelper argServiceConfigHelper) {
        _serviceConfigHelper = argServiceConfigHelper;
    }

    /**
     * @return the serviceId
     */
    public String getServiceId() {
        return _serviceId;
    }

    /**
     * @param argServiceId the serviceId to set
     */
    public void setServiceId(String argServiceId) {
        _serviceId = argServiceId;
    }

}
