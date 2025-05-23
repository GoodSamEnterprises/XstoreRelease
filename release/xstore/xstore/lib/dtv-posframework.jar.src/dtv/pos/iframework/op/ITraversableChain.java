package dtv.pos.iframework.op;

public interface ITraversableChain extends IOpChain {
  void addAsCompleted(IOperation paramIOperation);
  
  void addToQueueFront(IOperation paramIOperation);
  
  void addToReversalStack(IOperation paramIOperation);
  
  IOperation[] getCompletedOps();
  
  IOperation getCurrentOp();
  
  boolean hasOpOnList(IOperation paramIOperation);
  
  boolean isCompletedStackEmpty();
  
  boolean isOpQueueEmpty();
  
  boolean isOpStackEmpty();
  
  boolean isReversalStackEmpty();
  
  IOperation popFromCompletedStack();
  
  IOperation popFromOpQueue();
  
  IOperation popFromOpStack();
  
  IOperation popFromReversalStack();
  
  void requeue(IOperation paramIOperation);
  
  void revertOpState(IOperation paramIOperation);
  
  void setCurrentOp(IOperation paramIOperation);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\ITraversableChain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */