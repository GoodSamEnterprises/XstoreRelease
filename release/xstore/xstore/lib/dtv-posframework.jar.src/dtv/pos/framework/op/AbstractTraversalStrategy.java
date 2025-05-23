/*    */ package dtv.pos.framework.op;
/*    */ 
/*    */ import dtv.pos.framework.logging.ProcessLogger;
/*    */ import dtv.pos.iframework.op.IOpChain;
/*    */ import dtv.pos.iframework.op.IOpChainProcessor;
/*    */ import dtv.pos.iframework.op.ITraversalStrategy;
/*    */ import dtv.pos.iframework.op.TraversalStrategyType;
/*    */ import javax.inject.Inject;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractTraversalStrategy
/*    */   implements ITraversalStrategy
/*    */ {
/* 22 */   protected static final Logger _logger = Logger.getLogger(AbstractTraversalStrategy.class);
/*    */ 
/*    */   
/*    */   @Inject
/*    */   protected ProcessLogger _flowLogger;
/*    */ 
/*    */   
/*    */   @Inject
/*    */   protected OpResponseHelper _opResponseHelper;
/*    */ 
/*    */   
/*    */   private final TraversalStrategyType _type;
/*    */ 
/*    */   
/*    */   private IOpChainProcessor _processor;
/*    */ 
/*    */   
/*    */   public AbstractTraversalStrategy(TraversalStrategyType argType) {
/* 40 */     this._type = argType;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final TraversalStrategyType getTraversalStrategyType() {
/* 46 */     return this._type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {}
/*    */ 
/*    */   
/*    */   public void setOpChainProcessor(IOpChainProcessor argProcessor) {
/* 54 */     this._processor = argProcessor;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 59 */     return "TraversalStrategy[" + this._type.name() + "]";
/*    */   }
/*    */   
/*    */   protected final IOpChainProcessor getOpChainProcessor() {
/* 63 */     return this._processor;
/*    */   }
/*    */   
/*    */   protected void postChainComplete(IOpChain argOpChain) {
/* 67 */     this._flowLogger.decrementProcessDepth();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractTraversalStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */