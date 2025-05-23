package dtv.pos.framework.process;

public interface ILaunchedProcessManager {
  boolean isProcessRunning(String paramString);
  
  void monitor(IProcMonitorConfig paramIProcMonitorConfig, Process paramProcess);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\process\ILaunchedProcessManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */