package dtv.pos.iframework.action;

import dtv.pos.common.OpChainKey;
import dtv.pos.iframework.event.IXstEventListener;
import dtv.pos.iframework.security.ISecureAction;

public interface IXstChainAction extends IXstAction, ISecureAction, ITriggeredAction {
  OpChainKey getOpChainKey();
  
  boolean isRequired();
  
  void setEventListener(IXstEventListener paramIXstEventListener);
  
  void setRequired(boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstChainAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */