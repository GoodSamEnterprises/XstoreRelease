/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ26888              240718    [Internal] Move 2 Paid In (980920) & Paid Out (980919) items to configuration file
 * BZ27629              180818    [PROD] Update Order Service to send Gift Card item as GC RELOAD in Tender Exchange
 * BZ29391              140219    [Internal] PLCC payment generates a 400 error.
 *== ================================================================
 */

package caw.orderservice.utils;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.constant.CawPValueConstant;

/**
 * Define methods to get properties at system or application scope
 */
public class CawPropertiesConfig {

    static final Logger logger = Logger.getLogger(CawPropertiesConfig.class);

    /**
     * @return the logger
     */
    public static Logger getLogger() {

        return logger;
    }

    /**
     * Get System properties and environment variables
     * 
     * @param key
     * @return
     */
    public static String getSystemEnvVariable(String key) {

        try {
            return CawUtils.getInstance().vString(System.getenv(key));
        } catch (RuntimeException e) {
            getLogger().warn("System Variable Not Found-1 : " + key, e);
            return null;
        } catch (Exception e) {
            getLogger().warn("System Variable Not Found-2 : " + key, e);
            return null;
        }
    }

    /**
     * Get value for key from configProperties
     * 
     * @param key
     *            to get the value
     * @return a String that is a value of key in hash map. Return NULL if the
     *         key is not exist in hash map
     */
    public static String get(String key) {

        return CawPropertiesLoader.getProperty(key);
    }

    public static int getInt(String key) {

        String tmp = CawPropertiesLoader.getProperty(key);
        return CawUtils.getInstance().vInt(tmp);
    }

    //Begin BZ23565
    /**
     * @return
     */
    static String getWLSContexPath() {

        String path = "";
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            MBeanServer server = (MBeanServer) ctx
                    .lookup(CawPValueConstant.JAVA_COMP_ENV_JMX_RUNTIME);
            ObjectName service = new ObjectName(
                    CawPValueConstant.RUNTIME_SERVICE);
            ObjectName domain = (ObjectName) server
                    .getAttribute(service, CawPValueConstant.DOMAIN_CONFIGURATION);
            path = server.getAttribute(domain, CawPValueConstant.ROOT_DIRECTORY)
                    .toString();
        } catch (NamingException e) {
            logger.error("Error: " + e.getMessage());
        } catch (MalformedObjectNameException e) {
            logger.error("Error: " + e.getMessage());
        } catch (AttributeNotFoundException e) {
            logger.error("Error: " + e.getMessage());
        } catch (InstanceNotFoundException e) {
            logger.error("Error: " + e.getMessage());
        } catch (MBeanException e) {
            logger.error("Error: " + e.getMessage());
        } catch (ReflectionException e) {
            logger.error("Error: " + e.getMessage());
        }

        return path;
    }
    //End BZ23565

    /**
     * Get full path of root domain
     * @return
     */
    public static String getSysRootDomainPath() {

        return getSystemEnvVariable(CawPValueConstant.DOMAIN_HOME);
    }

    /**
     * Get full path of config.properties
     * @return
     */
    public static String getConfigPropertiesPath() {

        return getSysRootDomainPath() + CawPValueConstant.CONFIG_CONTEXT_PATH
                + CawPValueConstant.CONFIG_PROPERTIES;
    }

    /**
     * Get full path of orderservice-mapping.xml
     * @return
     */
    public static String getConfigXMLMappingPath() {

        return getSysRootDomainPath() + CawPValueConstant.CONFIG_CONTEXT_PATH
                + CawPValueConstant.CONFIG_XML_MAPPING_FILE;
    }

    /**
     * Get full path of orderservice-config.xml
     * @return
     */
    public static String getXmlApplicationContextPath() {

        return getSysRootDomainPath() + CawPValueConstant.CONFIG_CONTEXT_PATH
                + CawPValueConstant.CONFIG_XML_CONTEXT_FILE;
    }

    /**
     * Get Paid Out Item Code from configuration
     * Used :980919
     * @return
     */
    public static String getPaidOutItemId() {

        return CawPropertiesConfig.get(CawPKeyConstant.ITEM_PAID_OUT);
    }

    /**
     * Get Paid In Item Code from configuration
     * Used: 980920
     * @return
     */
    public static String getPaidInItemId() {

        return CawPropertiesConfig.get(CawPKeyConstant.ITEM_PAID_IN);
    }

    /**
     * Get AR Reason Code from configuration
     * Used: PI2
     * @return
     */
    public static String getArReasonCode() {

        return CawPropertiesConfig.get(CawPKeyConstant.AR_REASON_CODE);
    }

    //Begin BZ27629
    public static String getItemCodeTenderExchange() {

        return CawPropertiesConfig
                .get(CawPKeyConstant.ITM_CODE_TENDER_EXCHANGE);
    }
    //End BZ27629
    //Begin BZ29391
    public static String getAcReasonCode() {

        return CawPropertiesConfig.get(CawPKeyConstant.AC_REASON_CODE);
    }
    //End BZ29391
}