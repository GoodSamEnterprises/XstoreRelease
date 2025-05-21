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
 * 24275            151117    unable to scan sale receipts on scan screen.
 *===================================================================
 */

package caw.hardware.service;

import dtv.hardware.service.DtvJposEntry;
import dtv.hardware.service.scanner.AbstractScannerService;

/**
 *
 */
public class CawScannerDummy extends AbstractScannerService {

    public static CawScannerDummy instance     = null;

    public static final String    CODE93PREFIX = "E";

    public CawScannerDummy(DtvJposEntry argEntry) {

        super(argEntry);
        instance = this;
    }

    /* (non-Javadoc)
     * @see dtv.hardware.service.AbstractDeviceService#getActualHardwareDescription()
     */
    @Override
    protected String getActualHardwareDescription() {

        return "Virtual Scanner";
    }

    /* (non-Javadoc)
     * @see dtv.hardware.service.AbstractDeviceService#getActualHardwareName()
     */
    @Override
    protected String getActualHardwareName() {

        return "Virtual Scanner";
    }

    /* (non-Javadoc)
     * @see dtv.hardware.service.AbstractDeviceService#getActualServiceDescription()
     */
    @Override
    protected String getActualServiceDescription() {

        return "Virtual Scanner";
    }

    @Override
    protected void doClaim(int argTimeout) {

        instance = this;
    }

    //Currently, in jpos, the prefix for code 93 is 'E'
    // so add E as prefix to create the barcode as code 93.
    public void scanOccurred(String argScanData) {

        String data = CODE93PREFIX + argScanData;
        setScanData(data.getBytes());
        setDataCount(1);
        decodeDate();
        fireScanComplete();
    }

}
