package dtv.logbuilder.model;

import dtv.xst.dao.trn.IPosTransaction;
import dtv.xst.daocommon.ISystemUser;
import java.util.List;

public interface IOverrideModel extends ILoggableModel {
  ISystemUser getOverridingUser();
  
  List<String> getPrivileges();
  
  IPosTransaction getRelatedTransaction();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\model\IOverrideModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */