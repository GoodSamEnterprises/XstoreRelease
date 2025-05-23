package dtv.data2.access.query;

import java.util.Map;
import java.util.Properties;

public interface IQueryPersistenceStrategy {
  Object execute(Map<String, Object> paramMap, Properties paramProperties);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\IQueryPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */