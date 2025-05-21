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
 * BZ23710          041017    Should remove "purchase of used firearm" option out of reason code screen 
 *                            when performing a return no receipt transaction.
 *===================================================================
 */

package caw.pos.register.returns;

import java.util.*;

import org.apache.log4j.Logger;

import caw.pos.common.CawValueKeys;
import caw.pos.register.returns.common.CawPurchaseUsedFirearmConstant;

import dtv.data2.access.DataFactory;
import dtv.pos.common.ConfigurationMgr;
import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.model.IMenuModel;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.register.returns.verification.PromptVerifiedReturnReasonCodeOp;
import dtv.xst.dao.com.CodeLocator;
import dtv.xst.dao.com.IReasonCode;

/**
 *  Prompt the purchase of used firearm reason if the item return is Purchase Used Firearm.
 */
public class CawPromptVerifiedReturnReasonCodeOp
        extends PromptVerifiedReturnReasonCodeOp {

    private static final Logger _logger          = Logger
            .getLogger(CawPromptReturnReasonCodeOp.class);

    private static final String DESCRIPTION      = "Purchase Of Used Firearm";

    private static final String COMMENT_REQUIRED = "Purchase Of Used Firearm";

    private static final String LOCATION_ID      = "ON_HAND";

    private static final int    SORT_ORDER       = 10;

    @Override
    protected Object[] getPromptList(IXstEvent argEvent) {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);
        if ((isPurchaseUsedFirearm != null) && (isPurchaseUsedFirearm)) {
            IReasonCode purchaseUsedFirearmReasonCode = CodeLocator
                    .getReasonCode(ConfigurationMgr
                            .getOrganizationId(), CawPurchaseUsedFirearmConstant.REASON_TYPE_CODE, CawPurchaseUsedFirearmConstant.TYPE_CODE);
            List<IReasonCode> listReasonCode = new ArrayList<IReasonCode>();

            if (purchaseUsedFirearmReasonCode != null) {
                listReasonCode.add(purchaseUsedFirearmReasonCode);
                return listReasonCode.toArray();
            } else {
                _logger.warn("Purchase Used Reason Code cannot found. Create a Purchase Used Firearm Reason Code");

                //create purchase used firearm reason code
                purchaseUsedFirearmReasonCode = DataFactory
                        .createObject(IReasonCode.class);

                //set value
                purchaseUsedFirearmReasonCode.setOrganizationId(ConfigurationMgr
                        .getOrganizationId());
                purchaseUsedFirearmReasonCode
                        .setReasonTypeCode(CawPurchaseUsedFirearmConstant.REASON_TYPE_CODE);
                purchaseUsedFirearmReasonCode
                        .setReasonCode(CawPurchaseUsedFirearmConstant.TYPE_CODE);
                purchaseUsedFirearmReasonCode.setDescription(DESCRIPTION);
                purchaseUsedFirearmReasonCode
                        .setCommentRequired(COMMENT_REQUIRED);
                purchaseUsedFirearmReasonCode
                        .setInventoryLocationId(LOCATION_ID);
                purchaseUsedFirearmReasonCode.setSortOrder(SORT_ORDER);

                //add to list
                listReasonCode.add(purchaseUsedFirearmReasonCode);

                return listReasonCode.toArray();
            }
        } else {
            List<IReasonCode> listReasonCode = new ArrayList<IReasonCode>();
            Object[] objectList = super.getPromptList(argEvent);

            for (Object o : objectList) {
                if (o instanceof IReasonCode) {
                    if (!(CawPurchaseUsedFirearmConstant.TYPE_CODE
                            .equals(((IReasonCode) o).getReasonCode()))) {
                        listReasonCode.add((IReasonCode) o);
                    }
                }
            }

            return listReasonCode.toArray();
        }
    }

    @Override
    protected boolean showListIfOne() {

        Boolean isPurchaseUsedFirearm = _transactionScope
                .getValue(CawValueKeys.IS_PURCHASE_USED_FIREARM);

        if ((isPurchaseUsedFirearm != null) && isPurchaseUsedFirearm) {
            //that is true because show only Purchase Of Firearm reason.
            return true;
        }

        //if item return isn't Purchase Used Firearm, return as base did.
        return super.showListIfOne();
    }
    
    protected void disableActions(Collection<IXstAction> argActions) {
        Iterator<IXstAction> var2 = argActions.iterator();
        while (var2.hasNext()) {
          IXstAction action = var2.next();
          _logger.debug("Disabling action: " + action);
          action.setEnabled(false);
          action.clearPostActions();
        } 
      }
    
    /* (non-Javadoc)
     * @see dtv.pos.framework.op.AbstractPromptOp#handlePromptEvent(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    protected IOpResponse handlePromptEvent(IXstEvent argEvent) {
        @SuppressWarnings("cast")
        IPromptActionModel promptActionModel = ((IModeController)this._modeProvider.get()).getStationModel()
          .getPromptActionModel();
        disableActions(promptActionModel.getActions());
        @SuppressWarnings("cast")
        IMenuModel menuModel = ((IModeController)this._modeProvider.get()).getStationModel().getMenuModel();
        disableActions(menuModel.getActions());
      
        return super.handlePromptEvent(argEvent);
    }
    
}
