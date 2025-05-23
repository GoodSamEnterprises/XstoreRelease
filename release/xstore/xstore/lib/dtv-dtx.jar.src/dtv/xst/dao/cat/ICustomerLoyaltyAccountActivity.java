package dtv.xst.dao.cat;

import java.math.BigDecimal;
import java.util.Date;

public interface ICustomerLoyaltyAccountActivity {
  String getAccountActivityId();
  
  BigDecimal getBonusPointsBalance();
  
  Date getBusinessDate();
  
  String getComments();
  
  String getCreateUser();
  
  Date getEarnDate();
  
  BigDecimal getEarnedPointsBalance();
  
  String getErrorCode();
  
  BigDecimal getEscrowPointsBalance();
  
  String getLocationId();
  
  BigDecimal getNumPoints();
  
  String getReferencedTranId();
  
  String getRetailTransactionId();
  
  String getRuleName();
  
  String getTransactionType();
  
  Date getUpdateDate();
  
  String getUpdateUser();
  
  boolean isPendingFlag();
  
  boolean isVoidFlag();
  
  void setAccountActivityId(String paramString);
  
  void setBonusPointsBalance(BigDecimal paramBigDecimal);
  
  void setBusinessDate(Date paramDate);
  
  void setComments(String paramString);
  
  void setCreateUser(String paramString);
  
  void setEarnDate(Date paramDate);
  
  void setEarnedPointsBalance(BigDecimal paramBigDecimal);
  
  void setErrorCode(String paramString);
  
  void setEscrowPointsBalance(BigDecimal paramBigDecimal);
  
  void setLocationId(String paramString);
  
  void setNumPoints(BigDecimal paramBigDecimal);
  
  void setPendingFlag(boolean paramBoolean);
  
  void setReferencedTranId(String paramString);
  
  void setRetailTransactionId(String paramString);
  
  void setRuleName(String paramString);
  
  void setTransactionType(String paramString);
  
  void setUpdateDate(Date paramDate);
  
  void setUpdateUser(String paramString);
  
  void setVoidFlag(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ICustomerLoyaltyAccountActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */