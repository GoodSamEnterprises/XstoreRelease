/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.FormatterType;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.iframework.type.IDtvDateRange;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Date;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbsoluteDtvDateRange
/*     */   implements IDtvDateRange
/*     */ {
/*     */   private static final long serialVersionUID = 8652555155727426175L;
/*  29 */   private static final FormattableFactory FF = FormattableFactory.getInstance();
/*     */   
/*     */   private static final String SEPERATOR = "/";
/*  32 */   private static final Logger _logger = Logger.getLogger(AbsoluteDtvDateRange.class);
/*     */   
/*     */   @Inject
/*     */   private TransDateProvider _transDateProvider;
/*     */   private Date startDate_;
/*     */   private Date endDate_;
/*     */   private IFormattable description_;
/*     */   
/*     */   public static IDtvDateRange valueOf(String s) {
/*  41 */     String[] parts = s.split("/");
/*  42 */     if (parts.length != 2) {
/*  43 */       throw new IllegalArgumentException(s);
/*     */     }
/*  45 */     Date start = DateUtils.parseDate(parts[0]);
/*  46 */     Date end = DateUtils.parseDate(parts[1]);
/*  47 */     return new AbsoluteDtvDateRange(start, end);
/*     */   }
/*     */   
/*     */   private static Date copy(Date argDate) {
/*  51 */     if (argDate == null) {
/*  52 */       return null;
/*     */     }
/*  54 */     return (Date)argDate.clone();
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
/*     */   public AbsoluteDtvDateRange() {
/*  67 */     this(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbsoluteDtvDateRange(Date argStartDate, Date argEndDate) {
/*  77 */     this(argStartDate, argEndDate, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbsoluteDtvDateRange(Date argStartDate, Date argEndDate, IFormattable argDescription) {
/*  88 */     processInjections();
/*  89 */     if (argStartDate == null) {
/*  90 */       this.startDate_ = this._transDateProvider.getDate();
/*     */     } else {
/*     */       
/*  93 */       this.startDate_ = argStartDate;
/*     */     } 
/*     */     
/*  96 */     if (argEndDate == null) {
/*  97 */       this.endDate_ = this._transDateProvider.getDate();
/*     */     } else {
/*     */       
/* 100 */       this.endDate_ = argEndDate;
/*     */     } 
/*     */     
/* 103 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange() {
/* 109 */     return getDateRange(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(boolean argEndOfDay) {
/* 115 */     return new DateRange(getStartDate(), getEndDate(argEndOfDay));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(Date argReferencePoint) {
/* 121 */     return getDateRange(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DateRange getDateRange(Date argReferencePoint, boolean argEndOfDay) {
/* 127 */     return getDateRange(argEndOfDay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormattable getDescription() {
/* 138 */     if (this.description_ == null) {
/*     */ 
/*     */       
/* 141 */       IFormattable[] dates = { FF.getSimpleFormattable(this.startDate_, FormatterType.DATE_MEDIUM), FF.getSimpleFormattable(this.endDate_, FormatterType.DATE_MEDIUM) };
/*     */       
/* 143 */       this.description_ = FF.getTranslatable("_dateRangeFromXtoY", dates);
/*     */     } 
/* 145 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate() {
/* 151 */     return getEndDate(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(boolean argEndOfDay) {
/* 157 */     if (!argEndOfDay)
/*     */     {
/* 159 */       return copy(this.endDate_);
/*     */     }
/*     */     
/* 162 */     return DateUtils.dateAdd(CalendarField.MILLISECOND, DateUtils.MILLIS_PER_DAY.intValue() - 1000, 
/* 163 */         DateUtils.clearTime(this.endDate_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(Date argReferencePoint) {
/* 170 */     return getEndDate(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getEndDate(Date argReferencePoint, boolean argEndOfDay) {
/* 176 */     return getEndDate(argEndOfDay);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartDate() {
/* 183 */     return copy(this.startDate_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getStartDate(Date argReferencePoint) {
/* 189 */     return getStartDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRelative() {
/* 199 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toExternalForm() {
/* 205 */     return DateUtils.format(this.startDate_) + "/" + DateUtils.format(this.endDate_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 215 */     return getDescription().toString(OutputContextType.VIEW);
/*     */   }
/*     */   
/*     */   private void processInjections() {
/*     */     try {
/* 220 */       InjectionHammer.forceAtInjectProcessing(this);
/*     */     }
/* 222 */     catch (Exception ex) {
/* 223 */       _logger.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException {
/* 231 */     this.startDate_ = DateUtils.getNewDate(in.readLong());
/* 232 */     this.endDate_ = DateUtils.getNewDate(in.readLong());
/* 233 */     processInjections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 240 */     out.writeLong(this.startDate_.getTime());
/* 241 */     out.writeLong(this.endDate_.getTime());
/*     */   }
/*     */   
/*     */   public static class DefaultDateRange
/*     */     extends AbsoluteDtvDateRange
/*     */   {
/*     */     private IFormattable description_;
/*     */     
/*     */     public DefaultDateRange() {
/* 250 */       super(DateUtils.getFarPastDate(), DateUtils.getFarFutureDate(), null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IFormattable getDescription() {
/* 256 */       if (this.description_ == null) {
/* 257 */         this.description_ = FormattableFactory.getInstance().getTranslatable("_dateRangeAll");
/*     */       }
/* 259 */       return this.description_;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\AbsoluteDtvDateRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */