/*     */ package dtv.pos.storecalendar.fourfivefour;
/*     */ 
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.storecalendar.AbstractStoreCalendar;
/*     */ import dtv.pos.storecalendar.DateRangeHelper;
/*     */ import dtv.pos.storecalendar.IStoreCalendar;
/*     */ import dtv.pos.storecalendar.StoreCalendarException;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FourFiveFourCalendar
/*     */   extends AbstractStoreCalendar
/*     */ {
/*     */   private static final int LENGTH_OF_YEAR = 364;
/*     */   private static final int LENGTH_OF_QUARTER = 91;
/*     */   private static final int WEEKS_PER_YEAR = 52;
/*  24 */   private static final int[] MONTH_LENGTHS = new int[] { 4, 5, 4, 4, 5, 4, 4, 5, 4, 4, 5, 4 };
/*     */   
/*  26 */   private final Calendar calendar_ = new GregorianCalendar();
/*     */   
/*     */   private Date epoch_;
/*     */   private List<Date> closedDates_;
/*     */   private List<Integer> closedDayOfWeeks_;
/*     */   
/*     */   public FourFiveFourCalendar() {
/*  33 */     super(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date add(Date argStartingDate, int argFieldIndex, int argAmount) {
/*     */     int daysToAdd;
/*     */     int year;
/*     */     int month;
/*     */     int i;
/*  48 */     switch (argFieldIndex) {
/*     */       
/*     */       case 200:
/*  51 */         daysToAdd = argAmount * 364;
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
/*  91 */         return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, argStartingDate));case 201: daysToAdd = argAmount * 91; return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, argStartingDate));case 202: year = get(200, argStartingDate); month = get(202, argStartingDate); daysToAdd = 0; for (i = 1; i <= argAmount; i++) { if (month == 12) { month = 1; year++; } else { month++; }  daysToAdd += getDaysInMonth(year, month); }  return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, argStartingDate));case 203: daysToAdd = argAmount * 7; return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, argStartingDate));case 204: daysToAdd = argAmount; return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, argStartingDate));
/*     */     } 
/*     */     throw new IllegalArgumentException("Unknown field " + argFieldIndex);
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
/*     */   public int get(int argField, Date argDate) {
/*     */     int month, end;
/* 106 */     long daysAfterEpoch = DateUtils.dateDiff(CalendarField.DAY, argDate, this.epoch_);
/* 107 */     int year = (int)daysAfterEpoch / 364 + 1;
/* 108 */     int dayOfYear = (int)daysAfterEpoch % 364 + 1;
/*     */     
/* 110 */     switch (argField) {
/*     */       
/*     */       case 200:
/* 113 */         return year;
/*     */       
/*     */       case 201:
/* 116 */         return dayOfYear / 91;
/*     */       
/*     */       case 202:
/* 119 */         month = 1;
/* 120 */         end = 28;
/* 121 */         while (dayOfYear > end) {
/* 122 */           month++;
/* 123 */           end += getDaysInMonth(year, month);
/*     */         } 
/* 125 */         return month;
/*     */ 
/*     */       
/*     */       case 203:
/* 129 */         return dayOfYear / 7;
/*     */       
/*     */       case 204:
/* 132 */         return dayOfYear;
/*     */       
/*     */       case 205:
/* 135 */         month = 1;
/* 136 */         end = 28;
/* 137 */         while (dayOfYear > end) {
/* 138 */           month++;
/* 139 */           end += getDaysInMonth(year, month);
/*     */         } 
/* 141 */         return dayOfYear - end;
/*     */ 
/*     */       
/*     */       case 206:
/* 145 */         this.calendar_.setTime(argDate);
/* 146 */         return this.calendar_.get(7);
/*     */     } 
/*     */ 
/*     */     
/* 150 */     throw new IllegalArgumentException("Unknown field" + argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(int argField, Date argDate, int argOffset, Date argCurrentBusinessDate) throws StoreCalendarException {
/* 157 */     return DateRangeHelper.getDateRange((IStoreCalendar)this, argField, argDate, argOffset, -1, argCurrentBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstDayOfWeek() {
/* 167 */     this.calendar_.setTime(this.epoch_);
/* 168 */     return this.calendar_.get(7);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastDayOfWeek() {
/* 173 */     return getLastDayOfWeek(getFirstDayOfWeek());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMonthsInYear(int argYear) {
/* 178 */     return MONTH_LENGTHS.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartOfYear(int argYear) {
/* 189 */     int daysToAdd = (argYear - 1) * 364;
/*     */     
/* 191 */     return DateUtils.clearTime(DateUtils.dateAdd(CalendarField.DAY, daysToAdd, this.epoch_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getWeek(int argYear, int argWeek, Date argCurrentBusinessDate) {
/* 197 */     Date d = getStartOfYear(argYear);
/* 198 */     Date startOfTargetWeek = add(d, 203, argWeek);
/* 199 */     Date endOfTargetWeek = add(startOfTargetWeek, 204, 6);
/* 200 */     return new DateRange(startOfTargetWeek, endOfTargetWeek);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWeeksInYear(int argYear) {
/* 205 */     return 52;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void init() {
/* 217 */     FourFiveFourCalendarConfigHelper config = new FourFiveFourCalendarConfigHelper();
/* 218 */     config.initialize();
/* 219 */     this.epoch_ = config.getEpoch();
/* 220 */     this.closedDates_ = config.getClosedDates();
/* 221 */     this.closedDayOfWeeks_ = config.getClosedDayOfWeeks();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isScheduledCloseDate(Date argDate, int argRetailLocationId) {
/* 227 */     Integer dayOfWeek = Integer.valueOf(DateUtils.getDayOfWeek(argDate));
/* 228 */     if (this.closedDayOfWeeks_ != null && this.closedDayOfWeeks_.contains(dayOfWeek)) {
/* 229 */       return true;
/*     */     }
/* 231 */     if (this.closedDates_ != null && this.closedDates_.contains(argDate)) {
/* 232 */       return true;
/*     */     }
/* 234 */     return super.isScheduledCloseDate(argDate, argRetailLocationId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean preferOpenOnCurrentSystemDate() {
/* 240 */     return ConfigurationMgr.getPreferCurrentSystemDayOpen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Date getEpoch() {
/* 247 */     return this.epoch_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setEpoch(Date argEpoch) {
/* 254 */     this.epoch_ = argEpoch;
/*     */   }
/*     */   
/*     */   private int getDaysInMonth(int argYear, int argMonth) {
/* 258 */     return MONTH_LENGTHS[argMonth - 1] * 7;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fourfivefour\FourFiveFourCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */