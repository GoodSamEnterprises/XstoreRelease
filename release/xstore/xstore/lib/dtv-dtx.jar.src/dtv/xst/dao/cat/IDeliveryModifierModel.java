package dtv.xst.dao.cat;

import dtv.util.IName;
import dtv.util.address.IMutableAddress;
import dtv.xst.dao.inv.IShipperMethod;

public interface IDeliveryModifierModel extends IMutableAddress, IName {
  IShipperMethod getShippingMethodObject();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IDeliveryModifierModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */