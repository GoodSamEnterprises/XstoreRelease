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
 * BZ24177          271017    [Tenders] BAD CARD READ displayed when you swipe on Monitor Card Reader for Tender Exchange
 * BZ24307          241117    [Xstore] Xstore displays "Please Wait" for about 12 seconds before displaying prompt to enter or swipe gift card
 *===================================================================
 */

package caw.pos.hardware.op;

import java.util.ArrayList;

import caw.hardware.service.CawHardwareMgr;

import dtv.hardware.HardwareMgr;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.type.VoucherActivityCodeType;

/**
 * Reset all device to enable MSR device.
 */
public class CawRefreshMSRDeviceOp extends Operation {

    private ArrayList<VoucherActivityCodeType> giftCardActivity = new ArrayList<>();

    @SuppressWarnings("deprecation")
    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        initGiftCardActivityList();
        if (HardwareMgr.getCurrentHardwareMgr() instanceof CawHardwareMgr) {
            //Begin BZ24307
            CawHardwareMgr msrMgr = (CawHardwareMgr) HardwareMgr
                    .getCurrentHardwareMgr();
            msrMgr.releaseAndRestartMSR();
            //End BZ24307
        }
        return HELPER.completeResponse();
    }

    private void initGiftCardActivityList() {

        if (giftCardActivity.isEmpty()) {
            giftCardActivity.add(VoucherActivityCodeType.ISSUED);
            giftCardActivity.add(VoucherActivityCodeType.RELOAD);
            giftCardActivity.add(VoucherActivityCodeType.INQUIRE_BALANCE);
            giftCardActivity.add(VoucherActivityCodeType.CASHOUT);
        }
    }

}
