/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.pos.storecalendar.DateOutOfRangeException;
/*     */ import dtv.pos.storecalendar.ICalendarDay;
/*     */ import dtv.pos.storecalendar.StoreCalendarException;
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
/*     */ public class FiscalDay
/*     */   implements ICalendarDay, Comparable<FiscalDay>
/*     */ {
/*     */   private final FiscalWeek _week;
/*     */   private Integer _index;
/*     */   private final Date _date;
/*     */   
/*     */   public FiscalDay(FiscalWeek argWeek, Date argDate) {
/*  24 */     this._week = argWeek;
/*  25 */     this._date = argDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalDay other) {
/*  30 */     int results = this._week.compareTo(other._week);
/*  31 */     if (results == 0) {
/*  32 */       return this._date.compareTo(other._date);
/*     */     }
/*     */     
/*  35 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  41 */     if (argOther == this) {
/*  42 */       return true;
/*     */     }
/*  44 */     if (!(argOther instanceof FiscalDay)) {
/*  45 */       return false;
/*     */     }
/*  47 */     FiscalDay other = (FiscalDay)argOther;
/*     */     
/*  49 */     return (other._week.equals(this._week) && other._date.equals(this._date));
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate() {
/*  54 */     return (Date)this._date.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDayOfMonth() throws StoreCalendarException {
/*  59 */     return this._week.getMonth().getIndex(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDayOfQuarter() throws DateOutOfRangeException {
/*  64 */     return this._week.getQuarter().getIndex(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDayOfWeek() throws DateOutOfRangeException {
/*  69 */     return this._week.getIndex(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDayOfYear() throws DateOutOfRangeException {
/*  74 */     if (this._index == null) {
/*  75 */       this._index = Integer.valueOf(getYear().getDayIndexOfYear(this));
/*     */     }
/*  77 */     return this._index.intValue();
/*     */   }
/*     */   
/*     */   public FiscalWeek getWeek() {
/*  81 */     return this._week;
/*     */   }
/*     */   
/*     */   public FiscalYear getYear() {
/*  85 */     return this._week.getYear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  90 */     int result = 17;
/*  91 */     result = 37 * result + this._week.hashCode();
/*  92 */     result = 37 * result + this._index.intValue();
/*  93 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalDay next() throws DateOutOfRangeException {
/*  99 */     int i = getDayOfWeek();
/* 100 */     if (i == this._week.getDayCount()) {
/* 101 */       return this._week.next().getDay(1);
/*     */     }
/*     */     
/* 104 */     return this._week.getDay(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FiscalDay previous() throws DateOutOfRangeException {
/* 110 */     int i = getDayOfWeek();
/* 111 */     if (i == 1) {
/* 112 */       FiscalWeek lastWeek = this._week.previous();
/* 113 */       return lastWeek.getDay(lastWeek.getDayCount());
/*     */     } 
/*     */     
/* 116 */     return this._week.getDay(i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 122 */     return "FiscalDay[y=" + getYear().getIndex() + ",q=" + getWeek().getQuarter().getQuarterOfYear() + ",m=" + 
/* 123 */       getWeek().getMonth().getMonthOfYear() + ",w=" + getWeek().getWeekOfYear() + ",d=" + 
/* 124 */       DateUtils.format(getDate()) + "]";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalDay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */