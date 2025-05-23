package dtv.pos.iframework.form;

import dtv.data2.access.IDataModel;
import dtv.xst.daocommon.ISystemUser;
import java.util.List;

public interface IListFieldElementDescr {
  void addInstance(IEditModel paramIEditModel, List<IDataModel> paramList);
  
  IEditModelFieldMetadata<?>[] getFieldMetadata();
  
  void setUser(ISystemUser paramISystemUser);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IListFieldElementDescr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */