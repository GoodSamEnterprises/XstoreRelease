package dtv.xst.dao.cat;

import dtv.xst.dao.crm.IParty;

public interface IEscrowAccountModel {
  IParty getParty();
  
  void setParty(IParty paramIParty);
  
  void updateAccountBalance();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IEscrowAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */