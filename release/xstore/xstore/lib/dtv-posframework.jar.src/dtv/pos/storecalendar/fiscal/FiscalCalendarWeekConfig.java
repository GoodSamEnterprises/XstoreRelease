/*     */ package dtv.pos.storecalendar.fiscal;
/*     */ 
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ public class FiscalCalendarWeekConfig
/*     */   extends AbstractParentConfig
/*     */   implements Comparable<FiscalCalendarWeekConfig>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  23 */   private int _year = Integer.MIN_VALUE;
/*  24 */   private int _quarter = Integer.MIN_VALUE;
/*  25 */   private int _month = Integer.MIN_VALUE;
/*  26 */   private int _weekInYear = Integer.MIN_VALUE;
/*  27 */   private Date _start = null;
/*  28 */   private Date _end = null;
/*     */ 
/*     */   
/*     */   public int compareTo(FiscalCalendarWeekConfig other) {
/*  32 */     int yearCompared = Integer.valueOf(this._year).compareTo(Integer.valueOf(other._year));
/*  33 */     if (yearCompared != 0) {
/*  34 */       return yearCompared;
/*     */     }
/*     */     
/*  37 */     return Integer.valueOf(this._weekInYear).compareTo(Integer.valueOf(other._weekInYear));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  43 */     if (argOther == this) {
/*  44 */       return true;
/*     */     }
/*  46 */     if (!(argOther instanceof FiscalCalendarWeekConfig)) {
/*  47 */       return false;
/*     */     }
/*  49 */     FiscalCalendarWeekConfig other = (FiscalCalendarWeekConfig)argOther;
/*     */     
/*  51 */     return (other._year == this._year && other._weekInYear == this._weekInYear);
/*     */   }
/*     */   
/*     */   public Date getEnd() {
/*  55 */     return this._end;
/*     */   }
/*     */   
/*     */   public int getMonth() {
/*  59 */     return this._month;
/*     */   }
/*     */   
/*     */   public int getQuarter() {
/*  63 */     return this._quarter;
/*     */   }
/*     */   
/*     */   public Date getStart() {
/*  67 */     return this._start;
/*     */   }
/*     */   
/*     */   public int getWeekInYear() {
/*  71 */     return this._weekInYear;
/*     */   }
/*     */   
/*     */   public int getYear() {
/*  75 */     return this._year;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  80 */     HashCodeBuilder hsb = new HashCodeBuilder();
/*  81 */     hsb.append(this._year);
/*  82 */     hsb.append(this._weekInYear);
/*  83 */     return hsb.toHashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  88 */     if ("year".equalsIgnoreCase(argKey)) {
/*  89 */       this._year = ConfigUtils.toInt(argValue);
/*     */     }
/*  91 */     else if ("quarter".equalsIgnoreCase(argKey)) {
/*  92 */       this._quarter = ConfigUtils.toInt(argValue);
/*     */     }
/*  94 */     else if ("month".equalsIgnoreCase(argKey)) {
/*  95 */       this._month = ConfigUtils.toInt(argValue);
/*     */     }
/*  97 */     else if ("week".equalsIgnoreCase(argKey)) {
/*  98 */       this._weekInYear = ConfigUtils.toInt(argValue);
/*     */     }
/* 100 */     else if ("start".equalsIgnoreCase(argKey)) {
/* 101 */       this._start = ConfigUtils.toDate(argValue);
/*     */     }
/* 103 */     else if ("end".equalsIgnoreCase(argKey)) {
/* 104 */       this._end = ConfigUtils.toDate(argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\fiscal\FiscalCalendarWeekConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */