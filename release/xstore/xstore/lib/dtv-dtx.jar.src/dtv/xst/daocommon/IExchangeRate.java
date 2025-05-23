package dtv.xst.daocommon;

import java.math.BigDecimal;

public interface IExchangeRate {
  String getBaseCurrency();
  
  BigDecimal getExchangeRate();
  
  String getTargetCurrency();
  
  void setBaseCurrency(String paramString);
  
  void setExchangeRate(BigDecimal paramBigDecimal);
  
  void setTargetCurrency(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IExchangeRate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */