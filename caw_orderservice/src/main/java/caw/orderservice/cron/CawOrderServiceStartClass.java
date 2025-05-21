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
 * CAW_OrderService     210817    Initial development framework
 * BZ23922              251017    [Order Service] Update order service
 * BZ24271              301017    [OrderService] Exp Date of credit/debit card is unrecognizable in the order_service.out
 * BZ25306              070218    [PROD] Orders Have No Line Items
 * BZ25614              140318    [Order Service] Order Service code review
 *== ================================================================
 */

package caw.orderservice.cron;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import caw.orderservice.constant.CawPKeyConstant;
import caw.orderservice.utils.CawPropertiesConfig;

/**
 * The <code>CawOrderServiceStartClass</code> class. 
 * It is invoked (by web.xml) to do 2 tasks
 * + load properties files such as config.properties and orderservice-mapping.xml
 * + and initiate application context,
 * then all objects in orderservice-config.xml will be initiated
 */
public class CawOrderServiceStartClass implements ServletContextListener {

    private static final Logger logger = Logger
            .getLogger(CawOrderServiceStartClass.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

        logger.info("********** ORDER SERVICE IS DESTROYED! **********");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        logger.info("********** ORDER SERVICE IS STARTED! **********");//BZ25306
        try {
            //Begin BZ24271
            //Set variable for CustomerId. it is used for decrypt
            String customerID_context = CawPropertiesConfig
                    .get(CawPKeyConstant.DTV_CUSTOMERID);
            System.getProperties()
                    .setProperty(CawPKeyConstant.DTV_CUSTOMERID, customerID_context);
            //End Begin BZ24271
            //Begin BZ23922
            String resKeyContext = CawPropertiesConfig
                    .get(CawPKeyConstant.DTV_RES_KEY);
            System.getProperties()
                    .setProperty(CawPKeyConstant.DTV_RES_KEY, resKeyContext);
            //End BZ23922
            //Begin BZ23922
            //Example: "file:/u01/app/wls/user_projects/domains/caw_os/config/orderservice-config.xml";
            String CONFIG_PATH = "file:"
                    + CawPropertiesConfig.getXmlApplicationContextPath();
            @SuppressWarnings({ "unused", "resource" })
            AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                    CONFIG_PATH);
            //End BZ23922
        } catch (Exception e) {
            logger.error("Cannot read configuration files. " + e.getMessage());
        }
    }

}
