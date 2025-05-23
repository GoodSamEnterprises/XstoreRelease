package dtv.pos.iframework.form.dependency;

import dtv.pos.iframework.form.IEditModel;
import dtv.pos.iframework.form.config.IFieldDependencyConfig;
import dtv.util.config.IHasSourceDescription;

public interface IDependencyRule extends IHasSourceDescription {
  void initialize();
  
  void setConfig(IFieldDependencyConfig paramIFieldDependencyConfig);
  
  void setParentEditModel(IEditModel paramIEditModel);
  
  void setParentField(IMutableFieldDefinition paramIMutableFieldDefinition);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\dependency\IDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */