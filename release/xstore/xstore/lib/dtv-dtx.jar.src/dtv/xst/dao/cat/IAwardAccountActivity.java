package dtv.xst.dao.cat;

import java.math.BigDecimal;
import java.util.Date;

public interface IAwardAccountActivity {
  BigDecimal getActivityAmount();
  
  Date getActivityDateTime();
  
  String getAwardTranId();
  
  Date getBusinessDate();
  
  String getComments();
  
  String getCouponId();
  
  String getCreateUser();
  
  String getErrorCode();
  
  BigDecimal getExchangeRate();
  
  String getLocationId();
  
  String getOperatorId();
  
  String getReferencedTranId();
  
  BigDecimal getRequestedAmount();
  
  String getRequestedCurrencyCode();
  
  String getRetailTransactionId();
  
  String getTransactionType();
  
  Date getUpdateDate();
  
  String getUpdateUser();
  
  String getWorkstationId();
  
  boolean isVoidFlag();
  
  void setActivityAmount(BigDecimal paramBigDecimal);
  
  void setActivityDateTime(Date paramDate);
  
  void setAwardTranId(String paramString);
  
  void setBusinessDate(Date paramDate);
  
  void setComments(String paramString);
  
  void setCouponId(String paramString);
  
  void setCreateUser(String paramString);
  
  void setErrorCode(String paramString);
  
  void setExchangeRate(BigDecimal paramBigDecimal);
  
  void setLocationId(String paramString);
  
  void setOperatorId(String paramString);
  
  void setReferencedTranId(String paramString);
  
  void setRequestedAmount(BigDecimal paramBigDecimal);
  
  void setRequestedCurrencyCode(String paramString);
  
  void setRetailTransactionId(String paramString);
  
  void setTransactionType(String paramString);
  
  void setUpdateDate(Date paramDate);
  
  void setUpdateUser(String paramString);
  
  void setVoidFlag(boolean paramBoolean);
  
  void setWorkstationId(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\IAwardAccountActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */