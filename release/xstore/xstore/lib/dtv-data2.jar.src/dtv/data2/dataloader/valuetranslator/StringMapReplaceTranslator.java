/*    */ package dtv.data2.dataloader.valuetranslator;
/*    */ 
/*    */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringMapReplaceTranslator
/*    */   extends AbstractValueTranslator
/*    */   implements IValueTranslator
/*    */ {
/* 31 */   private static final Logger logger_ = Logger.getLogger(StringMapReplaceTranslator.class);
/*    */   
/*    */   private static final String PARAM_MAPPING = "Mapping";
/*    */   
/*    */   private static final String PARAM_PRESERVE = "PreserveNotFound";
/*    */   private static final String PARAM_SPLIT = "Split";
/* 37 */   protected final Map<String, String> map_ = new HashMap<>();
/*    */   
/* 39 */   private String splitString_ = "::";
/*    */ 
/*    */   
/*    */   private boolean preserveNotFound_ = true;
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 46 */     if ("PreserveNotFound".equalsIgnoreCase(argName)) {
/* 47 */       this.preserveNotFound_ = ConfigUtils.toBoolean(argValue, this.preserveNotFound_).booleanValue();
/*    */     }
/* 49 */     else if ("Split".equalsIgnoreCase(argName)) {
/* 50 */       if (StringUtils.isEmpty(argValue)) {
/* 51 */         logger_.warn("Split is empty");
/*    */       } else {
/*    */         
/* 54 */         this.splitString_ = argValue.trim();
/*    */       }
/*    */     
/* 57 */     } else if ("Mapping".equalsIgnoreCase(argName)) {
/* 58 */       String[] values = argValue.trim().split(this.splitString_, 2);
/* 59 */       this.map_.put(values[0].trim(), values[1].trim());
/*    */     } else {
/*    */       
/* 62 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 69 */     String key = (argCurrentValue == null) ? "" : argCurrentValue.trim();
/* 70 */     String value = "";
/*    */     
/* 72 */     if (this.map_.containsKey(key)) {
/* 73 */       value = this.map_.get(key);
/*    */     }
/* 75 */     else if (this.preserveNotFound_) {
/* 76 */       value = key;
/*    */     } 
/*    */     
/* 79 */     return value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final String getSplitString() {
/* 87 */     return this.splitString_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final boolean isPreserveNotFound() {
/* 95 */     return this.preserveNotFound_;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\StringMapReplaceTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */