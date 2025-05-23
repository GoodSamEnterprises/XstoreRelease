package dtv.pos.storecalendar;

import java.util.Date;

public interface ICalendarDay {
  Date getDate();
  
  ICalendarDay next() throws DateOutOfRangeException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\ICalendarDay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */