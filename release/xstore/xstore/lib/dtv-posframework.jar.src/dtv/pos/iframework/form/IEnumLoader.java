package dtv.pos.iframework.form;

import dtv.pos.iframework.form.config.IFormValueEnumConfig;
import java.util.List;

public interface IEnumLoader {
  List<? extends Object> getValues();
  
  IValueWrapperFactory getWrapperFactory();
  
  void setConfig(IFormValueEnumConfig paramIFormValueEnumConfig);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\IEnumLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */