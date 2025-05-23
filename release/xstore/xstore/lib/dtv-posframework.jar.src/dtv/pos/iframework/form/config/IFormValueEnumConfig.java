package dtv.pos.iframework.form.config;

import dtv.pos.iframework.form.IValueWrapperFactory;
import dtv.util.config.IConfigObject;
import dtv.util.config.ParameterListConfig;
import java.util.List;

public interface IFormValueEnumConfig extends IConfigObject {
  IFormValueEnumListConfig getConfiguredValues();
  
  ParameterListConfig getLoaderParams();
  
  List<? extends Object> getValues();
  
  IValueWrapperFactory getWrapperFactory();
  
  boolean isNullAllowed();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFormValueEnumConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */