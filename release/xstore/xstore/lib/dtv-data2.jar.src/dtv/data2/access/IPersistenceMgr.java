package dtv.data2.access;

import dtv.data2.access.exception.PersistenceException;
import dtv.data2.access.transaction.TransactionToken;
import java.util.List;
import java.util.Map;

public interface IPersistenceMgr {
  void cleanup();
  
  IDataModel getObjectById(IObjectId paramIObjectId, IPersistenceMgrType paramIPersistenceMgrType) throws ObjectNotFoundException;
  
  Object getObjectByQuery(String paramString, Map<String, Object> paramMap, IPersistenceMgrType paramIPersistenceMgrType) throws ObjectNotFoundException;
  
  <T> T makePersistent(T paramT, long paramLong) throws PersistenceException;
  
  void replicateData(TransactionToken paramTransactionToken, String paramString, IPersistable paramIPersistable, List<String> paramList);
  
  void setReplicationEnabled(boolean paramBoolean);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IPersistenceMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */