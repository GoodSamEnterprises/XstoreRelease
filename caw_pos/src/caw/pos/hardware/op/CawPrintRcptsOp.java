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
 * BZ35513          120320    [NEW REQ] Need option for "No Receipt" as a Receipt Method on Sales Complete screen
 *===================================================================
 */

package caw.pos.hardware.op;

import java.util.Arrays;
import java.util.List;

import caw.pos.common.CawValueKeys;
import dtv.docbuilding.DefaultPrinterTargetInfo;
import dtv.hardware.posprinting.RcptStack;
import dtv.hardware.rcptbuilding.IRcpt;
import dtv.pos.hardware.op.PrintRcptsOp;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.spring.ValueKeys;

/**
 *
 */
public class CawPrintRcptsOp extends PrintRcptsOp {

    @Override
    public IOpResponse handleOpExec(IXstEvent argEvent) {
        RcptStack rcpts = getScopedValue(ValueKeys.CURRENT_RECEIPTS_STACK);
        Boolean noPrintReceipts = getScopedValue(CawValueKeys.NO_PRINT_RECEIPTS);

        /* BZ35513: Handle in case option "No Receipt" is selected */
        if (noPrintReceipts != null && noPrintReceipts && rcpts != null && !rcpts.isEmpty()) {
            IRcpt[] arrReceipts = rcpts.getRcpts();
            List<IRcpt> listReceipts = Arrays.asList(arrReceipts);
            /* For each receipt in stack, update printer hardware which is gonna to be used*/
            listReceipts.stream().forEach(receipt -> {
                receipt.setPrinterTargetInfo(new DefaultPrinterTargetInfo(geEjournalPrinterHW(),
                        receipt.getPrinterTargetInfo().getBackupPrinterType()));
            });
        }
        return super.handleOpExec(argEvent);
    }

    private String geEjournalPrinterHW() {
        return "EJOURNAL_RECEIPT";
    }
}
