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
 * BZ23933          101017    Missing Credit card number/Authorization/Entry method and signature 
 *                            on receipt when competing transaction with tender new good Sam visa
 *===================================================================
 */

package caw.tenderauth.impl.eigen.op;

import caw.pos.common.CawValueKeys;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawIsNewGoodSamVisaTenderOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        setScopedValue(CawValueKeys.IS_NEW_GSV_TENDER, true);
        return HELPER.completeResponse();
    }

}
