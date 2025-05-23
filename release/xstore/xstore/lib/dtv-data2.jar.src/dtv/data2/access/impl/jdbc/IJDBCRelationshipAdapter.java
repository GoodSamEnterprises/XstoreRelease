package dtv.data2.access.impl.jdbc;

import dtv.data2.access.impl.IRelationshipAdapter;

public interface IJDBCRelationshipAdapter extends IRelationshipAdapter {
  String getSelect();
  
  boolean isOrgHierarchyJoinRequired();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\IJDBCRelationshipAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */