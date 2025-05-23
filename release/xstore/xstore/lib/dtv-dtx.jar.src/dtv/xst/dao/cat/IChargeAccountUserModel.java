package dtv.xst.dao.cat;

import dtv.data2.access.IDataModel;
import dtv.xst.dao.crm.IParty;

public interface IChargeAccountUserModel extends IDataModel {
  IParty getParty();
  
  void setParty(IParty paramIParty);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IChargeAccountUserModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */