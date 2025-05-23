package dtv.pos.iframework.form;

import dtv.i18n.IFormattable;
import java.util.Properties;

public interface IInputFieldDescriptor {
  Properties getFormatModifiers();
  
  String getFormatterType();
  
  IFormattable getLabel();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IInputFieldDescriptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */