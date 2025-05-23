package dtv.data2.access.impl;

import dtv.data2.access.IDataModel;
import dtv.data2.access.IDataModelRelationship;
import dtv.data2.access.IObjectId;
import dtv.data2.access.IPersistable;
import dtv.data2.access.query.QueryToken;
import dtv.data2.access.transaction.TransactionToken;
import java.util.Map;
import java.util.Properties;

public interface IPersistenceStrategy {
  boolean checkExistence(IObjectId paramIObjectId, QueryToken paramQueryToken);
  
  boolean equivalentDataSources(IPersistenceStrategy paramIPersistenceStrategy);
  
  IObjectId getChildObjectIdForRelationship(IDataModelRelationship paramIDataModelRelationship);
  
  String getDataSourceName();
  
  IDataModel getObjectById(IObjectId paramIObjectId, QueryToken paramQueryToken);
  
  Object getObjectByQuery(String paramString, Map<String, Object> paramMap, QueryToken paramQueryToken);
  
  Object getObjectByRelationship(IDataModelRelationship paramIDataModelRelationship, QueryToken paramQueryToken);
  
  Properties getProperties();
  
  boolean isFullGraphPersisted();
  
  boolean isFullGraphProvided();
  
  boolean isOnlineStrategyType();
  
  void makePersistent(TransactionToken paramTransactionToken, IPersistable paramIPersistable);
  
  void setDataSourceName(String paramString);
  
  void setOnlineStrategyType(boolean paramBoolean);
  
  void setProperties(Properties paramProperties);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */