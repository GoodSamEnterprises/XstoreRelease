package dtv.docbuilding.trace;

public interface ITracer {
  void attr(String paramString);
  
  void endNode(String paramString);
  
  String startNode(String paramString);
  
  String startNode(String paramString, int paramInt);
  
  void warn(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\trace\ITracer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */