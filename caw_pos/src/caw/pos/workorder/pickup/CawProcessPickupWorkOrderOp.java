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
 * BZ27248          230818     Warranty Items from S&I are not associated with the items covered
 * BZ27264          240818     Work Order Complete Performance Issue
 *===================================================================
 */

package caw.pos.workorder.pickup;

import java.util.*;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.workorder.common.CawWorkOrderConstants;

import dtv.pos.customer.account.CustomerAccountHelper;
import dtv.pos.customer.account.type.CustomerItemAccountActivityCodeType;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.ItemLocator;
import dtv.pos.spring.ValueKeys;
import dtv.pos.warranty.WarrantyHelper;
import dtv.pos.warranty.WarrantyManager;
import dtv.pos.workorder.pickup.ProcessPickupWorkOrderOp;
import dtv.util.CompositeObject.TwoPiece;
import dtv.util.DateUtils;
import dtv.xst.dao.cat.ICustomerItemAccountDetail;
import dtv.xst.dao.itm.*;
import dtv.xst.dao.trl.*;
import dtv.xst.daocommon.IInventoryLocationModifier;

/**
 *
 */
public class CawProcessPickupWorkOrderOp extends ProcessPickupWorkOrderOp {

    private static final Logger   _logger = LogManager
            .getLogger(CawProcessPickupWorkOrderOp.class);

    @Inject
    private CustomerAccountHelper _accountHelper;

    @Inject
    private WarrantyHelper        _warrantyHelper;

    @Inject
    private WarrantyManager       _warrantyMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        try {
            /* BZ27264 commented out 
             * new DefaultEventor(new EventDescriptor(ModelEventor.class))
                    .post(ModelEventor.CLOSE_EVENT); 
             _pricingHelper.setProcessingEnabled(false);*/

            List<ICustomerItemAccountDetail> pickedItems = getScopedValue(ValueKeys.ITEM_ACCOUNT_PICKUP_LIST);
            for (ICustomerItemAccountDetail pickedItem : pickedItems) {
                processPickedDetail(pickedItem);
            }
            setScopedValue(ValueKeys.PICKUP_SALE_LINES_LIST, _inventoryPickupLines);

            /* BZ27264 commented out 
             * _pricingHelper.setProcessingEnabled(true);
             * new DefaultEventor(new EventDescriptor(ModelEventor.class))
                    .post(ModelEventor.OPEN_EVENT); */

        } catch (Exception ex) {
            _logger.error("handleOpExec-1: " + ex.getMessage());
        }

        return HELPER.completeResponse();
    }

    @Override
    public boolean isOperationApplicable() {

        List<ICustomerItemAccountDetail> pickedItems = getScopedValue(ValueKeys.ITEM_ACCOUNT_PICKUP_LIST);
        return ((pickedItems != null) && !pickedItems.isEmpty());
    }

    @Override
    protected void processPickedDetail(ICustomerItemAccountDetail argDetail) {
        ISaleReturnLineItem origSaleLine = (ISaleReturnLineItem) argDetail
                .getRetailLineItem();
        if (origSaleLine != null) {
            ISaleReturnLineItem newSaleLine = ItemLocator.getLocator()
                    .getSaleLineItem(origSaleLine
                            .getItem(), SaleItemType.SALE, origSaleLine
                                    .getItemIdEntryMethodCode());
            processNewSaleLine(argDetail, origSaleLine, newSaleLine);
        }
    }

    @Override
    protected void processNewSaleLine(ICustomerItemAccountDetail argDetail,
            ISaleReturnLineItem argOrigSaleLine,
            ISaleReturnLineItem argNewSaleLine) {

        if (argOrigSaleLine != null && CawWorkOrderConstants.SELECTED
                .equalsIgnoreCase(argOrigSaleLine
                        .getStringProperty(CawWorkOrderConstants.WARRANTY_STATUS))) {
            IItem iItemCover = argNewSaleLine.getItem();
            List<String> itemRemoveList = new ArrayList<String>();
            itemRemoveList.add(iItemCover.getItemId());

            getWarrantyItems(argOrigSaleLine, iItemCover, itemRemoveList);

            getListItemRemoves(argDetail, argOrigSaleLine, argNewSaleLine, itemRemoveList);

        } else {
            super.processNewSaleLine(argDetail, argOrigSaleLine, argNewSaleLine);
        }

    }

    /**
     * @param argDetail
     * @param argOrigSaleLine
     * @param argNewSaleLine
     * @param itemRemoveList
     */
    private void getListItemRemoves(ICustomerItemAccountDetail argDetail,
            ISaleReturnLineItem argOrigSaleLine,
            ISaleReturnLineItem argNewSaleLine, List<String> itemRemoveList) {

        argNewSaleLine.setDisallowDealFlag(this.onlySetupDealIsApplicable());

        if (argOrigSaleLine.getEnteredDescription() != null) {
            argNewSaleLine.setEnteredDescription(argOrigSaleLine
                    .getEnteredDescription());

        }

        argNewSaleLine.setEndDateTimestamp(DateUtils.getNewDate());
        this.getTransaction().addRetailTransactionLineItem(argNewSaleLine);

        this.adjustPrice(argDetail, argNewSaleLine, argOrigSaleLine);
        CorrectionModifierReasonCode reasonCode = this.getReasonCode(argDetail);

        ISaleReturnLineItem lineCopy = ItemLocator.getLocator()
                .copySaleLineItem(argNewSaleLine, argOrigSaleLine, reasonCode);

        this._accountHelper
                .addAccountItemActivity(argDetail, CustomerItemAccountActivityCodeType.PICKUP, lineCopy);

        argDetail.setRetailLineItem(lineCopy);

        if (!argNewSaleLine.getItem().getNotInventoried()
                && !(argNewSaleLine.getItem() instanceof INonPhysicalItem)) {

            while (!argNewSaleLine.getAllInventoryLocationModifiers()
                    .isEmpty()) {
                IInventoryLocationModifier toRemove = argNewSaleLine
                        .getAllInventoryLocationModifiers().get(0);
                argNewSaleLine.removeInventoryLocationModifier(toRemove);
            }

            if (_transactionScope
                    .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY) == null) {
                _transactionScope
                        .setValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY, itemRemoveList);
            } else {
                _transactionScope
                        .getValue(CawValueKeys.CAW_WO_LINE_ITEM_WRRANTY)
                        .addAll(itemRemoveList);
            }
        }
    }

    /**
     * @param argOrigSaleLine
     * @param iItemCover
     * @param itemRemoveList
     */
    @SuppressWarnings("unchecked")
    private void getWarrantyItems(ISaleReturnLineItem argOrigSaleLine,
            IItem iItemCover, List<String> itemRemoveList) {

        List<IWarrantyLineItem> iWarrantyLineItems = _warrantyMgr
                .getWarrantyLineItems(argOrigSaleLine, CawWorkOrderConstants.WARRANTY_TYPCODE);
        if (iWarrantyLineItems != null && iWarrantyLineItems.size() > 0) {
            IItem warrantyItem = iWarrantyLineItems.get(0).getItem();

            List<TwoPiece<IWarrantyItem, IWarrantyItem>> warrantyItemCrossReferences = _warrantyHelper
                    .getAvailableWarrantyPlans(iItemCover, CawWorkOrderConstants.WARRANTY_TYPCODE, null);

            if (warrantyItem != null && warrantyItemCrossReferences != null
                    && warrantyItemCrossReferences.size() > 0) {
                Map<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem> warrantyItems = new HashMap<TwoPiece<IWarrantyItem, IWarrantyItem>, IItem>();
                for (TwoPiece<IWarrantyItem, IWarrantyItem> twoPiece : warrantyItemCrossReferences) {
                    if (twoPiece.b() != null && twoPiece.b().getItemId()
                            .equalsIgnoreCase(warrantyItem.getItemId())) {
                        itemRemoveList.add(twoPiece.b().getItemId());
                        if (_transactionScope
                                .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST) != null
                                && _transactionScope
                                        .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST)
                                        .size() > 0) {
                            _transactionScope
                                    .getValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST)
                                    .put(twoPiece, iItemCover);
                        } else {
                            warrantyItems.put(twoPiece, iItemCover);
                            _transactionScope
                                    .setValue(CawValueKeys.ITM_WARRANTY_ITEM_LIST, warrantyItems);
                        }

                        break;
                    }
                }
            }
        }
    }

}
