/*    */ package dtv.xst.daocommon;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
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
/*    */ public interface IRetailTransactionManager
/*    */   extends IEventSource
/*    */ {
/* 27 */   public static final EventEnum TRANSACTION_UPDATED = new EventEnum("TRANSACTION_UPDATED");
/*    */   
/*    */   void init();
/*    */   
/*    */   void initializeListeners();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IRetailTransactionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */