package dtv.xst.dao.tax;

import dtv.data2.access.IDataModel;
import java.math.BigDecimal;
import java.util.Date;

public interface ITaxRule extends IDataModel {
  boolean doesTaxRuleApply(BigDecimal paramBigDecimal);
  
  boolean doesTaxRuleApply(Date paramDate);
  
  BigDecimal getAmount();
  
  String getBreakPointTypeCode();
  
  Date getDailyEndTime();
  
  Date getDailyStartTime();
  
  Date getEffectiveDatetimestamp();
  
  Date getExpirationDatetimestamp();
  
  long getOrganizationId();
  
  BigDecimal getPercent();
  
  String getTaxBracketId();
  
  String getTaxGroupId();
  
  String getTaxLocationId();
  
  BigDecimal getTaxRateMaxTaxableAmount();
  
  BigDecimal getTaxRateMinTaxableAmount();
  
  int getTaxRateRuleSequence();
  
  int getTaxRuleSequence();
  
  void setAmount(BigDecimal paramBigDecimal);
  
  void setBreakPointTypeCode(String paramString);
  
  void setDailyEndTime(Date paramDate);
  
  void setDailyStartTime(Date paramDate);
  
  void setEffectiveDatetimestamp(Date paramDate);
  
  void setExpirationDatetimestamp(Date paramDate);
  
  void setOrganizationId(long paramLong);
  
  void setPercent(BigDecimal paramBigDecimal);
  
  void setTaxBracketId(String paramString);
  
  void setTaxGroupId(String paramString);
  
  void setTaxLocationId(String paramString);
  
  void setTaxRateMaxTaxableAmount(BigDecimal paramBigDecimal);
  
  void setTaxRateMinTaxableAmount(BigDecimal paramBigDecimal);
  
  void setTaxRateRuleSequence(int paramInt);
  
  void setTaxRuleSequence(int paramInt);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\ITaxRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */