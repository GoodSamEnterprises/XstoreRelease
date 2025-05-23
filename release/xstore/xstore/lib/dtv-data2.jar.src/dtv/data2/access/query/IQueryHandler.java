package dtv.data2.access.query;

import dtv.data2.access.impl.IPersistenceStrategy;
import dtv.util.config.IHasSourceDescription;
import java.util.Map;
import java.util.Properties;

public interface IQueryHandler extends IHasSourceDescription {
  Object execute(IPersistenceStrategy paramIPersistenceStrategy, Map<String, Object> paramMap, QueryToken paramQueryToken) throws Exception;
  
  Properties getProperties();
  
  void setProperties(Properties paramProperties);
  
  void setQueryDecorator(ISqlQueryDecorator paramISqlQueryDecorator);
  
  void setSourceDescription(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\IQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */