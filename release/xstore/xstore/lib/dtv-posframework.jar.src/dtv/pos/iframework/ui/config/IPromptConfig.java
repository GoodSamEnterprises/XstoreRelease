package dtv.pos.iframework.ui.config;

import dtv.pos.common.PromptKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.hardware.audio.ISound;
import dtv.pos.iframework.ui.ActionDisplayType;
import dtv.pos.iframework.ui.IViewElementType;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.IConfigObject;
import java.util.Collection;

public interface IPromptConfig extends ICascadableConfig, IConfigObject {
  void clear();
  
  ActionDisplayType getActionDisplayType();
  
  IDataFieldConfig getDataFieldConfig();
  
  IDataSelectionConfig getDataSelectionConfig();
  
  String getDataSourceName();
  
  IIconGroupConfig getIconGroupConfig();
  
  IViewElementType getListViewHeaderType();
  
  String getListViewRuleSet();
  
  IViewElementType getListViewType();
  
  IPromptSectionConfig getMsgSectionConfig();
  
  IActionConfig[] getPromptActionConfigs();
  
  Collection<IXstAction> getPromptActions();
  
  PromptKey getPromptKey();
  
  String getPromptType();
  
  IPromptSectionConfig getSecondaryMsgSectionConfig();
  
  ISound getSound();
  
  IPromptSectionConfig getTitleSectionConfig();
  
  boolean isAutoPopDecimalKbdEnabled();
  
  boolean isDataFieldConfigSet();
  
  boolean isDataSelectionConfigSet();
  
  boolean isFingerprintEnabled();
  
  void setDataSourceName(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IPromptConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */