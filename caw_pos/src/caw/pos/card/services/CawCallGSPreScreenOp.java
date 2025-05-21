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
 * BZ25435          160718    New Requirement - Xstore changes to call the CardServices API instead of the Prompting Engine
 * BZ25761          121018    New Requirement - Acquisition of Private Label Credit Card integration in Xstore
 *===================================================================
 */

package caw.pos.card.services;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.tenderauth.impl.eigen.goodsam.op.CawGoodSamVisaPreScreenOp;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * The overwrites current GS workflow when integrating with CardSevices.
 * This class will not be used anymore since BZ25761
 */
public class CawCallGSPreScreenOp extends CawGoodSamVisaPreScreenOp {

    private static final Logger _logger     = LogManager
            .getLogger(CawCallGSPreScreenOp.class);

    private String              preScreenId = "";

    @Override
    public boolean isOperationApplicable() {

        boolean isRun = false;
        try {
            if (StringUtils.isNotEmpty(_transactionScope
                    .getValue(CawValueKeys.STATUS_PRESCREEN_ID))) {
                isRun = true;
                preScreenId = _transactionScope
                        .getValue(CawValueKeys.STATUS_PRESCREEN_ID);
            }
        } catch (Exception ex) {
            _logger.error("Can not get PRESCREEN_ID" + ex.getMessage());
        }

        return isRun;
    }

    protected String getPreScreenId() {

        if (StringUtils.isNotEmpty(preScreenId)) {
            return preScreenId;
        }

        return "";
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {

        return super.handlePromptResponse(argEvent);
    }

}
