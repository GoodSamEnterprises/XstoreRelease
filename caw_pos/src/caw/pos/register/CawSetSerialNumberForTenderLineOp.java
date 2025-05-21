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
 * BZ23359          091017    Gift cards can't be swiped at screen
 *===================================================================
 */

package caw.pos.register;

import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.util.crypto.EncString;
import dtv.xst.dao.ttr.IVoucherTenderLineItem;

/**
 *
 */
public class CawSetSerialNumberForTenderLineOp extends Operation {

    @Override
    public IOpResponse handleOpExec(IXstEvent argParamIXstEvent) {

        if (getScopedValue(ValueKeys.CURRENT_TENDER_LINE) instanceof IVoucherTenderLineItem) {
            getScopedValue(ValueKeys.CURRENT_TENDER_LINE)
                    .setSerialNumber(EncString
                            .getSensitiveData(getScopedValue(ValueKeys.ENTERED_SERIAL_NUMBER)));
        }
        return HELPER.completeResponse();
    }

}
