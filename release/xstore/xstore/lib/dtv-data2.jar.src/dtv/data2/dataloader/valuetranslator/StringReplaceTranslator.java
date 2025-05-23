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
/*    */ public class StringReplaceTranslator
/*    */   extends AbstractValueTranslator
/*    */ {
/*    */   public static final String PARM_SEARCH_FOR = "searchFor";
/*    */   public static final String PARM_REPLACE_WITH = "replaceWith";
/* 22 */   private String searchFor_ = null;
/* 23 */   private String replaceWith_ = "";
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 28 */     if ("searchFor".equals(argName)) {
/* 29 */       this.searchFor_ = argValue;
/*    */     }
/* 31 */     else if ("replaceWith".equals(argName)) {
/* 32 */       this.replaceWith_ = StringUtils.nonNull(argValue);
/*    */     } else {
/*    */       
/* 35 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String translate(String argCurrentValue, FileLine argCurrentLine) {
/* 43 */     if (argCurrentValue == null) {
/* 44 */       return "";
/*    */     }
/* 46 */     return argCurrentValue.replaceAll(this.searchFor_, this.replaceWith_);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\valuetranslator\StringReplaceTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */