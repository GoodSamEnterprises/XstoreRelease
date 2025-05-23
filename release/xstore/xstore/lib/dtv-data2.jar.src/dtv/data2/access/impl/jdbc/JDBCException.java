/*    */ package dtv.data2.access.impl.jdbc;
/*    */ 
/*    */ import dtv.data2.SQLExceptionScrubber;
/*    */ import java.sql.SQLException;
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
/*    */ public class JDBCException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 383692603770283434L;
/*    */   
/*    */   private static Throwable scrubCause(Throwable argEx) {
/* 22 */     return (argEx instanceof SQLException) ? SQLExceptionScrubber.scrub((SQLException)argEx) : argEx;
/*    */   }
/*    */ 
/*    */   
/*    */   public JDBCException() {}
/*    */ 
/*    */   
/*    */   public JDBCException(String argMessage) {
/* 30 */     super(SQLExceptionScrubber.scrub(argMessage));
/*    */   }
/*    */   
/*    */   public JDBCException(String argMessage, Throwable ex) {
/* 34 */     super(SQLExceptionScrubber.scrub(argMessage), scrubCause(ex));
/*    */   }
/*    */   
/*    */   public JDBCException(Throwable ex) {
/* 38 */     super(scrubCause(ex));
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\jdbc\JDBCException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */