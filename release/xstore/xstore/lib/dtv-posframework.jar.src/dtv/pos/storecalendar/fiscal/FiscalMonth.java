/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.pos.storecalendar.StoreCalendarException;
/*     */ import dtv.util.DateRange;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ public class FiscalMonth
/*     */   implements Comparable<FiscalMonth>
/*     */ {
/*     */   private static final int MIN_INDEX = 1;
/*     */   private final FiscalQuarter quarter_;
/*     */   private final int _index;
/*  28 */   private final List<FiscalWeek> _weeks = new ArrayList<>();
/*     */   private FiscalDay[] _days;
/*     */   
/*     */   public FiscalMonth(FiscalQuarter argQuarter, int argIndex) {
/*  32 */     this.quarter_ = argQuarter;
/*  33 */     this._index = argIndex;
/*  34 */     if (this._index < 1) {
/*  35 */       throw new IllegalArgumentException("invalid month number " + this._index);
/*     */     }
/*  37 */     argQuarter.addMonth(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalMonth other) {
/*  42 */     int results = this.quarter_.compareTo(other.quarter_);
/*  43 */     if (results == 0) {
/*  44 */       return (this._index < other._index) ? -1 : ((this._index == other._index) ? 0 : 1);
/*     */     }
/*     */     
/*  47 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  53 */     if (argOther == this) {
/*  54 */       return true;
/*     */     }
/*  56 */     if (!(argOther instanceof FiscalMonth)) {
/*  57 */       return false;
/*     */     }
/*  59 */     FiscalMonth other = (FiscalMonth)argOther;
/*     */     
/*  61 */     return (other.quarter_.equals(this.quarter_) && other._index == this._index);
/*     */   }
/*     */   
/*     */   public DateRange getDateRange() {
/*  65 */     FiscalDay first = getDay(1);
/*  66 */     FiscalDay last = getDay(getDayCount());
/*  67 */     return new DateRange(first.getDate(), last.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalDay getDay(int argIndex) {
/*  75 */     return getDays()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getDayCount() {
/*  79 */     return (getDays()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMonthOfQuarter() throws StoreCalendarException {
/*  84 */     return this.quarter_.getIndex(this);
/*     */   }
/*     */   
/*     */   public int getMonthOfYear() {
/*  88 */     return this._index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalWeek getWeek(int argIndex) {
/*  96 */     return this._weeks.get(argIndex - 1);
/*     */   }
/*     */   
/*     */   public int getWeekCount() {
/* 100 */     return this._weeks.size();
/*     */   }
/*     */   
/*     */   public FiscalYear getYear() {
/* 104 */     return this.quarter_.getYear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 109 */     int result = 17;
/* 110 */     result = 37 * result + this.quarter_.hashCode();
/* 111 */     result = 37 * result + this._index;
/* 112 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public FiscalMonth next() throws DateOutOfRangeException {
/* 117 */     int i = this._index;
/* 118 */     FiscalYear year = getYear();
/* 119 */     if (i == year.getMonthCount()) {
/* 120 */       return year.next().getMonth(1);
/*     */     }
/*     */     
/* 123 */     return year.getMonth(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalMonth previous() throws DateOutOfRangeException {
/* 130 */     int i = this._index;
/* 131 */     FiscalYear year = getYear();
/* 132 */     if (i == 1) {
/* 133 */       FiscalYear lastYear = year.previous();
/* 134 */       return lastYear.getMonth(lastYear.getMonthCount());
/*     */     } 
/*     */     
/* 137 */     return year.getMonth(i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     ToStringBuilder tsb = new ToStringBuilder(this);
/* 145 */     tsb.append("index", this._index);
/* 146 */     tsb.append("weeks", this._weeks);
/* 147 */     return tsb.toString();
/*     */   }
/*     */   
/*     */   protected FiscalDay[] getDays() {
/* 151 */     if (this._days == null) {
/* 152 */       List<FiscalDay> days = new ArrayList<>(40);
/* 153 */       for (FiscalWeek week : this._weeks) {
/* 154 */         days.addAll(Arrays.asList(week.getDays()));
/*     */       }
/* 156 */       this._days = days.<FiscalDay>toArray(new FiscalDay[days.size()]);
/*     */     } 
/* 158 */     return this._days;
/*     */   }
/*     */   
/*     */   protected FiscalWeek[] getWeeks() {
/* 162 */     return this._weeks.<FiscalWeek>toArray(new FiscalWeek[this._weeks.size()]);
/*     */   }
/*     */   
/*     */   void addWeek(FiscalWeek argWeek) {
/* 166 */     this._weeks.add(argWeek);
/*     */   }
/*     */ 
/*     */   
/*     */   int getIndex(FiscalDay argDay) throws StoreCalendarException {
/* 171 */     FiscalDay[] days = getDays();
/* 172 */     for (int i = 0; i < days.length; i++) {
/* 173 */       if (argDay.equals(days[i])) {
/* 174 */         return i + 1;
/*     */       }
/*     */     } 
/* 177 */     throw new StoreCalendarException("day not in this month");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalMonth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */