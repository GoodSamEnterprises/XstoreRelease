package dtv.data2.access;

import dtv.data2.access.config.query.QueryDescriptor;
import dtv.data2.access.query.IQueryHandler;
import dtv.data2.access.status.IStatusMgr;

public interface IDataFactory {
  <T extends IDataModel> T createNewObject(IObjectId paramIObjectId, Class<T> paramClass);
  
  IPersistenceMgr getPersistenceMgr();
  
  QueryDescriptor getQueryDescriptor(String paramString);
  
  IQueryHandler getQueryHandler(String paramString);
  
  IStatusMgr getStatusMgr();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */