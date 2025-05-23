package dtv.xst.dao.sec;

import dtv.data2.access.IDataModel;

public interface IAclAccessTypeModel extends IDataModel {
  byte[] getGroupMembership();
  
  void setGroupMembership(byte[] paramArrayOfbyte);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\IAclAccessTypeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */