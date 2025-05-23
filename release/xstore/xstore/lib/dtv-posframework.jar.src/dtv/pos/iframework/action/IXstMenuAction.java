package dtv.pos.iframework.action;

import dtv.pos.iframework.op.req.IOpRequest;
import java.awt.event.ActionEvent;

public interface IXstMenuAction extends IXstAction, IOpRequest {
  ActionEvent getMenuEvent();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstMenuAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */