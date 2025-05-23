package dtv.pos.iframework.validation;

import dtv.util.Money;
import java.math.BigDecimal;

public interface IValidationData {
  BigDecimal getBigDecimal();
  
  double getDouble();
  
  int getInt();
  
  Money getMoney();
  
  Object getObject();
  
  Object[] getObjectArray();
  
  String getString();
  
  Object[] getSuppliedData();
  
  ValidationDataType getType();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\validation\IValidationData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */