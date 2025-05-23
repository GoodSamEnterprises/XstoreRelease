package dtv.data2.access.impl;

import dtv.data2.access.IObjectId;
import dtv.data2.access.IPersistable;
import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
import dtv.data2.access.impl.jdbc.JDBCCall;
import java.util.List;

public interface IJDBCPersistenceStrategy extends IPersistenceStrategy {
  String getConnectionUrl();
  
  List<JDBCCall> getJDBCCallData(IPersistable paramIPersistable);
  
  IJDBCTableAdapter getTableAdapter(Class<?> paramClass);
  
  IJDBCTableAdapter getTableAdapter(IObjectId paramIObjectId);
  
  IJDBCTableAdapter getTableAdapter(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\IJDBCPersistenceStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */