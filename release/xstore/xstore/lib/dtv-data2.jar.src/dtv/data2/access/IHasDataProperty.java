package dtv.data2.access;

import java.math.BigDecimal;
import java.util.Date;

public interface IHasDataProperty<T extends IDataProperty> {
  boolean deleteProperty(String paramString);
  
  boolean getBooleanProperty(String paramString);
  
  boolean getBooleanProperty(String paramString, boolean paramBoolean);
  
  Date getDateProperty(String paramString);
  
  Date getDateProperty(String paramString, Date paramDate);
  
  BigDecimal getDecimalProperty(String paramString);
  
  BigDecimal getDecimalProperty(String paramString, BigDecimal paramBigDecimal);
  
  T getProperty(String paramString);
  
  String getStringProperty(String paramString);
  
  String getStringProperty(String paramString1, String paramString2);
  
  String getType(String paramString);
  
  void setBooleanProperty(String paramString, boolean paramBoolean);
  
  void setDateProperty(String paramString, Date paramDate);
  
  void setDecimalProperty(String paramString, BigDecimal paramBigDecimal);
  
  void setStringProperty(String paramString1, String paramString2);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IHasDataProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */