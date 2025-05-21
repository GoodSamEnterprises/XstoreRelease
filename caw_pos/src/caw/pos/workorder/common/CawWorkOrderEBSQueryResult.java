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
 * BZ26207          190718    New Requirement - Enable Work Order Functionalitys
 * BZ30754          160519    [PORT 30531 to 5.0] [Prod] Unable to complete the WO if WO deposit is created in xstore offline mode
 *===================================================================
 */

package caw.pos.workorder.common;

import java.math.BigDecimal;
import java.util.*;

import dtv.data2.access.*;
import dtv.pos.customer.account.type.CustomerAccountType;
import dtv.xst.query.results.CustAccountSearchResult;

/**
 *
 */
public class CawWorkOrderEBSQueryResult extends CustAccountSearchResult {

    /**
     * 
     */
    private static final long      serialVersionUID         = -3832748678959079111L;

    private String                 _woCustomerAccountNumber = null;

    private Date                   _woDateTime              = null;

    private String                 _woNumber                = null;

    private String                 _woStatus                = null;

    private String                 _woFirstProduct          = null;

    private String                 _woType                  = null;

    private String                 _woPosStatus             = null;

    private String                 _woPosStatusDescription  = null;

    private boolean                _woHasDeposit            = false;

    private BigDecimal             _woDepositAmt            = BigDecimal.ZERO;

    private BigDecimal             _woTotalTax              = BigDecimal.ZERO;

    private BigDecimal             _woTotalWithTax          = BigDecimal.ZERO;

    private BigDecimal             _woShippingAmt           = BigDecimal.ZERO;

    private String                 _woDescription           = null;

    private String                 _woCorrelationKey        = null;

    private List<CawWorkOrderItem> _woItems                 = new ArrayList<CawWorkOrderItem>();

    /**
     * @return the woCustomerAccountNumber
     */
    public String getWoCustomerAccountNumber() {
        return _woCustomerAccountNumber;
    }

    /**
     * @param argWoCustomerAccountNumber the woCustomerAccountNumber to set
     */
    public void setWoCustomerAccountNumber(String argWoCustomerAccountNumber) {
        _woCustomerAccountNumber = argWoCustomerAccountNumber;
    }

    /**
     * @return the woType
     */
    public String getWoType() {

        return _woType;
    }

    /**
     * @param argWoType the woType to set
     */
    public void setWoType(String argWoType) {

        _woType = argWoType;
    }

    /**
     * @return the woPosStatus
     */
    public String getWoPosStatus() {

        return _woPosStatus;
    }

    /**
     * @param argWoPosStatus the woPosStatus to set
     */
    public void setWoPosStatus(String argWoPosStatus) {

        _woPosStatus = argWoPosStatus;
    }

    /**
     * @return the woPosStatusDescription
     */
    public String getWoPosStatusDescription() {

        return _woPosStatusDescription;
    }

    /**
     * @param argWoPosStatusDescription the woPosStatusDescription to set
     */
    public void setWoPosStatusDescription(String argWoPosStatusDescription) {

        _woPosStatusDescription = argWoPosStatusDescription;
    }

    /**
     * @return the woHasDeposit
     */
    public boolean isWoHasDeposit() {

        return _woHasDeposit;
    }

    /**
     * @param argWoHasDeposit the woHasDeposit to set
     */
    public void setWoHasDeposit(boolean argWoHasDeposit) {

        _woHasDeposit = argWoHasDeposit;
    }

    /**
     * @return the woTotalTax
     */
    public BigDecimal getWoTotalTax() {

        return _woTotalTax;
    }

    /**
     * @param argWoTotalTax the woTotalTax to set
     */
    public void setWoTotalTax(BigDecimal argWoTotalTax) {

        _woTotalTax = argWoTotalTax;
    }

    /**
     * @return the woShippingAmt
     */
    public BigDecimal getWoShippingAmt() {
        return _woShippingAmt;
    }

    /**
     * @param argWoShippingAmt the woShippingAmt to set
     */
    public void setWoShippingAmt(BigDecimal argWoShippingAmt) {
        _woShippingAmt = argWoShippingAmt;
    }

    /**
     * @return the woDescription
     */
    public String getWoDescription() {

        return _woDescription;
    }

    /**
     * @param argWoDescription the woDescription to set
     */
    public void setWoDescription(String argWoDescription) {

        _woDescription = argWoDescription;
    }

    /**
     * @return the woDateTime
     */
    public Date getWoDateTime() {

        return _woDateTime;
    }

    /**
     * @param argWoDateTime the woDateTime to set
     */
    public void setWoDateTime(Date argWoDateTime) {

        _woDateTime = argWoDateTime;
    }

    /**
     * @return the woNumber
     */
    public String getWoNumber() {

        return _woNumber;
    }

    /**
     * @param argWoNumber the woNumber to set
     */
    public void setWoNumber(String argWoNumber) {

        _woNumber = argWoNumber;
    }

    /**
     * @return the woStatus
     */
    public String getWoStatus() {

        return _woStatus;
    }

    /**
     * @param argWoStatus the woStatus to set
     */
    public void setWoStatus(String argWoStatus) {

        _woStatus = argWoStatus;
    }

    /**
     * @return the woFirstProduct
     */
    public String getWoFirstProduct() {

        return _woFirstProduct;
    }

    /**
     * @param argWoFirstProduct the woFirstProduct to set
     */
    public void setWoFirstProduct(String argWoFirstProduct) {

        _woFirstProduct = argWoFirstProduct;
    }

    /**
     * @return the woCorrelationKey
     */
    public String getWoCorrelationKey() {
        return _woCorrelationKey;
    }

    /**
     * @param argWoCorrelationKey the woCorrelationKey to set
     */
    public void setWoCorrelationKey(String argWoCorrelationKey) {
        _woCorrelationKey = argWoCorrelationKey;
    }

    /**
     * @return the woItems
     */
    public List<CawWorkOrderItem> getWoItems() {
        return _woItems;
    }

    /**
     * @param argWoItems the woItems to set
     */
    public void setWoItems(List<CawWorkOrderItem> argWoItems) {
        _woItems = argWoItems;
    }

    /**
     * @return the woTotalWithTax
     */
    public BigDecimal getWoTotalWithTax() {
        return _woTotalWithTax;
    }

    /**
     * @param argWoTotalWithTax the woTotalWithTax to set
     */
    public void setWoTotalWithTax(BigDecimal argWoTotalWithTax) {
        _woTotalWithTax = argWoTotalWithTax;
    }

    /**
     * @return the woDepositAmt
     */
    public BigDecimal getWoDepositAmt() {
        return _woDepositAmt;
    }

    /**
     * @param argWoDepositAmt the woDepositAmt to set
     */
    public void setWoDepositAmt(BigDecimal argWoDepositAmt) {
        _woDepositAmt = argWoDepositAmt;
    }

    /* BEGIN BZ30754
     * Change strategy for retrieving WO data
     * @see dtv.xst.query.results.CustAccountSearchResult#getPopulatedObject()
     */
    public IDataModel getPopulatedObject(CustomerAccountType accountType, IPersistenceMgrType argPmType) {

        //
        if (accountType.equals(CustomerAccountType.WORK_ORDER)) {
            if (_populatedObject != null) {
                return _populatedObject;
            } else {
                try {
                    Object obj = DataFactory.getObjectById(getObjectId(), argPmType);
                    if (obj != null && obj instanceof IDataModel) {
                        this._populatedObject = (IDataModel) obj;
                    }
                    return obj != null ? (IDataModel) obj : null;
                } catch (ObjectNotFoundException var2) {
                    return null;
                }
            }
        }
        //
        return super.getPopulatedObject();
    }
    /*END BZ30754*/
}
