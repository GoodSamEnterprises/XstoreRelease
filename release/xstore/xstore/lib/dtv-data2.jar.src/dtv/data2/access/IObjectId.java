package dtv.data2.access;

import java.io.Serializable;

public interface IObjectId extends IHasGenericProperties, Serializable {
  public static final String IGNORE_ORG_HIERARCHY_FILTERING = "IGNORE_ORG_HIERARCHY_FILTERING";
  
  public static final String IGNORE_CONFIG_ELEMENT_FILTERING = "IGNORE_CONFIG_ELEMENT_FILTERING";
  
  String getDtxTypeName();
  
  Long getOrganizationId();
  
  void setOrganizationId(Long paramLong);
  
  void setValue(String paramString);
  
  boolean validate();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IObjectId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */