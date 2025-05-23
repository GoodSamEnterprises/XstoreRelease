package dtv.xst.dao.cat;

import dtv.xst.dao.crm.IParty;
import java.util.List;

public interface ICustomerAccountModel {
  List<? extends ICustomerAccountJournal> getLatestJournals();
  
  IParty getParty();
  
  void restoreFromJournal(ICustomerAccountJournal paramICustomerAccountJournal);
  
  void saveToJournal(ICustomerAccountJournal paramICustomerAccountJournal);
  
  void setParty(IParty paramIParty);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */