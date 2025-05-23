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
/*    */ public class DateOutOfRangeException
/*    */   extends StoreCalendarException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public DateOutOfRangeException() {}
/*    */   
/*    */   public DateOutOfRangeException(String message) {
/* 19 */     super(message);
/*    */   }
/*    */   
/*    */   public DateOutOfRangeException(String message, Throwable cause) {
/* 23 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public DateOutOfRangeException(Throwable cause) {
/* 27 */     super(cause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\storecalendar\DateOutOfRangeException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */