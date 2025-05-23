package dtv.pos.framework.scope;

public interface XScope {
  String dump();
  
  <T> T getValue(ValueKey<T> paramValueKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\XScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */