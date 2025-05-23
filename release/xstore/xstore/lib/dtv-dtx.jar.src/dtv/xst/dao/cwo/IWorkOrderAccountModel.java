package dtv.xst.dao.cwo;

import dtv.xst.dao.cat.ICustomerItemAccountModel;
import java.math.BigDecimal;
import java.util.List;

public interface IWorkOrderAccountModel extends ICustomerItemAccountModel {
  void addWorkItems(List<IWorkItem> paramList);
  
  int getOpenWorkItemCount();
  
  List<IWorkItem> getOpenWorkItems();
  
  BigDecimal getTotalValue();
  
  void setOpenWorkItemCount(int paramInt);
  
  void setTotalValue(BigDecimal paramBigDecimal);
  
  void updateTotalValue();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkOrderAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */