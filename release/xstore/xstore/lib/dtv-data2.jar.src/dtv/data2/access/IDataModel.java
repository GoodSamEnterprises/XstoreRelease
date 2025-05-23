package dtv.data2.access;

import dtv.event.IEventSource;
import dtv.util.IReceiptSource;
import java.io.Serializable;
import java.util.Date;

public interface IDataModel extends IQueryResult, IPersistable, IEventSource, Serializable, Cloneable, IReceiptSource {
  void commitTransaction();
  
  Date getCreateDate();
  
  String getCreateUserId();
  
  IObjectId getObjectId();
  
  String getObjectIdAsString();
  
  long getOrganizationId();
  
  Date getUpdateDate();
  
  String getUpdateUserId();
  
  boolean isNew();
  
  void rollbackChanges();
  
  void setCreateDate(Date paramDate);
  
  void setCreateUserId(String paramString);
  
  void setObjectId(IObjectId paramIObjectId);
  
  void setOrganizationId(long paramLong);
  
  void setUpdateDate(Date paramDate);
  
  void setUpdateUserId(String paramString);
  
  void startTransaction();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */