/*    */ package dtv.pos.framework.scope;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.pos.common.TransactionType;
/*    */ import dtv.xst.dao.trn.IPosTransaction;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface TransactionScope
/*    */   extends MutableXScope
/*    */ {
/* 35 */   public static final EventEnum TRANSACTION_MODIFIED = new EventEnum("TRANSACTION_MODIFIED");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   public static final ValueKey<IPosTransaction> CURRENT_TRANSACTION = new ValueKey<>(IPosTransaction.class, "CURRENT_TRANSACTION");
/*    */   
/*    */   <T> void clearValue(ValueKey<T> paramValueKey);
/*    */   
/*    */   IEventSource getEventSource();
/*    */   
/*    */   IPosTransaction getTransaction();
/*    */   
/*    */   <T extends IPosTransaction> T getTransaction(TransactionType<T> paramTransactionType);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\TransactionScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */