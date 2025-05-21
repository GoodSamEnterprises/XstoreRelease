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
 * BZ24937          090118    [Prod Support] Disable line item displaying on pinpad
 * BZ26270          290618    New Requirement - Display UPC on both Xstore screens and on receipts
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28407          281118    [Internal] PINPAD doesn't show full items when item has quantity >1
 *===================================================================
 */

package caw.pos.transaction.model;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawCurrentTransactionModel {

    private String              _itemID      = "";

    private String              _qty         = "";

    private String              _unitPrice   = "";

    private String              _extPrice    = "";

    private String              _isVoid      = "";

    private String              _description = "";

    private static final Logger logger_      = Logger.getLogger(CawCurrentTransactionModel.class);

    /**
     * Constructor is be private
     */
    public CawCurrentTransactionModel() {//BZ28407

        this._itemID = "";
    }

    /**
     * BZ27344: moved code of BZ26270
     * @param saleLineItm
     * @return
     */
    public static CawCurrentTransactionModel getNewInstance(ISaleReturnLineItem saleLineItm) {

        CawCurrentTransactionModel model = new CawCurrentTransactionModel();
        try {
            if (saleLineItm != null) {
                model.setCurrentTransStt(saleLineItm.getItemId(), saleLineItm.getQuantity().toString(), saleLineItm
                        .getUnitPrice().toString(), saleLineItm.getBaseExtendedPrice()
                                .toString(), String.valueOf(saleLineItm.getVoid()), saleLineItm.getItemDescription());
            }
        } catch (Exception ex) {
            logger_.error("Error in getNewInstance:" + ex.getMessage());
        }
        return model;
    }

    public void setCurrentTransStt(String itemID, String qty, String unitPrice, String extPrice, String isVoid,
            String desc) {

        setItemID(itemID);
        setQty(qty);
        setUnitPrice(unitPrice);
        setExtPrice(extPrice);
        setIsVoid(isVoid);
        setDescription(desc);
    }

    /**
     * BZ27344 added
     * @param saleLineItm
     */
    public void update(ISaleReturnLineItem saleLineItm) {

        try {
            if (saleLineItm != null) {
                setCurrentTransStt(saleLineItm.getItemId(), saleLineItm.getQuantity().toString(), saleLineItm
                        .getUnitPrice().toString(), saleLineItm.getBaseExtendedPrice()
                                .toString(), String.valueOf(saleLineItm.getVoid()), saleLineItm.getItemDescription());
            }
        } catch (Exception ex) {
            logger_.error("Error in update:" + ex.getMessage());
        }
    }

    /**
     * BZ27344
     * @param updElement
     * @return
     */
    public boolean hasChanged(ISaleReturnLineItem updElement) {

        BigDecimal tmpValue, tmpValueEx, modelValue, modelValueEx;
        try {
            tmpValue = updElement.getUnitPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
            modelValue = new BigDecimal(getUnitPrice()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            tmpValueEx = updElement.getBaseExtendedPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
            modelValueEx = new BigDecimal(getExtPrice()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            if (!updElement.getQuantity().toString().equals(getQty()) || tmpValue.compareTo(modelValue) != 0
                    || tmpValueEx.compareTo(modelValueEx) != 0
                    || !String.valueOf(updElement.getVoid()).equals(getIsVoid())) {
                return true;
            }
        } catch (Exception ex) {
            logger_.error("Error in hasChanged:" + ex.getMessage());
        }

        return false;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {

        return _itemID;
    }

    /**
     * @param argItemID the itemID to set
     */
    public void setItemID(String argItemID) {

        _itemID = argItemID;
    }

    /**
     * @return the qty
     */
    public String getQty() {

        return _qty;
    }

    /**
     * @param argQty the qty to set
     */
    public void setQty(String argQty) {

        _qty = argQty;
    }

    /**
     * @return the unitPrice
     */
    public String getUnitPrice() {

        return _unitPrice;
    }

    /**
     * @param argUnitPrice the unitPrice to set
     */
    public void setUnitPrice(String argUnitPrice) {

        _unitPrice = argUnitPrice;
    }

    /**
     * @return the extPrice
     */
    public String getExtPrice() {

        return _extPrice;
    }

    /**
     * @param argExtPrice the extPrice to set
     */
    public void setExtPrice(String argExtPrice) {

        _extPrice = argExtPrice;
    }

    /**
     * @return the isVoid
     */
    public String getIsVoid() {

        return _isVoid;
    }

    /**
     * @param argIsVoid the isVoid to set
     */
    public void setIsVoid(String argIsVoid) {

        _isVoid = argIsVoid;
    }

    /**
     * @return the description
     */
    public String getDescription() {

        return _description;
    }

    /**
     * @param argDescription the description to set
     */
    public void setDescription(String argDescription) {

        _description = argDescription;
    }
}
