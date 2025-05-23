package dtv.data2.access.query;

import dtv.data2.access.IQueryResult;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IResultFilter {
  Collection<? extends IQueryResult> filter(List<? extends IQueryResult> paramList, Map<String, Object> paramMap);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\IResultFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */