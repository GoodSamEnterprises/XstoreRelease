package dtv.pos.framework.ui.config;

import dtv.pos.iframework.ui.config.IViewComponentConfig;
import dtv.util.config.IParentConfig;

public interface IRootComponentConfig extends IParentConfig {
  IViewComponentConfig getMainComponent();
  
  String getName();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\config\IRootComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */