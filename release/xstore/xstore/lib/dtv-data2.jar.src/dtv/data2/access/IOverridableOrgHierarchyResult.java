package dtv.data2.access;

public interface IOverridableOrgHierarchyResult extends IQueryResult {
  IObjectId getFilteringObjectId();
  
  String getLevelCode();
  
  String getLevelValue();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IOverridableOrgHierarchyResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */