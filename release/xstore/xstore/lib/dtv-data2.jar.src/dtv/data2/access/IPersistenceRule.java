package dtv.data2.access;

import dtv.data2.access.impl.PersistableMetaData;
import dtv.util.config.IConfigObject;

public interface IPersistenceRule {
  IPersistable applyRule(PersistableMetaData paramPersistableMetaData, Object paramObject);
  
  boolean isApplicable(PersistableMetaData paramPersistableMetaData, Object paramObject);
  
  void setParameter(String paramString, IConfigObject paramIConfigObject);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IPersistenceRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */