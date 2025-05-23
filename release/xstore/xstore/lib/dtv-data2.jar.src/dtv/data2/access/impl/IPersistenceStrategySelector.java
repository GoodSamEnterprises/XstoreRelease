package dtv.data2.access.impl;

import dtv.data2.access.IObjectId;
import dtv.data2.access.IPersistable;
import dtv.data2.access.transaction.TransactionToken;
import java.util.Map;
import java.util.Properties;

public interface IPersistenceStrategySelector {
  IPersistenceStrategy getPersistenceStrategy();
  
  boolean acceptGetObjectById(IObjectId paramIObjectId);
  
  boolean acceptGetObjectByQuery(String paramString, Map<String, Object> paramMap);
  
  boolean acceptMakePersistent(TransactionToken paramTransactionToken, IPersistable paramIPersistable);
  
  void setProperties(Properties paramProperties);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IPersistenceStrategySelector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */