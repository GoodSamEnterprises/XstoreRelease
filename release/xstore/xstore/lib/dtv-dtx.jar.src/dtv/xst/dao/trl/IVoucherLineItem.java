package dtv.xst.dao.trl;

import dtv.util.crypto.EncString;
import dtv.xst.dao.ttr.IVoucher;
import java.math.BigDecimal;
import java.util.Date;

public interface IVoucherLineItem extends IAuthorizableLineItem {
  String getActivityCode();
  
  EncString getCid();
  
  Date getEffectiveDate();
  
  Date getExpirationDate();
  
  BigDecimal getFaceValueAmount();
  
  Date getIssueDatetimestamp();
  
  String getIssueTypeCode();
  
  EncString getTrack1();
  
  EncString getTrack2();
  
  EncString getTrack3();
  
  BigDecimal getUnspentBalanceAmount();
  
  IVoucher getVoucher();
  
  String getVoucherStatusCode();
  
  String getVoucherTypeCode();
  
  void setActivityCode(String paramString);
  
  void setCid(EncString paramEncString);
  
  @Deprecated
  void setCid(String paramString);
  
  void setEffectiveDate(Date paramDate);
  
  void setExpirationDate(Date paramDate);
  
  void setFaceValueAmount(BigDecimal paramBigDecimal);
  
  void setIssueDatetimestamp(Date paramDate);
  
  void setIssueTypeCode(String paramString);
  
  void setTrack1(EncString paramEncString);
  
  @Deprecated
  void setTrack1(String paramString);
  
  void setTrack2(EncString paramEncString);
  
  @Deprecated
  void setTrack2(String paramString);
  
  void setTrack3(EncString paramEncString);
  
  @Deprecated
  void setTrack3(String paramString);
  
  void setUnspentBalanceAmount(BigDecimal paramBigDecimal);
  
  void setVoucher(IVoucher paramIVoucher);
  
  void setVoucherStatusCode(String paramString);
  
  void setVoucherTypeCode(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\IVoucherLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */