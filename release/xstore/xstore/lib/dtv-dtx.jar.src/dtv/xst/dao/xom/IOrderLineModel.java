package dtv.xst.dao.xom;

import dtv.xst.dao.inv.IShipperMethod;

public interface IOrderLineModel extends IShadowsSaleItem, IOrderDetail {
  String getTaxType();
  
  void setTaxType(String paramString);
  
  IShipperMethod getActualShipMethodObject();
  
  ILocateItemData getLocateItemData();
  
  IShipperMethod getSelectedShipMethodObject();
  
  void setLocateItemData(ILocateItemData paramILocateItemData);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\IOrderLineModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */