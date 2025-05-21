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
 * Req/Bug ID#          ddMMyy    Description
 * BZ23558              270917    Receipts are missing EMV data
 * BZ24383              091117    "Auto-Renew" term should be printed on receipt when choosing "Auto-renew membership sold"
 *===================================================================
 */

package caw.pos.common.rcpt;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.advance.prompting.CawDirectiveType;
import caw.pos.common.CawEBSConstant;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.docbuilding.conditions.AbstractInvertableCondition;

public class CawAutoRenewalMsgCondition extends AbstractInvertableCondition {

    private static final Logger _logger = LogManager
            .getLogger(CawAutoRenewalMsgCondition.class);

    /** {@inheritDoc} */
    @Override
    protected boolean conditionMetImpl(Object argValue) {

        Boolean isRun = Boolean.FALSE;
        try {
            if (CawCatalystHelper.getCatalystDirectiveResponse() != null
                    && CawCatalystHelper.getCatalystDirectiveResponse()
                            .length() > 0) {
                JSONObject directive = null;
                int length = CawCatalystHelper.getCatalystDirectiveResponse()
                        .length();
                for (int i = 0; i < length; i++) {
                    if (CawCatalystHelper.getCatalystDirectiveResponse()
                            .getJSONObject(i) != null) {
                        directive = CawCatalystHelper
                                .getCatalystDirectiveResponse()
                                .getJSONObject(i);
                        if (!directive.isNull(CawEBSConstant.TYPE_ATTR)
                                && directive
                                        .getInt(CawEBSConstant.TYPE_ATTR) == CawDirectiveType.CREDIT_CARD_REQUIRED
                                                .getType()) {
                            isRun = Boolean.TRUE;
                            break;
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            _logger.debug("Can not get item." + ex.getMessage());
        }

        return isRun;
    }
}
