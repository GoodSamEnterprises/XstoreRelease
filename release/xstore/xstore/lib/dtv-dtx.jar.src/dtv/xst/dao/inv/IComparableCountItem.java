package dtv.xst.dao.inv;

import java.math.BigDecimal;

public interface IComparableCountItem {
  String getAlternateId();
  
  int getCountCycle();
  
  String getDescription();
  
  String getInventoryBucketId();
  
  String getInventoryCountId();
  
  String getItemId();
  
  BigDecimal getQuantity();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IComparableCountItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */