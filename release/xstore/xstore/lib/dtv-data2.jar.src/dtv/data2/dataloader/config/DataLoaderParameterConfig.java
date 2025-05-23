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
/*    */ public class DataLoaderParameterConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String parameterName_;
/*    */   private String parameterValue_;
/*    */   
/*    */   public String getParameterName() {
/* 27 */     return this.parameterName_;
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
/* 40 */     if ("name".equalsIgnoreCase(argKey)) {
/* 41 */       this.parameterName_ = argValue.toString();
/*    */     }
/* 43 */     else if ("value".equalsIgnoreCase(argKey)) {
/* 44 */       this.parameterValue_ = argValue.toString();
/*    */     } else {
/*    */       
/* 47 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DataLoaderParameterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */