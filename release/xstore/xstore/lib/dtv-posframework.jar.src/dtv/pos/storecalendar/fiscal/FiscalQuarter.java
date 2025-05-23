/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
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
/*     */ public class FiscalQuarter
/*     */   implements Comparable<FiscalQuarter>
/*     */ {
/*     */   private static final int MIN_INDEX = 1;
/*     */   private static final int MAX_INDEX = 4;
/*     */   private final FiscalYear _year;
/*     */   private final int _index;
/*  27 */   private final List<FiscalMonth> _months = new ArrayList<>();
/*     */   private FiscalWeek[] _weeks;
/*     */   private FiscalDay[] _days;
/*     */   
/*     */   public FiscalQuarter(FiscalYear argYear, int argIndex) {
/*  32 */     this._year = argYear;
/*  33 */     this._index = argIndex;
/*  34 */     if (this._index < 1 || this._index > 4) {
/*  35 */       throw new IllegalArgumentException("invalid quarter number " + this._index);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalQuarter other) {
/*  41 */     int results = this._year.compareTo(other._year);
/*  42 */     if (results == 0) {
/*  43 */       return (this._index < other._index) ? -1 : ((this._index == other._index) ? 0 : 1);
/*     */     }
/*     */     
/*  46 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  52 */     if (argOther == this) {
/*  53 */       return true;
/*     */     }
/*  55 */     if (!(argOther instanceof FiscalQuarter)) {
/*  56 */       return false;
/*     */     }
/*  58 */     FiscalQuarter other = (FiscalQuarter)argOther;
/*     */     
/*  60 */     return (other._year.equals(this._year) && other._index == this._index);
/*     */   }
/*     */   
/*     */   public DateRange getDateRange() {
/*  64 */     FiscalDay firstDay = getDay(1);
/*  65 */     FiscalDay lastDay = getDay(getDayCount());
/*  66 */     return new DateRange(firstDay.getDate(), lastDay.getDate());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalDay getDay(int argIndex) {
/*  74 */     return getDays()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getDayCount() {
/*  78 */     return (getDays()).length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalMonth getMonth(int argIndex) {
/*  86 */     return this._months.get(argIndex - 1);
/*     */   }
/*     */   
/*     */   public int getMonthCount() {
/*  90 */     return this._months.size();
/*     */   }
/*     */   
/*     */   public int getQuarterOfYear() {
/*  94 */     return this._index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalWeek getWeek(int argIndex) {
/* 102 */     return getWeeks()[argIndex - 1];
/*     */   }
/*     */   
/*     */   public int getWeekCount() {
/* 106 */     return (getWeeks()).length;
/*     */   }
/*     */   
/*     */   public FiscalYear getYear() {
/* 110 */     return this._year;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     int result = 17;
/* 116 */     result = 37 * result + this._year.hashCode();
/* 117 */     result = 37 * result + this._index;
/* 118 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalQuarter next() throws DateOutOfRangeException {
/* 124 */     int i = this._index;
/* 125 */     FiscalYear year = getYear();
/* 126 */     if (i == year.getQuarterCount()) {
/* 127 */       return year.next().getQuarter(1);
/*     */     }
/*     */     
/* 130 */     return year.getQuarter(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalQuarter previous() throws DateOutOfRangeException {
/* 137 */     int i = this._index;
/* 138 */     FiscalYear year = getYear();
/* 139 */     if (i == 1) {
/* 140 */       FiscalYear lastYear = year.previous();
/* 141 */       return lastYear.getQuarter(lastYear.getQuarterCount());
/*     */     } 
/*     */     
/* 144 */     return year.getQuarter(i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     ToStringBuilder tsb = new ToStringBuilder(this);
/* 152 */     tsb.append("idx", this._index);
/* 153 */     tsb.append("months", this._months);
/* 154 */     return tsb.toString();
/*     */   }
/*     */   
/*     */   protected FiscalDay[] getDays() {
/* 158 */     if (this._days == null) {
/* 159 */       List<FiscalDay> l = new ArrayList<>(120);
/* 160 */       for (FiscalMonth m : this._months) {
/* 161 */         l.addAll(Arrays.asList(m.getDays()));
/*     */       }
/* 163 */       this._days = l.<FiscalDay>toArray(new FiscalDay[l.size()]);
/*     */     } 
/* 165 */     return this._days;
/*     */   }
/*     */   
/*     */   protected FiscalWeek[] getWeeks() {
/* 169 */     if (this._weeks == null) {
/* 170 */       List<FiscalWeek> l = new ArrayList<>();
/* 171 */       for (FiscalMonth m : this._months) {
/* 172 */         l.addAll(Arrays.asList(m.getWeeks()));
/*     */       }
/* 174 */       this._weeks = l.<FiscalWeek>toArray(new FiscalWeek[l.size()]);
/*     */     } 
/* 176 */     return this._weeks;
/*     */   }
/*     */   
/*     */   void addMonth(FiscalMonth argMonth) {
/* 180 */     this._months.add(argMonth);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int getIndex(FiscalDay argDay) throws DateOutOfRangeException {
/* 186 */     FiscalDay[] days = getDays();
/* 187 */     for (int i = 0; i < days.length; i++) {
/* 188 */       if (argDay.equals(days[i])) {
/* 189 */         return i + 1;
/*     */       }
/*     */     } 
/* 192 */     throw new DateOutOfRangeException("day not in this quarter");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getIndex(FiscalMonth argMonth) throws DateOutOfRangeException {
/* 203 */     for (int i = 0; i < this._months.size(); i++) {
/* 204 */       if (argMonth.equals(this._months.get(i))) {
/* 205 */         return i + 1;
/*     */       }
/*     */     } 
/* 208 */     throw new DateOutOfRangeException("month not in this quarter");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalQuarter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */