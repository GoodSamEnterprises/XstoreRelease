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
 *===================================================================
 */

package caw.pos.address.search;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.qas.proweb.*;

/**
 * this class is used to invoke to QAS service. 
 * Sending Request and getting response, 
 * parsing data and showing log file.
 */
public class CawQASHelper {

    private static final Logger          _logger         = LogManager.getLogger(CawQASHelper.class);

    private static final String          QAS_QNAME_LOCAL = "ProWeb";

    private CawQASConfigHandler          _configs        = CawQASConfigHandler.getInstance();

    /**
     * The singleton instance of the CawQASHelper class
     */
    private static volatile CawQASHelper instance        = null;

    private boolean                      isOffline       = false;

    /**
     * Default constructor is private
     */
    private CawQASHelper() {

        super();
    }

    /**
     * Returns a reference to the single instance of this object
     * 
     * @return CawQASHelper
     */
    public static CawQASHelper getInstance() {

        if (instance == null) {
            synchronized (CawQASHelper.class) {
                if (instance == null) {
                    instance = new CawQASHelper();
                }
            }
        }
        return instance;
    }

    private CawQASConfigHandler getConfigs() {
        return _configs;
    }

    /**
     * Create instance of CawProWeb
     * @return
     * @throws Exception
     */
    private CawProWeb createProWeb() {
        CawProWeb webservice = null;
        try {
            webservice = new CawProWeb(new URL(getConfigs().getQASWsdlUrl()),
                    new QName(getConfigs().getQASNamespaceUri(), QAS_QNAME_LOCAL));
            this.isOffline = false;
        } catch (Exception e) {
            this.isOffline = true;
            _logger.error("createProWeb-1", e);
        }
        return webservice;

    }

    /**
     * 
     * @param request
     * @return
     */
    public CawQASearchResult doSearch(CawQASearch request) {

        CawQASearchResult result = null;
        try {
            CawProWeb service = createProWeb();
            if (request != null && request.getEngine() != null) {
                request.getEngine().setThreshold(getConfigs().getQASThreshold());
                request.getEngine().setTimeout(getConfigs().getQASEngineTimeout());
            }
            result = service.getQAPortType().doSearch(request);
        } catch (Exception ex) {
            this.isOffline = true;
            _logger.error("doSearch-1", ex);
        }
        return result;
    }

    /**
     * 
     * @param request
     * @return
     */
    public CawPicklist doRefine(CawQARefine request) {

        CawPicklist result = null;
        try {
            CawProWeb service = createProWeb();
            if (request != null) {
                request.setThreshold(getConfigs().getQASThreshold());
                request.setTimeout(getConfigs().getQASEngineTimeout());
            }
            result = service.getQAPortType().doRefine(request);
        } catch (Exception ex) {
            this.isOffline = true;
            _logger.error("doRefine-1", ex);
        }
        return result;
    }

    /**
     * @return the isOffline
     */
    public boolean isOffline() {
        return isOffline;
    }

}
