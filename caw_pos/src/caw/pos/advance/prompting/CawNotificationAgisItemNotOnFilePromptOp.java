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
 * BZ69644          170225    [Internal][AGIS Modification] The 'Item Not On File' prompt is NOt displayed when entering Membership items do not exist in Xstore
 *===================================================================
 */

package caw.pos.advance.prompting;

import static dtv.hardware.types.InputType.*;

import java.util.List;

import caw.hardware.service.CawHardwareHelper;
import caw.pos.agis.model.CawAGISPitchesItemModel;
import caw.pos.common.CawPropertyUtils;
import caw.pos.common.CawValueKeys;

import dtv.hardware.types.InputType;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.event.*;
import dtv.pos.iframework.op.IOpResponse;

/**
 *
 */
public class CawNotificationAgisItemNotOnFilePromptOp extends AbstractPromptOp implements IXstEventObserver {

    private static final IXstEventType[] EVENTS = new IXstEventType[] { InputType.INPUT_ITEM, InputType.INPUT_TRANSACTION, INPUT_CUSTOMER_CARD, INPUT_ID_CARD, INPUT_EMPLOYEE_CARD, INPUT_MSR_OTHER, INPUT_ACCOUNT_RECEIVABLE, INPUT_DRIVERS_LICENSE }; //BZ34226

    @Override
    public boolean isOperationApplicable() {
        List<CawAGISPitchesItemModel> itemNOFModels = _transactionScope.getValue(CawValueKeys.CAW_AGIS_LIST_NOT_ON_FILE);
        if(itemNOFModels != null && itemNOFModels.size() > 0) {
            _transactionScope.clearValue(CawValueKeys.CAW_AGIS_LIST_NOT_ON_FILE);
            return true;
        }
        return false;
    }
    
    @Override
    public IOpResponse handlePromptResponse(IXstEvent argEvent) {
        return HELPER.completeResponse();
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("SCANNED_ITEMS_NOT_FOUND");
    }
    
    //Begin BZ34226
    @Override
    public IXstEventType[] getObservedEvents() {
    
        return EVENTS;
    }
    
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {

        if (!(argEvent instanceof IXstAction)) {
            CawHardwareHelper.getInstance().sendBeepScanner(CawHardwareHelper
                    .getInstance().getScanner(), CawHardwareHelper.getInstance()
                            .getScannerID(), CawPropertyUtils.CAW_BEEP_VALUE);
            return HELPER.waitResponse();
        }
        return super.handlePromptEvent(argEvent);
    }


}
