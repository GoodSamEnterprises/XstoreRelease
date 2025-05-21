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
 *== ================================================================
 */

package caw.orderservice.constant;

/**
 * Define Value of properties
 */
public class CawPValueConstant {

    public static final String CONFIG_CONTEXT_PATH       = "/config/";

    public static final String CONFIG_XML_CONTEXT_FILE   = "orderservice-config.xml";

    public static final String CONFIG_XML_MAPPING_FILE   = "orderservice-mapping.xml";

    public static final String CONFIG_PROPERTIES         = "config.properties";

    public static final String DOMAIN_HOME               = "DOMAIN_HOME";

    public static final String ROOT_DIRECTORY            = "RootDirectory";

    public static final String DOMAIN_CONFIGURATION      = "DomainConfiguration";

    public static final String RUNTIME_SERVICE           = "com.bea:Name=RuntimeService,Type=weblogic.management.mbeanservers.runtime.RuntimeServiceMBean";

    public static final String JAVA_COMP_ENV_JMX_RUNTIME = "java:comp/env/jmx/runtime";

    public static final String MAIL_SMTP_HOST            = "mail.smtp.host";

}