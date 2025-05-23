package dtv.xst.daocommon;

import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.hrs.IEmployeeAnswers;
import dtv.xst.dao.hrs.IWorkCodes;
import dtv.xst.dao.sec.IGroup;
import java.util.Date;
import java.util.List;

public interface ISystemUser {
  boolean getClockedIn();
  
  boolean getClockInNotRequired();
  
  List<IEmployeeAnswers> getEmployeeAnswers();
  
  byte[] getGroupMembership();
  
  boolean getLockedOut();
  
  Date getLockedOutTimestamp();
  
  long getOperatorId();
  
  IParty getOperatorParty();
  
  String getPreferredLocale();
  
  IGroup getPrimaryGroup();
  
  IWorkCodes getWorkCode();
  
  boolean isClockedIn();
  
  boolean isLockedOut();
  
  void setClockedIn(boolean paramBoolean);
  
  void setLockedOut(boolean paramBoolean);
  
  void setLockedOutTimestamp(Date paramDate);
  
  void setWorkCode(IWorkCodes paramIWorkCodes);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\ISystemUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */