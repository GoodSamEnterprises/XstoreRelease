package dtv.pos.iframework.form.config;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.i18n.config.IFormattableConfig;
import dtv.pos.iframework.ui.ScrollingPolicy;
import dtv.pos.iframework.ui.SelectionMode;
import dtv.pos.iframework.ui.config.IRendererDefConfig;
import dtv.util.config.ISavableConfig;
import dtv.util.config.ITabOrder;

public interface IFormViewCellConfig extends IFormComponentConfig<IFormComponentConfig>, ISavableConfig, ITabOrder {
  boolean allowsPossibleValues();
  
  IFormattable getBorderTextKey();
  
  EnumPossibleValues getEnumPossibleValues();
  
  FormatterType getFormatterType();
  
  boolean getHideFromXstoreM();
  
  ScrollingPolicy getHorizontalScrollingPolicy();
  
  Integer getNotifyDelay();
  
  Boolean getReadOnly();
  
  boolean getRefreshDependentValues();
  
  IRendererDefConfig getRendererDef(String paramString);
  
  Boolean getRequired();
  
  String getResourceLink();
  
  SelectionMode getSelectionMode();
  
  ITableColumnsConfig getTableColumnsConfig();
  
  ScrollingPolicy getVerticalScrollingPolicy();
  
  String getVisibilityGroup();
  
  String getXmlTag();
  
  boolean isEntryMasked();
  
  void setEnumPossibleValues(EnumPossibleValues paramEnumPossibleValues);
  
  void setFieldWeight(Integer paramInteger);
  
  void setFormatterType(FormatterType paramFormatterType);
  
  void setHideFromXstoreM(boolean paramBoolean);
  
  void setHorizontalScrollingPolicy(ScrollingPolicy paramScrollingPolicy);
  
  void setNotifyDelay(Integer paramInteger);
  
  void setReadOnly(Boolean paramBoolean);
  
  void setRefreshDependentValues(boolean paramBoolean);
  
  void setRendererDef(IRendererDefConfig paramIRendererDefConfig);
  
  void setRequired(Boolean paramBoolean);
  
  void setResource(String paramString);
  
  void setResourceLink(String paramString);
  
  void setSelectionMode(SelectionMode paramSelectionMode);
  
  void setTextKey(IFormattableConfig paramIFormattableConfig);
  
  void setTextKey(String paramString);
  
  void setType(String paramString);
  
  void setValue(IFormattableConfig paramIFormattableConfig);
  
  void setVerticalScrollingPolicy(ScrollingPolicy paramScrollingPolicy);
  
  void setVisibilityGroup(String paramString);
  
  void setXmlTag(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormViewCellConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */