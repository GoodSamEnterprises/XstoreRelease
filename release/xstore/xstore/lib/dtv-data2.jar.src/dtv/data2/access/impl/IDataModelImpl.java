package dtv.data2.access.impl;

import dtv.data2.IPersistenceDefaults;
import dtv.data2.access.IDataAccessObject;
import dtv.data2.access.IDataModel;
import dtv.event.EventManager;
import java.util.Set;

public interface IDataModelImpl extends IDataModel {
  Set<?> getAndClearDeletedObjects();
  
  IDataAccessObject getDAO();
  
  Object getThis();
  
  Object getValue(String paramString);
  
  Object getValueSafe(String paramString);
  
  void setDAO(IDataAccessObject paramIDataAccessObject);
  
  void setDependencies(IPersistenceDefaults paramIPersistenceDefaults, EventManager paramEventManager);
  
  void setValue(String paramString, Object paramObject);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IDataModelImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */