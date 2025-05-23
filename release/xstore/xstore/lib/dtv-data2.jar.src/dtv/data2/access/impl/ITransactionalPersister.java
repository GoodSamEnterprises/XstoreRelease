package dtv.data2.access.impl;

import dtv.data2.access.IPersistable;
import dtv.data2.access.transaction.ITransactionalDataSource;
import dtv.data2.access.transaction.TransactionToken;

public interface ITransactionalPersister extends ITransactionalDataSource {
  void prepareForPersistence(TransactionToken paramTransactionToken, IPersistable paramIPersistable);
  
  void setDataSourceName(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\ITransactionalPersister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */