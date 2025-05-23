package dtv.pos.iframework.form.config;

import dtv.i18n.IFormattable;
import dtv.i18n.config.IFormattableConfig;
import dtv.pos.common.FormKey;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.form.FormLocationType;
import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.ui.config.IActionGroupConfig;
import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;
import java.util.Collection;

public interface IFormViewConfig extends ISavableConfig, IConfigObject {
  void addActionGroupConfig(IActionGroupConfig paramIActionGroupConfig);
  
  void addViewPanelConfig(IFormViewPanelConfig paramIFormViewPanelConfig);
  
  void addViewSectionConfig(IFormViewSectionConfig paramIFormViewSectionConfig);
  
  IActionGroupConfig getActionGroupConfig(DataActionGroupKey paramDataActionGroupKey, String paramString);
  
  Collection<IActionGroupConfig> getActionGroupConfigs();
  
  Class<?> getCustomViewClass();
  
  FormKey getFormKey();
  
  String getFormLayoutName();
  
  FormLocationType getFormLocation();
  
  IFormViewSectionConfig getFormViewSection(String paramString);
  
  IFormattable getInstructions();
  
  Collection<IXstAction> getPromptActions(IEditModel paramIEditModel, DataActionGroupKey paramDataActionGroupKey);
  
  Collection<IXstAction> getPromptActions(IEditModel paramIEditModel, DataActionGroupKey paramDataActionGroupKey, String paramString);
  
  IFormattable getTitleText();
  
  IFormViewPanelConfig<?>[] getViewPanelConfigs();
  
  IFormViewSectionConfig<?>[] getViewSectionConfigs();
  
  boolean isAutoPopOnScreenKbdEnabled();
  
  void removeViewPanelConfig(IFormViewPanelConfig paramIFormViewPanelConfig);
  
  void removeViewSectionConfig(IFormViewSectionConfig paramIFormViewSectionConfig);
  
  void setFormKey(FormKey paramFormKey);
  
  void setFormLayoutName(String paramString);
  
  void setFormLocation(FormLocationType paramFormLocationType);
  
  void setInstructions(IFormattableConfig paramIFormattableConfig);
  
  void setInstructions(String paramString);
  
  void setTitleText(IFormattableConfig paramIFormattableConfig);
  
  void setTitleText(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormViewConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */