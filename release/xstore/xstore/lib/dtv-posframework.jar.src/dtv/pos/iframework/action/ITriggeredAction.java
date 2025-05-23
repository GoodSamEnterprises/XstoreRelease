package dtv.pos.iframework.action;

import dtv.pos.iframework.event.IXstEvent;

public interface ITriggeredAction {
  IXstEvent getTrigger();
  
  void setTrigger(IXstEvent paramIXstEvent);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\ITriggeredAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */