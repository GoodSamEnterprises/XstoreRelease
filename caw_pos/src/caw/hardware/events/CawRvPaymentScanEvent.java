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
 * BZ46381          110821    IDS Payment - Should be able to scan a barcode of IDS Customer Number and IDS WO Number when doing a RV Service Payment Search in Xstore
 *===================================================================
 */

package caw.hardware.events;

import javax.inject.Inject;

import caw.hardware.types.CawInputType;
import caw.pos.common.CawValueKeys;

import dtv.hardware.events.AbstractInputEvent;
import dtv.pos.framework.scope.TransactionScope;
import dtv.pos.iframework.hardware.IInput;
import dtv.util.temp.InjectionHammer;

/**
 *
 */
@SuppressWarnings("deprecation")
public class CawRvPaymentScanEvent extends AbstractInputEvent<IInput> {
    @Inject
    protected TransactionScope _transactionScope;
    public CawRvPaymentScanEvent(IInput argBarcode) {
        super(CawInputType.INPUT_RV_PAYMENT, argBarcode);
        InjectionHammer.forceAtInjectProcessing(this);
        if(_transactionScope != null) {
            _transactionScope.setValue(CawValueKeys.CAW_RV_PAYMENT_BARCODE, this.getStringData());
        }
    }
}
