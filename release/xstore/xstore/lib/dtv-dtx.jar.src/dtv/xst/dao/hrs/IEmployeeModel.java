package dtv.xst.dao.hrs;

import dtv.xst.daocommon.ISystemUser;
import java.util.Date;
import java.util.List;

public interface IEmployeeModel extends ISystemUser {
  void addEmployeePassword(IEmployeePassword paramIEmployeePassword);
  
  boolean isInactive();
  
  boolean isTerminated(Date paramDate);
  
  IEmployeePassword getCurrentPassword();
  
  List<IEmployeePassword> getEmployeePasswords();
  
  byte[] getGroupMembership();
  
  long getOperatorId();
  
  EmployeePasswordId getPasswordId();
  
  boolean isActiveForStore(long paramLong, Date paramDate);
  
  void setGroupMembership(byte[] paramArrayOfbyte);
  
  void setPreferredLocale(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\IEmployeeModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */