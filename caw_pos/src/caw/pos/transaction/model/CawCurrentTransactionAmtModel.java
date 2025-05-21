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
 * BZ27344          301018    Pin Pad Performance is slow when item price is updated by a deal/promo or a manual price adjustment
 *===================================================================
 */

package caw.pos.transaction.model;

import java.util.ArrayList;

import dtv.xst.dao.trl.ISaleReturnLineItem;

/**
 *
 */
public class CawCurrentTransactionAmtModel {

    private ArrayList<CawCurrentTransactionModel> _items    = new ArrayList<CawCurrentTransactionModel>();

    private String                                _transAmt = "";

    private String                                _transTax = "";

    /**
     * 
     */
    public CawCurrentTransactionAmtModel() {

        super();
    }

    /**
     * BZ27344 added
     */
    public boolean add(CawCurrentTransactionModel model) {

        return _items.add(model);
    }

    /**
     * BZ27344 added
     */
    public boolean add(CawCurrentTransactionModel model, String sAmountDue,
            String sTaxAmount) {

        setTotalAmt(sAmountDue, sTaxAmount);
        return add(model);
    }

    /**
     * BZ27344 added
     */
    public boolean add(ISaleReturnLineItem saleLineItem, String sAmountDue,
            String sTaxAmount) {

        CawCurrentTransactionModel model;
        model = CawCurrentTransactionModel.getNewInstance(saleLineItem);
        return add(model, sAmountDue, sTaxAmount);
    }

    /**
     * BZ27344 added
     */
    public void clear() {

        _transAmt = "";
        _transTax = "";
        _items.clear();
    }

    /**
     * BZ27344 added
     */
    public boolean isEmpty() {

        return (_items == null || _items.size() == 0);
    }

    /**
     * BZ27344 added
     */
    public int size() {

        if (_items != null) {
            return _items.size();
        } else {
            return 0;
        }
    }

    /**
     * BZ27344 added
     */
    public CawCurrentTransactionModel get(int index) {

        return _items.get(index);
    }

    /**
     * BZ27344 added
     */
    public boolean hasChanged(String argTransAmt, String argTransTax) {

        if (!argTransAmt.equalsIgnoreCase(getTransAmt())
                || !argTransTax.equalsIgnoreCase(getTransTax())) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param argTransAmt
     * @param argTransTax
     */
    public void setTotalAmt(String argTransAmt, String argTransTax) {

        _transAmt = argTransAmt;
        _transTax = argTransTax;
    }

    /**
     * @return the transTax
     */
    public String getTransTax() {

        return _transTax;
    }

    /**
     * @param argTransTax the transTax to set
     */
    public void setTransTax(String argTransTax) {

        _transTax = argTransTax;
    }

    /**
     * @return the transAmt
     */
    public String getTransAmt() {

        return _transAmt;
    }

    /**
     * @param argTransAmt the transAmt to set
     */
    public void setTransAmt(String argTransAmt) {

        _transAmt = argTransAmt;
    }
}
