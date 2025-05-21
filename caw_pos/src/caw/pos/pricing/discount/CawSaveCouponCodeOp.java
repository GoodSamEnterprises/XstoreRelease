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
 * BZ26629          300718    [New Requirement] Add a prompt to capture discount code when the Retail Coupon discount reason is selected
 * BZ27053          080818    [1.6.3][26629] Redundant inputted retail coupon code before displays on receipt/Order service after modify discount items or transaction.
 * BZ27028          021018    [New Requirement] Move the configuration for Return Merchandise Receipt into the table 
 *===================================================================
 */

package caw.pos.pricing.discount;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawConstants;

import dtv.data2.access.DataFactory;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.xst.dao.trl.*;
import dtv.xst.dao.trn.IPosTransaction;

/**
 * CawSaveCouponCodeOp class is save the coupon code to table TRL_RTRAINS_LINEITM_P
 */
public class CawSaveCouponCodeOp extends Operation {

    private static final Logger     _logger = LogManager
            .getLogger(CawSaveCouponCodeOp.class);

    @Inject
    private CawDiscountCouponHelper _cawDiscountCouponHelper;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        List<IRetailTransactionLineItemProperty> lineItemProperties = new ArrayList<IRetailTransactionLineItemProperty>();
        IPosTransaction trans = _transactionScope.getTransaction();
        if (trans != null) {
            List<ISaleReturnLineItem> lineItems = trans
                    .getLineItems(ISaleReturnLineItem.class);
            List<IRetailPriceModifier> priceModifiers = null;
            IRetailTransactionLineItemProperty tranLineItemProperty = null;
            String reasonCode = null;
            boolean valid;
            for (ISaleReturnLineItem saleReturnLineItem : lineItems) {
                if (!saleReturnLineItem.getVoid()) {// Check the line is void
                    priceModifiers = saleReturnLineItem
                            .getRetailPriceModifiers();
                    // Get list reason code from IRetailPriceModifier object
                    if (priceModifiers != null && priceModifiers.size() > 0) {
                        // BZ27053 start
                        for (IRetailPriceModifier priceModifier : priceModifiers) {
                            reasonCode = priceModifier.getDiscountReasonCode();
                            // Check the reason code have existed in configuration
                            if (!priceModifier.getVoid()) {
                                /* BZ27028 added, removed code of BZ26629 */
                                valid = _cawDiscountCouponHelper
                                        .isEnableReasonCode(CawConstants.DISCOUNT_REASON_TYPE_CODE, reasonCode);
                                if (valid) {
                                    // Create object prepare data for save to table TRL_RTRAINS_LINEITM_P
                                    tranLineItemProperty = createLineItemPropertyObject(saleReturnLineItem, priceModifier);
                                    if (tranLineItemProperty != null) {
                                        lineItemProperties
                                                .add(tranLineItemProperty);
                                    }
                                }
                            }
                        }
                        // BZ27053 end
                    }
                }
            }
        }

        if (lineItemProperties.size() > 0) {
            try {
                _logger.info("Persistent the coupon code to table TRL_RTRAINS_LINEITM_P. The number property:"
                        + lineItemProperties.size());
                DataFactory.makePersistent(lineItemProperties);
            } catch (Exception ex) {
                _logger.info("Can not persistent the coupon code to table TRL_RTRAINS_LINEITM_P."
                        + ex.getMessage());
            }
        }

        return HELPER.completeResponse();
    }

    /**
     * @param saleReturnLineItem
     * @param reasonCode
     */
    private IRetailTransactionLineItemProperty createLineItemPropertyObject(
            ISaleReturnLineItem saleReturnLineItem,
            IRetailPriceModifier priceModifier) {

        IRetailTransactionLineItemProperty tranLineItemProperty = null;
        try {
            tranLineItemProperty = DataFactory
                    .createObject(IRetailTransactionLineItemProperty.class);
            tranLineItemProperty
                    .setOrganizationId(saleReturnLineItem.getOrganizationId());
            tranLineItemProperty.setRetailLocationId(saleReturnLineItem
                    .getRetailLocationId());
            tranLineItemProperty
                    .setBusinessDate(saleReturnLineItem.getBusinessDate());
            tranLineItemProperty
                    .setWorkstationId(saleReturnLineItem.getWorkstationId());
            tranLineItemProperty.setTransactionSequence(saleReturnLineItem
                    .getTransactionSequence());
            tranLineItemProperty
                    .setRetailTransactionLineItemSequence(saleReturnLineItem
                            .getRetailTransactionLineItemSequence());
            tranLineItemProperty.setPropertyCode(CawConstants.PROP_COUPON_CODE
                    + ":" + priceModifier.getRetailPriceModifierSequenceNbr());
            tranLineItemProperty.setPropertyValue(priceModifier.getNotes());
            tranLineItemProperty.setType(CawConstants.PROP_STRING_TYPE);

        } catch (Exception ex) {
            tranLineItemProperty = null;
            _logger.info("createLineItemPropertyObject-1." + ex.getMessage());
        }

        return tranLineItemProperty;
    }
}
