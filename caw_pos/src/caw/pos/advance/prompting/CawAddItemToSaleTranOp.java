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
 * BZ24354          081117    [Advance Prompting] Add membership info validation API to all membership types when manually entered in POS
 * BZ26270          230718    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ39699          191120    [Task] Porting these fixes of xstore 6.0 patch 10.0/11.0 into Xstore 7.0 patch 1.0
 * BZ65612          260724    AGMOD Update to Membership SKU New Requirements
 *===================================================================
 */

package caw.pos.advance.prompting;

import java.util.List;

import caw.pos.agis.model.CawAGISPitchesModel;
import caw.pos.common.CawConstants;
import caw.pos.common.CawValueKeys;

import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.AddItemToSaleTranOp;
import dtv.pos.spring.ValueKeys;
import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawAddItemToSaleTranOp extends AddItemToSaleTranOp {

    /* (non-Javadoc)
     * @see dtv.pos.register.AddItemToSaleTranOp#isOperationApplicable()
     */
    @Override
    public boolean isOperationApplicable() {

        if (getScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG) != null) {
            // BZ39699 remove: clearScopedValue(CawValueKeys.RESPONSE_IN_VALIDATE_MEMBERSHIP_MSG);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /* (non-Javadoc)
     * @see dtv.pos.register.AddItemToSaleTranOp#handleOpExec(dtv.pos.iframework.event.IXstEvent)
     */
    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {

        ISaleReturnLineItem newLineItem = getScopedValue(ValueKeys.CURRENT_SALE_LINE);
        //BEGIN BZ65612
        CawAGISPitchesModel cawPitchesModel = _transactionScope.getValue(CawValueKeys.CAW_AGIS_PICHES_MODEL);
        List<String> itemIds = cawPitchesModel.getAllItemIds();
        newLineItem.setStringProperty(CawConstants.CAW_PITCHES_ITEM_LIST, itemIds.toString());
        //END BZ65612
        if (newLineItem != null) {
            getScopedValue(ValueKeys.CURRENT_SALE_LINE).setVoid(false);
            //BEGIN BZ26270
            if (newLineItem.getScannedItemId() == null) {
                newLineItem.setScannedItemId(newLineItem.getItemId());
            }
            //END BZ26270
        }
        return super.handleOpExec(argEvent);
    }
}
