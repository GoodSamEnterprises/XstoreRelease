package dtv.data2.replication;

import dtv.data2.access.IPersistable;
import dtv.data2.access.transaction.ITransactionalDataSource;
import dtv.data2.access.transaction.TransactionToken;
import java.util.List;

public interface IReplicationStrategy extends ITransactionalDataSource {
  boolean isReplicationCandidate(String paramString, Object paramObject, List<String> paramList);
  
  void replicateData(String paramString, TransactionToken paramTransactionToken, IPersistable paramIPersistable, List<String> paramList);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\IReplicationStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */