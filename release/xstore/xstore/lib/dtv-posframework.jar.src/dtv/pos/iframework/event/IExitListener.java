package dtv.pos.iframework.event;

public interface IExitListener {
  void exiting(IExitEvent paramIExitEvent);
  
  public static interface IPrioritizedExitListener extends IExitListener {
    int priority();
  }
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\event\IExitListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */