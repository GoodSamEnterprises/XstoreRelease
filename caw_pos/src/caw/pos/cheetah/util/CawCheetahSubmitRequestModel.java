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
 * BZ63054          080424    [API Change] - Format of the Submit Order API response is changed.
 *===================================================================
 */

package caw.pos.cheetah.util;

import java.math.BigDecimal;
import java.util.List;

import dtv.xst.dao.crm.IParty;

public class CawCheetahSubmitRequestModel {

    private CawCheetahWorkOrderDetailModel workOrderDetail;
    
    private String wondersignCartIdSubmitOrder;
    
    private BigDecimal rvPropertiesSubmitOrder;
    
    private List<CawCheetahItemAdjustmentsModel> itemAdjustmentsModel;
    
    private IParty party;
    
    /*BEGIN BZ63054 */
    private String receiptType;
    
    private String receiptTypeDescription;
    
    private String emailReceipt;
    
    /*END BZ63054 */
    /**
     * @return the workOrderDetail
     */
    public CawCheetahWorkOrderDetailModel getWorkOrderDetail() {

        return workOrderDetail;
    }

    /**
     * @param argWorkOrderDetail the workOrderDetail to set
     */
    public void setWorkOrderDetail(
            CawCheetahWorkOrderDetailModel argWorkOrderDetail) {

        workOrderDetail = argWorkOrderDetail;
    }

    
    /**
     * @return the wondersignCartIdSubmitOrder
     */
    public String getWondersignCartIdSubmitOrder() {
    
        return wondersignCartIdSubmitOrder;
    }

    
    /**
     * @param argWondersignCartIdSubmitOrder the wondersignCartIdSubmitOrder to set
     */
    public void setWondersignCartIdSubmitOrder(
            String argWondersignCartIdSubmitOrder) {
    
        wondersignCartIdSubmitOrder = argWondersignCartIdSubmitOrder;
    }

    
    /**
     * @return the rvPropertiesSubmitOrder
     */
    public BigDecimal getRvPropertiesSubmitOrder() {
    
        return rvPropertiesSubmitOrder;
    }

    
    /**
     * @param argRvPropertiesSubmitOrder the rvPropertiesSubmitOrder to set
     */
    public void setRvPropertiesSubmitOrder(BigDecimal argRvPropertiesSubmitOrder) {
    
        rvPropertiesSubmitOrder = argRvPropertiesSubmitOrder;
    }

    
    /**
     * @return the itemAdjustmentsModel
     */
    public List<CawCheetahItemAdjustmentsModel> getItemAdjustmentsModel() {
    
        return itemAdjustmentsModel;
    }

    
    /**
     * @param argItemAdjustmentsModel the itemAdjustmentsModel to set
     */
    public void setItemAdjustmentsModel(
            List<CawCheetahItemAdjustmentsModel> argItemAdjustmentsModel) {
    
        itemAdjustmentsModel = argItemAdjustmentsModel;
    }

    
    /**
     * @return the party
     */
    public IParty getParty() {
    
        return party;
    }

    
    /**
     * @param argParty the party to set
     */
    public void setParty(IParty argParty) {
    
        party = argParty;
    }

    
    /**
     * @return the receiptType
     */
    public String getReceiptType() {
    
        return receiptType;
    }

    
    /**
     * @param argReceiptType the receiptType to set
     */
    public void setReceiptType(String argReceiptType) {
    
        receiptType = argReceiptType;
    }

    
    /**
     * @return the receiptTypeDescription
     */
    public String getReceiptTypeDescription() {
    
        return receiptTypeDescription;
    }

    
    /**
     * @param argReceiptTypeDescription the receiptTypeDescription to set
     */
    public void setReceiptTypeDescription(String argReceiptTypeDescription) {
    
        receiptTypeDescription = argReceiptTypeDescription;
    }

    
    /**
     * @return the emailReceipt
     */
    public String getEmailReceipt() {
    
        return emailReceipt;
    }

    
    /**
     * @param argEmailReceipt the emailReceipt to set
     */
    public void setEmailReceipt(String argEmailReceipt) {
    
        emailReceipt = argEmailReceipt;
    }

    

    
    
}
