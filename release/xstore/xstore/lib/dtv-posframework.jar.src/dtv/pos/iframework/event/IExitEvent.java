package dtv.pos.iframework.event;

import dtv.pos.iframework.type.IExitType;

public interface IExitEvent {
  IExitType getExitType();
  
  String getMessage();
  
  Throwable getThrowable();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\event\IExitEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */