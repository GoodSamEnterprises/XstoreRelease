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
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 * BZ28401          211118    [Internal] Item displayed twice on PINPAD screen when adding a discount to the item
 *===================================================================
 */

package caw.tenderauth.impl.eigen;

/**
 *
 */
public class CawPinpadItemModel implements Cloneable {

    private String                    _itemID       = "";

    private String                    _qty          = "";

    private String                    _unitPrice    = "";

    private String                    _extPrice     = "";

    private String                    _isVoid       = "";

    private String                    _description  = "";

    private String                    _sAmountDue;

    private String                    _sTaxAmount;

    private Integer                   _saleLineSequence;

    private String                    _currentQty   = "";

    private CawPinpadItemModelCommand _pinpadItemModelCommand;

    /* Begin BZ28401 */
    private String                    _unitPriceOld = "";
    /* End BZ28401 */

    /**
     * @return the pinpadItemModelCommand
     */
    public CawPinpadItemModelCommand getPinpadItemModelCommand() {

        return _pinpadItemModelCommand;
    }

    /**
     * @param argPinpadItemModelCommand the pinpadItemModelCommand to set
     */
    public void setPinpadItemModelCommand(
            CawPinpadItemModelCommand argPinpadItemModelCommand) {

        _pinpadItemModelCommand = argPinpadItemModelCommand;
    }

    /**
     * @return the saleLineSequence
     */
    public Integer getSaleLineSequence() {

        return _saleLineSequence;
    }

    /**
     * @param argSaleLineSequence the saleLineSequence to set
     */
    public void setSaleLineSequence(Integer argSaleLineSequence) {

        _saleLineSequence = argSaleLineSequence;
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

    /**
     * @return the sAmountDue
     */
    public String getsAmountDue() {

        return _sAmountDue;
    }

    /**
     * @param argSAmountDue the sAmountDue to set
     */
    public void setsAmountDue(String argSAmountDue) {

        _sAmountDue = argSAmountDue;
    }

    /**
     * @return the sTaxAmount
     */
    public String getsTaxAmount() {

        return _sTaxAmount;
    }

    /**
     * @param argSTaxAmount the sTaxAmount to set
     */
    public void setsTaxAmount(String argSTaxAmount) {

        _sTaxAmount = argSTaxAmount;
    }

    /**
     * @return the currentQty
     */
    public String getCurrentQty() {

        return _currentQty;
    }

    /**
     * @param argCurrentQty the currentQty to set
     */
    public void setCurrentQty(String argCurrentQty) {

        _currentQty = argCurrentQty;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    /* Begin BZ28401 */
    /**
     * @return the unitPriceOld
     */
    public String getUnitPriceOld() {

        return _unitPriceOld;
    }

    /**
     * @param argUnitPriceOld the unitPriceOld to set
     */
    public void setUnitPriceOld(String argUnitPriceOld) {

        _unitPriceOld = argUnitPriceOld;
    }
    /* End BZ28401 */

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("");
        if (_itemID != null) {
            builder.append("Item Id:");
            builder.append(_itemID);
        }

        if (_description != null) {
            builder.append(", Description:");
            builder.append(_description);
        }

        if (_pinpadItemModelCommand != null) {
            builder.append(", Command:");
            builder.append(_pinpadItemModelCommand);
        }

        if (_extPrice != null) {
            builder.append(", ExtPrice:");
            builder.append(_extPrice);
        }

        if (_unitPrice != null) {
            builder.append(", Unit Price:");
            builder.append(_unitPrice);
        }

        if (_sAmountDue != null) {
            builder.append(", _Amount Due:");
            builder.append(_sAmountDue);
        }

        if (_sTaxAmount != null) {
            builder.append(", Tax Amount:");
            builder.append(_sTaxAmount);
        }

        return builder.toString();
    }

}
