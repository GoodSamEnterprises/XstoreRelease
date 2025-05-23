package dtv.pos.framework.worker;

import dtv.pos.iframework.op.IOperationImpl;
import java.util.List;

public interface IWorkerOp extends IOperationImpl {
  void setWorkers(List<IWorker> paramList);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\IWorkerOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */