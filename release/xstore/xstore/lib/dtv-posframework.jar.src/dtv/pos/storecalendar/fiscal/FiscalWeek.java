/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public class FiscalWeek
/*     */   implements Comparable<FiscalWeek>
/*     */ {
/*     */   private static final int MIN_INDEX = 1;
/*     */   private final FiscalYear _year;
/*     */   private final FiscalQuarter _quarter;
/*     */   private final FiscalMonth _month;
/*     */   private final int _index;
/*     */   private final Date _start;
/*     */   private final Date _end;
/*     */   private FiscalDay[] _days;
/*     */   private long[] _dayStartMillis;
/*     */   
/*     */   public FiscalWeek(FiscalYear argYear, FiscalQuarter argQuarter, FiscalMonth argMonth, FiscalCalendarWeekConfig argCfg) {
/*  37 */     this._year = argYear;
/*  38 */     this._quarter = argQuarter;
/*  39 */     this._month = argMonth;
/*  40 */     this._index = argCfg.getWeekInYear();
/*  41 */     if (this._index < 1) {
/*  42 */       throw new IllegalArgumentException("invalid week number " + this._index);
/*     */     }
/*     */     
/*  45 */     this._start = argCfg.getStart();
/*  46 */     if (this._start == null) {
/*  47 */       throw new NullPointerException("no start date defined @@ " + argCfg.getSourceDescription());
/*     */     }
/*     */     
/*  50 */     this._end = argCfg.getEnd();
/*  51 */     if (this._end == null) {
/*  52 */       throw new NullPointerException("no end date defined @@ " + argCfg.getSourceDescription());
/*     */     }
/*     */     
/*  55 */     if (!this._start.before(this._end)) {
/*  56 */       throw new IllegalArgumentException("start must be before end [" + this._start + "->" + this._end + "] @@ " + argCfg
/*  57 */           .getSourceDescription());
/*     */     }
/*  59 */     argMonth.addWeek(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalWeek other) {
/*  64 */     int results = this._year.compareTo(other._year);
/*  65 */     if (results == 0) {
/*  66 */       return (this._index < other._index) ? -1 : ((this._index == other._index) ? 0 : 1);
/*     */     }
/*     */     
/*  69 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  75 */     if (argOther == this) {
/*  76 */       return true;
/*     */     }
/*  78 */     if (!(argOther instanceof FiscalWeek)) {
/*  79 */       return false;
/*     */     }
/*  81 */     FiscalWeek other = (FiscalWeek)argOther;
/*     */     
/*  83 */     return (other._year.equals(this._year) && other._index == this._index);
/*     */   }
/*     */   
/*     */   public DateRange getDateRange() {
/*  87 */     return new DateRange((Date)this._start.clone(), (Date)this._end.clone());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalDay getDay(int argIndex) {
/*  95 */     return getDays()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getDayCount() {
/*  99 */     return (getDays()).length;
/*     */   }
/*     */   
/*     */   public int getWeekOfYear() {
/* 103 */     return this._index;
/*     */   }
/*     */   
/*     */   public FiscalYear getYear() {
/* 107 */     return this._year;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 112 */     int result = 17;
/* 113 */     result = 37 * result + this._year.hashCode();
/* 114 */     result = 37 * result + this._index;
/* 115 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalWeek next() throws DateOutOfRangeException {
/* 121 */     int i = getWeekOfYear();
/* 122 */     FiscalYear year = getYear();
/* 123 */     if (i == year.getWeekCount()) {
/* 124 */       return year.next().getWeek(1);
/*     */     }
/*     */     
/* 127 */     return year.getWeek(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalWeek previous() throws DateOutOfRangeException {
/* 134 */     int i = getWeekOfYear();
/* 135 */     FiscalYear year = getYear();
/* 136 */     if (i == 1) {
/* 137 */       FiscalYear lastYear = year.previous();
/* 138 */       return lastYear.getWeek(lastYear.getWeekCount());
/*     */     } 
/*     */     
/* 141 */     return year.getWeek(i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     ToStringBuilder tsb = new ToStringBuilder(this);
/* 149 */     tsb.append("index", this._index);
/* 150 */     tsb.append("start", this._start);
/* 151 */     tsb.append("end", this._end);
/* 152 */     return tsb.toString();
/*     */   }
/*     */   
/*     */   protected FiscalDay[] getDays() {
/* 156 */     if (this._days == null) {
/* 157 */       List<FiscalDay> days = new ArrayList<>(7);
/*     */       
/* 159 */       Date d = this._start;
/* 160 */       for (; d.before(this._end); d = DateUtils.dateAdd(CalendarField.DAY, 1, d)) {
/* 161 */         days.add(new FiscalDay(this, d));
/*     */       }
/* 163 */       days.add(new FiscalDay(this, d));
/* 164 */       this._days = days.<FiscalDay>toArray(new FiscalDay[days.size()]);
/*     */     } 
/* 166 */     return this._days;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   FiscalDay getFiscalDay(Date argDate) throws DateOutOfRangeException {
/* 172 */     FiscalDay[] days = getDays();
/* 173 */     if (this._dayStartMillis == null) {
/* 174 */       this._dayStartMillis = new long[days.length];
/* 175 */       for (int i = 0; i < days.length; i++) {
/* 176 */         this._dayStartMillis[i] = days[i].getDate().getTime();
/*     */       }
/*     */     } 
/* 179 */     int idx = Arrays.binarySearch(this._dayStartMillis, argDate.getTime());
/* 180 */     if (idx < 0)
/*     */     {
/*     */ 
/*     */       
/* 184 */       idx = -idx - 2;
/*     */     }
/* 186 */     if (idx < 0)
/*     */     {
/* 188 */       throw new DateOutOfRangeException("possible hole in FiscalCalendar configuration.  no period containing " + argDate);
/*     */     }
/*     */     
/* 191 */     return days[idx];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int getIndex(FiscalDay argDay) throws DateOutOfRangeException {
/* 197 */     FiscalDay[] days = getDays();
/* 198 */     for (int i = 0; i < days.length; i++) {
/* 199 */       if (argDay.equals(days[i])) {
/* 200 */         return i + 1;
/*     */       }
/*     */     } 
/* 203 */     throw new DateOutOfRangeException("day not in this week");
/*     */   }
/*     */   
/*     */   FiscalMonth getMonth() {
/* 207 */     return this._month;
/*     */   }
/*     */   
/*     */   FiscalQuarter getQuarter() {
/* 211 */     return this._quarter;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalWeek.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */