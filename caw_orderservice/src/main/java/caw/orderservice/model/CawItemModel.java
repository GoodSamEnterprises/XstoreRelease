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
 * BZ25558              100418    New Requirement - Return Reason Codes Not Flowing to EBS
 * BZ25860              120418    New Requirement - Add "isReturn" (true/false) attribute to Order Service to differentiate Sale from Return transactions
 * BZ26735              290618    [PROD] Transaction with UOM as EACH submitted a quantity of 0 in the order service
 * BZ45903              250821    [Internal] Order Service - brokerItemDetail is incorrect if transaction included two same items but one is a sale item and one from EW order
 *== ================================================================
 */

package caw.orderservice.model;

import java.math.BigDecimal;
import java.util.List;

public class CawItemModel {

    private String                    correlationKey;

    private String                    code;

    private CawSalesPersonModel       salesPerson;

    private BigDecimal                quantity;        //BZ24573

    private String                    unitOfMeasure;

    private BigDecimal                unitListPrice;

    private BigDecimal                unitSellingPrice;

    private String                    taxCode;

    private BigDecimal                taxAmount;

    private BigDecimal                lineTotal;

    private List<CawAdjustmentsModel> adjustments;

    private CawPropertiesModel        propertiesModel;

    private CawAttributesModel        attributesModel; //BZ25558 added

    private boolean                   isReturn;        //BZ25860

    private int                       rtransLineitmSeq; /*BZ45903*/
    public String getCorrelationKey() {

        return correlationKey;
    }

    public void setCorrelationKey(String correlationKey) {

        this.correlationKey = correlationKey;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public CawSalesPersonModel getSalesPerson() {

        return salesPerson;
    }

    public void setSalesPerson(CawSalesPersonModel salesPerson) {

        this.salesPerson = salesPerson;
    }

    //Begin BZ26735
    public BigDecimal getQuantity() {

        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {

        this.quantity = quantity;
    }

    //End BZ26735
    public String getUnitOfMeasure() {

        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {

        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getUnitListPrice() {

        return unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) {

        this.unitListPrice = unitListPrice;
    }

    public BigDecimal getUnitSellingPrice() {

        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {

        this.unitSellingPrice = unitSellingPrice;
    }

    public String getTaxCode() {

        return taxCode;
    }

    public void setTaxCode(String taxCode) {

        this.taxCode = taxCode;
    }

    public BigDecimal getTaxAmount() {

        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {

        this.taxAmount = taxAmount;
    }

    public BigDecimal getLineTotal() {

        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {

        this.lineTotal = lineTotal;
    }

    public List<CawAdjustmentsModel> getAdjustments() {

        return adjustments;
    }

    public void setAdjustments(List<CawAdjustmentsModel> adjustments) {

        this.adjustments = adjustments;
    }

    public CawPropertiesModel getPropertiesModel() {

        return propertiesModel;
    }

    public void setPropertiesModel(CawPropertiesModel propertiesModel) {

        this.propertiesModel = propertiesModel;
    }

    /**
     * @return the attributesModel
     */
    public CawAttributesModel getAttributesModel() {

        return attributesModel;
    }

    /**
     * @param attributesModel the attributesModel to set
     */
    public void setAttributesModel(CawAttributesModel attributesModel) {

        this.attributesModel = attributesModel;
    }

    //Begin BZ25860
    /**
     * @return the isReturn
     */
    public boolean isReturn() {

        return isReturn;
    }

    /**
     * @param isReturn the isReturn to set
     */
    public void setReturn(boolean isReturn) {

        this.isReturn = isReturn;
    }
    //End BZ25860
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
}
