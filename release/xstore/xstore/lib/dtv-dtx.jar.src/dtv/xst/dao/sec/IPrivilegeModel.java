package dtv.xst.dao.sec;

import dtv.data2.access.IDataModel;

public interface IPrivilegeModel extends IDataModel {
  byte[] getGroupMembership();
  
  byte[] getSecondPromptGroupMembership();
  
  void setGroupMembership(byte[] paramArrayOfbyte);
  
  void setSecondPromptGroupMembership(byte[] paramArrayOfbyte);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IPrivilegeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */