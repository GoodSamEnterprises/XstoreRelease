package dtv.pos.iframework.ui.config;

import dtv.i18n.IFormattable;
import dtv.pos.ui.text.TextFieldFormatters;
import dtv.pos.ui.text.TextFieldInputType;
import dtv.ui.swing.text.IStyler;
import dtv.util.MutableString;
import dtv.util.config.ICascadableConfig;
import dtv.util.config.IConfigObject;
import dtv.util.config.ISavableConfig;
import java.util.Currency;

public interface IDataFieldConfig extends ISavableConfig, ICascadableConfig, IUIConfig, IConfigObject {
  TextFieldInputType getDisplayFormatType();
  
  IEditFormatterParams getEditFormatterParams();
  
  MutableString getEditPattern();
  
  TextFieldFormatters getFormatters();
  
  TextFieldInputType getFormatType();
  
  int getMaxCharacters();
  
  IStyler getStyler();
  
  IFormattable getTextKey();
  
  Object getValue();
  
  Boolean isEditable();
  
  boolean isEndOfValueDisplayed();
  
  boolean isEntryDisabled();
  
  boolean isEntryMasked();
  
  void setCurrency(Currency paramCurrency);
  
  void setDefaultValue(Object paramObject);
  
  void setDisplayFormatType(TextFieldInputType paramTextFieldInputType);
  
  void setEditFormatterParams(IEditFormatterParams paramIEditFormatterParams);
  
  void setEditPattern(String paramString);
  
  void setEndOfValueDisplayed(boolean paramBoolean);
  
  void setFormatType(TextFieldInputType paramTextFieldInputType);
  
  void setMaxCharacters(int paramInt);
  
  void setStyler(IStyler paramIStyler);
  
  void setTextKey(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\config\IDataFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */