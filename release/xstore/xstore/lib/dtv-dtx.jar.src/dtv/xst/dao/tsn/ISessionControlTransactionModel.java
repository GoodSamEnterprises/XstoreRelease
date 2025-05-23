package dtv.xst.dao.tsn;

import dtv.xst.dao.trn.IPosTransaction;

public interface ISessionControlTransactionModel extends IPosTransaction {
  ISession getSession();
  
  ISessionWorkstation getSessionWorkstation();
  
  String getTypeCode();
  
  void setSession(ISession paramISession);
  
  void setSessionWorkstation(ISessionWorkstation paramISessionWorkstation);
  
  void setTypeCode(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\ISessionControlTransactionModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */