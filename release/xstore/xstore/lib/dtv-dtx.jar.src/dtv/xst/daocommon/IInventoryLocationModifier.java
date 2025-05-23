package dtv.xst.daocommon;

import java.math.BigDecimal;

public interface IInventoryLocationModifier {
  String getActionCode();
  
  String getDestinationBucketId();
  
  String getDestinationLocationId();
  
  String getItemId();
  
  BigDecimal getQuantity();
  
  String getSerialNumber();
  
  String getSourceBucketId();
  
  String getSourceLocationId();
  
  void setActionCode(String paramString);
  
  void setDestinationBucketId(String paramString);
  
  void setDestinationLocationId(String paramString);
  
  void setItemId(String paramString);
  
  void setQuantity(BigDecimal paramBigDecimal);
  
  void setSerialNumber(String paramString);
  
  void setSourceBucketId(String paramString);
  
  void setSourceLocationId(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IInventoryLocationModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */