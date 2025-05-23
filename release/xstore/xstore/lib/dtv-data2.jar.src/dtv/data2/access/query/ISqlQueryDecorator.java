package dtv.data2.access.query;

import dtv.data2.access.IObjectId;
import dtv.data2.access.impl.IPersistenceStrategy;
import java.util.Map;

public interface ISqlQueryDecorator {
  String decorateSql(String paramString, IPersistenceStrategy paramIPersistenceStrategy, IObjectId paramIObjectId);
  
  String decorateSql(String paramString, IPersistenceStrategy paramIPersistenceStrategy, Map<String, Object> paramMap);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\ISqlQueryDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */