package dtv.pos.iframework.op;

import dtv.util.IPooledObject;
import dtv.util.config.IConfigObject;

public interface IOpExecutor extends IReversibleOp, IPooledObject, IConfigObject {
  void setOp(IOperation paramIOperation);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOpExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */