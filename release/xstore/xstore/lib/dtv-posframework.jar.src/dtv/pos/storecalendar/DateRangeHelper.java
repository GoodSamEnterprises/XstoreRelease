/*     */ package dtv.pos.storecalendar;
/*     */ 
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.Date;
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
/*     */ public class DateRangeHelper
/*     */ {
/*     */   public static DateRange getDateRange(IStoreCalendar argCalendar, int argField, Date argStartingPoint, int argOffset, Date argCurrentBusinessDate) throws StoreCalendarException {
/*  21 */     return getDateRange(argCalendar, argField, argStartingPoint, argOffset, argCalendar.getLastDayOfWeek(), argCurrentBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateRange getDateRange(IStoreCalendar argCalendar, int argField, Date argStartingPoint, int argOffset, int lastDayOfWeek, Date argCurrentBusinessDate) throws StoreCalendarException {
/*     */     DateRange results;
/*  29 */     switch (argField) {
/*     */       case 200:
/*  31 */         results = getYear(argCalendar, argStartingPoint, argOffset);
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
/*  55 */         return results;case 201: results = getQuarter(argCalendar, argStartingPoint, argOffset); return results;case 202: results = getMonth(argCalendar, argStartingPoint, argOffset); return results;case 203: results = getWeek(argCalendar, argStartingPoint, argOffset, lastDayOfWeek, argCurrentBusinessDate); return results;case 204: results = getDay(argCalendar, argStartingPoint, argOffset); return results;
/*     */     } 
/*     */     throw new IllegalArgumentException("invalid field " + argField);
/*     */   }
/*     */   public static DateRange getDay(IStoreCalendar argCalendar, Date argStartingPoint, int argOffset) throws DateOutOfRangeException {
/*  60 */     Date d = argCalendar.add(argStartingPoint, 204, argOffset);
/*  61 */     return new DateRange(d, d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateRange getMonth(IStoreCalendar argCalendar, Date argStartingPoint, int argOffset) throws StoreCalendarException {
/*  68 */     int containingYear = argCalendar.get(200, argStartingPoint);
/*     */     
/*  70 */     int containingMonth = argCalendar.get(202, argStartingPoint);
/*  71 */     int targetYear = containingYear;
/*  72 */     int targetMonth = containingMonth + argOffset;
/*     */     
/*  74 */     while (targetMonth < 1) {
/*  75 */       targetMonth += argCalendar.getMonthsInYear(targetYear - 1);
/*  76 */       targetYear--;
/*     */     } 
/*     */     
/*  79 */     while (targetMonth > argCalendar.getMonthsInYear(targetYear)) {
/*  80 */       targetMonth -= argCalendar.getMonthsInYear(targetYear);
/*  81 */       targetYear++;
/*     */     } 
/*     */     
/*  84 */     Date startOfTargetYear = argCalendar.getStartOfYear(targetYear);
/*  85 */     Date startOfTargetMonth = argCalendar.add(startOfTargetYear, 202, targetMonth - 1);
/*  86 */     Date startOfNextMonth = argCalendar.add(startOfTargetMonth, 202, 1);
/*  87 */     Date endOfTargetMonth = argCalendar.add(startOfNextMonth, 204, -1);
/*  88 */     return new DateRange(startOfTargetMonth, endOfTargetMonth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateRange getQuarter(IStoreCalendar argCalendar, Date argStartingPoint, int argOffset) throws StoreCalendarException {
/*  95 */     int containingYear = argCalendar.get(200, argStartingPoint);
/*     */     
/*  97 */     int containingQuarter = argCalendar.get(201, argStartingPoint);
/*  98 */     int targetYear = containingYear;
/*  99 */     int targetQuarter = containingQuarter + argOffset;
/*     */     
/* 101 */     while (targetQuarter < 1) {
/* 102 */       targetQuarter += 4;
/* 103 */       targetYear--;
/*     */     } 
/*     */     
/* 106 */     while (targetQuarter > 4) {
/* 107 */       targetQuarter -= 4;
/* 108 */       targetYear++;
/*     */     } 
/* 110 */     Date startOfTargetYear = argCalendar.getStartOfYear(targetYear);
/*     */     
/* 112 */     Date startOfTargetQuarter = argCalendar.add(startOfTargetYear, 201, targetQuarter - 1);
/* 113 */     Date startOfNextQuarter = argCalendar.add(startOfTargetQuarter, 201, 1);
/* 114 */     Date endOfTargetQuarter = argCalendar.add(startOfNextQuarter, 204, -1);
/* 115 */     return new DateRange(startOfTargetQuarter, endOfTargetQuarter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateRange getWeek(IStoreCalendar argCalendar, Date argStartingPoint, int argOffset, int lastDayOfWeek, Date argCurrentBusinessDate) throws StoreCalendarException {
/* 123 */     Date date = DateUtils.dateAdd(CalendarField.DAY, 7 * argOffset, argStartingPoint);
/*     */ 
/*     */     
/* 126 */     int containingYear = argCalendar.get(200, date);
/*     */     
/* 128 */     int containingWeek = argCalendar.get(203, date);
/* 129 */     int targetYear = containingYear;
/* 130 */     int targetWeek = containingWeek;
/*     */     
/* 132 */     int startingPointDayOfWeek = argCalendar.get(206, date);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     if (lastDayOfWeek > 1 && lastDayOfWeek < 8 && 
/* 141 */       startingPointDayOfWeek > lastDayOfWeek)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 146 */       targetWeek++;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 151 */     while (targetWeek < 1) {
/*     */       
/* 153 */       targetWeek += argCalendar.getWeeksInYear(targetYear - 1);
/* 154 */       if (argCalendar.get(202, date) == 1) {
/* 155 */         targetYear--;
/*     */       }
/*     */     } 
/*     */     
/* 159 */     while (targetWeek > argCalendar.getWeeksInYear(targetYear) && (lastDayOfWeek == 7 || startingPointDayOfWeek > lastDayOfWeek))
/*     */     {
/*     */       
/* 162 */       targetWeek -= argCalendar.getWeeksInYear(targetYear);
/*     */     }
/*     */     
/* 165 */     if (targetWeek == 1 && argCalendar
/* 166 */       .get(202, date) == argCalendar.getMonthsInYear(targetYear))
/*     */     {
/* 168 */       targetYear++;
/*     */     }
/*     */     
/* 171 */     return argCalendar.getWeek(targetYear, targetWeek, argCurrentBusinessDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DateRange getYear(IStoreCalendar argCalendar, Date argStartingPoint, int argOffset) throws StoreCalendarException {
/* 178 */     int containingYear = argCalendar.get(200, argStartingPoint);
/*     */     
/* 180 */     int targetYear = containingYear + argOffset;
/*     */     
/* 182 */     Date start = argCalendar.getStartOfYear(targetYear);
/*     */     
/* 184 */     Date startOfNextYear = argCalendar.getStartOfYear(targetYear + 1);
/* 185 */     Date end = argCalendar.add(startOfNextYear, 204, -1);
/* 186 */     return new DateRange(start, end);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\DateRangeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */