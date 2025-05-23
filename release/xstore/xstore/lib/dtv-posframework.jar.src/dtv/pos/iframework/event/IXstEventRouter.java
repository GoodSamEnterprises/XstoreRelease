package dtv.pos.iframework.event;

public interface IXstEventRouter extends IXstEventListener {
  boolean addListener(IXstEventListener paramIXstEventListener);
  
  boolean addListener(IXstEventListener paramIXstEventListener, Class<?> paramClass);
  
  boolean addListener(IXstEventListener paramIXstEventListener, IXstEventType paramIXstEventType);
  
  void fireEvent(IXstEvent paramIXstEvent);
  
  boolean removeListener(IXstEventListener paramIXstEventListener);
  
  boolean removeListener(IXstEventListener paramIXstEventListener, Class<?> paramClass);
  
  boolean removeListener(IXstEventListener paramIXstEventListener, IXstEventType paramIXstEventType);
  
  void setDefaultEventHandler(IXstEventListener paramIXstEventListener);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\event\IXstEventRouter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */