package dtv.xst.daocommon;

import java.util.Date;
import java.util.List;

public interface IInventoriedItemTransaction {
  Date getBusinessDate();
  
  List<? extends IInventoriedLineItem> getInventoriedLineItems();
  
  long getOrganizationId();
  
  long getRetailLocationId();
  
  long getTransactionSequence();
  
  long getWorkstationId();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IInventoriedItemTransaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */