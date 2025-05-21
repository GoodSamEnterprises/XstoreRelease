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
 * BZ64483          090924    [PROD] - 502 Error in Xstore log
 *===================================================================
 */

package caw.pos.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.pos.framework.op.AbstractRunCondition;

/**
 *
 */
public class CawOrderEnableCondition extends AbstractRunCondition{
    private static final Logger _logger = LogManager.getLogger(CawOrderEnableCondition.class);

    @Override
    protected boolean shouldRunImpl() {

        boolean isOrderEnable = Boolean.FALSE;
        try {
            String orderEnable = System.getProperty("caw.pos.order.enable");
            if(orderEnable != null && orderEnable.equalsIgnoreCase(CawConstants.TRUE_STRING)) {
                isOrderEnable = Boolean.TRUE;
            }
        } catch (Exception ex) {
            _logger.error("Error at CawOrderEnableCondition: ", ex.getMessage());
        }
        
        return isOrderEnable;
    }

}
