/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions [of the software code and associated documentation] 
 * developed for Camping World are proprietary and confidential 
 * to BTM Global. BTM Global has granted Camping World a perpetual, 
 * non-exclusive, non-sublicensable license to use [the software 
 * code and associated documentation] for its internal business 
 * operations only.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ37463              220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ38176              300920    [Internal] - The request of information Pickup store address (shipToInfo) is sent Incorrectly when create Order transaction in case the customer selects multiple pick-up stores
 * BZ48320              220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 *===================================================================
 */

package caw.orderservice.model;

import java.util.List;

/**
 *
 */
public class CawBrokeredOrderModel {

    private String                          channelType;

    private String                          transSeq;

    private String                          orderType;

    private String                          orderId;

    private String                          posStatus;

    private List<CawBrokeredOrderLineModel> cawBrokeredOrderLineModel;

    private CawShipToInfoModel              shipToInfoModel;

    private String                          transType;                // Retails transaction or Order transaction
    
    private boolean                         isVinTrans;/*BZ48320*/
    
    /* BEGIN BZ38716 */
    private List<CawShipToInfoModel> shipToInfoModels;
    /**
     * @return the shipToInfoModels
     */
    public List<CawShipToInfoModel> getShipToInfoModels() {
    
        return shipToInfoModels;
    }
    /**
     * @param shipToInfoModels the shipToInfoModels to set
     */
    public void setShipToInfoModels(List<CawShipToInfoModel> shipToInfoModels) {
    
        this.shipToInfoModels = shipToInfoModels;
    }
    /* END BZ38716 */
    /**
     * @return the channelType
     */
    public String getChannelType() {

        return channelType;
    }

    /**
     * @param channelType the channelType to set
     */
    public void setChannelType(String channelType) {

        this.channelType = channelType;
    }

    /**
     * @return the transSeq
     */
    public String getTransSeq() {

        return transSeq;
    }

    /**
     * @param transSeq the transSeq to set
     */
    public void setTransSeq(String transSeq) {

        this.transSeq = transSeq;
    }

    /**
     * @return the orderType
     */
    public String getOrderType() {

        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(String orderType) {

        this.orderType = orderType;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {

        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {

        this.orderId = orderId;
    }

    /**
     * @return the posStatus
     */
    public String getPosStatus() {

        return posStatus;
    }

    /**
     * @param posStatus the posStatus to set
     */
    public void setPosStatus(String posStatus) {

        this.posStatus = posStatus;
    }

    /**
     * @return the cawBrokeredOrderLineModel
     */
    public List<CawBrokeredOrderLineModel> getCawBrokeredOrderLineModel() {

        return cawBrokeredOrderLineModel;
    }

    /**
     * @param cawBrokeredOrderLineModel the cawBrokeredOrderLineModel to set
     */
    public void setCawBrokeredOrderLineModel(
            List<CawBrokeredOrderLineModel> cawBrokeredOrderLineModel) {

        this.cawBrokeredOrderLineModel = cawBrokeredOrderLineModel;
    }

    /**
     * @return the transType
     */
    public String getTransType() {

        return transType;
    }

    /**
     * @param transType the transType to set
     */
    public void setTransType(String transType) {

        this.transType = transType;
    }

    @Override
    public String toString() {

        return "CawBrokeredOrderModel [orderType=" + orderType + ", orderId="
                + orderId + ", posStatus=" + posStatus
                + ", cawBrokeredOrdershipToInfo=" + shipToInfoModel + "]";
    }

    /**
     * @return the shipToInfoModel
     */
    public CawShipToInfoModel getShipToInfoModel() {

        return shipToInfoModel;
    }

    /**
     * @param shipToInfoModel the shipToInfoModel to set
     */
    public void setShipToInfoModel(CawShipToInfoModel shipToInfoModel) {

        this.shipToInfoModel = shipToInfoModel;
    }

    /*BEGIN BZ48320*/
    /**
     * @return the isVinTrans
     */
    public boolean isVinTrans() {
    
        return isVinTrans;
    }
    
    /**
     * @param isVinTrans the isVinTrans to set
     */
    public void setVinTrans(boolean isVinTrans) {
    
        this.isVinTrans = isVinTrans;
    }
    /*END BZ48320*/
}
