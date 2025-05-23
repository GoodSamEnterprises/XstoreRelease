package dtv.pos.iframework.form.config;

import dtv.data2.access.IDataModel;
import dtv.i18n.IFormattable;
import dtv.pos.iframework.form.IDaoEditModel;
import dtv.pos.iframework.form.mapping.IEditModelKey;
import dtv.util.config.IConfigObject;
import java.util.Map;

public interface IDaoEditMappingConfig extends IConfigObject {
  IDataObjectDefinitionConfig[] getDataDefs();
  
  IFormattable getDescription();
  
  IEditModelKey getModelKey();
  
  IFormattable getName();
  
  Map<String, IDataObjectDefinitionConfig> getObjectMap();
  
  IDaoEditModel makeEditModel(IDataModel[] paramArrayOfIDataModel, Boolean paramBoolean);
  
  void setObjectMap(Map<String, IDataObjectDefinitionConfig> paramMap);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IDaoEditMappingConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */