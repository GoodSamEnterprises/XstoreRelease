/*     */ package dtv.pos.storecalendar;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.xst.query.results.CloseDateSearchResult;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public abstract class AbstractStoreCalendar
/*     */   implements IStoreCalendar {
/*  21 */   private static final Logger logger_ = Logger.getLogger(AbstractStoreCalendar.class);
/*  22 */   private static final IQueryKey<CloseDateSearchResult> LOC_CLOSE_DATES = (IQueryKey<CloseDateSearchResult>)new QueryKey("LOC_CLOSE_DATES", CloseDateSearchResult.class);
/*     */   private final int lastDayOfWeek_;
/*     */   
/*     */   protected static int getLastDayOfWeek(int argFirstDayOfWeek) {
/*  26 */     return makeValidDayOfWeek(argFirstDayOfWeek - 1);
/*     */   }
/*     */   
/*     */   private static int makeValidDayOfWeek(int argDayOfWeek) {
/*  30 */     if (argDayOfWeek < 1) {
/*  31 */       return argDayOfWeek + 7;
/*     */     }
/*  33 */     if (argDayOfWeek > 7) {
/*  34 */       return argDayOfWeek - 7;
/*     */     }
/*     */     
/*  37 */     return argDayOfWeek;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  42 */   private final ThreadLocal<Calendar> cal_ = new ThreadLocal<Calendar>()
/*     */     {
/*     */       protected synchronized Calendar initialValue() {
/*  45 */         return Calendar.getInstance();
/*     */       }
/*     */     };
/*     */   
/*     */   protected AbstractStoreCalendar(int argLastDayOfWeek) {
/*  50 */     this.lastDayOfWeek_ = argLastDayOfWeek;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date add(Date argStartingDate, int argIndex, int argAmount) throws DateOutOfRangeException {
/*     */     CalendarField field;
/*  59 */     int amount = argAmount;
/*     */     
/*  61 */     switch (argIndex) {
/*     */       case 204:
/*  63 */         field = CalendarField.DAY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  89 */         return DateUtils.dateAdd(field, amount, argStartingDate);case 202: field = CalendarField.MONTH; return DateUtils.dateAdd(field, amount, argStartingDate);case 203: field = CalendarField.DAY; amount *= 7; return DateUtils.dateAdd(field, amount, argStartingDate);case 201: field = CalendarField.MONTH; amount *= 3; return DateUtils.dateAdd(field, amount, argStartingDate);case 200: field = CalendarField.YEAR; return DateUtils.dateAdd(field, amount, argStartingDate);
/*     */     } 
/*     */     String msg = "Unknown index [" + argIndex + "]";
/*     */     logger_.error(msg);
/*     */     throw new IllegalArgumentException(msg);
/*     */   }
/*     */   
/*     */   public int get(int argField, Date argDate) throws StoreCalendarException {
/*  97 */     int result = -1;
/*  98 */     if (argDate != null) {
/*  99 */       Calendar cal = this.cal_.get();
/* 100 */       cal.setTime(argDate);
/* 101 */       switch (argField) {
/*     */         case 200:
/* 103 */           return cal.get(1);
/*     */         case 201:
/* 105 */           return cal.get(2) / 3 + 1;
/*     */         case 202:
/* 107 */           return cal.get(2) + 1;
/*     */         case 203:
/* 109 */           return cal.get(3);
/*     */         case 204:
/* 111 */           return cal.get(6);
/*     */         case 205:
/* 113 */           return cal.get(5);
/*     */         case 206:
/* 115 */           return cal.get(7);
/*     */       } 
/* 117 */       throw new IllegalArgumentException("unable to get index for field request " + argField);
/*     */     } 
/*     */     
/* 120 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getBusinessDateYear(Date argBusinessDate) {
/* 131 */     return DateUtils.getYear(argBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(int argField, Date argDate, int argOffset, Date argCurrentBusinessDate) throws StoreCalendarException {
/* 140 */     return DateRangeHelper.getDateRange(this, argField, argDate, argOffset, argCurrentBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange[] getDateRanges(int argField, Date argDate, int argOffset, int argQuantity) throws StoreCalendarException {
/* 147 */     return getDateRanges(argField, argDate, argOffset, argQuantity, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange[] getDateRanges(int argField, Date argDate, int argOffset, int argQuantity, boolean argEndOfDay) throws StoreCalendarException {
/* 156 */     int absQuantity = Math.abs(argQuantity);
/* 157 */     int sign = (argQuantity < 0) ? -1 : 1;
/* 158 */     DateRange[] results = new DateRange[absQuantity];
/* 159 */     for (int i = 0; i < absQuantity; i++) {
/* 160 */       results[i] = getDateRange(argField, argDate, argOffset + sign * i, argDate);
/* 161 */       if (argEndOfDay) {
/* 162 */         results[i] = results[i].toEndOfDay();
/*     */       }
/*     */     } 
/* 165 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstDayOfWeek() {
/* 171 */     return getFirstDayOfWeek(getLastDayOfWeek());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastDayOfWeek() {
/* 177 */     return this.lastDayOfWeek_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMonthsInYear(int argYear) throws DateOutOfRangeException {
/* 184 */     Calendar cal = this.cal_.get();
/* 185 */     cal.set(1, argYear);
/* 186 */     return cal.getMaximum(2) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Date getNextOpenDate(Date argCurrentBusinessDate, int argRetailLocationId) throws DateOutOfRangeException {
/* 196 */     ICalendarDay day = getCalendarDay(argCurrentBusinessDate).next();
/* 197 */     while (isScheduledCloseDate(day.getDate(), argRetailLocationId)) {
/* 198 */       day = day.next();
/*     */     }
/* 200 */     return day.getDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartOfYear(int argYear) throws DateOutOfRangeException {
/* 215 */     Calendar cal = this.cal_.get();
/* 216 */     cal.set(1, argYear);
/* 217 */     cal.set(6, 1);
/* 218 */     return DateUtils.clearTime(cal.getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getWeek(int argYear, int argWeek, Date argCurrentBusinessDate) throws DateOutOfRangeException {
/* 226 */     Calendar cal = this.cal_.get();
/* 227 */     cal.set(1, argYear);
/* 228 */     cal.set(3, argWeek);
/* 229 */     cal.set(7, getLastDayOfWeek());
/* 230 */     if (getLastDayOfWeek() == 1) {
/* 231 */       cal.set(3, argWeek + 1);
/*     */     }
/*     */     
/* 234 */     if (getLastDayOfWeek() == 1 && DateUtils.getDayOfWeek(argCurrentBusinessDate) == 1) {
/* 235 */       cal.set(3, argWeek);
/*     */     }
/*     */     
/* 238 */     Date end = cal.getTime();
/* 239 */     Date start = DateUtils.dateAdd(CalendarField.DAY, -6, end);
/*     */     
/* 241 */     return new DateRange(start, end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getWeeklyDateRange(Date argDate) throws StoreCalendarException {
/* 248 */     return getDateRange(203, argDate, 0, argDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange[] getWeeklyDateRange(Date argDate, int argQuantity) throws StoreCalendarException {
/* 255 */     return getWeeklyDateRange(argDate, argQuantity, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange[] getWeeklyDateRange(Date argDate, int argQuantity, boolean argEndOfDay) throws StoreCalendarException {
/* 262 */     return getDateRanges(203, argDate, 0, argQuantity, argEndOfDay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWeeksInYear(int argYear) throws DateOutOfRangeException {
/* 270 */     Calendar cal = Calendar.getInstance();
/* 271 */     cal.set(1, argYear);
/*     */     
/* 273 */     return cal.getMaximum(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void init() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBusinessDateSettable() {
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChangeBusinessDateAllowed() {
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isScheduledCloseDate(Date argDate, int argRetailLocationId) {
/*     */     IQueryResultList iQueryResultList;
/* 300 */     boolean closeDate = false;
/*     */     
/* 302 */     Map<String, Object> params = new HashMap<>();
/* 303 */     params.put("argCloseDate", argDate);
/* 304 */     params.put("argRetailLocId", Long.valueOf(argRetailLocationId));
/*     */     
/* 306 */     List<CloseDateSearchResult> results = null;
/*     */     try {
/* 308 */       iQueryResultList = DataFactory.getObjectByQuery(LOC_CLOSE_DATES, params);
/*     */     }
/* 310 */     catch (ObjectNotFoundException ex) {
/* 311 */       closeDate = false;
/*     */     } 
/*     */     
/* 314 */     if (iQueryResultList != null) {
/* 315 */       for (CloseDateSearchResult r : iQueryResultList) {
/* 316 */         Date nextDate = r.getCloseDate();
/* 317 */         if (DateUtils.isSameDay(nextDate, argDate)) {
/* 318 */           closeDate = true;
/*     */         }
/*     */       } 
/*     */     }
/* 322 */     return closeDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validateNewBusinessDate(Date argBusinessDate, Date argCurrentBusinessDate) throws DateOutOfRangeException, OperationRestrictedException {
/* 329 */     if (argBusinessDate == null) {
/* 330 */       throw new DateOutOfRangeException("Cannot accept business date of NULL.");
/*     */     }
/* 332 */     Date currentBusinessDate = argCurrentBusinessDate;
/* 333 */     if (currentBusinessDate != null) {
/* 334 */       if (argBusinessDate.before(currentBusinessDate)) {
/* 335 */         throw new DateOutOfRangeException("Cannot open a day previous to the last open day.");
/*     */       }
/*     */       
/* 338 */       Date yearFromLastOpen = DateUtils.dateAdd(CalendarField.YEAR, 1, currentBusinessDate);
/* 339 */       if (yearFromLastOpen.before(argBusinessDate)) {
/* 340 */         throw new DateOutOfRangeException("Cannot open a day more than one year in advance of the system date.");
/*     */       }
/*     */ 
/*     */       
/* 344 */       if (DateUtils.isSameDay(currentBusinessDate, argBusinessDate) && !getAllowSameDayStoreReopen())
/*     */       {
/* 346 */         throw new DateOutOfRangeException("Cannot re-open for the same business day.");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean getAllowSameDayStoreReopen() {
/* 352 */     return true;
/*     */   }
/*     */   
/*     */   protected ICalendarDay getCalendarDay(Date argCurrentBusinessDate) {
/* 356 */     return new BasicCalendarDay(argCurrentBusinessDate);
/*     */   }
/*     */   
/*     */   protected int getFirstDayOfWeek(int argLastDayOfWeek) {
/* 360 */     return makeValidDayOfWeek(argLastDayOfWeek + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class BasicCalendarDay
/*     */     implements ICalendarDay
/*     */   {
/*     */     private final Date _date;
/*     */ 
/*     */ 
/*     */     
/*     */     public BasicCalendarDay(Date argDate) {
/* 373 */       this._date = argDate;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Date getDate() {
/* 379 */       return (Date)this._date.clone();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ICalendarDay next() {
/* 385 */       return new BasicCalendarDay(DateUtils.dateAdd(CalendarField.DAY, 1, this._date));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\AbstractStoreCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */