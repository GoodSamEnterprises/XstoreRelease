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
 * BZ42307          200921    [Requirement] Add ability to reject at the item level for BOPIS
 *===================================================================
 */

package caw.pos.order.maint;

import java.math.BigDecimal;

import dtv.i18n.IFormattable;
import dtv.i18n.OutputContextType;
import dtv.pos.framework.form.BasicEditModel;
import dtv.xst.dao.xom.IOrderLine;

public class CawOrderItemUpdateQtyModel extends BasicEditModel {

    private String     _message;

    private BigDecimal _quantity;

    public CawOrderItemUpdateQtyModel(String msgKey, IOrderLine argOrderLine) {

        super(FF.getTranslatable("_enterquantity"), null);
        this._message = FF.getTranslatable(msgKey, new IFormattable[] { FF.getLiteral(argOrderLine.getItemId())
                , FF.getSimpleFormattable(argOrderLine.getItem().getDescription())
                , FF.getLiteral(argOrderLine.getQuantity()) }).toString(OutputContextType.VIEW);
        this.addField("message", String.class, 10);
        this.addField("quantity", Integer.class);
        this.initializeFieldState();
    }

    public String getMessage() {

        return this._message;
    }

    public BigDecimal getQuantity() {

        return this._quantity;
    }

    public void setQuantity(Integer argQuantity) {

        this._quantity = new BigDecimal(argQuantity);
    }

    public void setQuantity(BigDecimal argQuantity) {

        this._quantity = argQuantity;
    }
}
