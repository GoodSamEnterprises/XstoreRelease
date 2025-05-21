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
 *===================================================================
 */

package caw.pos.hardware.op;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dtv.hardware.HardwareMgr;
import dtv.hardware.msr.IDtvMsr;
import dtv.hardware.types.HardwareFamilyType;
import dtv.hardware.types.HardwareType;
import dtv.pos.framework.op.Operation;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;

/**
 * Disable MSR Device. Only enable when swipe gift card flows.
 */
public class CawDisableMSRDeviceOp extends Operation {

    private static final String MAIN_MSR = "MAIN_MSR";

    private static final Logger _logger  = LogManager
            .getLogger(CawDisableMSRDeviceOp.class);

    @Inject
    private HardwareMgr         _hardwareMgr;

    @Override
    public IOpResponse handleOpExec(IXstEvent argArg0) {

        try {
            HardwareType<IDtvMsr> type = HardwareType
                    .forUse(HardwareFamilyType.MSR, MAIN_MSR);
            if (type != null) {
                IDtvMsr device = _hardwareMgr.getDevice(type);
                if (device != null) {
                    device.disable();
                }
            }
        } catch (RuntimeException ex) {
            _logger.error(ex);
        } catch (Exception ex) {
            _logger.error(ex);
        }
        return HELPER.completeResponse();
    }

}
