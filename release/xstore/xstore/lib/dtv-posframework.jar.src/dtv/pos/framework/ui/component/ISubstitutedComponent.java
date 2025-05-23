package dtv.pos.framework.ui.component;

import dtv.pos.iframework.ui.config.IViewComponentConfig;
import dtv.ui.IComponent;

public interface ISubstitutedComponent<C extends IViewComponentConfig> extends IComponent {
  IViewComponentConfig<C> getNewConfig();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\ISubstitutedComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */