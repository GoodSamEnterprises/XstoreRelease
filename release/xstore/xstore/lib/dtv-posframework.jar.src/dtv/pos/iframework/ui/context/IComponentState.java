package dtv.pos.iframework.ui.context;

import dtv.util.config.ParameterListConfig;

public interface IComponentState {
  String getComponentName();
  
  ParameterListConfig getParameters();
  
  boolean isEnabled();
  
  boolean isVisible();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\context\IComponentState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */