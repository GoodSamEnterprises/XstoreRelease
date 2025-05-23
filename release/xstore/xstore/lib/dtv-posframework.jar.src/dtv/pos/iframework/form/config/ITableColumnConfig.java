package dtv.pos.iframework.form.config;

import dtv.i18n.FormatterType;
import dtv.i18n.IFormattable;
import dtv.i18n.IFormatter;
import dtv.pos.ui.text.TextFieldInputType;
import dtv.util.config.IConfigObject;

public interface ITableColumnConfig extends IConfigObject {
  TextFieldInputType getEditFormatType();
  
  IFormattable getHeader();
  
  Integer getModelColumnIndex();
  
  boolean getReadOnly();
  
  String getResource();
  
  IFormatter getViewFormatter();
  
  FormatterType getViewFormatType();
  
  Integer getWidth();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\ITableColumnConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */