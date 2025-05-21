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
 * BZ26575          140618    [QAS] Update address verification flow to reduce the number of click in the QAS process
 * BZ41382          310321    [Production] Order Service Tender Token Errors
 *===================================================================
 */

package caw.pos.address.search;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;
import caw.qas.proweb.CawAddressLineType;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.framework.op.OpState;
import dtv.pos.iframework.action.*;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.IOpState;
import dtv.pos.iframework.ui.model.IPromptActionModel;

/**
 * The class display the confirm address after QAS search success.
 */
public class CawCustomerAddressConfirmPromptOp extends AbstractPromptOp {

    private static final String NO_BUTTON  = "NO";

    private static final String YES_BUTTON = "YES";

    private final IOpState      YES_STATE  = new OpState("YES_STATE");

    private final IOpState      NO_STATE   = new OpState("NO_STATE");

    private static final Logger _logger    = LogManager.getLogger(CawCustomerAddressConfirmPromptOp.class);

    @Override
    public boolean isOperationApplicable() {

        String dialogStr = getScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY);
        if (CawConstants.CONFIRM.equals(dialogStr) && getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_INFO) != null) {
            return true;
        }

        return false;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_CUSTOMER_ADDRESS_CONFIRM");
    }

    @Override
    protected IOpResponse handleDataAction(IXstDataAction argEvent) {
        
        // Start BZ-41382
        // disable prompt actions
        IPromptActionModel promptActionModel = _modeProvider.get().getStationModel().getPromptActionModel();
        disableActions(promptActionModel.getActions());
        // End

        if (argEvent != null && argEvent.getActionKey() != null) {
            IXstActionKey key = argEvent.getActionKey();
            if (YES_BUTTON.equalsIgnoreCase(key.toString())) {
                this.setOpState(this.YES_STATE);
            } else if (NO_BUTTON.equals(key.toString())) {
                this.setOpState(this.NO_STATE);
            }
        }

        return super.handleDataAction(argEvent);
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        if (NO_STATE.equals(this.getOpState())) {
            _logger.info("Redirect to Edit cutomer screen");
            clearScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY);
            _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION_EDIT"));
        } else if (YES_STATE.equals(this.getOpState())) {
            _logger.info("Go to class CawCustomerUpdateAddressOp for update address of the customer");
            return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CAW_CUSTOMER_UPDATE_ADDRESS"));
        }

        return HELPER.completeResponse();
    }

    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        List<CawAddressLineType> addressLineTypes = getScopedValue(CawValueKeys.CAW_CUSTOMER_ADDRESS_LINES);
        if (addressLineTypes != null && addressLineTypes.size() > 0) {
            StringBuilder addressBuilder = new StringBuilder();
            for (CawAddressLineType cawAddressLineType : addressLineTypes) {
                if (StringUtils.isNotEmpty(cawAddressLineType.getLine())) {
                    addressBuilder.append(cawAddressLineType.getLine());
                    addressBuilder.append(" ");
                }
            }

            IFormattable args[] = new IFormattable[2];
            args[0] = _ff.getSimpleFormattable(addressBuilder.toString(), FormatterType.SIMPLE);
            args[1] = _ff.getSimpleFormattable("", FormatterType.SIMPLE);
            return args;
        }

        return super.getPromptArgs(argEvent);
    }

    // Start BZ-41382
    /**
     * Disable actions
     * @param argActions - list of action
     */
    private void disableActions(Collection<IXstAction> argActions) {

        // iterate and disable each action
        for (IXstAction action : argActions) {
            _logger.debug("Disabling action: " + action);
            action.setEnabled(false);
        }
    } // End BZ-41382
}
