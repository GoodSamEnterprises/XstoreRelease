package dtv.xst.dao.inv;

import java.math.BigDecimal;

public interface IShipmentLineItemModel extends IHasDocumentId {
  void commitTemp();
  
  IInventoryDocumentLineItem getInventoryLineItem();
  
  BigDecimal getTempShipQuantity();
  
  String getTempStatusCode();
  
  void setTempShipQuantity(BigDecimal paramBigDecimal);
  
  void setTempStatusCode(String paramString);
  
  void startTemp();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IShipmentLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */