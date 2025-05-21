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
 * CAW_OrderService     210817    Initial development framework              
 * BZ23591              270917    Add channelType in Customer Update and Order Service
 * BZ24395              081117    [OrderService]Paid In & Paid Out transactions in order_service.out
 * BZ26207              250718    New Requirement - Enable Work Order Functionality
 * BZ51771              191022    [Task] Xstore needs to update request included the 'Loyaltydetail' information as a part of call to order service.
 * BZ61159              160124    [New Requirement] - Xstore AGIS Replacement
 *===================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;
import java.util.List;

import caw.orderservice.constant.CawCommonConstant;

public class CawTheOrderModel {

    private CawSalesChannelModel salesChannel;

    //Begin BZ24395
    private CawPaidInOutDetail   paidInOutDetail;
    //End BZ24395

    private CawWorkOrderDetail   workOrderDetail;  //BZ26207

    private String               orderType;        // BZ23591

    private Long                 id;

    private String               correlationKey;

    private CawCashierModel      cashier;

    private String               orderDate;

    private BigDecimal           orderTotalWithTax;

    private CawCustomerModel     customer;

    private CawShipToInfoModel   shipToInfo;

    private List<CawItemModel>   items   = null;

    private List<CawTenderModel> tenders = null;

    private String               receiptType;

    private String               eReceiptEmail;

    private CawAttributesModel   attributes;
    
    //BEGIN BZ51771
    private String                    loyatyDetail         = CawCommonConstant.EMPTY_STRING;
    //END BZ51771

    private String                    pitchesInfo          = CawCommonConstant.EMPTY_STRING; //BZ61159
    
    public CawSalesChannelModel getSalesChannel() {

        return salesChannel;
    }

    public void setSalesChannel(CawSalesChannelModel salesChannel) {

        this.salesChannel = salesChannel;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getCorrelationKey() {

        return correlationKey;
    }

    public void setCorrelationKey(String correlationKey) {

        this.correlationKey = correlationKey;
    }

    public CawCashierModel getCashier() {

        return cashier;
    }

    public void setCashier(CawCashierModel cashier) {

        this.cashier = cashier;
    }

    public String getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(String orderDate) {

        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotalWithTax() {

        return orderTotalWithTax;
    }

    public void setOrderTotalWithTax(BigDecimal orderTotalWithTax) {

        this.orderTotalWithTax = orderTotalWithTax;
    }

    public CawCustomerModel getCustomer() {

        return customer;
    }

    public void setCustomer(CawCustomerModel customer) {

        this.customer = customer;
    }

    public CawShipToInfoModel getShipToInfo() {

        return shipToInfo;
    }

    public void setShipToInfo(CawShipToInfoModel shipToInfo) {

        this.shipToInfo = shipToInfo;
    }

    public List<CawItemModel> getItems() {

        return items;
    }

    public void setItems(List<CawItemModel> items) {

        this.items = items;
    }

    public List<CawTenderModel> getTenders() {

        return tenders;
    }

    public void setTenders(List<CawTenderModel> tenders) {

        this.tenders = tenders;
    }

    public String getReceiptType() {

        return receiptType;
    }

    public void setReceiptType(String receiptType) {

        this.receiptType = receiptType;
    }

    public String getEReceiptEmail() {

        return eReceiptEmail;
    }

    public void setEReceiptEmail(String eReceiptEmail) {

        this.eReceiptEmail = eReceiptEmail;
    }

    public CawAttributesModel getAttributes() {

        return attributes;
    }

    public void setAttributes(CawAttributesModel attributes) {

        this.attributes = attributes;
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

    //Begin BZ24395
    /**
     * @return the paidInOutDetail
     */
    public CawPaidInOutDetail getPaidInOutDetail() {

        return paidInOutDetail;
    }

    /**
     * @param paidInOutDetail the paidInOutDetail to set
     */
    public void setPaidInOutDetail(CawPaidInOutDetail paidInOutDetail) {

        this.paidInOutDetail = paidInOutDetail;
    }
    //End BZ24395

    //Begin BZ26207
    /**
     * @return the workOrderDetail
     */
    public CawWorkOrderDetail getWorkOrderDetail() {

        return workOrderDetail;
    }

    /**
     * @param workOrderDetail the workOrderDetail to set
     */
    public void setWorkOrderDetail(CawWorkOrderDetail workOrderDetail) {

        this.workOrderDetail = workOrderDetail;
    }
    //End BZ26207
    
    //BEGIN BZ51771
    /**
     * @return the loyatyDetail
     */
    public String getLoyatyDetail() {
    
        return loyatyDetail;
    }
    /**
     * @param loyatyDetail the loyatyDetail to set
     */
    public void setLoyatyDetail(String loyatyDetail) {
        
        this.loyatyDetail = loyatyDetail;
    }
    //END BZ51771

    //BEGIN BZ61159
    /**
     * @return the pitchesInfo
     */
    public String getPitchesInfo() {

        return pitchesInfo;
    }

    /**
     * @param pitchesInfo the pitchesInfo to set
     */
    public void setPitchesInfo(String pitchesInfo) {

        this.pitchesInfo = pitchesInfo;
    }
    //END BZ61159
}
