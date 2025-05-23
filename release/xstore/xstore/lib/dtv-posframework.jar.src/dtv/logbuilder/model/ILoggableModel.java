package dtv.logbuilder.model;

import dtv.xst.daocommon.ISystemUser;
import java.util.Date;

public interface ILoggableModel {
  String getAction();
  
  Date getCurrentBusinessDate();
  
  int getRetailLocationId();
  
  Date getSystemDateTimeStamp();
  
  ISystemUser getSystemUser();
  
  int getWorkstationId();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\model\ILoggableModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */