package dtv.data2.access;

import java.util.List;

public interface IDataPropertyParent<T extends IDataProperty> {
  List<T> getProperties();
  
  void setProperties(List<T> paramList);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataPropertyParent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */