/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.util.DateRange;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FiscalYear
/*     */   implements Comparable<FiscalYear>
/*     */ {
/*     */   private final FiscalCalendar _calendar;
/*     */   private final int _index;
/*  25 */   private Map<Integer, FiscalQuarter> _quarterMap = new HashMap<>();
/*  26 */   private Map<Integer, FiscalMonth> _monthMap = new HashMap<>();
/*  27 */   private List<FiscalWeek> _weekList = new ArrayList<>();
/*  28 */   private final Set<Integer> _weekIndices = new HashSet<>();
/*     */   
/*     */   private FiscalQuarter[] _quarters;
/*     */   private FiscalMonth[] _months;
/*     */   private FiscalWeek[] _weeks;
/*     */   private long[] _weekStartMillis;
/*     */   private FiscalDay[] _days;
/*     */   private DateRange _range;
/*     */   
/*     */   public FiscalYear(FiscalCalendar argCalendar, int argIndex) {
/*  38 */     this._calendar = argCalendar;
/*  39 */     this._index = argIndex;
/*     */   }
/*     */   
/*     */   public void addWeek(FiscalCalendarWeekConfig argWeek) {
/*  43 */     int weekInYear = argWeek.getWeekInYear();
/*  44 */     if (weekInYear != 1 && !this._weekIndices.contains(Integer.valueOf(weekInYear - 1))) {
/*  45 */       throw new IllegalArgumentException("You have a gap in week numbers for year " + this._index + "; missing entry for " + (weekInYear - 1) + " @@ " + argWeek
/*  46 */           .getSourceDescription());
/*     */     }
/*  48 */     if (!this._weekIndices.add(Integer.valueOf(weekInYear))) {
/*  49 */       throw new IllegalArgumentException("You already have week #" + weekInYear + " for year " + this._index + " @@ " + argWeek
/*  50 */           .getSourceDescription());
/*     */     }
/*     */     
/*  53 */     Integer quarterIdx = Integer.valueOf(argWeek.getQuarter());
/*  54 */     FiscalQuarter q = this._quarterMap.get(quarterIdx);
/*  55 */     if (q == null) {
/*  56 */       q = new FiscalQuarter(this, argWeek.getQuarter());
/*  57 */       this._quarterMap.put(quarterIdx, q);
/*     */     } 
/*     */     
/*  60 */     Integer monthIdx = Integer.valueOf(argWeek.getMonth());
/*  61 */     FiscalMonth m = this._monthMap.get(monthIdx);
/*  62 */     if (m == null) {
/*  63 */       m = new FiscalMonth(q, argWeek.getMonth());
/*  64 */       this._monthMap.put(monthIdx, m);
/*     */     } 
/*     */     
/*  67 */     this._weekList.add(new FiscalWeek(this, q, m, argWeek));
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalYear o) {
/*  72 */     int thisVal = this._index;
/*  73 */     int anotherVal = o._index;
/*  74 */     return (thisVal < anotherVal) ? -1 : ((thisVal == anotherVal) ? 0 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  79 */     if (argOther == this) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(argOther instanceof FiscalYear)) {
/*  83 */       return false;
/*     */     }
/*  85 */     FiscalYear other = (FiscalYear)argOther;
/*     */     
/*  87 */     return (other._index == this._index);
/*     */   }
/*     */   
/*     */   public DateRange getDateRange() {
/*  91 */     if (this._range == null) {
/*  92 */       synchronized (this) {
/*  93 */         FiscalWeek[] weeks = getWeeks();
/*  94 */         FiscalWeek firstWeek = weeks[0];
/*  95 */         FiscalWeek lastWeek = weeks[weeks.length - 1];
/*  96 */         this._range = new DateRange(firstWeek.getDateRange().getStartDate(), lastWeek.getDateRange().getEndDate());
/*     */       } 
/*     */     }
/*     */     
/* 100 */     return new DateRange((Date)this._range.getStartDate().clone(), (Date)this._range.getEndDate().clone());
/*     */   }
/*     */   
/*     */   public FiscalDay getDay(int argIndex) {
/* 104 */     return getDays()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getDayCount() {
/* 108 */     return (getDays()).length;
/*     */   }
/*     */   
/*     */   public int getIndex() {
/* 112 */     return this._index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalMonth getMonth(int argIndex) {
/* 122 */     return getMonths()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getMonthCount() {
/* 126 */     return (getMonths()).length;
/*     */   }
/*     */   
/*     */   public FiscalQuarter getQuarter(int argIndex) {
/* 130 */     return getQuarters()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getQuarterCount() {
/* 134 */     return (getQuarters()).length;
/*     */   }
/*     */   
/*     */   public FiscalWeek getWeek(int argIndex) {
/* 138 */     return getWeeks()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getWeekCount() {
/* 142 */     return (getWeeks()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     return (new HashCodeBuilder())
/* 148 */       .append(this._index)
/* 149 */       .toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalYear next() throws DateOutOfRangeException {
/* 155 */     return this._calendar.getYear(this._index + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalYear previous() throws DateOutOfRangeException {
/* 161 */     return this._calendar.getYear(this._index - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     ToStringBuilder tsb = new ToStringBuilder(this);
/* 168 */     tsb.append("idx", this._index);
/* 169 */     tsb.append("quarters", (Object[])getQuarters());
/* 170 */     return tsb.toString();
/*     */   }
/*     */   
/*     */   protected FiscalDay[] getDays() {
/* 174 */     if (this._days == null) {
/* 175 */       FiscalWeek[] weeks = getWeeks();
/* 176 */       List<FiscalDay> days = new ArrayList<>(380);
/* 177 */       for (FiscalWeek week : weeks) {
/* 178 */         days.addAll(Arrays.asList(week.getDays()));
/*     */       }
/* 180 */       this._days = days.<FiscalDay>toArray(new FiscalDay[days.size()]);
/*     */     } 
/* 182 */     return this._days;
/*     */   }
/*     */   
/*     */   protected FiscalMonth[] getMonths() {
/* 186 */     if (this._months == null) {
/* 187 */       synchronized (this) {
/* 188 */         FiscalMonth[] months = (FiscalMonth[])this._monthMap.values().toArray((Object[])new FiscalMonth[this._monthMap.size()]);
/* 189 */         Arrays.sort((Object[])months);
/* 190 */         this._monthMap = null;
/* 191 */         this._months = months;
/*     */       } 
/*     */     }
/* 194 */     return this._months;
/*     */   }
/*     */   
/*     */   protected FiscalQuarter[] getQuarters() {
/* 198 */     if (this._quarters == null) {
/* 199 */       synchronized (this) {
/* 200 */         FiscalQuarter[] quarters = (FiscalQuarter[])this._quarterMap.values().toArray((Object[])new FiscalQuarter[this._quarterMap.size()]);
/* 201 */         Arrays.sort((Object[])quarters);
/* 202 */         this._quarterMap = null;
/* 203 */         this._quarters = quarters;
/*     */       } 
/*     */     }
/* 206 */     return this._quarters;
/*     */   }
/*     */   
/*     */   protected FiscalWeek[] getWeeks() {
/* 210 */     if (this._weeks == null) {
/* 211 */       synchronized (this) {
/* 212 */         FiscalWeek[] weeks = this._weekList.<FiscalWeek>toArray(new FiscalWeek[this._weekList.size()]);
/* 213 */         Arrays.sort((Object[])weeks);
/* 214 */         this._weeks = weeks;
/* 215 */         this._weekList = null;
/*     */       } 
/*     */     }
/* 218 */     return this._weeks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int getDayIndexOfYear(FiscalDay argDay) throws DateOutOfRangeException {
/* 224 */     FiscalDay[] days = getDays();
/* 225 */     for (int i = 0; i < days.length; i++) {
/* 226 */       if (argDay.equals(days[i])) {
/* 227 */         return i + 1;
/*     */       }
/*     */     } 
/* 230 */     throw new DateOutOfRangeException("day not in this year");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   FiscalDay getFiscalDay(Date argDate) throws DateOutOfRangeException {
/* 236 */     FiscalWeek[] weeks = getWeeks();
/* 237 */     if (this._weekStartMillis == null) {
/* 238 */       this._weekStartMillis = new long[weeks.length];
/* 239 */       for (int i = 0; i < weeks.length; i++) {
/* 240 */         this._weekStartMillis[i] = weeks[i].getDateRange().getStartDate().getTime();
/*     */       }
/*     */     } 
/* 243 */     int idx = Arrays.binarySearch(this._weekStartMillis, argDate.getTime());
/* 244 */     if (idx < 0)
/*     */     {
/*     */ 
/*     */       
/* 248 */       idx = -idx - 2;
/*     */     }
/* 250 */     if (idx < 0)
/*     */     {
/* 252 */       throw new DateOutOfRangeException("possible hole in FiscalCalendar configuration.  no period containing " + argDate);
/*     */     }
/*     */     
/* 255 */     return weeks[idx].getFiscalDay(argDate);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalYear.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */