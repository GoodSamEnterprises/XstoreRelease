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
 * Req/Bug ID#          ddMMyy    Description
 * BZ27339              031018    [New Requirement] Display Membership Information on Xstore POS Information tab
 * BZ28033              110518    [New Requirement]Clean up the redundant calls to Neuron from xstore
 * BZ27535              090519    [New Requirement] Tax Exempt Wholesale Customer status not recognized at different stores
 * BZ31983              170719    [INTERNAL] Missing the AR account on the receipt when return trans
 * BZ48567              100222    [Task] - Display Loyalty Information on the Membership Info tab
 * BZ48848              270422    [Internal] - Loyalty information is NOT displayed on Membership Info tab.
 * BZ49729              280422    [Internal] - The title at Info Tab should display 'Membership Info' when customer assigned is NOT GSAM Club.
 * BZ49801              040522    Loyalty Customer Lookup API - Real data is different from sample at the beginning
 * BZ49801              121022    [NEW] Points Expiring needs to change the way it appears in Xstore
 * BZ51465              211022    [NEW]Coupons tab does not show offer counter until user clicks on it.
 * BZ51469              251022    [NEW] Points Expiring needs to change the way it appears in Xstore
 * BZ53664              171122    [UAT] Points expiring should not be displayed in decimal 
 * BZ53772              221122    [UAT] Points Expiring Display String improperly trimming one single space from left and right of string before displaying
 * BZ54290              160823    [PROD] Points are being earned on S&I PrePay Work Order Transactions
 * BZ58770              060923    Loyalty information is not printing on receipt for verified return
 * BZ58973              190923    Resumed loyalty transaction not prompting loyalty offers
 *===================================================================
 */

package caw.pos.customer.membership;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.advance.prompting.CawCatalystHelper;
import caw.pos.araccount.CawCustomerUtil;
import caw.pos.cheetah.util.CawCheetahHelper;
import caw.pos.common.*;
import caw.pos.customer.CawCustomerConstants;
import caw.pos.customer.CawCustomerHelper;
import caw.pos.util.CawEBSHelper;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import dtv.pos.common.FormKey;
import dtv.pos.framework.op.Operation;
import dtv.pos.framework.op.req.ShowFormRequest;
import dtv.pos.framework.ui.model.InfoTabHelper;
import dtv.pos.iframework.IBusyState;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.form.FormLocationType;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.op.req.IOpRequest;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trl.IRetailTransaction;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * The CawCustomerMembershipInfoOp class
 */
public class CawCustomerMembershipInfoOp extends Operation {

    private static final Logger _logger = LogManager.getLogger(CawCustomerMembershipInfoOp.class);/*BZ48567*/
    private CawCheetahHelper _cheetahHelper = CawCheetahHelper.getInstance();//BZ49729
    @Inject
    private IBusyState _busyState;
    //BEGIN BZ51465
    @Inject
    private Optional<InfoTabHelper> _tabHelper;  
    private static final String TRANSACTION_COUPONS = "TRANSACTION_COUPONS";
    //END BZ51465
    /** (non-Javadoc)
     * @see dtv.pos.iframework.op.IOperation#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argVar) {

        CawCustomerMembershipModel model = new CawCustomerMembershipModel();

        List<CawCustomerMembershipView> outCustomerMembershipViews = null;

        IParty cust = _transactionScope.getValue(ValueKeys.SELECTED_CUSTOMER);
        FormKey formMembership = CawCustomerConstants.FORM_CUSTOMER_MEMBERSHIP;
        String jsonMessage = CawCatalystHelper.getLookupResponseData();
        _tabHelper.get().setTabUpdated(TRANSACTION_COUPONS); //BZ51465
        if (cust != null) {
            outCustomerMembershipViews = CawMembershipHelper.getInstance().getReloadMemberships(jsonMessage);
            if (CawCustomerUtil.isWhslCustomer(cust)) {
                String accNumber = CawCustomerUtil.getAccountNumber(cust);
                if (accNumber == null || accNumber.length() == 0) {
                    accNumber = CawCustomerUtil.getAccountNumber(jsonMessage);
                }
                model.setAccountValue(accNumber);
                model.setStatusValue(CawConstants.OPEN);
                BigDecimal arAccBalance = CawCustomerUtil
                        .getAvailableCredit(jsonMessage);
                if (arAccBalance != null) {
                    model.setAvailableCreditValue(arAccBalance.toString());
                }
                model.setTaxExemptStatusValue(CawCustomerUtil
                        .getCustomerTaxExempt(jsonMessage));
                model.setAccountOnHoldValue(CawCustomerUtil
                        .getArCreditHold(jsonMessage));

                formMembership = CawCustomerConstants.FORM_CUSTOMER_HA_MEMBERSHIP;
            }
            /*BEGIN BZ48567*/
            //BEGIN BZ49729, BZ58973
            else if (CawCatalystHelper.getLookupLoyaltyResponseData() != null
                    && CawCheetahHelper.getInstance().checkIsLoyaltyCustomer(CawCatalystHelper.getLookupLoyaltyResponseData())) {//BZ54290
                //Start BZ49801
                _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                //End BZ49801
            }
            //END BZ49729, BZ58973
            
            /*END BZ48567*/
        } else {

            /* Customer is not assigned, 
             * and barcode of the original transaction entered for doing a return*/
            IPosTransaction origialTrans = null;
            origialTrans = _transactionScope.getTransaction();
            if (origialTrans instanceof IRetailTransaction) {

                IParty orginalParty = ((IRetailTransaction) origialTrans)
                        .getCustomerParty();
                cust = orginalParty; //BZ58973
                String origAccNumber = null;
                if (orginalParty != null) {
                    origAccNumber = CawCustomerUtil
                            .getAccountNumber(orginalParty);

                    /* BEGIN BZ31983 */
                    if (StringUtils.isNotEmpty(origAccNumber)) {
                        _transactionScope
                                .setValue(CawCustomerConstants.ACCOUNT_NUMBER, origAccNumber);
                    }
                    /* END BZ31983 */

                    /* BEGIN BZ28033 */
                    String orgLookupResponseDB = CawCatalystHelper.getLookupResponseData();
                    //Step 1: lookup JSON customer from EBS
                    if (origAccNumber != null && CawUtilFunction.allowEBSConnection()
                            && StringUtils.isEmpty(orgLookupResponseDB)) {
                        _busyState.start(CawConstants.BUSY_STATE_MSG);
                        orgLookupResponseDB = CawEBSHelper.getInstance()
                                .lookupCustomerInEBS(origAccNumber, CawPropertyUtils.STORE_NUMBER);/*BZ27535*/
                        //CawCatalystHelper.setLookupResponseData(orgLookupResponseDB); //BZ58973
                        _busyState.end();
                    }
                    /* END BZ28033 */
                    //Step 2: Just read json customer from DB
                    if (StringUtils.isEmpty(orgLookupResponseDB)) {
                        //Read customer info from DB
                        orgLookupResponseDB = CawCustomerHelper.getInstance()
                                .buildCustomerJsonObjectOffline(orginalParty);
                    }

                    //Step 3: Check and reload memberships
                    if (!StringUtils.isEmpty(orgLookupResponseDB)) {
                        CawCatalystHelper.setLookupResponseData(orgLookupResponseDB); //BZ58973
                        outCustomerMembershipViews = CawMembershipHelper
                                .getInstance()
                                .getReloadMemberships(orgLookupResponseDB);
                        //BEGIN BZ58770
                        boolean isLoyaltyCustomer = CawCheetahHelper.getInstance().checkIsLoyaltyCustomer(CawCatalystHelper.getLookupLoyaltyResponseData());
                        if(isLoyaltyCustomer) {
                            _transactionScope.setValue(CawValueKeys.IS_LOYALTY_CUSTOMER, true);
                        }
                        //END BZ58770
                    }
                    if (CawCustomerUtil.isWhslCustomer(orginalParty)) {
                        formMembership = CawCustomerConstants.FORM_CUSTOMER_HA_MEMBERSHIP;
                        model.setAccountValue(origAccNumber);
                        model.setStatusValue(CawConstants.OPEN);
                        BigDecimal arAccBalance = CawCustomerUtil
                                .getAvailableCredit(orgLookupResponseDB);
                        if (arAccBalance != null) {
                            model.setAvailableCreditValue(arAccBalance
                                    .toString());
                        }
                        model.setTaxExemptStatusValue(CawCustomerUtil
                                .getCustomerTaxExempt(orgLookupResponseDB));
                        model.setAccountOnHoldValue(CawCustomerUtil
                                .getArCreditHold(orgLookupResponseDB));
                    }

                }

            }
        }
        //Start BZ49801, BZ58770, BZ58973
        //Update the membership info tab
        if(cust != null && !CawCustomerUtil.isWhslCustomer(cust)
                && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER) != null
                && _transactionScope.getValue(CawValueKeys.IS_LOYALTY_CUSTOMER)
                && CawCatalystHelper.getLookupLoyaltyResponseData() != null){
            JSONObject jsonObject = CawJSONUtils.toJSONObject(CawCatalystHelper.getLookupLoyaltyResponseData());
            if (!jsonObject.isNull(CawJSONConstant.JSON_STATUS)) {
                formMembership = CawCustomerConstants.FORM_CUSTOMER_MEMBERSHIP_CLUB;
                updateLoyaltyInfo(model, jsonObject);
                
                String lookupResponseData = CawCatalystHelper.getLookupLoyaltyResponseData();
                if(lookupResponseData != null && !lookupResponseData.isEmpty()) {
                    CawCustomerLoyaltyFlag custLoyalFlag= new CawCustomerLoyaltyFlag();
                    custLoyalFlag.persistCustomerLoyaltyFlagFromDB(lookupResponseData, cust);
                }
            }
        }
        //End BZ49801, BZ58770, BZ58973
        
        String awartarIcon = _transactionScope
                .getValue(CawValueKeys.CAW_CUSTOMER_AVATAR_ICON_KEY);
        if (!StringUtils.isEmpty(awartarIcon)) {
            model.setAvatarIcon(awartarIcon);
        }

        model.setCustomerMembershipList(outCustomerMembershipViews);
        model.initFieldValues();
        IOpResponse response = HELPER
                .getCompleteShowFormResponse(formMembership, model);
        IOpRequest formReq = new ShowFormRequest(formMembership, model, null,
                true, FormLocationType.MESSAGE_AREA);

        response.insertOpRequest(formReq);

        return response;
    }
     
    /*BEGIN BZ48567*/

    /**
     * @param argModel
     * @param argJsonMessage
     */
    private void updateLoyaltyInfo(CawCustomerMembershipModel argModel, JSONObject loyaltyJson) {
        String value = "" ; 
        try {
            //START BZ49801
            if (loyaltyJson.has(CawJSONConstant.JSON_STATUS) && !loyaltyJson.isNull(CawJSONConstant.JSON_STATUS)) {
                JSONObject status = CawJSONUtils.getJSONObject(loyaltyJson, CawJSONConstant.JSON_STATUS);
                if(status.has(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE) && !StringUtils.isEmpty(status.getString(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE))) {
                    value = String.format("%,d",status.getLong(CawJSONConstant.JSON_TOTAL_POINTS_BALANCE));
                    argModel.setPointsBalance(value);
                }
                if(status.has(CawJSONConstant.JSON_POINTS_TO_EXPIRE)) {
                    //Start BZ51469, BZ53664
                    try {
                        if(status.get(CawJSONConstant.JSON_POINTS_TO_EXPIRE) != null && !StringUtils.isEmpty(status.getString(CawJSONConstant.JSON_POINTS_TO_EXPIRE))) {
                            String pointsExpireArray = status.getString(CawJSONConstant.JSON_POINTS_TO_EXPIRE);
                            value = pointsExpireArray; //BZ53772
                        } else {
                            value = "0";
                        }
                    } catch (JSONException ex) {
                        value = "0";
                        _logger.error("Can not parse to JSON object: " + ex.getMessage());
                    } 
                    catch (Exception ex) {
                        value = "0";
                        _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
                    }
                    //End BZ51469, BZ53664
                    argModel.setPointsExpiring(value);
               }
               if(status.has(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD) && !StringUtils.isEmpty(status.getString(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD))) {
                   value = String.format("%,d",status.getLong(CawJSONConstant.JSON_POINTS_TO_NEXT_REWARD));
                    argModel.setPointsToNextReward(value);
               }
               if(status.has(CawJSONConstant.REDEEMABLE_POINTS) && !StringUtils.isEmpty(status.getString(CawJSONConstant.REDEEMABLE_POINTS))) {
                    String result = String.format("%,d",status.getLong(CawJSONConstant.REDEEMABLE_POINTS));
                    argModel.setRedeemableAmount(result);
               }                          
               if(status.has(CawJSONConstant.REDEEMABLE_AMOUNT) && !StringUtils.isEmpty(status.getString(CawJSONConstant.REDEEMABLE_AMOUNT)))  {
                   value = status.getString(CawJSONConstant.REDEEMABLE_AMOUNT);
                   argModel.setRedeemableValue(value);
              } 
            }
            //END BZ49801
            
        } catch (JSONException ex) {
            _logger.error("Can not parse to JSON object: " + ex.getMessage());
        } catch (Exception ex) {
            _logger.error("Error happened in method updateLoyaltyInfo: " + ex.getMessage());
        }

    }
    /*END BZ48567*/
    
}
