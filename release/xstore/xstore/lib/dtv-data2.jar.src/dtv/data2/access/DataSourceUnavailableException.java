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
/*    */ 
/*    */ public class DataSourceUnavailableException
/*    */   extends ObjectNotFoundException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public DataSourceUnavailableException() {}
/*    */   
/*    */   public DataSourceUnavailableException(String argMessage) {
/* 29 */     super(argMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataSourceUnavailableException(String argMessage, Throwable argCause) {
/* 39 */     super(argMessage, argCause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataSourceUnavailableException(Throwable argCause) {
/* 48 */     super(argCause);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\DataSourceUnavailableException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */