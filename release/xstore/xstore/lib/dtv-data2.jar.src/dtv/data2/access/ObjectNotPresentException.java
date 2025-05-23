/*    */ package dtv.data2.access;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ObjectNotPresentException
/*    */   extends ObjectNotFoundException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ObjectNotPresentException() {}
/*    */   
/*    */   public ObjectNotPresentException(String argMessage) {
/* 28 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ObjectNotPresentException(String argMessage, Throwable argCause) {
/* 38 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ObjectNotPresentException(Throwable argCause) {
/* 47 */     super(argCause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ObjectNotPresentException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */