package dtv.pos.iframework.op;

import dtv.pos.iframework.event.IXstEvent;

public interface ITraversalStrategy {
  TraversalStrategyType getTraversalStrategyType();
  
  IOpResponse handleExec(ITraversableChain paramITraversableChain, IOperation paramIOperation, IXstEvent paramIXstEvent) throws CancelOpException;
  
  IOpResponse handleNoNextOp(ITraversableChain paramITraversableChain);
  
  void handleOpCompleted(ITraversableChain paramITraversableChain, IOperation paramIOperation);
  
  void init();
  
  boolean isChainComplete(ITraversableChain paramITraversableChain);
  
  void setNextOp(ITraversableChain paramITraversableChain) throws CancelOpException;
  
  void setOpChainProcessor(IOpChainProcessor paramIOpChainProcessor);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\ITraversalStrategy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */