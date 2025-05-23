/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringConcatTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/*    */   private static final String PREFIX_STRING = "string.";
/* 30 */   private final Map<String, String> parameters_ = new HashMap<>(4);
/*    */   
/* 32 */   private final List<String> valuesToConcat_ = new ArrayList<>(4);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 43 */     if (argName.startsWith("string.")) {
/* 44 */       this.parameters_.put(argName, argValue);
/*    */     } else {
/*    */       
/* 47 */       super.setParameter(argName, argValue);
/*    */     } 
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
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 62 */     parseParameters(argCurrentValue, argCurrentLine);
/*    */     
/* 64 */     StringBuilder buff = new StringBuilder(32);
/*    */     
/* 66 */     for (String val : this.valuesToConcat_) {
/* 67 */       if (val == null) {
/* 68 */         return null;
/*    */       }
/*    */       
/* 71 */       buff.append(val);
/*    */     } 
/*    */ 
/*    */     
/* 75 */     return buff.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void parseParameters(String argCurrentValue, FileLine argCurrentLine) {
/* 85 */     for (int ii = 1;; ii++) {
/* 86 */       String key = (new StringBuilder("string.".length() + 2)).append("string.").append(ii).toString();
/* 87 */       String value = this.parameters_.get(key);
/*    */       
/* 89 */       if (value == null) {
/*    */         break;
/*    */       }
/*    */       
/* 93 */       this.valuesToConcat_.add(getValueForArgument(argCurrentValue, value, argCurrentLine));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\StringConcatTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */