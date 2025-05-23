package dtv.data2.access.transaction;

public interface ITransactionalDataSource {
  void commitPhase1(TransactionToken paramTransactionToken);
  
  void commitPhase2(TransactionToken paramTransactionToken);
  
  String getDataSourceName();
  
  void rollback(TransactionToken paramTransactionToken);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\transaction\ITransactionalDataSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */