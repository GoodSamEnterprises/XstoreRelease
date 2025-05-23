package dtv.xst.dao.sec;

import oracle.retail.xstore.passwd.IUserDetails;

public interface IUserPasswordModel extends IUserDetails {
  void setPasswordFailureLifeSpanInMinutes(int paramInt);
  
  void setPasswordLifeSpanInDays(int paramInt);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IUserPasswordModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */