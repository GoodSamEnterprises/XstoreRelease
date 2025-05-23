package dtv.pos.iframework.visibilityrules;

import dtv.xst.dao.trl.IRetailTransactionLineItem;

public interface ILineItemTester {
  boolean evaluateEndOfList();
  
  boolean testLineItem(IRetailTransactionLineItem paramIRetailTransactionLineItem);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\visibilityrules\ILineItemTester.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */