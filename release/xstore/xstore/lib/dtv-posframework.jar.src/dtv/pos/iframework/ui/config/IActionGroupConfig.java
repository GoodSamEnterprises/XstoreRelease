package dtv.pos.iframework.ui.config;

import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.form.design.IHasEquivalence;
import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;
import java.util.Collection;

public interface IActionGroupConfig extends ISavableConfig, IHasEquivalence, IConfigObject {
  void addActionConfig(IActionConfig paramIActionConfig);
  
  IActionConfig[] getActionConfigs();
  
  Collection<IXstAction> getActions();
  
  DataActionGroupKey getGroupKey();
  
  String getGroupSubKey();
  
  void removeActionConfig(IActionConfig paramIActionConfig);
  
  void setGroupKey(DataActionGroupKey paramDataActionGroupKey);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IActionGroupConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */