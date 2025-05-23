package dtv.data2.access.impl;

import dtv.data2.access.IDataAccessObject;

public interface IExtensibleDataAccessObjectImpl extends IDataAccessObject {
  String getImplementingClass();
  
  void setClassName(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IExtensibleDataAccessObjectImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */