/*    */ package dtv.pos.storecalendar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OperationRestrictedException
/*    */   extends StoreCalendarException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public OperationRestrictedException() {}
/*    */   
/*    */   public OperationRestrictedException(String message) {
/* 19 */     super(message);
/*    */   }
/*    */   
/*    */   public OperationRestrictedException(String message, Throwable cause) {
/* 23 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public OperationRestrictedException(Throwable cause) {
/* 27 */     super(cause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\OperationRestrictedException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */