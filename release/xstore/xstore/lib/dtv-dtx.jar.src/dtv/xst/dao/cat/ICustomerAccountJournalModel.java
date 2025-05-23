package dtv.xst.dao.cat;

import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.PosTransactionId;

public interface ICustomerAccountJournalModel {
  void copyTo(ICustomerAccountJournal paramICustomerAccountJournal);
  
  PosTransactionId createTransactionId();
  
  IParty getParty();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerAccountJournalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */