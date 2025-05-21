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
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ34287          161219    [Internal] Xstore show HDE when input sale receipt barcode manually
 *===================================================================
 */

package caw.hardware.barcode;

import jpos.Scanner;

import dtv.hardware.scanner.DtvBarcodeScanner;
import dtv.hardware.types.HardwareType;
import dtv.pos.iframework.hardware.Barcode;

public class CawBarcodeScanner extends DtvBarcodeScanner {

    public CawBarcodeScanner(HardwareType<?> argType) {
        super(argType);
    }

    /**
     * Get information of ZebraAllScanners when startup Xstore
     * @return
     */
    public Scanner getCawJposControl() {
        return super.getJposControl();
    }

    /* BEGIN BZ34287 */
    @Override
    public void inputOccurred(Barcode data) {
        super.inputOccurred(data);
    }
    /* END BZ34287 */
}
