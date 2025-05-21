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
 * BZ27068          080818    [1.6.4] WO Cannot complete refund
 * BZ31520          250619    [Port BZ31207 to 5.0][Work Order] clicking back after selecting a WO throws error message
 *===================================================================
 */
package caw.pos.workorder.op;

import javax.inject.Inject;

import dtv.data2.access.IDataModel;
import dtv.i18n.IFormattable;
import dtv.pos.common.FormKey;
import dtv.pos.common.PromptKey;
import dtv.pos.customer.account.ICustomerAccountType;
import dtv.pos.framework.form.EditModelKey;
import dtv.pos.framework.form.EditModelMapper;
import dtv.pos.framework.op.req.ShowFormRequest;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.mapping.IEditModelKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.req.IOpRequest;
import dtv.pos.spring.ValueKeys;
import dtv.pos.workorder.account.DisplayWorkOrderAcctFormOp;
import dtv.pos.workorder.common.WorkOrderHelper;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyLocaleInformation;
import dtv.xst.dao.cwo.*;

/**
 * This operation display the work order account information.<br>
 * 
 */
public class CawDisplayWorkOrderAcctFormOp extends DisplayWorkOrderAcctFormOp {

    @Inject
    private WorkOrderHelper _workOrderHelper;

    @Override
    protected IDataModel[] getDataObjects() {

        IWorkOrderAccount account = _workOrderHelper
                .getCurrentWorkOrderAccount();

        if (account != null) {
            IWorkOrderCategory woAcctCat = account
                    .getWorkOrderAccountCategory();
            IServiceLocation serviceLoc = account
                    .getWorkOrderAccountServiceLocation();
            IParty party = account.getParty();
            IPartyLocaleInformation partyLoc = _customerHelper
                    .getLocaleInfo(party);
            if (woAcctCat != null && serviceLoc != null && party != null
                    && partyLoc != null) {
                return new IDataModel[] { account, woAcctCat, serviceLoc, party, partyLoc };
            }
        }
        return null;
    }

    @Override
    protected IEditModelKey getEditModelKey() {
        return EditModelKey.valueOf("WORK_ORDER_ACCOUNT");
    }

    /**
     * Displays the banner form on the register screen from within a customer account view context.
     *
     * @param argEvent the event that occurres
     * @return the completion status of this operation
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        IDataModel[] objects = getDataObjects();
        
        if (objects == null){
            return HELPER.getPromptResponse(PromptKey
                    .valueOf("CAW_WORK_ORDER_INVALID"), promptMessage());
        }

        IEditModel model = EditModelMapper.getInstance()
                .mapDao(getEditModelKey(), objects, false);

        ICustomerAccountType accountType = getScopedValue(ValueKeys.CURRENT_ACCOUNT_TYPE);
        FormKey formKey = accountType.getMessageAreaFormKey();
        /*BEGIN BZ31520: we return COMPLETE first then appending the request to display the from*/
        IOpResponse response = HELPER.completeResponse();
        IOpRequest formRequest = new ShowFormRequest(formKey, model,
                DataActionGroupKey.DEFAULT, false, null);
        response.appendOpRequest(formRequest);
        /*END BZ31520*/
        return HELPER.getCompleteShowFormResponse(formKey, model);
    }

    /**
     * Display message on prompt.
     * @return
     */
    protected IFormattable[] promptMessage() {

        IFormattable[] args = new IFormattable[2];
        args[0] = _formattables.getTranslatable("_woNoFoundTitle");
        args[1] = _formattables.getTranslatable("_woNoFoundMsg");
        return args;
    }
}
