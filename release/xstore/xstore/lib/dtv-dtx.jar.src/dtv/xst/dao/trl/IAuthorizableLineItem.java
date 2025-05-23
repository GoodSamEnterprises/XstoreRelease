package dtv.xst.dao.trl;

import java.math.BigDecimal;

public interface IAuthorizableLineItem extends IRetailTransactionLineItem {
  String getAdjudicationCode();
  
  BigDecimal getAmount();
  
  String getAuthorizationCode();
  
  String getAuthorizationMethodCode();
  
  String getAuthorizationToken();
  
  String getBankReferenceNumber();
  
  String getEntryMethodCode();
  
  String getLineDescription();
  
  String getSerialNumber();
  
  String getTraceNumber();
  
  String getTransactionReferenceData();
  
  void setAdjudicationCode(String paramString);
  
  void setAuthorizationCode(String paramString);
  
  void setAuthorizationMethodCode(String paramString);
  
  void setAuthorizationToken(String paramString);
  
  void setBankReferenceNumber(String paramString);
  
  void setEntryMethodCode(String paramString);
  
  void setSerialNumber(String paramString);
  
  void setTraceNumber(String paramString);
  
  void setTransactionReferenceData(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IAuthorizableLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */