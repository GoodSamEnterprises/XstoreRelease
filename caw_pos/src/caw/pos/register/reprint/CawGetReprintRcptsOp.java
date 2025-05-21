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
 * BZ35549          130320    [Defect 35513] No receipt is printed when reprinting the last receipt
 *===================================================================
 */

package caw.pos.register.reprint;

import java.util.Arrays;
import java.util.List;

import dtv.docbuilding.DefaultPrinterTargetInfo;
import dtv.hardware.posprinting.RcptStack;
import dtv.hardware.rcptbuilding.IRcpt;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.register.reprint.GetReprintRcptsOp;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawGetReprintRcptsOp extends GetReprintRcptsOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        IOpResponse response = super.handleOpExec(argEvent);
        RcptStack rcptStack = getScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK);

        /* BZ35549: In case Reprint receipts, receipts's printer should be reset to use physical printer */
        if (rcptStack != null && !rcptStack.isEmpty()) {
            IRcpt[] arrReceipts = rcptStack.getRcpts();
            List<IRcpt> listReceipts = Arrays.asList(arrReceipts);
            /* For each receipt in stack, update printer hardware which is gonna to be used*/
            listReceipts.stream().forEach(receipt -> {
                receipt.setPrinterTargetInfo(new DefaultPrinterTargetInfo(gePhysicalPrinterHW(),
                        receipt.getPrinterTargetInfo().getBackupPrinterType()));
            });
        }
        return response;
    }

    private String gePhysicalPrinterHW() {
        return "RECEIPT";
    }
}
