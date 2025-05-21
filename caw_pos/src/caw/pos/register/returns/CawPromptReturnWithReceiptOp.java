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
 * BZ23458          210917    [DEV] Create a custom flow for "purchase used firearm" that is 
 *                            largely the same as the non-receipted return flow
 * BZ25262          261017    Tender types of Return Web Order display incorrectly when pressing Back to access to sale screen.
 * BZ28036          100220    [New Requirement] Enable the base Functionality available for Customer Purchase History
 *===================================================================
 */

package caw.pos.register.returns;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstDataAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.returns.*;
import dtv.pos.spring.ValueKeys;

/**
 * When xstore start return, check the return has Purchase Used Firearm.
 */
public class CawPromptReturnWithReceiptOp extends PromptReturnWithReceiptOp {

    // Begin BZ25262
    private static final String BUTTON_YES = "YES";

    private static final String BUTTON_NO  = "NO";
    // End BZ25262

    private static final Logger _logger    = Logger
            .getLogger(CawPromptReturnWithReceiptOp.class);

    @Inject
    private ReturnManager       _returnMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);
        if ((isPurchaseUsedFirearm != null)
                && (isPurchaseUsedFirearm == true)) {
            _returnMgr.setReturnWithReceipt(false);
            _returnMgr.setCurrentReturnType(ReturnType.BLIND);
            _logger.info("Purchase Used Firearm with Return No Receipt- Return Type BLIND");
        }
        /*BEGIN BZ28036*/
        if (_transactionScope
                .getValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION) != null) {
            if(_transactionScope
                .getValue(CawValueKeys.IS_RETURN_CONTINUTE) != null) {
                _returnMgr.setReturnWithReceipt(false);
                _returnMgr.setCurrentReturnType(ReturnType.BLIND);
                _transactionScope.clearValue(CawValueKeys.IS_SELECT_RETURN_TRANSACTION);
            }
            else {
                this._returnMgr.setReturnWithReceipt(true);
                return this.handleReturnVerification();
            }
            
        }
        /*END BZ28036*/

        return super.handleOpExec(argEvent);
    }

    // Begin BZ25262
    @Override
    protected IOpResponse handleDataAction(IXstDataAction argAction) {

        try {
            if (argAction != null) {
                IXstActionKey key = argAction.getActionKey();
                if (key != null) {
                    if (BUTTON_NO.equals(key.toString())) {
                        _transactionScope
                                .clearValue(CawValueKeys.IS_RETURN_WEB_ORDER);
                    } else if (BUTTON_YES.equals(key.toString())) {
                        _transactionScope
                                .clearValue(CawValueKeys.IS_RETURN_WEB_ORDER);
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("Can not get IXstDataAction." + ex.getMessage());
        }

        return super.handleDataAction(argAction);
    }

    @Override
    protected IOpResponse handleInitialState(IXstEvent argEvent) {

        _transactionScope.clearValue(CawValueKeys.IS_SALE_SCREEN);
        
        return super.handleInitialState(argEvent);
    }
    // End BZ25262
}
