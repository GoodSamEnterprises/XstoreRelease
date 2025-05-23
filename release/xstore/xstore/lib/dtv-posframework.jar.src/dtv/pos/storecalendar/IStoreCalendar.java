package dtv.pos.storecalendar;

import dtv.util.DateRange;
import java.util.Date;

public interface IStoreCalendar {
  public static final int YEAR = 200;
  
  public static final int QUARTER = 201;
  
  public static final int MONTH = 202;
  
  public static final int WEEK = 203;
  
  public static final int DAY = 204;
  
  public static final int DAY_OF_MONTH = 205;
  
  public static final int DAY_OF_WEEK = 206;
  
  Date add(Date paramDate, int paramInt1, int paramInt2) throws DateOutOfRangeException;
  
  int get(int paramInt, Date paramDate) throws StoreCalendarException;
  
  @Deprecated
  int getBusinessDateYear(Date paramDate);
  
  DateRange getDateRange(int paramInt1, Date paramDate1, int paramInt2, Date paramDate2) throws StoreCalendarException;
  
  DateRange[] getDateRanges(int paramInt1, Date paramDate, int paramInt2, int paramInt3) throws StoreCalendarException;
  
  DateRange[] getDateRanges(int paramInt1, Date paramDate, int paramInt2, int paramInt3, boolean paramBoolean) throws StoreCalendarException;
  
  int getFirstDayOfWeek();
  
  int getLastDayOfWeek();
  
  int getMonthsInYear(int paramInt) throws DateOutOfRangeException;
  
  Date getNextOpenDate(Date paramDate, int paramInt) throws DateOutOfRangeException;
  
  Date getStartOfYear(int paramInt) throws DateOutOfRangeException;
  
  DateRange getWeek(int paramInt1, int paramInt2, Date paramDate) throws DateOutOfRangeException;
  
  DateRange getWeeklyDateRange(Date paramDate) throws StoreCalendarException;
  
  DateRange[] getWeeklyDateRange(Date paramDate, int paramInt) throws StoreCalendarException;
  
  DateRange[] getWeeklyDateRange(Date paramDate, int paramInt, boolean paramBoolean) throws StoreCalendarException;
  
  int getWeeksInYear(int paramInt) throws DateOutOfRangeException;
  
  @Deprecated
  void init();
  
  boolean isBusinessDateSettable();
  
  boolean isChangeBusinessDateAllowed();
  
  boolean isScheduledCloseDate(Date paramDate, int paramInt);
  
  boolean preferOpenOnCurrentSystemDate();
  
  void validateNewBusinessDate(Date paramDate1, Date paramDate2) throws DateOutOfRangeException, OperationRestrictedException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\IStoreCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */