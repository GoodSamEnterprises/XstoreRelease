package dtv.pos.iframework.op.req;

import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.event.IXstEventListener;

public interface IOpReqHandler {
  void handleRequest(IOpRequest paramIOpRequest, IXstEventListener paramIXstEventListener, IModeController paramIModeController);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\req\IOpReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */