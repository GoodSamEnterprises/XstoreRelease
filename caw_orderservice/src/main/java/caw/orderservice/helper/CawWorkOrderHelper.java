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
 * Req/Bug ID#      ddMMyy    Description
 * BZ48749          052422    [PROD] Issues in xStore vs DW sales report
 *===================================================================
 */

package caw.orderservice.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.log4j.Logger;

import caw.orderservice.constant.CawDBFieldConstant;
import caw.orderservice.constant.CawSQLConstant;
import caw.orderservice.model.CawTransactionModel;

/**
 *
 */
public class CawWorkOrderHelper {

    private static Logger                          logger   = Logger.getLogger(CawWorkOrderHelper.class);

    private static volatile CawWorkOrderHelper INSTANCE = null;

    public static CawWorkOrderHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawWorkOrderHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawWorkOrderHelper();
                }
            }
        }

        return INSTANCE;
    }
    
    /**
     * query retail trans line item's property
     * @param conn
     * @param querryKey
     * @return
     */
    public String getRTransLineItemProperty(Connection conn,CawTransactionModel model, String propertyCode) {

        String property = null;
        PreparedStatement psRTLItemProperty = null;
        ResultSet rsRTLItemProperty = null;

        try {
            psRTLItemProperty = conn.prepareStatement(CawSQLConstant.QUERY_RTRANS_LINE_ITEM_PROPERTY);

            psRTLItemProperty.setString(1, model.getStoreID());
            psRTLItemProperty.setString(2, model.getRegID());
            psRTLItemProperty.setString(3, model.getTransSeq());
            psRTLItemProperty.setTimestamp(4, model.getBsnDate());
            psRTLItemProperty.setString(5, model.getRtransLineitmSeq());
            psRTLItemProperty.setString(6, propertyCode);

            rsRTLItemProperty = psRTLItemProperty.executeQuery();
            logger.debug("getRTransLineItemProperty()-Executed query for getting retail trans line item property\n"
                    + CawSQLConstant.QUERY_RTRANS_LINE_ITEM_PROPERTY + " "
                    + Arrays.asList(model.getTransSeq(), model.getStoreID(), model.getRegID(), model.getBsnDate(), model.getRtransLineitmSeq(), propertyCode));

            while (rsRTLItemProperty.next()) {
                property = rsRTLItemProperty.getString(CawDBFieldConstant.STRING_VALUE_FIELD);
            }
        } catch (Exception ex) {
            logger.error("getRTransLineItemProperty-0: " + ex.getMessage());
        } finally {
            if (rsRTLItemProperty != null) {
                try {
                    rsRTLItemProperty.close();
                } catch (SQLException e) {
                    logger.error("getRTransLineItemProperty-1: " + e.getMessage());
                }
            }
            if (psRTLItemProperty != null) {
                try {
                    psRTLItemProperty.close();
                } catch (SQLException e) {
                    logger.error("getRTransLineItemProperty-2: " + e.getMessage());
                }
            }
        }

        return property;
    }
}
