/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import dtv.util.StringUtils;
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
/*    */ public class DefaultValueTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/*    */   private static final String PARAM_DEFAULT_VALUE = "default";
/* 21 */   private String _defaultValue = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 26 */     if ("default".equalsIgnoreCase(argName)) {
/* 27 */       this._defaultValue = argValue;
/*    */     } else {
/*    */       
/* 30 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 37 */     return StringUtils.isEmpty(argCurrentValue) ? 
/* 38 */       getValueForArgument(argCurrentValue, this._defaultValue, argCurrentLine) : argCurrentValue;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\DefaultValueTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */