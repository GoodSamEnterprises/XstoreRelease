package dtv.xst.dao.cat;

import java.math.BigDecimal;
import java.util.List;

public interface ICustomerLoyaltyAccountModel extends IHasExpirationDate {
  void addLoyaltyAccountActivity(ICustomerLoyaltyAccountActivity paramICustomerLoyaltyAccountActivity);
  
  List<? extends ICustomerLoyaltyAccountActivity> getLoyaltyAccountActivity();
  
  BigDecimal getProformaAccountBonusPoints();
  
  BigDecimal getProformaAccountEarnedPoints();
  
  BigDecimal getProformaAccountEscrowPoints();
  
  BigDecimal getProformaTransactionBonusPoints();
  
  BigDecimal getProformaTransactionEarnedPoints();
  
  BigDecimal getProformaTransactionEscrowPoints();
  
  String getType();
  
  void setLoyaltyAccountActivity(List<? extends ICustomerLoyaltyAccountActivity> paramList);
  
  void setProformaAccountBonusPoints(BigDecimal paramBigDecimal);
  
  void setProformaAccountEarnedPoints(BigDecimal paramBigDecimal);
  
  void setProformaAccountEscrowPoints(BigDecimal paramBigDecimal);
  
  void setProformaTransactionBonusPoints(BigDecimal paramBigDecimal);
  
  void setProformaTransactionEarnedPoints(BigDecimal paramBigDecimal);
  
  void setProformaTransactionEscrowPoints(BigDecimal paramBigDecimal);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerLoyaltyAccountModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */