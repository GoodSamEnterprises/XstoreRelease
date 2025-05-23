package dtv.xst.dao.itm;

import dtv.data2.access.IDataModel;
import java.math.BigDecimal;

public interface IAttachedItemsModel extends IDataModel {
  BigDecimal getAttachedItemPrice();
  
  void setAttachedItemPrice(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IAttachedItemsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */