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
 * BZ37912          021020    Shipping Fee is being applied to the line item vs transaction level
 * 
 *===================================================================
 */

package caw.pos.order;

import java.math.BigDecimal;

/**
 *
 */
public class CawShippingItemsModel {

    private BigDecimal quantity;

    private String     itemCode;

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {

        return quantity;
    }

    /**
     * @param argQuantity the quantity to set
     */
    public void setQuantity(BigDecimal argQuantity) {

        quantity = argQuantity;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {

        return itemCode;
    }

    /**
     * @param argItemCode the itemCode to set
     */
    public void setItemCode(String argItemCode) {

        itemCode = argItemCode;
    }
}
