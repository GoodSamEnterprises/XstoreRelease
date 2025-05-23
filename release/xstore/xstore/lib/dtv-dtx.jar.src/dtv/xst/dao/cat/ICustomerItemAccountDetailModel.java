package dtv.xst.dao.cat;

import dtv.xst.dao.trn.PosTransactionId;
import java.math.BigDecimal;

public interface ICustomerItemAccountDetailModel {
  PosTransactionId createTransactionId();
  
  BigDecimal getUnitPrice();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountDetailModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */