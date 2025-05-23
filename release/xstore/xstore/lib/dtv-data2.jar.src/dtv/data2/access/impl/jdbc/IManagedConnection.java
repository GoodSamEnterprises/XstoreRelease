package dtv.data2.access.impl.jdbc;

import dtv.data2.access.transaction.TransactionToken;

public interface IManagedConnection {
  TransactionToken getAssociatedTransaction();
  
  void setAssociatedTransaction(TransactionToken paramTransactionToken);
  
  void setMyManager(JDBCDataSourceMgr paramJDBCDataSourceMgr);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\IManagedConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */