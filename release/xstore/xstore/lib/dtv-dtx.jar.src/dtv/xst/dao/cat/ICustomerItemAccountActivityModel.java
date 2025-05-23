package dtv.xst.dao.cat;

import dtv.xst.dao.trn.PosTransactionId;

public interface ICustomerItemAccountActivityModel {
  void copyTo(ICustomerItemAccountActivity paramICustomerItemAccountActivity);
  
  PosTransactionId createTransactionId();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerItemAccountActivityModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */