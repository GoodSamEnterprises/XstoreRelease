/*    */ package dtv.pos.iframework.op;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.iframework.event.IXstEventObserver;
/*    */ import java.util.Collection;
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
/*    */ public interface IOpChain
/*    */   extends IReversibleOp, IEventSource, IXstEventObserver
/*    */ {
/* 24 */   public static final EventEnum OP_CHAIN_STARTED = new EventEnum("OP_CHAIN_STARTED");
/* 25 */   public static final EventEnum OP_CHAIN_NOT_COMPLETE = new EventEnum("OP_CHAIN_NOT_COMPLETE");
/* 26 */   public static final EventEnum OP_CHAIN_COMPLETE = new EventEnum("OP_CHAIN_COMPLETE");
/*    */   
/*    */   void addOp(IOperation paramIOperation);
/*    */   
/*    */   OpChainKey getChainKey();
/*    */   
/*    */   IOperation getCurrentOp();
/*    */   
/*    */   int getOpCount();
/*    */   
/*    */   OpChainKey getRollbackChainKey();
/*    */   
/*    */   int getRollbackLevel();
/*    */   
/*    */   Collection<String> getSignals();
/*    */   
/*    */   TraversalStrategyType getTraversalStrategyType();
/*    */   
/*    */   IOpResponse handleChainReverse();
/*    */   
/*    */   boolean isCurrentOpCancelable();
/*    */   
/*    */   boolean isDefault();
/*    */   
/*    */   boolean isError();
/*    */   
/*    */   void setChainKey(OpChainKey paramOpChainKey);
/*    */   
/*    */   void setProcessor(IOpChainProcessor paramIOpChainProcessor);
/*    */   
/*    */   void setRollbackChainKey(OpChainKey paramOpChainKey);
/*    */   
/*    */   void setRollbackLevel(int paramInt);
/*    */   
/*    */   void setSignals(Collection<String> paramCollection);
/*    */   
/*    */   void setTraversalStrategyType(TraversalStrategyType paramTraversalStrategyType);
/*    */   
/*    */   void stackChain(IOpChain paramIOpChain);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOpChain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */