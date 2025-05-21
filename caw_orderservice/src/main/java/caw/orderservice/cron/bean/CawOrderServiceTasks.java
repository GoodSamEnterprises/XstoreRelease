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
 * BZ25306              070218    [PROD] Orders Have No Line Items
 * BZ25614              140318    [Order Service] Order Service code review
 * BZ48630              150622    [Task] Order Service - Transaction Posting to Cheetah
 *== ================================================================
 */

package caw.orderservice.cron.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import caw.orderservice.bean.CawOrderServiceApp;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.model.CawCheetahTokenModel;

@Component("tasks")
public class CawOrderServiceTasks {

    private static final Logger logger = Logger
            .getLogger(CawOrderServiceTasks.class);

    @Autowired
    private DataSource          dataSource;

    @Autowired
    private CawOrderServiceApp  orderServiceApp;

    public static HashMap<String, CawCheetahTokenModel> listTokenModel = new HashMap<String, CawCheetahTokenModel>(); //BZ48630

    /* BEGIN BZ48630: Handle to use TOKEN */

    /**
     * @return the listTokenModel
     */
    public static HashMap<String, CawCheetahTokenModel> getListTokenModel() {
    
        return listTokenModel;
    }


    
    /**
     * @param listTokenModel the listTokenModel to set
     */
    public static void setListTokenModel(
            HashMap<String, CawCheetahTokenModel> listTokenModel) {
    
        CawOrderServiceTasks.listTokenModel = listTokenModel;
    }
    /* END BZ48630: Handle to use TOKEN */

    /**
     * The method is invoked by scheduler every 5 minutes
     * Connect to XOffice database 
     * and start process of transferring data via ESB
     */
    public void connectDatabase() {

        Connection conn = null;
        boolean success = false;
        logger.info("********** ORDER SERVICE SCHEDULER IS STARTED");
        try {
            conn = getDataSource().getConnection();
            if (conn != null) {
                int row = countTransactionInQueue(conn);
                if (row > 0) {
                    getOrderServiceApp().run(conn);
                }
                success = true;
            } else {
                logger.error("Can not get connection from datasource\n");
            }
        } catch (SQLException e) {
            logger.error("SQL exception: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("Can not close connection" + e.getMessage());
                }
            }
        }

        if (success) {
            logger.info("********** Order Service scheduler is completed.");
        } else {
            logger.info("********** Order Service scheduler is completed with error.");
        }

    }

    /**
     * Check number of transactions for Order Service process
     * @param conn
     * @return
     */
    private int countTransactionInQueue(Connection conn) {

        int rowcount = 0;
        try {
            PreparedStatement psCountTransations = conn
                    .prepareStatement(CawSQLConstant.QUERY_COUNT_TRANSACTIONS);
            ResultSet rsCountTransations = psCountTransations.executeQuery();

            try {
                while (rsCountTransations.next()) {
                    rowcount = rsCountTransations.getInt("COUNT");
                }
            } catch (SQLException e) {
                logger.error("countTransactionInQueue-0: " + e.getMessage());
            } finally {
                if (rsCountTransations != null) {
                    rsCountTransations.close();
                }
                if (psCountTransations != null) {
                    psCountTransations.close();
                }
            }

        } catch (RuntimeException e1) {
            logger.error("countTransactionInQueue-1:" + e1.getMessage());
        } catch (Exception e1) {
            logger.error("countTransactionInQueue-2:" + e1.getMessage());
        }

        logger.info("THERE IS/ARE " + rowcount
                + " TRANSACTION(S) FOUND IN QUEUE");
        return rowcount;

    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {

        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    /**
     * @return the orderServiceApp
     */
    public CawOrderServiceApp getOrderServiceApp() {

        return orderServiceApp;
    }

    /**
     * @param orderServiceApp the orderServiceApp to set
     */
    public void setOrderServiceApp(CawOrderServiceApp orderServiceApp) {

        this.orderServiceApp = orderServiceApp;
    }
    

}
