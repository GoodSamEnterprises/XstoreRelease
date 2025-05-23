package dtv.xst.dao.itm;

import dtv.data2.access.IDataModel;
import dtv.xst.dao.crm.IParty;
import dtv.xst.dao.loc.RetailLocationId;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import dtv.xst.dao.trl.IWarrantyLineItem;
import dtv.xst.dao.trn.PosTransactionId;

public interface IWarrantyModel extends IDataModel {
  IItem getCoveredItem();
  
  ISaleReturnLineItem getCoveredLineItem();
  
  IParty getCustomer();
  
  long getPartyId();
  
  RetailLocationId getRetailLocationIdObject();
  
  PosTransactionId getWarrantyIssueTransactionId();
  
  IWarrantyItem getWarrantyItem();
  
  IWarrantyLineItem getWarrantyLineItem();
  
  IWarrantyItem getWarrantyPlan();
  
  void setCoveredItem(IItem paramIItem);
  
  void setCoveredLineItem(ISaleReturnLineItem paramISaleReturnLineItem);
  
  void setCustomer(IParty paramIParty);
  
  void setPartyId(long paramLong);
  
  void setWarrantyItem(IWarrantyItem paramIWarrantyItem);
  
  void setWarrantyLineItem(IWarrantyLineItem paramIWarrantyLineItem);
  
  void setWarrantyPlan(IWarrantyItem paramIWarrantyItem);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarrantyModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */