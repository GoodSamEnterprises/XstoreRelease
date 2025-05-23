package dtv.data2.access;

import dtv.data2.IPersistenceDefaults;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public interface IDataAccessObject extends IPersistable, Serializable, Cloneable, IHasObjectId {
  public static final String DAO_ORIGIN = "originDS";
  
  @Deprecated
  public static final int UNDEFINED = 0;
  
  @Deprecated
  public static final int CLEAN = 1;
  
  @Deprecated
  public static final int NEW = 16;
  
  @Deprecated
  public static final int UPDATED = 256;
  
  @Deprecated
  public static final int DELETED = 4096;
  
  @Deprecated
  public static final int INSERT_ONLY = 65536;
  
  @Deprecated
  public static final int INSERT_OR_UPDATE = 1048576;
  
  Object clone() throws CloneNotSupportedException;
  
  Date getCreateDate();
  
  String getCreateUserId();
  
  int getLastObjectState();
  
  IObjectId getObjectId();
  
  int getObjectState();
  
  Long getOrganizationId();
  
  String getOriginDataSource();
  
  Date getUpdateDate();
  
  String getUpdateUserId();
  
  boolean isObjectStateRulesApplied();
  
  boolean isTransientObject();
  
  void revertObjectState();
  
  void setCreateDate(Date paramDate);
  
  void setCreateUserId(String paramString);
  
  void setObjectId(IObjectId paramIObjectId);
  
  void setObjectState(int paramInt);
  
  void setObjectState(String paramString);
  
  void setObjectStateRulesApplied(boolean paramBoolean);
  
  void setOrganizationId(Long paramLong);
  
  void setOriginDataSource(String paramString);
  
  void setPersistenceDefaults(IPersistenceDefaults paramIPersistenceDefaults);
  
  void setTransientObject(boolean paramBoolean);
  
  void setUpdateDate(Date paramDate);
  
  void setUpdateUserId(String paramString);
  
  void setValues(Map<String, String> paramMap);
  
  void suppressStateChanges(boolean paramBoolean);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataAccessObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */