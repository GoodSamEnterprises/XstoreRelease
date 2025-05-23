package dtv.pos.iframework.action;

import java.awt.Component;
import java.util.Collection;

public interface IXstKeyStrokeAction extends IXstAction {
  Collection<Component> getKeyStrokeTargets();
  
  void setKeyStrokeTargets(Collection<Component> paramCollection);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\action\IXstKeyStrokeAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */