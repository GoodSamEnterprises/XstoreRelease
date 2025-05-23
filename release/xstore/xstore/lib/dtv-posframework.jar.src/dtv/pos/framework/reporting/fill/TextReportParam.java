/*     */ package dtv.pos.framework.reporting.fill;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.reporting.ReportMgr;
/*     */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*     */ import dtv.pos.iframework.reporting.ITextReportParam;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import dtv.util.JsExpressionEvaluator;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Properties;
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
/*     */ class TextReportParam
/*     */   extends ReportParam
/*     */   implements ITextReportParam
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(TextReportParam.class);
/*     */   
/*     */   private final Properties fieldModifiers_;
/*     */   
/*     */   private final String fieldName_;
/*     */   
/*     */   private TextFieldInputType inputType_;
/*     */   
/*     */   private Object defaultValue_;
/*     */   private Object initialValue_;
/*     */   private boolean multi_ = false;
/*     */   
/*     */   TextReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, String[] argParams, ReportParamComponentType argComponentType, boolean argMultiEntry) {
/*  40 */     super(argParamName, argValueClass, argLabel, argComponentType);
/*     */     
/*  42 */     this.multi_ = argMultiEntry;
/*  43 */     if (argParams.length > 2) {
/*  44 */       this.inputType_ = TextFieldInputType.forName(argParams[2]);
/*     */     }
/*  46 */     if (this.inputType_ == null) {
/*  47 */       this.inputType_ = TextFieldInputType.SIMPLE;
/*     */     }
/*     */     
/*  50 */     this.fieldModifiers_ = new Properties();
/*  51 */     String fieldName = null;
/*  52 */     for (int i = 3; i < argParams.length; i++) {
/*  53 */       String[] prop = StringUtils.split(argParams[i], '=');
/*  54 */       if ("defaultValue".equals(prop[0])) {
/*     */         try {
/*  56 */           this.defaultValue_ = JsExpressionEvaluator.evalToObject(prop[1]);
/*     */         }
/*  58 */         catch (Exception ex) {
/*  59 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         }
/*     */       
/*  62 */       } else if ("initialValue".equals(prop[0])) {
/*     */         try {
/*  64 */           this.initialValue_ = JsExpressionEvaluator.evalToObject(prop[1]);
/*  65 */           setValue(this.initialValue_);
/*     */         }
/*  67 */         catch (Exception ex) {
/*  68 */           logger_.error("CAUGHT EXCEPTION", ex);
/*     */         }
/*     */       
/*  71 */       } else if ("invokeMethods".equalsIgnoreCase(prop[0])) {
/*  72 */         setInvokeMethods(StringUtils.split(prop[1], ','));
/*     */       }
/*  74 */       else if ("fieldName".equalsIgnoreCase(prop[0])) {
/*  75 */         fieldName = prop[1];
/*     */       } else {
/*     */         
/*  78 */         this.fieldModifiers_.setProperty(prop[0], prop[1]);
/*     */       } 
/*     */     } 
/*  81 */     this.fieldName_ = fieldName;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getActualValue() {
/*  86 */     Object value = super.getActualValue();
/*  87 */     if (value == null) {
/*  88 */       return this.defaultValue_;
/*     */     }
/*  90 */     if (isMultiEntry() && value instanceof Object[]) {
/*  91 */       return ReportMgr.getInstance().buildSqlInStatement(this.fieldName_, (Object[])value);
/*     */     }
/*     */     
/*  94 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties getFieldModifiers() {
/* 105 */     return this.fieldModifiers_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getInitialValue() {
/* 111 */     return this.initialValue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextFieldInputType getInputType() {
/* 121 */     return this.inputType_;
/*     */   }
/*     */   
/*     */   public boolean isMultiEntry() {
/* 125 */     return this.multi_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\TextReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */