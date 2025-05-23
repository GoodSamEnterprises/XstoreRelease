package dtv.pos.framework.scope;

public interface OperationDefaultScope extends DefaultScope, MutableXScope {
  <T> void clearValue(ValueKey<T> paramValueKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\scope\OperationDefaultScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */