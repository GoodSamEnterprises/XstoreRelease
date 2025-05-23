/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderException;
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import java.util.HashMap;
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
/*    */ public class ConditionalValueTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/*    */   private static final String IF_PREFIX = "if:";
/*    */   private static final String THEN_PREFIX = "then:";
/*    */   private static final String ELSE_PREFIX = "else:";
/* 25 */   private String defaultValue_ = null;
/* 26 */   private final Map<String, String> conditions_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 31 */     if (argName.startsWith("if:")) {
/* 32 */       this.conditions_.put(stripIfPrefix(argName), stripThenPrefix(argValue));
/*    */     }
/* 34 */     else if (argName.startsWith("else:")) {
/* 35 */       this.defaultValue_ = stripThenPrefix(argValue);
/*    */     } else {
/*    */       
/* 38 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 45 */     this.defaultValue_ = getValueForArgument(argCurrentValue, this.defaultValue_, argCurrentLine);
/*    */     
/* 47 */     if (this.defaultValue_ == null) {
/* 48 */       this.defaultValue_ = argCurrentValue;
/*    */     }
/*    */     
/* 51 */     String result = this.conditions_.get(argCurrentValue);
/* 52 */     result = getValueForArgument(argCurrentValue, result, argCurrentLine);
/*    */     
/* 54 */     if (result != null) {
/* 55 */       return result;
/*    */     }
/*    */     
/* 58 */     return this.defaultValue_;
/*    */   }
/*    */ 
/*    */   
/*    */   private String stripIfPrefix(String argValue) {
/* 63 */     if (!argValue.startsWith("if:")) {
/* 64 */       throw new DataLoaderException("DataLoader translator is misconfigured. Conditions for conditional translator should start with 'if:'.  Current Condition: " + argValue);
/*    */     }
/*    */ 
/*    */     
/* 68 */     return argValue.substring("if:".length());
/*    */   }
/*    */   
/*    */   private String stripThenPrefix(String argValue) {
/* 72 */     if (!argValue.startsWith("then:")) {
/* 73 */       throw new DataLoaderException("DataLoader translator is misconfigured. Values for conditional translator should start with 'then:'.  Current Value: " + argValue);
/*    */     }
/*    */     
/* 76 */     return argValue.substring("then:".length());
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\ConditionalValueTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */