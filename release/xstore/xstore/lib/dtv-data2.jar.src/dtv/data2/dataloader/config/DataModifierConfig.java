/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class DataModifierConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private final List<DataModifierParameterConfig> parameters_ = new ArrayList<>();
/* 25 */   private String className_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getClassName() {
/* 31 */     return this.className_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DataModifierParameterConfig> getParameters() {
/* 38 */     return this.parameters_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 44 */     if ("className".equalsIgnoreCase(argKey)) {
/* 45 */       this.className_ = argValue.toString();
/*    */     }
/* 47 */     else if ("Param".equalsIgnoreCase(argKey)) {
/* 48 */       this.parameters_.add((DataModifierParameterConfig)argValue);
/*    */     } else {
/*    */       
/* 51 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DataModifierConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */