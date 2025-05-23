package dtv.pos.framework.tax;

import java.math.BigDecimal;

public interface ITaxSystemLocation {
  String getCity();
  
  String getCountry();
  
  BigDecimal getFailoverTaxPct();
  
  String getGeoCode();
  
  String getPostalCode();
  
  String getStateCode();
  
  void setCity(String paramString);
  
  void setCountry(String paramString);
  
  void setFailoverTaxPct(BigDecimal paramBigDecimal);
  
  void setGeoCode(String paramString);
  
  void setPostalCode(String paramString);
  
  void setStateCode(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\tax\ITaxSystemLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */