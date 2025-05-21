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
 * BZ37305          260820    [New Requirement] Prompting Engine call before customer information gets displayed on the PinPad.
 * BZ37834          110920    When a customer is added, pinpad verification is skipped and a receipt is printed.
 * BZ46837          191021    [Internal]Email Capture - Xstore advances to 'the Membership Number prompt' instead 'the Edit Customer screen' when selecting No on the Pinpad customer verification screen.
 * BZ47818          221221    [Internal patch 7.0.18] Xstore sent incorrect address in the Upsert request to Neuron if editing address right after the customer was created
 * BZ47123          050122    [PROD] Order Service Token Error
 *===================================================================
 */

package caw.pos.customer;

import org.apache.commons.lang3.StringUtils;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.*;
import caw.tender.impl.mira.response.CawMiraResponse;
import caw.tenderauth.impl.eigen.constants.CawEigenConstants;

import dtv.pos.common.FormKey;
import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.tenderauth.*;
import dtv.tenderauth.event.IAuthResponse;
import dtv.tenderauth.impl.op.AbstractAuthorizeOp;
import dtv.xst.dao.crm.IParty;

public class CawDisplayCustomerVerificationOp extends AbstractAuthorizeOp {

    private IParty party      = null;

    private long timeOut;
    @Override
    public boolean isOperationApplicable() {

        /*BEGIN BZ47123*/
        //if cash drawer open => check time out
        if(_transactionScope.getValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG) != null 
                && _transactionScope.getValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG)){
            long currentTime = System.currentTimeMillis();
            //customer action on pinpad while cash drawer opening
            if(_transactionScope.getValue(CawValueKeys.CAW_VERIFY_CUSTOMER_MIRA_RESPONSE) != null) {
                return true;
            }
            //pinpad time out while cash drawer opening
            if(currentTime > timeOut) {
                _transactionScope.clearValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG);
                clearScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP);
                return false;
            }
        }else {
            //if cash drawer not open => reset timeout
            timeOut = System.currentTimeMillis() + Long.parseLong(CawUtilFunction.getSystemProperty(CawConstants.CAW_CUSTOMER_VERIFICATION_TIMEOUT, CawConstants.CAW_VERIFY_DEFAULT_TIME_OUT)) * 1000;
        }
        /*END BZ47123*/
        String lookupResponse = CawCatalystHelper.getLookupResponseData();
        String emailAddress = CawCustomerUtil.getEmailAddress(lookupResponse);
        this.party = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER); //BZ47818
        if(StringUtils.isNotEmpty(emailAddress)) {
            this.party.setEmailAddress(emailAddress);
            setScopedValue(ValueKeys.SELECTED_CUSTOMER, this.party);
        }
        return (CawCustomerUtil.isAllowEdit(lookupResponse) && this.party != null);
    }
    @Override
    protected IOpResponse getProcessingResponse(IAuthRequest argAuthRequest) {

        setScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP, true);/*BZ47123*/
        DataActionGroupKey actionGroup = DataActionGroupKey.NO_SKIP;
        return this.HELPER.getShowFormResponse(FormKey
                .valueOf("CAW_DISPLAY_CUSTOMER_INFORMATION"), new CawCustomerInformationModel(
                        this.party), actionGroup);
    }

    @Override
    protected IAuthProcess buildAuthProcessor() {

        return AuthFactory.getInstance().getAuthProcess(CawEigenConstants.EIGEN);
    }

    @Override
    protected IAuthRequest buildAuthRequest() {

        IAuthRequest request = AuthFactory.getInstance()
                .makeAuthRequest(CawEigenConstants.EIGEN, AuthRequestType.forName("DISPLAY_CUSTOMER"), null, true);
        return request;
    }

    @Override
    protected IOpResponse handleAuthResponse(IAuthResponse argResponse) {
        /*BEGIN BZ47123*/
        _transactionScope.clearValue(CawValueKeys.CAW_CASH_DRAWER_CLOSE_FLAG);
        _transactionScope.clearValue(CawValueKeys.CAW_VERIFY_CUSTOMER_MIRA_RESPONSE);
        clearScopedValue(CawValueKeys.IS_DISPLAY_CUSTOMER_VERIFICATION_OP);
        /*END BZ47123*/
        if (argResponse.getData() != null && argResponse.getData()
                .equals(CawConstants.CAW_VERIFY_CUSTOMER_NO)) {
            _transactionScope.setValue(CawValueKeys.IS_SELECT_VIEW, true);
            return HELPER.getWaitStackChainResponse(OpChainKey.valueOf("CUST_ASSOCIATION_EDIT"));
        }

        clearScopedValue(CawValueKeys.IS_MEMBERSHIP_EMAIL_CAPTURED); //BZ46837
        return this.HELPER.completeResponse();//BZ37834
    }

    @Override
    protected IOpResponse handleFailed(IAuthResponse argResponse) {

        return super.handleFailed(argResponse);
    }

    @Override
    protected IOpResponse handleInitialState() {
        /*BEGIN BZ47123*/
        if(_transactionScope.getValue(CawValueKeys.CAW_VERIFY_CUSTOMER_MIRA_RESPONSE) != null) {
            CawMiraResponse cawMiraResponse = _transactionScope.getValue(CawValueKeys.CAW_VERIFY_CUSTOMER_MIRA_RESPONSE);
            return this.handleAuthResponse(cawMiraResponse);
        }
        /*END BZ47123*/
        return super.handleInitialState();
    }

    @Override
    protected IOpResponse handleTrainingMode() {

        return null;
    }

    @Override
    protected IOpResponse handleVoid() {

        return null;
    }

}
