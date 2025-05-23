package dtv.xst.dao.cat;

import dtv.data2.access.IDataModel;
import java.math.BigDecimal;
import java.util.List;

public interface ICustomerItemAccountModel extends ICustomerAccountModel {
  List<? extends IDataModel> getCustItemAccountDetailsFiltered(String paramString);
  
  int getOpenItemCount();
  
  BigDecimal getRoundedAmount();
  
  void setOpenItemCount(int paramInt);
  
  void setRoundedAmount(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */