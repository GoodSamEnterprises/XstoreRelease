/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
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
/*    */ public class DaoConfig
/*    */   extends PersistableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private static final Collection<String> _ignoredFields = Arrays.asList(new String[] { "suppress" });
/*    */   
/*    */   private String daoName_;
/*    */   
/*    */   public String getDaoName() {
/* 27 */     return this.daoName_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 33 */     if ("name".equalsIgnoreCase(argKey)) {
/* 34 */       this.daoName_ = argValue.toString();
/*    */     }
/* 36 */     else if (!_ignoredFields.contains(argKey)) {
/* 37 */       super.setConfigObject(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\DaoConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */