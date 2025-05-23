package dtv.pos.iframework.form.config;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.form.ICardinality;
import dtv.pos.iframework.form.IListFieldElementDescr;
import dtv.pos.iframework.form.IValueWrapperFactory;
import dtv.pos.iframework.security.ISecuredObjectID;
import dtv.util.config.IConfigObject;
import java.util.List;
import java.util.Map;

public interface IDataEditFieldConfig extends IConfigObject {
  ICardinality getCardinality();
  
  Class<?> getDataType();
  
  IFormattable getDescription();
  
  String getDisplayMask();
  
  IFieldDependencyConfig getFieldDependencyConfig();
  
  String getFieldKey();
  
  IFormattable getFieldName();
  
  String getInputMask();
  
  List<?> getPossibleValues();
  
  ISecuredObjectID getSecuredObject();
  
  IValueWrapperFactory getWrapperFactory();
  
  IListFieldElementDescr makeFieldElementDescriptor(Map<String, IDataObjectDefinitionConfig> paramMap);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IDataEditFieldConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */