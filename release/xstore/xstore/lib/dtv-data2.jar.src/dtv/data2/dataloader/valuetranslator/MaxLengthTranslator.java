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
/*    */ public class MaxLengthTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/*    */   private static final String PARAM_MAX_LENGTH = "length";
/* 21 */   private int _maxLength = Integer.MAX_VALUE;
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 26 */     if ("length".equalsIgnoreCase(argName)) {
/* 27 */       this._maxLength = Integer.valueOf(argValue).intValue();
/*    */     } else {
/*    */       
/* 30 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 37 */     String translatedValue = argCurrentValue;
/*    */     
/* 39 */     if (this._maxLength > 0) {
/* 40 */       translatedValue = StringUtils.left(translatedValue, this._maxLength);
/*    */     }
/* 42 */     return translatedValue;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\MaxLengthTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */