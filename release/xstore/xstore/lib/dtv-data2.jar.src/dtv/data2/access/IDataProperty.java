package dtv.data2.access;

import java.math.BigDecimal;
import java.util.Date;

public interface IDataProperty {
  public static final String TYPE_STRING = "STRING";
  
  public static final String TYPE_DATE = "DATE";
  
  public static final String TYPE_DECIMAL = "BIGDECIMAL";
  
  public static final String TYPE_BOOLEAN = "BOOLEAN";
  
  boolean getBooleanValue(boolean paramBoolean);
  
  Date getDateValue();
  
  BigDecimal getDecimalValue();
  
  String getPropertyCode();
  
  Object getPropertyValue();
  
  String getStringValue();
  
  String getType();
  
  void setBooleanValue(boolean paramBoolean);
  
  void setDateValue(Date paramDate);
  
  void setDecimalValue(BigDecimal paramBigDecimal);
  
  void setPropertyValue(Object paramObject);
  
  void setStringValue(String paramString);
  
  void setType(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IDataProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */