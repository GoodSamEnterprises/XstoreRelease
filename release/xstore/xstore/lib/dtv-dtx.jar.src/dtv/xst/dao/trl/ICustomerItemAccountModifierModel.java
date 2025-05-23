package dtv.xst.dao.trl;

import dtv.xst.dao.cat.CustomerAccountId;
import dtv.xst.daocommon.IInventoryAccountModifier;

public interface ICustomerItemAccountModifierModel extends ISaleReturnLineItemChild, IInventoryAccountModifier {
  CustomerAccountId getCustomerAccountIdObject();
  
  void setIdValuesByObject(RetailTransactionLineItemId paramRetailTransactionLineItemId);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\ICustomerItemAccountModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */