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
 * BZ26836          170718    [Internal][QAS]There are not consistent result found from QAS validation when doing QAS process via Assign&Continue and Save&Changes with the same address.
 *===================================================================
 */

package caw.pos.address.search;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.pos.common.OpChainKey;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.op.AbstractPromptOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 *The class display notify screen when QAS search with result: no record, multiple records, partial
 */
public class CawCustomerAddressNotifyPromptOp extends AbstractPromptOp {

    private static final String ADDRESS_NOT_FOUND_MSG = "_cawAddressNotifyMsg";                                       //BZ26836

    private static final Logger _logger               = LogManager.getLogger(CawCustomerAddressNotifyPromptOp.class); //BZ26836

    @Override
    public boolean isOperationApplicable() {

        String dialogStr = getScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY);
        if (CawConstants.NOTIFY.equals(dialogStr)) {
            return true;
        }

        return false;
    }

    @Override
    public PromptKey getDefaultPromptKey() {

        return PromptKey.valueOf("CAW_CUSTOMER_ADDRESS_NOTIFY");
    }

    @Override
    public IOpResponse handlePromptResponse(IXstEvent argArg0) {

        clearScopedValue(CawValueKeys.IS_ADDRESS_DIALOG_DISPLAY);
        clearScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY);//BZ26836
        // Redirect to the customer edit information
        _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, Boolean.valueOf(true));
        return HELPER.getCompleteStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION_EDIT"));
    }

    // Begin BZ26836
    @Override
    protected IFormattable[] getPromptArgs(IXstEvent argEvent) {

        IFormattable args[] = new IFormattable[1];
        try {
            if (StringUtils.isNotEmpty(getScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY))) {
                String msg = getScopedValue(CawValueKeys.ADDRESS_MESSAGES_DISPLAY);
                args[0] = _ff.getTranslatable(msg);
            } else {
                args[0] = _ff.getSimpleFormattable(ADDRESS_NOT_FOUND_MSG, FormatterType.SIMPLE);
            }

        } catch (Exception ex) {
            _logger.debug("The ADDRESS_MESSAGES_DISPLAY can not from scope." + ex.getMessage());
        }
        return args;
    }
    // End BZ26836
}
