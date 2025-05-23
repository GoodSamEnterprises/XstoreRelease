package dtv.pos.iframework.op;

import dtv.pos.iframework.event.IXstEvent;

public interface IReversibleOp extends IOperation {
  IOpResponse handleOpReverse(IXstEvent paramIXstEvent);
  
  boolean isApplicableToReverse();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IReversibleOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */