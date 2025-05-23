/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.BasicStoreCalendar;
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.pos.storecalendar.StoreCalendarException;
/*     */ import dtv.util.DateRange;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FiscalCalendar
/*     */   extends BasicStoreCalendar
/*     */ {
/*     */   private final String _calenderSet;
/*  21 */   private final Map<Integer, FiscalYear> _yearMap = new HashMap<>();
/*     */   
/*  23 */   private final GregorianCalendar _cal = new GregorianCalendar();
/*     */   
/*     */   private FiscalYear[] _years;
/*     */   private long[] _yearStartMilis;
/*  27 */   private int _firstDayOfWeek = -1;
/*     */   
/*     */   protected FiscalCalendar() {
/*  30 */     this(null);
/*     */   }
/*     */   
/*     */   protected FiscalCalendar(String argCalenderSet) {
/*  34 */     this._calenderSet = argCalenderSet;
/*  35 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Date add(Date argStartingDate, int argField, int argAmount) throws DateOutOfRangeException {
/*     */     int i;
/*  42 */     if (argAmount == 0) {
/*  43 */       return argStartingDate;
/*     */     }
/*  45 */     this._cal.setTime(argStartingDate);
/*     */     
/*  47 */     int sign = (argAmount < 0) ? -1 : 1;
/*  48 */     int offset = Math.abs(argAmount);
/*  49 */     switch (argField) {
/*     */       
/*     */       case 200:
/*  52 */         for (i = 0; i < offset; i++) {
/*  53 */           FiscalDay d = getFiscalDay(this._cal.getTime());
/*  54 */           this._cal.add(5, d.getYear().getDayCount() * sign);
/*     */         } 
/*  56 */         return this._cal.getTime();
/*     */ 
/*     */       
/*     */       case 201:
/*  60 */         for (i = 0; i < offset; i++) {
/*  61 */           FiscalDay d = getFiscalDay(this._cal.getTime());
/*  62 */           this._cal.add(5, d.getWeek().getQuarter().getDayCount() * sign);
/*     */         } 
/*  64 */         return this._cal.getTime();
/*     */ 
/*     */       
/*     */       case 202:
/*  68 */         for (i = 0; i < offset; i++) {
/*  69 */           FiscalDay d = getFiscalDay(this._cal.getTime());
/*  70 */           this._cal.add(5, d.getWeek().getMonth().getDayCount() * sign);
/*     */         } 
/*  72 */         return this._cal.getTime();
/*     */ 
/*     */       
/*     */       case 203:
/*  76 */         for (i = 0; i < offset; i++) {
/*  77 */           FiscalDay d = getFiscalDay(this._cal.getTime());
/*  78 */           this._cal.add(5, d.getWeek().getDayCount() * sign);
/*     */         } 
/*  80 */         return this._cal.getTime();
/*     */ 
/*     */       
/*     */       case 204:
/*  84 */         this._cal.add(5, argAmount);
/*  85 */         return this._cal.getTime();
/*     */     } 
/*     */ 
/*     */     
/*  89 */     throw new IllegalArgumentException("Unknown field" + argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int argField, Date argDate) throws StoreCalendarException {
/* 100 */     FiscalDay d = getFiscalDay(argDate);
/* 101 */     switch (argField) {
/*     */       
/*     */       case 200:
/* 104 */         return d.getYear().getIndex();
/*     */       
/*     */       case 201:
/* 107 */         return d.getWeek().getQuarter().getQuarterOfYear();
/*     */       
/*     */       case 202:
/* 110 */         return d.getWeek().getMonth().getMonthOfYear();
/*     */       
/*     */       case 203:
/* 113 */         return d.getWeek().getWeekOfYear();
/*     */       
/*     */       case 204:
/* 116 */         return d.getDayOfYear();
/*     */       
/*     */       case 205:
/* 119 */         return d.getDayOfMonth();
/*     */       
/*     */       case 206:
/* 122 */         return d.getDayOfWeek();
/*     */     } 
/*     */     
/* 125 */     throw new IllegalArgumentException("Unknown field" + argField);
/*     */   }
/*     */   public final DateRange getDateRange(int argField, Date argDate, int argOffset, Date argCurrentBusinessDate) throws DateOutOfRangeException {
/*     */     FiscalYear y;
/*     */     FiscalQuarter q;
/*     */     FiscalMonth m;
/*     */     FiscalWeek w;
/*     */     int i, j;
/* 133 */     FiscalDay d = getFiscalDay(argDate);
/* 134 */     boolean backwards = (argOffset < 0);
/* 135 */     int offset = Math.abs(argOffset);
/* 136 */     switch (argField) {
/*     */       
/*     */       case 200:
/* 139 */         y = d.getYear();
/* 140 */         for (j = 0; j < offset; j++) {
/* 141 */           if (backwards) {
/* 142 */             y = y.previous();
/*     */           } else {
/*     */             
/* 145 */             y = y.next();
/*     */           } 
/*     */         } 
/* 148 */         return y.getDateRange();
/*     */ 
/*     */       
/*     */       case 201:
/* 152 */         q = d.getWeek().getQuarter();
/* 153 */         for (j = 0; j < offset; j++) {
/* 154 */           if (backwards) {
/* 155 */             q = q.previous();
/*     */           } else {
/*     */             
/* 158 */             q = q.next();
/*     */           } 
/*     */         } 
/* 161 */         return q.getDateRange();
/*     */ 
/*     */       
/*     */       case 202:
/* 165 */         m = d.getWeek().getMonth();
/* 166 */         for (j = 0; j < offset; j++) {
/* 167 */           if (backwards) {
/* 168 */             m = m.previous();
/*     */           } else {
/*     */             
/* 171 */             m = m.next();
/*     */           } 
/*     */         } 
/* 174 */         return m.getDateRange();
/*     */ 
/*     */       
/*     */       case 203:
/* 178 */         w = d.getWeek();
/* 179 */         for (j = 0; j < offset; j++) {
/* 180 */           if (backwards) {
/* 181 */             w = w.previous();
/*     */           } else {
/*     */             
/* 184 */             w = w.next();
/*     */           } 
/*     */         } 
/* 187 */         return w.getDateRange();
/*     */ 
/*     */       
/*     */       case 204:
/* 191 */         for (i = 0; i < offset; i++) {
/* 192 */           if (backwards) {
/* 193 */             d = d.previous();
/*     */           } else {
/*     */             
/* 196 */             d = d.next();
/*     */           } 
/*     */         } 
/* 199 */         return new DateRange(d.getDate(), d.getDate());
/*     */     } 
/*     */     
/* 202 */     throw new IllegalArgumentException("Unknown field" + argField);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstDayOfWeek() {
/* 208 */     if (this._firstDayOfWeek == -1) {
/*     */       
/* 210 */       this._cal.setTime(this._years[0].getWeek(1).getDay(1).getDate());
/* 211 */       this._firstDayOfWeek = this._cal.get(7);
/*     */     } 
/* 213 */     return this._firstDayOfWeek;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastDayOfWeek() {
/* 218 */     return getLastDayOfWeek(getFirstDayOfWeek());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMonthsInYear(int argYear) throws DateOutOfRangeException {
/* 224 */     return getYear(argYear).getMonthCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Date getStartOfYear(int argYear) throws DateOutOfRangeException {
/* 230 */     return getYear(argYear).getDay(1).getDate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final DateRange getWeek(int argYear, int argWeek, Date argCurrentBusinessDate) throws DateOutOfRangeException {
/* 236 */     return getYear(argYear).getWeek(argWeek).getDateRange();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getWeeksInYear(int argYear) throws DateOutOfRangeException {
/* 242 */     return getYear(argYear).getWeekCount();
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
/* 254 */     if (this._years == null) {
/* 255 */       FiscalCalendarConfigHelper helper = new FiscalCalendarConfigHelper(this._calenderSet);
/* 256 */       FiscalCalendarWeekConfig[] weeks = helper.getWeeks();
/*     */       
/* 258 */       for (FiscalCalendarWeekConfig week2 : weeks) {
/* 259 */         Integer yearNbr = Integer.valueOf(week2.getYear());
/* 260 */         FiscalYear year = this._yearMap.get(yearNbr);
/* 261 */         if (year == null) {
/* 262 */           year = new FiscalYear(this, yearNbr.intValue());
/*     */         }
/* 264 */         year.addWeek(week2);
/* 265 */         this._yearMap.put(yearNbr, year);
/*     */       } 
/* 267 */       this._years = (FiscalYear[])this._yearMap.values().toArray((Object[])new FiscalYear[this._yearMap.size()]);
/* 268 */       Arrays.sort((Object[])this._years);
/* 269 */       this._yearStartMilis = new long[this._years.length];
/* 270 */       for (int i = 0; i < this._yearStartMilis.length; i++) {
/* 271 */         this._yearStartMilis[i] = this._years[i].getDateRange().getStartDate().getTime();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final FiscalDay getFiscalDay(Date argDate) throws DateOutOfRangeException {
/* 279 */     int idx = Arrays.binarySearch(this._yearStartMilis, argDate.getTime());
/* 280 */     if (idx < 0)
/*     */     {
/*     */ 
/*     */       
/* 284 */       idx = -idx - 2;
/*     */     }
/* 286 */     if (idx < 0)
/*     */     {
/* 288 */       throw new DateOutOfRangeException("no FiscalCalendar data going back that far!! " + argDate);
/*     */     }
/* 290 */     return this._years[idx].getFiscalDay(argDate);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final FiscalYear getYear(int argYear) throws DateOutOfRangeException {
/* 295 */     FiscalYear year = this._yearMap.get(Integer.valueOf(argYear));
/* 296 */     if (year == null) {
/* 297 */       throw new DateOutOfRangeException("no FiscalCalendar configuration for year " + argYear);
/*     */     }
/* 299 */     return year;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalCalendar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */