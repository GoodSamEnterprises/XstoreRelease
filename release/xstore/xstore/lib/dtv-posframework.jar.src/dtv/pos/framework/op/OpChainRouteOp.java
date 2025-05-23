/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.framework.action.type.XstChainActionType;
/*    */ import dtv.pos.framework.logging.ProcessLogger;
/*    */ import dtv.pos.framework.op.req.RunChainRequest;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
/*    */ import dtv.pos.iframework.op.IOpState;
/*    */ import dtv.pos.iframework.op.IReversibleOp;
/*    */ import dtv.pos.iframework.op.OpStatus;
/*    */ import dtv.pos.iframework.op.req.IOpRequest;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
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
/*    */ public class OpChainRouteOp
/*    */   extends Operation
/*    */   implements IReversibleOp
/*    */ {
/* 33 */   private IOpState CHAIN_STACKED = new OpState("CHAIN_STACKED");
/*    */ 
/*    */   
/*    */   private List<OpChainChoice> _chainChoices;
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private ProcessLogger _flowLogger;
/*    */ 
/*    */   
/*    */   public OpChainRouteOp(List<OpChainChoice> argChoices) {
/* 44 */     this._chainChoices = argChoices;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 50 */     if (getOpState() == null) {
/* 51 */       for (OpChainChoice choice : this._chainChoices) {
/* 52 */         if (choice.getRunCondition().shouldRun()) {
/* 53 */           String chainDetail = choice.getChainKey().toString() + ":" + choice.getChainType().toString();
/* 54 */           String suffix = " [Condition: " + choice.getRunCondition().getClass().getName() + "]";
/* 55 */           this._flowLogger.info("Choice", chainDetail, null, "+", suffix);
/* 56 */           OpStatus status = OpStatus.COMPLETE_HALT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 65 */           if (XstChainActionType.STACK.equals(choice.getChainType())) {
/* 66 */             setOpState(this.CHAIN_STACKED);
/* 67 */             status = OpStatus.INCOMPLETE_HALT;
/*    */           } 
/*    */ 
/*    */           
/* 71 */           RunChainRequest runChainRequest = new RunChainRequest(choice.getChainKey(), argEvent, choice.getChainType(), null, true);
/* 72 */           return new OpResponse(status, new IOpRequest[] { (IOpRequest)runChainRequest });
/*    */         } 
/*    */       } 
/*    */     }
/*    */     
/* 77 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpReverse(IXstEvent argEvent) {
/* 83 */     setOpState(null);
/* 84 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainRouteOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */