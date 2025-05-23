package dtv.pos.iframework.ui;

import java.awt.Component;

public interface IComponentRegistry {
  Component getNamedComponent(String paramString);
  
  void registerNamedComponent(Component paramComponent, String paramString);
  
  void removeNamedComponent(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\IComponentRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */