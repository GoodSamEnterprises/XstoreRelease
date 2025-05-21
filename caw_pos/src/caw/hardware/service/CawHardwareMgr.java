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
 * BZ24307          241117    [Xstore] Xstore displays "Please Wait" for about 12 seconds before displaying prompt to enter or swipe gift card
 *===================================================================
 */

package caw.hardware.service;

import dtv.hardware.*;
import dtv.hardware.msr.IDtvMsr;
import dtv.hardware.types.HardwareFamilyType;
import dtv.util.ObjectUtils;

/**
 * This function is used to start MSR
 */
public class CawHardwareMgr extends HardwareMgr {

    /**
     * This method is used to release and Start MSR
     * disableAndRelease: setDeviceEnabled is false and release device
     * claimAndEnable: after release we need to claim for device and help control is open, setDeviceEnabled(true)
     */
    public void releaseAndRestartMSR() {

        IDtvJposDevice jposDevice = (IDtvJposDevice) getMsr();
        jposDevice.disableAndRelease();
        jposDevice.claimAndEnable();
    }

    public IDtvMsr getMsr() {

        IDtvMsr[] msrs = getDevices(HardwareFamilyType.MSR);

        if (msrs.length == 0) {
            logger_.info("no MSR");
            return makeDefaultDeviceAdapter(HardwareFamilyType.MSR, "");
        }

        return (IDtvMsr) ObjectUtils.greatest((IDtvDevice[]) msrs);
    }
}
