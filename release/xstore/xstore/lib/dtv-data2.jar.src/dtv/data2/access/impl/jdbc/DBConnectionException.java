/*    */ package dtv.data2.access.impl.jdbc;
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
/*    */ public class DBConnectionException
/*    */   extends JDBCException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public DBConnectionException() {}
/*    */   
/*    */   public DBConnectionException(Exception ex) {
/* 21 */     super(ex);
/*    */   }
/*    */   
/*    */   public DBConnectionException(String argMsg) {
/* 25 */     super(argMsg);
/*    */   }
/*    */   
/*    */   public DBConnectionException(String argMessage, Throwable ex) {
/* 29 */     super(argMessage, ex);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\DBConnectionException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */