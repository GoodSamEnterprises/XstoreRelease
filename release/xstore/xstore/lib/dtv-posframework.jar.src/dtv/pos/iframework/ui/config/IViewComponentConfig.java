package dtv.pos.iframework.ui.config;

import dtv.pos.iframework.form.ILayoutLocation;
import dtv.pos.iframework.form.design.model.ILayoutParameters;
import dtv.ui.ComponentID;
import dtv.util.IParent;
import dtv.util.config.ClassConfig;
import dtv.util.config.ParameterConfig;
import dtv.util.config.ParameterListConfig;
import java.awt.Component;
import java.awt.LayoutManager;

public interface IViewComponentConfig<C extends IViewComponentConfig> extends IParent<C>, IUIConfig {
  void addChild(C paramC);
  
  void deleteChild(C paramC);
  
  String getClassType();
  
  Class<? extends Component> getComponentClass();
  
  ComponentID getComponentId();
  
  ParameterConfig[] getComponentParameters();
  
  String getContextSensitiveConstraint();
  
  IDataFieldConfig getDataConfig();
  
  String getDescription();
  
  ILayoutLocation getEditableLayoutLocation();
  
  ILayoutParameters getEditableLayoutParameters();
  
  boolean getEnabled();
  
  Class<? extends LayoutManager> getLayout();
  
  Integer getLayoutLayer();
  
  String getLayoutLocation();
  
  LayoutManager getLayoutManager() throws Exception;
  
  String getLayoutParameter();
  
  ParameterListConfig getLayoutParameters();
  
  String getName();
  
  String getToolTip();
  
  boolean getVisible();
  
  boolean isContextSensitive();
  
  boolean isEntryMasked();
  
  void setComponentId(String paramString);
  
  void setLayout(ClassConfig<? extends LayoutManager> paramClassConfig);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IViewComponentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */