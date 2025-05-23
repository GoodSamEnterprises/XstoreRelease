/*    */ package dtv.pos.iframework;
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
/*    */ public class CheckFailedException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 4986741044593255655L;
/*    */   
/*    */   public CheckFailedException(String argMsg) {
/* 23 */     super(argMsg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CheckFailedException(String argMsg, Throwable argCause) {
/* 35 */     super(argMsg, argCause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\CheckFailedException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */