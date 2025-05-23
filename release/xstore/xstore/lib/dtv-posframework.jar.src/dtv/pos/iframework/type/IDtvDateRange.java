package dtv.pos.iframework.type;

import dtv.i18n.IFormattable;
import dtv.util.DateRange;
import java.io.Serializable;
import java.util.Date;

public interface IDtvDateRange extends Serializable {
  DateRange getDateRange();
  
  DateRange getDateRange(boolean paramBoolean);
  
  DateRange getDateRange(Date paramDate);
  
  DateRange getDateRange(Date paramDate, boolean paramBoolean);
  
  IFormattable getDescription();
  
  Date getEndDate();
  
  Date getEndDate(boolean paramBoolean);
  
  Date getEndDate(Date paramDate);
  
  Date getEndDate(Date paramDate, boolean paramBoolean);
  
  Date getStartDate();
  
  Date getStartDate(Date paramDate);
  
  boolean isRelative();
  
  String toExternalForm();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\type\IDtvDateRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */