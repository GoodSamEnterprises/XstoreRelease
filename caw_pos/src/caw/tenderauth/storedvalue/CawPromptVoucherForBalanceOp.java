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
 * BZ25958          010818    New Requirement - Gift Card User Flow and Receipt Changes
 *===================================================================
 */

package caw.tenderauth.storedvalue;

import org.apache.commons.lang3.StringUtils;

import caw.pos.common.CawVoucherValue;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.tenderauth.storedvalue.PromptVoucherForBalanceOp;

/**
 *
 */
public class CawPromptVoucherForBalanceOp extends PromptVoucherForBalanceOp {

    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        if (argEvent != null
                && StringUtils.isNotEmpty(argEvent.getStringData())) {
            String cardNumber = argEvent.getStringData();
            CawVoucherValue.setVOUCHER_CARD_NUMBER(cardNumber);
        }

        return super.handlePromptEvent(argEvent);
    }
}
