package dtv.xst.daocommon;

import dtv.xst.dao.itm.IItem;
import dtv.xst.dao.xom.IOrderModifier;
import java.math.BigDecimal;
import java.util.List;

public interface IInventoriedLineItem {
  void addInventoryLocationModifier(IInventoryLocationModifier paramIInventoryLocationModifier);
  
  List<? extends IInventoryLocationModifier> getAllInventoryLocationModifiers();
  
  IInventoryAccountModifier getInventoryAccountModifier();
  
  IItem getItem();
  
  String getItemId();
  
  int getLineItemSequence();
  
  List<? extends IInventoryLocationModifier> getNewInventoryLocationModifiers();
  
  IOrderModifier getOrderModifier();
  
  BigDecimal getQuantityToAllocate();
  
  String getReturnReasonCode();
  
  boolean isIncomingInventoryProcessed();
  
  void removeInventoryLocationModifier(IInventoryLocationModifier paramIInventoryLocationModifier);
  
  void setIncomingInventoryProcessed(boolean paramBoolean);
  
  void setQuantityToAllocate(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IInventoriedLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */