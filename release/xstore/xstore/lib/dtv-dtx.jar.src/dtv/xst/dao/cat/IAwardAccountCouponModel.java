package dtv.xst.dao.cat;

import java.math.BigDecimal;

public interface IAwardAccountCouponModel extends IHasExpirationDate {
  BigDecimal getRedeemAmount();
  
  String getType();
  
  void setRedeemAmount(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IAwardAccountCouponModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */