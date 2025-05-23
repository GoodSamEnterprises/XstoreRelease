package dtv.xst.dao.cwo;

import dtv.data2.access.IDataModel;
import dtv.xst.dao.itm.ItemId;
import dtv.xst.dao.loc.RetailLocationId;

public interface IWorkItemModel extends IDataModel {
  ItemId getItemIdObject();
  
  RetailLocationId getRetailLocationIdObject();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\IWorkItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */