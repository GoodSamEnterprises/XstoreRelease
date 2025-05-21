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
 * Req/Bug ID#      ddMMyy    Description
 * BZ37463          220820    [Task] Creating Order Service Spec for Brokered Order transaction types.
 * BZ40561          140121    OB Reject Reasons and Order Status
 * BZ45903          250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 * BZ48320          220122    Vehicle Identification Number (VIN) Capture - New Order API to capture VIN into BOPIS transaction
 *===================================================================
 */

package caw.orderservice.model;

/**
 *
 */
public class CawBrokeredOrderLineModel {

    private String orderId;

    private int    detailSeq;

    private String requestId;
    
    private int    rtransLineitmSeq;/*BZ45903*/
    /**
     * @return the requestId
     */
    public String getRequestId() {

        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(String requestId) {

        this.requestId = requestId;
    }

    private String itemId;

    private int    quantity;

    private String fulfillmentType;

    private String statusCode;

    private String shippingMethod;

    private String shippingMethodDes;
    // Begin BZ-40561
    private String statusCodeReason;
    
    private String statusCodeReasonNote;
    // End BZ-40561
    private String vinNumber;/*BZ48320*/
    /**
     * @return the shippingMethodDes
     */
    public String getShippingMethodDes() {

        return shippingMethodDes;
    }

    /**
     * @param shippingMethodDes the shippingMethodDes to set
     */
    public void setShippingMethodDes(String shippingMethodDes) {

        this.shippingMethodDes = shippingMethodDes;
    }

    /**
     * @return the shippingMethod
     */
    public String getShippingMethod() {

        return shippingMethod;
    }

    /**
     * @param shippingMethod the shippingMethod to set
     */
    public void setShippingMethod(String shippingMethod) {

        this.shippingMethod = shippingMethod;
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
     * @return the detailSeq
     */
    public int getDetailSeq() {

        return detailSeq;
    }

    /**
     * @param detailSeq the detailSeq to set
     */
    public void setDetailSeq(int detailSeq) {

        this.detailSeq = detailSeq;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {

        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {

        this.itemId = itemId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {

        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    /**
     * @return the fulfillmentType
     */
    public String getFulfillmentType() {

        return fulfillmentType;
    }

    /**
     * @param fulfillmentType the fulfillmentType to set
     */
    public void setFulfillmentType(String fulfillmentType) {

        this.fulfillmentType = fulfillmentType;
    }

    /**
     * @return the statusCode
     */
    public String getStatusCode() {

        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode) {

        this.statusCode = statusCode;
    }
    
    // Begin BZ-40561
    /**
     * @return the statusCodeReason
     */
    public String getStatusCodeReason() {

        return statusCodeReason;
    }

    /**
     * @param statusCodeReason the statusCodeReason to set
     */
    public void setStatusCodeReason(String statusCodeReason) {

        this.statusCodeReason = statusCodeReason;
    }

    /**
     * @return the statusCodeReasonNote
     */
    public String getStatusCodeReasonNote() {

        return statusCodeReasonNote;
    }

    /**
     * @param statusCodeReasonNote the statusCodeReasonNote to set
     */
    public void setStatusCodeReasonNote(String statusCodeReasonNote) {

        this.statusCodeReasonNote = statusCodeReasonNote;
    }
    // End BZ-40561

    @Override
    public String toString() {

        return "CawBrokeredOrderLineModel [orderId=" + orderId + ", detailSeq="
                + detailSeq + ", requestId=" + requestId + ", itemId=" + itemId
                + ", quantity=" + quantity + ", fulfillmentType="
                + fulfillmentType + ", statusCode=" + statusCode + "]";
    }
    /*BEGIN BZ45903*/
    /**
     * @return the rtransLineitmSeq
     */
    public int getRtransLineitmSeq() {
    
        return rtransLineitmSeq;
    }

    
    /**
     * @param rtransLineitmSeq the rtransLineitmSeq to set
     */
    public void setRtransLineitmSeq(int rtransLineitmSeq) {
    
        this.rtransLineitmSeq = rtransLineitmSeq;
    }
    /*END BZ45903*/

    /*BEGIN BZ48320*/
    public String getVinNumber() {
    
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
    
        this.vinNumber = vinNumber;
    }
    /*END BZ48320*/
}
