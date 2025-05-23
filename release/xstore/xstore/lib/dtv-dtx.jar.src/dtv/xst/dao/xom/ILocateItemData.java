package dtv.xst.dao.xom;

import dtv.util.distance.Distance;
import java.math.BigDecimal;

public interface ILocateItemData {
  String getCity();
  
  String getCountry();
  
  Distance getDistance();
  
  BigDecimal getDistanceMagnitude();
  
  String getOrderType();
  
  String getPostalCode();
  
  String getState();
  
  void setCity(String paramString);
  
  void setCountry(String paramString);
  
  void setDistanceMagnitude(BigDecimal paramBigDecimal);
  
  void setOrderType(String paramString);
  
  void setPostalCode(String paramString);
  
  void setState(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\ILocateItemData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */