package dtv.pos.iframework.form.config;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.action.FormTabKey;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.visibilityrules.IVisibilityRule;
import dtv.util.config.ISavableConfig;
import dtv.util.config.ITabOrder;
import java.util.List;

public interface IFormViewPanelConfig<C extends dtv.pos.iframework.ui.config.IViewComponentConfig> extends IFormComponentConfig<C>, ITabOrder, ISavableConfig {
  String getActionSubGroupKey();
  
  IXstActionKey getAdditionalActionKey();
  
  Class<?> getCustomViewClass();
  
  FormTabKey getFormTabKey();
  
  FormPanelType getPanelType();
  
  IFormattable getTitle();
  
  List<IVisibilityRule> getVisibilityRules();
  
  void setFormTabKey(String paramString);
  
  void setPanelType(FormPanelType paramFormPanelType);
  
  void setResource(String paramString);
  
  void setTextKey(String paramString);
  
  void setVisible(Boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormViewPanelConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */