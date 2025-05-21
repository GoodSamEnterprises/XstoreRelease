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
 * BZ25674          040718    New Requirement - Add security override for employee/crew member sales
 * BZ25674          140818    New Requirement - Add security override for employee/crew member sales
 * BZ27224          160818    [WO] Security override displays unexpectedly when entering deposited amount > $10 for a WO attached CREW customer.
 *===================================================================
 */

package caw.pos.customer;

import static dtv.pos.common.ConfigurationMgr.*;
import static dtv.pos.framework.validation.ValidationResult.getOverridable;
import static dtv.pos.iframework.validation.IValidationResult.SUCCESS;
import static dtv.pos.iframework.validation.SimpleValidationResult.getFailed;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.araccount.CawCustomerUtil;
import caw.pos.common.CawPropertyUtils;

import dtv.pos.common.ConfigurationMgr;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.validation.IValidationResult;
import dtv.pos.spring.ValueKeys;
import dtv.pos.util.validation.AbstractSecuredValidationRule;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.cwo.IWorkOrderLineItem;
import dtv.xst.dao.trl.IRetailTransactionLineItem;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.impl.SaleReturnLineItemModel;

/**
 * This class is used to validate the crew member
 */
public class CawValidateEmployeeSaleRule extends AbstractSecuredValidationRule {

    private static final Logger _logger                 = LogManager
            .getLogger(CawValidateEmployeeSaleRule.class);

    @Inject
    protected TransactionScope  _transactionScope;

    private static final String CAW_CREW_SAVE_THRESHOLD = "CAW_CREW_SAVE_THRESHOLD";

    /**
     * @see dtv.pos.iframework.validation.IValidationRule#validate()
     */
    @Override
    public IValidationResult validate() {

        IValidationResult result = SUCCESS;
        try {
            List<ISaleReturnLineItem> lineItems = _transactionScope
                    .getTransaction().getLineItems(ISaleReturnLineItem.class);
            // BZ27224 start
            List<IRetailTransactionLineItem> retailLineItem = null;

            if (_transactionScope.getTransaction() != null) {
                retailLineItem = _transactionScope.getTransaction()
                        .getRetailTransactionLineItems();
            }
            //BZ27224 end
            IParty cust = _transactionScope
                    .getValue(ValueKeys.SELECTED_CUSTOMER);
            IParty user = _stationState.getSystemUser().getOperatorParty();
            if (cust != null && user != null) {
                boolean selfSale = (user.getPartyId() == cust.getPartyId());
                if (selfSale && !getAllowEmpSelfSale()) {
                    result = getFailed(FF.getTranslatable("_promptmsg74"));
                }
                //BZ27224 start
                else if (isWorkOrderTrans(retailLineItem)) {
                    return result;
                }
                // BZ27224 end
                else if (CawCustomerUtil.isEmployee(cust)) {
                    if (_transactionScope.getTransaction() != null) {
                        List<IRetailTransactionLineItem> saleLineItems = _transactionScope
                                .getTransaction().getSaleLineItems();
                        if (checkMOForCrewCustomer(saleLineItems)
                                && isExceedThreshold(lineItems)) {
                            result = getOverridable(FF
                                    .getTranslatable("_promptmsg306"), getPrivilege());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            _logger.error("validate - error: " + ex.getMessage());
        }

        return result;
    }

    /**
     * @param saleLineItems
     * @return
     */
    private boolean checkMOForCrewCustomer(
            List<IRetailTransactionLineItem> saleLineItems) {

        String crewVal = CawPropertyUtils.CUSTOMER_GROUP_TYPE_CREW_NEW_NAME;
        SaleReturnLineItemModel item = null;
        if (crewVal != null && saleLineItems != null) {
            for (IRetailTransactionLineItem saleLineItem : saleLineItems) {
                if (saleLineItem instanceof SaleReturnLineItemModel) {
                    item = ((SaleReturnLineItemModel) saleLineItem);
                    if (crewVal.equalsIgnoreCase(item.getPricePropertyCode())
                            && !item.getReturn()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method will check need override privilege
     * @param lineItems
     * @return boolean value
     */
    private boolean isExceedThreshold(List<ISaleReturnLineItem> lineItems) {

        BigDecimal subTotalAmt = BigDecimal.ZERO;
        BigDecimal thresoldSaveAmt = BigDecimal.ZERO;

        // Calculate sub-total from saleLineItem
        if (lineItems != null) {
            for (ISaleReturnLineItem saleLineItem : lineItems) {
                if (saleLineItem.getReturn() || saleLineItem.getVoid()) { // BZ24657
                    continue;
                }
                if (saleLineItem.getExtendedAmount() != null) {
                    subTotalAmt = subTotalAmt.add(saleLineItem
                            .getExtendedAmount()
                            .setScale(getLocalCurrencyScale(), getLocalCurrencyRoundingMode()));
                }
            }
        }

        // Get the value of CAW_CREW_SAVE_THRESHOLD from COM_CODE_VALUE table
        String thresoldSave = CodeLocator.getCodes(ConfigurationMgr
                .getOrganizationId(), CAW_CREW_SAVE_THRESHOLD).get(0);
        // Convert from String to BigDecimal
        if (thresoldSave != null && thresoldSave.length() > 0) {
            thresoldSaveAmt = new BigDecimal(thresoldSave);
        }
        // Compare and return
        if (subTotalAmt.compareTo(thresoldSaveAmt) > 0) {
            return true;
        } else {
            return false;
        }

    }

    // BZ27224 start
    /**
     * Check if a transaction is work order transaction or not.
     * 
     * @param retailLineItem
     * @return
     */
    private boolean isWorkOrderTrans(
            List<IRetailTransactionLineItem> retailLineItem) {

        if (retailLineItem != null) {

            for (IRetailTransactionLineItem saleLineItem : retailLineItem) {

                if (saleLineItem instanceof IWorkOrderLineItem) {
                    return true;
                }
            }
        }

        return false;
    }
    // BZ27224 end
}
