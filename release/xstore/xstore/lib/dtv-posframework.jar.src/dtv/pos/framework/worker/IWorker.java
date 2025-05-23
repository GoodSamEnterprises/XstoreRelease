package dtv.pos.framework.worker;

import dtv.pos.iframework.op.LongRunningCapable;
import dtv.util.config.IHasSourceDescription;
import dtv.util.config.ISourceLocationAware;

public interface IWorker extends LongRunningCapable, IHasSourceDescription, ISourceLocationAware {
  boolean isApplicable();
  
  void performWork() throws WorkFailedException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\IWorker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */