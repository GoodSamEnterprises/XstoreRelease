/*    */ package dtv.pos.framework.reporting.fill;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.framework.reporting.type.ReportParamComponentType;
/*    */ import dtv.pos.iframework.type.IDtvDate;
/*    */ import dtv.pos.ui.text.TextFieldInputType;
/*    */ import dtv.util.StringUtils;
/*    */ import java.util.Properties;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DateReportParam
/*    */   extends ReportParam
/*    */ {
/* 25 */   private static final Logger logger_ = Logger.getLogger(DateReportParam.class);
/*    */ 
/*    */   
/*    */   private final Properties fieldModifiers_;
/*    */ 
/*    */   
/*    */   DateReportParam(String argParamName, Class<?> argValueClass, IFormattable argLabel, String[] argParams, ReportParamComponentType argComponentType) {
/* 32 */     super(argParamName, argValueClass, argLabel, argComponentType);
/*    */ 
/*    */     
/* 35 */     this.fieldModifiers_ = new Properties();
/* 36 */     for (int i = 2; i < argParams.length; i++) {
/* 37 */       String[] prop = StringUtils.split(argParams[i], '=');
/* 38 */       if ("initialValue".equals(prop[0])) {
/*    */         try {
/* 40 */           IDtvDate value = DtvDateParser.parseDate(prop[1]);
/* 41 */           setValue(value);
/*    */         }
/* 43 */         catch (Exception ex) {
/* 44 */           logger_.error("CAUGHT EXCEPTION", ex);
/*    */         }
/*    */       
/* 47 */       } else if ("invokeMethods".equalsIgnoreCase(prop[0])) {
/* 48 */         setInvokeMethods(StringUtils.split(prop[1], ','));
/*    */       } else {
/*    */         
/* 51 */         this.fieldModifiers_.setProperty(prop[0], prop[1]);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Properties getFieldModifiers() {
/* 62 */     return this.fieldModifiers_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TextFieldInputType getInputType() {
/* 71 */     return TextFieldInputType.DATE;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\fill\DateReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */