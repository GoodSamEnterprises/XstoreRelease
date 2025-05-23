package dtv.xst.dao.trl;

import java.math.BigDecimal;

public interface IRetailPriceModifierModel extends ISaleReturnLineItemChild {
  IDiscountLineItem getDiscountLineItem();
  
  String getDisplayDescription();
  
  String getItemId();
  
  BigDecimal getPercentForRcpt();
  
  BigDecimal getPreviousPrice();
  
  String getVendor();
  
  boolean isFromVerifiedReturn();
  
  void setFromVerifiedReturn(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IRetailPriceModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */