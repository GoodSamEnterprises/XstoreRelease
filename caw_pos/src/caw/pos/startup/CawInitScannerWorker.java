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
 * BZ33595          271119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ34287          161219    [Internal] Xstore show HDE when input sale receipt barcode manually
 *===================================================================
 */

package caw.pos.startup;

import javax.inject.Inject;

import jpos.Scanner;

import caw.hardware.barcode.CawBarcodeScanner;
import caw.hardware.service.CawHardwareHelper;

import dtv.hardware.HardwareMgr;
import dtv.hardware.scanner.IDtvBarcodeScanner;
import dtv.hardware.types.HardwareType;
import dtv.pos.framework.worker.AbstractWorker;
import dtv.util.StringUtils;

public class CawInitScannerWorker extends AbstractWorker {

    @Inject
    private HardwareMgr              _hardwareMgr;

    @Override
    protected void performWorkImpl() throws Exception {

        HardwareType<IDtvBarcodeScanner> typeScanner = CawHardwareHelper.getInstance()._typeScanner;
        String scannerOutXML = StringUtils.EMPTY;
        CawBarcodeScanner barcodeScanner = null;
        /* BEGIN BZ34287 */
        if (_hardwareMgr != null && typeScanner != null) {
            IDtvBarcodeScanner iDtvBarcodeScanner = _hardwareMgr.getDevice(typeScanner);
            if (iDtvBarcodeScanner instanceof CawBarcodeScanner) {
                barcodeScanner = (CawBarcodeScanner) iDtvBarcodeScanner;
                Scanner jposScanner = barcodeScanner.getCawJposControl();
                if (jposScanner != null) {
                    CawHardwareHelper.getInstance().setScanner(jposScanner);
                    scannerOutXML = CawHardwareHelper.getInstance()
                            .getScannerOutXml(barcodeScanner.getCawJposControl());
                    if (!StringUtils.isEmpty(scannerOutXML)) {
                        CawHardwareHelper.getInstance().setScannerID(CawHardwareHelper.getInstance()
                                .getScannerIDFromScannerOutXml(scannerOutXML));
                    }
                }
            }
        }
        /* END BZ34287 */
    }

}
