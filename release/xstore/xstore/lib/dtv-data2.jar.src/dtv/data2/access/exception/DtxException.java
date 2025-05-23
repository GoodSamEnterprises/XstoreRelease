/*    */ package dtv.data2.access.exception;
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
/*    */ public class DtxException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 397381893538675286L;
/*    */   
/*    */   public DtxException(String argMessage) {
/* 22 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DtxException(String argMessage, Throwable argCause) {
/* 31 */     super(argMessage, argCause);
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\exception\DtxException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */