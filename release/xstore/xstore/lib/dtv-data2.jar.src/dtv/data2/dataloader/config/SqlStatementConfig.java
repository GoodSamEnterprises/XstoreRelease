/*    */ package dtv.data2.dataloader.config;
/*    */ 
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
/*    */ public class SqlStatementConfig
/*    */   extends PersistableConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String sqlString_;
/*    */   
/*    */   public String getSqlString() {
/* 23 */     return this.sqlString_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 29 */     if ("sql".equalsIgnoreCase(argKey)) {
/* 30 */       this.sqlString_ = argValue.toString();
/*    */     } else {
/*    */       
/* 33 */       super.setConfigObject(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\SqlStatementConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */