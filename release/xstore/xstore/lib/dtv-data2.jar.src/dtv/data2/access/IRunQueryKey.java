package dtv.data2.access;

import java.util.Map;

public interface IRunQueryKey extends IPersistable {
  Map<String, Object> getParams();
  
  IQueryKey<?> getQueryKey();
  
  void setParams(Map<String, Object> paramMap);
  
  void setQueryKey(IQueryKey<?> paramIQueryKey);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IRunQueryKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */