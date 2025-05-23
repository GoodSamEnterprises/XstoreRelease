package dtv.data2.access.impl.jdbc;

import dtv.data2.access.IDataAccessObject;
import dtv.data2.access.IObjectId;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IJDBCTableAdapter {
  void fill(IDataAccessObject paramIDataAccessObject);
  
  void fill(IJDBCTableAdapter paramIJDBCTableAdapter);
  
  String getSelectWhere();
  
  Object[] getWhereParameters();
  
  int[] getWhereParameterTypes();
  
  String[] getDelete();
  
  IFiller getFiller();
  
  String getImplementingClass();
  
  String[] getInsert();
  
  Object[][] getInsertParameters();
  
  int[][] getInsertParameterTypes();
  
  IObjectId getObjectId();
  
  String getSelect();
  
  String getTableName();
  
  String[] getUpdate();
  
  Object[][] getUpdateParameters();
  
  int[][] getUpdateParameterTypes();
  
  String getWhere();
  
  boolean isExtensible();
  
  IDataAccessObject loadDAO(IDataAccessObject paramIDataAccessObject);
  
  IDataAccessObject loadDefaultDAO();
  
  PreparedStatement writeObjectId(IObjectId paramIObjectId, PreparedStatement paramPreparedStatement) throws SQLException;
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\IJDBCTableAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */