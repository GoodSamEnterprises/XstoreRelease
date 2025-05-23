package dtv.pos.iframework.ui.config;

import dtv.i18n.IFormattable;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.IConfigObject;

public interface IPromptSectionConfig extends ICascadableConfig, IUIConfig, IConfigObject {
  void clear();
  
  IFormattable getText(IFormattable[] paramArrayOfIFormattable);
  
  IFormattable getTextKey();
  
  void setPretext(IFormattable paramIFormattable);
  
  void setTextKey(IFormattable paramIFormattable);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IPromptSectionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */