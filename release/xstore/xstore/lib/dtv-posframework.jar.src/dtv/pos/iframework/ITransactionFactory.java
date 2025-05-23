package dtv.pos.iframework;

import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.trn.IPosTransaction;

public interface ITransactionFactory {
  public static final String SEQ_TYPE_TRANSACTION = "TRANSACTION";
  
  <T extends IPosTransaction> T createTransaction(ITransactionType<T> paramITransactionType, IParty paramIParty);
  
  void resumeTransaction(IPosTransaction paramIPosTransaction);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\ITransactionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */