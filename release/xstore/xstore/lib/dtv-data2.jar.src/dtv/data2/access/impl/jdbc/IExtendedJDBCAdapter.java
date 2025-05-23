package dtv.data2.access.impl.jdbc;

public interface IExtendedJDBCAdapter extends IJDBCTableAdapter {
  IFiller[] getAllFillers();
  
  String[] getAllSelects();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\IExtendedJDBCAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */