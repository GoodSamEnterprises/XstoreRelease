package dtv.data2.access;

import java.util.List;

public interface IQueryResultList<T> extends List<T> {
  long getQueryLimit();
  
  Class<T> getResultClass();
  
  boolean isQueryLimitReached();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IQueryResultList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */