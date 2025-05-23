/*    */ package dtv.pos.iframework.op;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.pos.common.OpChainKey;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.event.IXstEventListener;
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
/*    */ public interface IOpChainProcessor
/*    */   extends IEventSource, IXstEventListener, Runnable
/*    */ {
/* 27 */   public static final EventEnum OP_CHAIN_PROCESSOR_COMPLETE = new EventEnum("OP_CHAIN_PROCESSOR_COMPLETE");
/* 28 */   public static final EventEnum OP_CHAIN_PROCESSOR_PAUSED = new EventEnum("OP_CHAIN_PROCESSOR_PAUSED");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public static final EventEnum OP_CHAIN_PROCESSOR_STARTED = new EventEnum("OP_CHAIN_PROCESSOR_STARTED");
/*    */   
/*    */   void handleXstAction(IXstAction paramIXstAction);
/*    */   
/*    */   void handleXstEventImmediately(IXstEvent paramIXstEvent);
/*    */   
/*    */   void initialize();
/*    */   
/*    */   void popDefaultChain();
/*    */   
/*    */   void postEvent(EventEnum paramEventEnum, Object paramObject);
/*    */   
/*    */   void setDefaultChain(OpChainKey paramOpChainKey, int paramInt);
/*    */   
/*    */   void setEnabled(boolean paramBoolean);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOpChainProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */