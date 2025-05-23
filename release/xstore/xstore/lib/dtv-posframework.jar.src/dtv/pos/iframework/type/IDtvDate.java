package dtv.pos.iframework.type;

import dtv.i18n.IFormattable;
import java.io.Serializable;
import java.util.Date;

public interface IDtvDate extends Serializable {
  Date getDate();
  
  Date getDate(Date paramDate);
  
  IFormattable getDescription();
  
  boolean isRelative();
  
  String toExternalForm();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\IDtvDate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */