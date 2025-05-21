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
 * BZ53752          221122    [BTM-255] - Wrong ItemCorrelationKey is being set in OrginalCorrelationKey attribute on returned items in SubmitOrder Request
 *===================================================================
 */

package caw.pos.cheetah.util;

public class CawCheetahWorkOrderDetailModel {

    private String workOrderId;

    private int    posStatus;

    /**
     * @return the workOrderId
     */
    public String getWorkOrderId() {

        return workOrderId;
    }

    /**
     * @param argWorkOrderId the workOrderId to set
     */
    public void setWorkOrderId(String argWorkOrderId) {

        workOrderId = argWorkOrderId;
    }

    /**
     * @return the posStatus
     */
    public int getPosStatus() {

        return posStatus;
    }

    /**
     * @param argPosStatus the posStatus to set
     */
    public void setPosStatus(int argPosStatus) {

        posStatus = argPosStatus;
    }

}
