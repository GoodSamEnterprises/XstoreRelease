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
 * BZ25640          051518    New Requirement - Used Firearm System Process Redesign
 *===================================================================
 */

package caw.pos.register.ufa;

import static dtv.pos.common.TransactionType.TENDER_CONTROL;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawEBSConstant;

import dtv.data2.access.DataFactory;
import dtv.pos.common.TransactionHelper;
import dtv.pos.common.TransactionStatus;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;
import dtv.pos.tender.TenderHelper;
import dtv.pos.till.SessionManager;
import dtv.pos.till.TillHelper;
import dtv.util.NumberUtils;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.crm.IPartyIdCrossReference;
import dtv.xst.dao.tnd.ITender;
import dtv.xst.dao.tnd.TenderStatus;
import dtv.xst.dao.trl.IRetailTransactionLineItemProperty;
import dtv.xst.dao.trl.RetailTransactionLineItemPropertyId;
import dtv.xst.dao.tsn.*;
import dtv.xst.dao.ttr.ITenderLineItem;

/**
 * An operation that populates a paid out transaction of Used firearm purchase
 * with all of the information collected from the paid out process. 
 * <br>
 * It includes persisting customer and used firearm information
 * <br>
 * 
 */
public class CawPopulateUFAPaidOutTransactionOp extends Operation {

    @Inject
    private SessionManager      _sessionManager;

    @Inject
    private TillHelper          _tillHelper;

    @Inject
    private TenderHelper        _tenderHelper;

    private static final Logger _logger = LogManager
            .getLogger(CawPopulateUFAPaidOutTransactionOp.class);

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        ITenderControlTransaction paidOutTrans = _transactionScope
                .getTransaction(TENDER_CONTROL);
        BigDecimal paidOutAmount = paidOutTrans.getAmount();

        //UFA Model
        CawUFAModel model = getCurrentUFAModel();

        /*Begin 25640 for customer*/
        this.populateCustomerPartyInfo(paidOutTrans, model);
        /*End 25640 for customer*/

        ITender cashTender = _tenderHelper.getLocalCurrency();
        ITenderLineItem lineItem = _tenderHelper
                .createTenderLineItem(cashTender, TenderStatus.TENDER, argEvent);
        lineItem.setAmount(paidOutAmount);

        /*Begin 25640 for used firearm attributes*/
        this.populateTenderLineItemProperty(lineItem, model);
        /*End 25640*/

        paidOutTrans.addRetailTransactionLineItem(lineItem);

        ISession session = _sessionManager.getSession();
        // Adjust the amount of money in the till
        ISessionTender sessionTender = _tillHelper
                .getSessionTender(session, lineItem
                        .getTenderId(), getSourceDescription());

        sessionTender.setMediaAmount(NumberUtils
                .nonNull(sessionTender.getMediaAmount())
                .subtract(lineItem.getAmount()));

        TransactionHelper
                .completeTransaction(paidOutTrans, TransactionStatus.COMPLETE);
        return HELPER.completeResponse();
    }

    /**
     * Populate Customer Party to Paid-out transaction
     * Data will populate to the following tables
     * crm_party
     * crm_party_locale_information
     * crm_party_email
     * CRM_PARTY_ID_XREF
     * CRM_PARTY_ID_XREF_P
     * @param paidOutTrans
     */
    private void populateCustomerPartyInfo(
            ITenderControlTransaction paidOutTrans, CawUFAModel model) {

        try {
            IParty selectedCustomer = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);
            if (model != null && selectedCustomer != null) {
                String accountNumber = model.getCustomerAccNumber();
                List<IPartyIdCrossReference> altIds = selectedCustomer
                        .getAlternatePartyIds();
                //Save customer to CRM_PARTY_ID_XREF
                IPartyIdCrossReference partyXRef = DataFactory
                        .createObject(IPartyIdCrossReference.class);
                partyXRef.setOrganizationId(selectedCustomer
                        .getOrganizationId());
                partyXRef.setPartyId(selectedCustomer.getPartyId());
                partyXRef.setAlternateId(accountNumber);
                partyXRef
                        .setAlternateIdOwner(CawEBSConstant.ALTERNATE_ID_OWNER);
                //Do not use DataFactory.makePersistent(partyXRef);
                altIds.add(partyXRef);
                selectedCustomer.setAlternatePartyIds(altIds);

                //Save customer to CRM_PARTY_ID_XREF_P with memberships only
                //CawCustomerHelper.saveCustomerJSON(iParty, responseData);
                //But, In case of Used Firearm Purchase has no memberships

                paidOutTrans.setFundsReceiptParty(selectedCustomer);
                paidOutTrans
                        .setFundsReceiptPartyId(selectedCustomer.getPartyId());

            }
        } catch (Exception ex) {
            _logger.error("populateCustomerPartyInfo-0", ex);
        }
    }

    /**
     * Add properties for Used Firearm
     * table: trl_rtrans_lineitm_p
     * @param lineItem
     */
    private void populateTenderLineItemProperty(ITenderLineItem lineItem,
            CawUFAModel model) {

        try {
            if (model != null) {
                IRetailTransactionLineItemProperty property = null;
                property = createLineItemProperty(CawUFAConstants.PROPERTY_ETRACK_ID, model
                        .getEtrackId());
                lineItem.addRetailTransactionLineItemProperty(property);

                property = createLineItemProperty(CawUFAConstants.PROPERTY_EBS_ITEM_CODE, model
                        .getEbsItemCode());
                lineItem.addRetailTransactionLineItemProperty(property);

                //If the json str's length is greater than 4000 letters.
                String value = model.getJsonFirearmDetail();
                int row = 0;
                String type = CawUFAConstants.PROPERTY_UFA_DETAIL;
                String strValue;
                while (value != null && value.length() > 0) {
                    if (value.length() > 4000) {
                        strValue = value.substring(0, 4000);
                        value = String
                                .valueOf(value.substring(4000, value.length()));
                    } else {
                        strValue = String.valueOf(value);
                        value = null;
                    }
                    if (row > 0) {
                        type = CawUFAConstants.PROPERTY_UFA_DETAIL
                                + String.valueOf(row);
                    }
                    property = createLineItemProperty(type, strValue);
                    lineItem.addRetailTransactionLineItemProperty(property);
                    row++;
                }
            }
        } catch (Exception ex) {
            _logger.error("populateTenderLineItem-0", ex);
        }
    }

    /**
     * 
     * @param propertyCode
     * @param strValue
     */
    private IRetailTransactionLineItemProperty createLineItemProperty(
            String propertyCode, String strValue) {

        IRetailTransactionLineItemProperty property = null;
        try {
            RetailTransactionLineItemPropertyId id = new RetailTransactionLineItemPropertyId();
            id.setPropertyCode(propertyCode);
            property = DataFactory
                    .createObject(id, IRetailTransactionLineItemProperty.class);
            property.setStringValue(strValue);
            property.setType(CawUFAConstants.PROPERTY_TYPE);
        } catch (Exception ex) {
            _logger.error("createLineItemProperty-1", ex);
        }
        return property;
    }

    /**
     * Get CawUFAModel from Transaction Scope
     * @return
     */
    private CawUFAModel getCurrentUFAModel() {

        CawUFAModel model = null;
        try {
            Object mObj = _transactionScope.getValue(ValueKeys.REPORT_SOURCE);
            if (mObj != null && mObj instanceof CawUFAModel) {
                model = (CawUFAModel) mObj;
            }
        } catch (Exception ex) {
            _logger.error("getCurrentUFAModel-0", ex);
        }
        return model;
    }
}
