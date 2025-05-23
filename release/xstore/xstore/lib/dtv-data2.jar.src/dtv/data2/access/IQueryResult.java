package dtv.data2.access;

import java.io.Serializable;

public interface IQueryResult extends IHasObjectId, Serializable {
  String getDataSource();
  
  void setDataSource(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */