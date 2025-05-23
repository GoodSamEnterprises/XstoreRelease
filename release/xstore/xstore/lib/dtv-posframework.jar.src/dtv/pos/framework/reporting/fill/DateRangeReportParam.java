/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*     */ import dtv.pos.iframework.type.IDtvDateRange;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class DateRangeReportParam
/*     */   extends ReportParam
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(DateRangeReportParam.class);
/*     */ 
/*     */   
/*     */   private IDtvDateRange range_;
/*     */ 
/*     */ 
/*     */   
/*     */   DateRangeReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, String[] argParams, ReportParamComponentType argComponentType) {
/*  34 */     super(argParamName, argValueClass, argLabel, argComponentType);
/*     */     
/*  36 */     for (int i = 2; i < argParams.length; i++) {
/*  37 */       String[] prop = StringUtils.split(argParams[i], '=');
/*  38 */       if ("initialValue".equals(prop[0])) {
/*     */         try {
/*  40 */           IDtvDateRange value = DtvDateParser.parseDateRange(prop[1]);
/*  41 */           setValue(value);
/*     */         }
/*  43 */         catch (Exception ex) {
/*  44 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         }
/*     */       
/*  47 */       } else if ("invokeMethods".equalsIgnoreCase(prop[0])) {
/*  48 */         setInvokeMethods(StringUtils.split(prop[1], ','));
/*     */       } 
/*     */     } 
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
/*     */   
/*     */   public Object getActualValue() {
/*  64 */     Object value = super.getActualValue();
/*     */     
/*  66 */     if (value instanceof AbsoluteDtvDateRange) {
/*  67 */       IDtvDateRange dateRange = (IDtvDateRange)value;
/*     */       
/*  69 */       Date endDate = DateUtils.clearTime(dateRange.getEndDate());
/*  70 */       Calendar cal = Calendar.getInstance();
/*  71 */       cal.clear();
/*  72 */       cal.setTimeInMillis(endDate.getTime());
/*  73 */       cal.add(5, 1);
/*  74 */       cal.add(13, -1);
/*  75 */       IDtvDateRange properRange = new AbsoluteDtvDateRange(dateRange.getStartDate(), cal.getTime());
/*  76 */       value = properRange;
/*     */     } 
/*     */     
/*  79 */     return value;
/*     */   }
/*     */   
/*     */   public Date getEndDate() {
/*  83 */     return (this.range_ != null) ? this.range_.getEndDate() : null;
/*     */   }
/*     */   
/*     */   public Date getStartDate() {
/*  87 */     return (this.range_ != null) ? this.range_.getStartDate() : null;
/*     */   }
/*     */   
/*     */   public void setDateRange(Date argStartDate, Date argEndDate) {
/*  91 */     setValue(new AbsoluteDtvDateRange(argStartDate, argEndDate));
/*     */   }
/*     */   
/*     */   public void setEndDate(Date argDate) {
/*  95 */     Date start = (this.range_ != null) ? this.range_.getStartDate() : null;
/*  96 */     setValue(new AbsoluteDtvDateRange(start, argDate));
/*     */   }
/*     */   
/*     */   public void setStartDate(Date argDate) {
/* 100 */     Date end = (this.range_ != null) ? this.range_.getEndDate() : null;
/* 101 */     setValue(new AbsoluteDtvDateRange(argDate, end));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object argValue) {
/* 109 */     if (argValue instanceof IDtvDateRange) {
/* 110 */       this.range_ = (IDtvDateRange)argValue;
/*     */     }
/* 112 */     super.setValue(argValue);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\DateRangeReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */