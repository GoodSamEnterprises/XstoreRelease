package dtv.pos.iframework.ui.config;

import dtv.i18n.IFormattable;
import dtv.i18n.config.IFormattableConfig;
import dtv.pos.iframework.action.DataActionGroupKey;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.action.IXstActionKey;
import dtv.pos.iframework.action.IXstActionType;
import dtv.pos.iframework.action.IXstKeyStroke;
import dtv.pos.iframework.form.design.IHasEquivalence;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.IReflectionParameterCapable;
import dtv.util.config.ISavableConfig;
import java.util.Set;

public interface IActionConfig extends ISavableConfig, IHasEquivalence, ICascadableConfig, IUIConfig {
  void addKeyStroke(IXstKeyStroke paramIXstKeyStroke);
  
  IXstAction getAction(DataActionGroupKey paramDataActionGroupKey);
  
  IReflectionParameterCapable<?> getData();
  
  String getIconKey();
  
  String getId();
  
  IXstActionKey getKey();
  
  IXstKeyStroke getKeyStroke();
  
  Set<IXstKeyStroke> getKeyStrokes();
  
  String getKeywords();
  
  String getReference();
  
  IFormattable getRootTextKey();
  
  IFormattable getTextKey();
  
  IXstActionType getType();
  
  boolean isVisible();
  
  void setData(IReflectionParameterCapable<?> paramIReflectionParameterCapable);
  
  void setIconKey(String paramString);
  
  void setKey(IXstActionKey paramIXstActionKey);
  
  void setKey(String paramString);
  
  void setKeyStroke(IXstKeyStroke paramIXstKeyStroke);
  
  void setKeywords(String paramString);
  
  void setReference(String paramString);
  
  void setRootTextKey(IFormattableConfig paramIFormattableConfig);
  
  void setTextKey(IFormattableConfig paramIFormattableConfig);
  
  void setType(IXstActionType paramIXstActionType);
  
  void setVisible(Boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */