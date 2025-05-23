package dtv.pos.iframework.form.config;

import dtv.util.config.ISavableConfig;
import dtv.util.config.ITabOrder;

public interface IFormViewSectionConfig<C extends dtv.pos.iframework.ui.config.IViewComponentConfig> extends IFormComponentConfig<C>, ITabOrder, ISavableConfig {
  IFormViewPanelConfig getFormViewPanel();
  
  void setFormViewPanel(IFormViewPanelConfig paramIFormViewPanelConfig);
  
  void setName(String paramString);
  
  void setVisible(Boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormViewSectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */