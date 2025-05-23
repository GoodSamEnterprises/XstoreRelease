/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class DataModifierParameterConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String parameterKey_;
/*    */   private String parameterValue_;
/*    */   
/*    */   public String getParameterKey() {
/* 27 */     return this.parameterKey_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getParameterValue() {
/* 34 */     return this.parameterValue_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 40 */     if ("key".equalsIgnoreCase(argKey)) {
/*    */       
/* 42 */       this.parameterKey_ = argValue.toString();
/*    */     }
/* 44 */     else if ("value".equalsIgnoreCase(argKey)) {
/* 45 */       this.parameterValue_ = argValue.toString();
/*    */     } else {
/*    */       
/* 48 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DataModifierParameterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */