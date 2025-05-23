package dtv.xst.dao.cat;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IAwardAccountModel {
  BigDecimal getAccountBalance();
  
  BigDecimal getAvailableAwardBalance();
  
  String getType();
  
  void setAvailableAwardBalance(BigDecimal paramBigDecimal);
  
  void addAwardAccountActivity(IAwardAccountActivity paramIAwardAccountActivity);
  
  Collection<? extends IAwardAccountCoupon> getAffectedAwards();
  
  List<? extends IAwardAccountActivity> getAwardAccountActivity();
  
  String getAwardTransactionId();
  
  void setAffectedAwards(Collection<IAwardAccountCoupon> paramCollection);
  
  void setAwardAccountActivity(List<? extends IAwardAccountActivity> paramList);
  
  void setAwardTransactionId(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IAwardAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */