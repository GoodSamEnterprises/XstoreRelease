package dtv.pos.iframework.form.config;

import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.dependency.IDependencyRule;
import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
import dtv.util.config.IConfigObject;
import dtv.util.config.ParameterListConfig;

public interface IFieldDependencyConfig extends IConfigObject {
  String getFieldRef();
  
  ParameterListConfig getRuleParams();
  
  IDependencyRule makeDependencyRule(IEditModel paramIEditModel, IMutableFieldDefinition paramIMutableFieldDefinition);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IFieldDependencyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */