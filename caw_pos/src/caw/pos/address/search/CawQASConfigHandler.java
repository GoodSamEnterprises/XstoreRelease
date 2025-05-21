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
 * BZ25358          300518    Enhancements to QAS Integration with POS
 * BZ26410          300518    [Technical] Move QAS URL from system.properties to ServiceHandlers.xml
 *===================================================================
 */

package caw.pos.address.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawAbsServiceHandler;
import caw.pos.common.CawUtilFunction;

import dtv.servicex.impl.config.req.*;

/**
 * This class is used to get properties/parameters defined for QAS service.
 */
public class CawQASConfigHandler extends CawAbsServiceHandler {

    private static final String                 QAS_WSDL_LOCATION_PARAM  = "WsdlLocation";

    private static final String                 QAS_NAME_SPACE_URI_PARAM = "QasTargetNamespaceUri";

    private static final String                 QAS_ENGINE_TIMEOUT_PARAM = "QasEngineTimeout";

    private static final String                 QAS_THRESHOLD_PARAM      = "ConnectTimeout";

    private static final String                 QAS_WSDL_LOCATION_KEY    = "qas.wsdlLocation";

    private static final String                 QAS_NAMESPACE_URI_KEY    = "qas.targetNamespace";

    private static final String                 QAS_ENGINE_TIMEOUT_KEY   = "qas.engine.timeout";

    private static final String                 QAS_ENGINE_THRESHOLD_KEY = "qas.engine.threshold";

    private static final int                    QAS_ENGINE_TIMEOUT_DEF   = 10000;

    private static final int                    QAS_THRESHOLD_DEF        = 30;

    private static final Logger                 _logger                  = LogManager
            .getLogger(CawQASConfigHandler.class);

    private boolean                             _initiated               = false;

    private String                              _namespaceUri;

    private String                              _wsdlUrl;

    private Integer                             _engineTimeout;

    private Integer                             _threshold;

    /**
     * The singleton instance of the CawQASConfigHandler class
     */
    private static volatile CawQASConfigHandler instance                 = null;

    /**
     * Default constructor is private
     */
    private CawQASConfigHandler() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawQASConfigHandler
     */
    public static CawQASConfigHandler getInstance() {

        if (instance == null) {
            synchronized (CawQASConfigHandler.class) {
                if (instance == null) {
                    instance = new CawQASConfigHandler();
                }
            }
        }
        return instance;
    }

    @Override
    protected void init() {

        try {
            super.init();

            ServiceConfig argServiceConfig = getServiceConfig();

            String wsdlLocation = argServiceConfig.getParameterValue(QAS_WSDL_LOCATION_PARAM).toString();
            String argNameSpaceUri = argServiceConfig.getParameterValue(QAS_NAME_SPACE_URI_PARAM).toString();
            Object cto = argServiceConfig.getParameterValue(QAS_THRESHOLD_PARAM);
            Object rto = argServiceConfig.getParameterValue(QAS_ENGINE_TIMEOUT_PARAM);

            Integer argConnectTimeout = Integer.valueOf(CawUtilFunction.vInt(cto.toString(), QAS_THRESHOLD_DEF));
            Integer argReadTimeout = Integer.valueOf(CawUtilFunction.vInt(rto.toString(), QAS_ENGINE_TIMEOUT_DEF));

            this._engineTimeout = argReadTimeout;
            this._threshold = argConnectTimeout;
            this._wsdlUrl = wsdlLocation;
            this._namespaceUri = argNameSpaceUri;
            this._initiated = true;
        } catch (Exception ex) {
            _logger.error("init() method: ", ex);
        }
    }

    /**
     * Required to declare init-method="init" 
     * in the bean in spring.xml
     * @return the initiated
     */
    public boolean isInitiated() {
        return _initiated;
    }

    /**
     * Engine timeout for QAS 
     * @return
     */
    public Integer getQASEngineTimeout() {

        Integer res = _engineTimeout;
        if (res == null || res.intValue() == 0) {
            String value = CawUtilFunction
                    .getSystemProperty(QAS_ENGINE_TIMEOUT_KEY, String.valueOf(QAS_ENGINE_TIMEOUT_DEF));
            res = Integer.valueOf(CawUtilFunction.vInt(value, QAS_ENGINE_TIMEOUT_DEF));
        }
        return res;
    }

    /**
     * Threshold for QAS 
     * @return
     */
    public Integer getQASThreshold() {

        Integer res = _threshold;
        if (res == null || res.intValue() == 0) {
            String value = CawUtilFunction
                    .getSystemProperty(QAS_ENGINE_THRESHOLD_KEY, String.valueOf(QAS_THRESHOLD_DEF));
            res = Integer.valueOf(CawUtilFunction.vInt(value, QAS_THRESHOLD_DEF));
        }
        return res;
    }

    /**
     * URL for QAS Name-space
     * @return
     */
    public String getQASNamespaceUri() {

        String value = _namespaceUri;
        if (value != null && value.length() > 0) {
            return value;
        } else {
            return CawUtilFunction.getSystemProperty(QAS_NAMESPACE_URI_KEY, "http://www.qas.com/web-2013-12");
        }

    }

    /**
     * Get URL for QAS
     * @return
     */
    public String getQASWsdlUrl() {

        String value = _wsdlUrl;
        if (value != null && value.length() > 0) {
            return value;
        } else {
            return CawUtilFunction.getSystemProperty(QAS_WSDL_LOCATION_KEY, "http://ky-bgr-qas-dev:2021/proweb.wsdl");
        }

    }
}
