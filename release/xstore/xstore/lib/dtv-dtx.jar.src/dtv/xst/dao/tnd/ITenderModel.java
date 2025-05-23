package dtv.xst.dao.tnd;

import dtv.xst.daocommon.ITenderSelection;

public interface ITenderModel extends ITenderSelection {
  boolean containsAvailCode(String paramString);
  
  String getCurrencyIdRaw();
  
  ITenderOptions getOptions();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\ITenderModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */