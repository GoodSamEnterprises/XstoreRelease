package dtv.pos.iframework.action;

import dtv.pos.iframework.event.IXstEventListener;
import dtv.pos.iframework.security.ISecureAction;
import dtv.pos.iframework.ui.model.IPromptActionModel;
import dtv.pos.iframework.ui.model.IUIInputModel;

public interface IXstDataAction extends IXstAction, ISecureAction {
  void setEventListener(IXstEventListener paramIXstEventListener);
  
  void setModel(IUIInputModel paramIUIInputModel);
  
  void setParent(IPromptActionModel paramIPromptActionModel);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstDataAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */