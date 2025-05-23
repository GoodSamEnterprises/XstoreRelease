/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*     */ import dtv.pos.iframework.reporting.ITextReportParam;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.JsExpressionEvaluator;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import javax.script.ScriptException;
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
/*     */ 
/*     */ class TimeIntReportParam
/*     */   extends ReportParam
/*     */   implements ITextReportParam
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(TimeIntReportParam.class); private final Properties fieldModifiers_;
/*     */   
/*     */   private static Date parseValue(String argValue) {
/*     */     Object result;
/*     */     try {
/*  36 */       result = JsExpressionEvaluator.evalToObject(argValue);
/*     */     }
/*  38 */     catch (ScriptException ex) {
/*  39 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  40 */       return null;
/*     */     } 
/*  42 */     return toDate(result);
/*     */   }
/*     */   private TextFieldInputType inputType_;
/*     */   private static Date toDate(Object o) {
/*  46 */     if (o == null) {
/*  47 */       return null;
/*     */     }
/*  49 */     if (o instanceof Date) {
/*  50 */       return (Date)o;
/*     */     }
/*  52 */     if (o instanceof Number) {
/*  53 */       int num = ((Number)o).intValue();
/*  54 */       return DateUtils.timeInt2Date(num);
/*     */     } 
/*  56 */     if ("null".equalsIgnoreCase(o.toString())) {
/*  57 */       return null;
/*     */     }
/*  59 */     return DateUtils.parseIso(o.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private Date defaultValue_ = null;
/*  66 */   private Date initialValue_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TimeIntReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, String[] argParams, ReportParamComponentType argComponentType) {
/*  72 */     super(argParamName, argValueClass, argLabel, argComponentType);
/*     */     
/*  74 */     if (argParams.length > 2) {
/*  75 */       this.inputType_ = TextFieldInputType.forName(argParams[2]);
/*     */     }
/*  77 */     if (this.inputType_ == null) {
/*  78 */       this.inputType_ = TextFieldInputType.TIME_SHORT;
/*     */     }
/*     */     
/*  81 */     this.fieldModifiers_ = new Properties();
/*  82 */     for (int i = 3; i < argParams.length; i++) {
/*  83 */       String[] prop = StringUtils.split(argParams[i], '=');
/*  84 */       if ("defaultValue".equals(prop[0])) {
/*     */         try {
/*  86 */           this.defaultValue_ = parseValue(prop[1]);
/*     */         }
/*  88 */         catch (Exception ex) {
/*  89 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         }
/*     */       
/*  92 */       } else if ("initialValue".equals(prop[0])) {
/*     */         try {
/*  94 */           this.initialValue_ = parseValue(prop[1]);
/*  95 */           setValue(this.initialValue_);
/*     */         }
/*  97 */         catch (Exception ex) {
/*  98 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         }
/*     */       
/* 101 */       } else if ("invokeMethods".equalsIgnoreCase(prop[0])) {
/* 102 */         setInvokeMethods(StringUtils.split(prop[1], ','));
/*     */       } else {
/*     */         
/* 105 */         this.fieldModifiers_.setProperty(prop[0], prop[1]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/* 113 */     Object value = super.getActualValue();
/* 114 */     Date date = toDate(value);
/* 115 */     if (date == null) {
/* 116 */       date = this.defaultValue_;
/*     */     }
/* 118 */     if (date == null) {
/* 119 */       return null;
/*     */     }
/* 121 */     return Integer.valueOf(DateUtils.date2TimeInt(date));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getFieldModifiers() {
/* 131 */     return this.fieldModifiers_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getInitialValue() {
/* 137 */     return this.initialValue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextFieldInputType getInputType() {
/* 147 */     return this.inputType_;
/*     */   }
/*     */   
/*     */   public boolean isMultiEntry() {
/* 151 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\TimeIntReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */