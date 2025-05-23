package dtv.xst.daocommon;

import java.math.BigDecimal;
import java.util.List;

public interface IExchangeRateHelper {
  BigDecimal getExchangeRate(String paramString1, String paramString2, long paramLong);
  
  List<? extends IExchangeRate> getLocalExchangeRates(long paramLong);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IExchangeRateHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */