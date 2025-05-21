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
 * BZ23263          250917    Implement House Account
 *===================================================================
 */

package caw.pos.common.rcpt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.pos.docbuilding.conditions.LineTenderTypeCondition;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 *
 */
public class CawLineTenderTypeARCondition
        extends dtv.docbuilding.conditions.AbstractInvertableCondition {

    private static final String FOREIGN      = "foreign";

    private static final String VALUE        = "value";

    private static final Logger logger_      = LogManager
            .getLogger(LineTenderTypeCondition.class);

    private static String       THIRD_PARTY_ = "THIRD_PARTY";

    private static String       AR_ACCOUNT   = "AR_ACCOUNT";

    /** {@inheritDoc} */
    @Override
    public void setParameter(String argName, Object argValue) {

        if (VALUE.equalsIgnoreCase(argName)) {
            argValue.toString();
        } else if (FOREIGN.equalsIgnoreCase(argName)) {
            toBooleanParameter(argValue);
        } else {
            super.setParameter(argName, argValue);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argSource) {

        try {
            ITender tender = ((ITenderLineItem) argSource).getTender();
            if (tender == null) {
                return false;
            }
            if (tender.getTenderId().equalsIgnoreCase(AR_ACCOUNT)
                    || tender.getTenderId().equalsIgnoreCase(THIRD_PARTY_)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            logger_.warn("unexpected source [" + argSource + "]", ex);
            return false;
        }
    }
}