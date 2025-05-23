package dtv.xst.dao.inv;

import dtv.xst.dao.inv.impl.InventoryCountSheetResult;
import java.util.List;

public interface IInventoryCountModel {
  List<InventoryCountSheetResult> getCountSheetResults();
  
  boolean getFinalVariancesAdjusted();
  
  void setCountSheetResults(List<InventoryCountSheetResult> paramList);
  
  void setFinalVariancesAdjusted(boolean paramBoolean);
  
  void updateCountBucket(String paramString1, int paramInt, String paramString2);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryCountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */