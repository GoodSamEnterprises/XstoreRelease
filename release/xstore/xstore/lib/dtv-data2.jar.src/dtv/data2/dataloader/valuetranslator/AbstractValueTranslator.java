/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderException;
/*    */ import dtv.data2.dataloader.DataLoaderUtils;
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
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
/*    */ public abstract class AbstractValueTranslator
/*    */   implements IValueTranslator
/*    */ {
/*    */   private static final String PARAM_CURRENT_VALUE = "variable=$currentValue";
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 24 */     throw new DataLoaderException("Unexpected parameter given to [" + getClass().getName() + "] Key: [" + argName + "] Value: [" + argValue + "]");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getValueForArgument(String argCurrentValue, String argValueSpecifer, FileLine argLine) {
/* 36 */     String value = DataLoaderUtils.getValueForValueSpecifier(argValueSpecifer, argLine);
/*    */     
/* 38 */     if ("variable=$currentValue".equals(value)) {
/* 39 */       return argCurrentValue;
/*    */     }
/*    */     
/* 42 */     return value;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\AbstractValueTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */