package dtv.pos.framework.worker;

public interface WorkerLocator {
  IWorker getWorker(String paramString);
  
  WorkerList getWorkerList(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\WorkerLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */