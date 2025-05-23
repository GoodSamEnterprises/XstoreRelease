package dtv.xst.dao.ttr;

import dtv.util.crypto.EncString;
import java.util.Date;
import java.util.List;

public interface ICreditDebitTenderLineItemModel extends IAuthorizableTenderLineItem {
  public static final String ACCOUNT_HASHER_ID = "CreditDebitTenderLineItem.accountNumber";
  
  public static final String MASK_ACCT_NBR_PROP_CODE = "MASKED_ACCOUNT_NUMBER";
  
  String getEftLinkRequestType();
  
  String getMiscellaneousData();
  
  List getReceiptLines();
  
  void setEftLinkRequestType(String paramString);
  
  void setMiscellaneousData(String paramString);
  
  void setReceiptLines(List paramList);
  
  void clearTokenInformation();
  
  String getAccountNumber();
  
  String getAccountNumberEncrypted();
  
  String getAdditionalPinSecurityInfo();
  
  String getBinNumber();
  
  String getCid();
  
  String getEncryptedPin();
  
  Date getExpirationDate();
  
  String getExpirationDateString();
  
  String getExpirationDateStringEncrypted();
  
  boolean getImprint();
  
  String getMaskAccountNumberDao();
  
  EncString getTrack1();
  
  EncString getTrack2();
  
  EncString getTrack3();
  
  void setAccountNumber(String paramString);
  
  void setAdditionalPinSecurityInfo(EncString paramEncString);
  
  void setAdditionalPinSecurityInfo(String paramString);
  
  void setBinNumber(String paramString);
  
  void setCid(EncString paramEncString);
  
  @Deprecated
  void setCid(String paramString);
  
  void setEncryptedPin(EncString paramEncString);
  
  @Deprecated
  void setEncryptedPin(String paramString);
  
  void setExpirationDateString(String paramString);
  
  void setImprint(boolean paramBoolean);
  
  void setMaskAccountNumberDao(String paramString);
  
  void setTrack1(EncString paramEncString);
  
  @Deprecated
  void setTrack1(String paramString);
  
  void setTrack2(EncString paramEncString);
  
  @Deprecated
  void setTrack2(String paramString);
  
  void setTrack3(EncString paramEncString);
  
  @Deprecated
  void setTrack3(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ICreditDebitTenderLineItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */