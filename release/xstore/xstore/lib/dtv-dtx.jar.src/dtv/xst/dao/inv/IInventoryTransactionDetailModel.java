package dtv.xst.dao.inv;

import dtv.xst.daocommon.IInventoriedLineItem;
import dtv.xst.daocommon.IInventoryLocationModifier;
import java.util.Date;

public interface IInventoryTransactionDetailModel extends IInventoriedLineItem {
  Date getTransactionDate();
  
  void setOverrideInventoryLocationModifier(IInventoryLocationModifier paramIInventoryLocationModifier);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IInventoryTransactionDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */