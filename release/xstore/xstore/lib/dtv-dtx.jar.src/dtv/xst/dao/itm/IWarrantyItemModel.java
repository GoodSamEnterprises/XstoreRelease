package dtv.xst.dao.itm;

import java.math.BigDecimal;

public interface IWarrantyItemModel extends INonPhysicalItem {
  BigDecimal getComputedPriceAmt();
  
  void setComputedPriceAmt(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\IWarrantyItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */