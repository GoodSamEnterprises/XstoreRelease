package dtv.data2.access.impl;

import dtv.data2.access.IDataAccessObject;
import dtv.data2.access.IObjectId;
import java.util.List;

public interface IRelationshipAdapter {
  IObjectId getChildObjectId();
  
  List<?> getParameterList();
  
  void setParent(IDataAccessObject paramIDataAccessObject);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IRelationshipAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */