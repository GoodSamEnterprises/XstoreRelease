package dtv.pos.framework.event;

import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.event.IXstEvent;

public interface IXstEventMatcher {
  IXstAction getAction();
  
  boolean matches(IXstEvent paramIXstEvent);
  
  int priority();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\IXstEventMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */