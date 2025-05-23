package dtv.pos.iframework.form.config;

import dtv.pos.iframework.form.IDataModelFactory;
import dtv.pos.iframework.form.IListFieldElementDescr;
import dtv.util.config.IConfigObject;

public interface IDataObjectDefinitionConfig extends IConfigObject {
  Class<IDataModelFactory> getFactoryClass();
  
  IDataEditFieldListConfig getKeyFields();
  
  String getMappingId();
  
  IDataEditFieldListConfig getOtherFields();
  
  IListFieldElementDescr makeFieldElementDescriptor();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IDataObjectDefinitionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */