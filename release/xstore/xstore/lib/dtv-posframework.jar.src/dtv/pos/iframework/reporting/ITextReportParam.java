package dtv.pos.iframework.reporting;

import dtv.pos.ui.text.TextFieldInputType;
import java.util.Properties;

public interface ITextReportParam extends IReportParam {
  Properties getFieldModifiers();
  
  Object getInitialValue();
  
  TextFieldInputType getInputType();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\reporting\ITextReportParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */