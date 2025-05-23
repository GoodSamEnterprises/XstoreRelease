package dtv.pos.iframework;

public interface IBusyState {
  void end();
  
  void endPermanent();
  
  void start(String paramString);
  
  void startPermanent(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\IBusyState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */