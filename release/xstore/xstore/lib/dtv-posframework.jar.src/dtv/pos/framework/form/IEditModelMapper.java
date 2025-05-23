package dtv.pos.framework.form;

import dtv.data2.access.IDataModel;
import dtv.pos.iframework.form.IDaoEditModel;
import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
import dtv.pos.iframework.form.mapping.IEditModelKey;

public interface IEditModelMapper {
  IDataObjectDefinitionConfig getDataObjectDefinitionConfig(String paramString);
  
  IDaoEditModel mapDao(IEditModelKey paramIEditModelKey, IDataModel paramIDataModel, boolean paramBoolean);
  
  IDaoEditModel mapDao(IEditModelKey paramIEditModelKey, IDataModel[] paramArrayOfIDataModel);
  
  IDaoEditModel mapDao(IEditModelKey paramIEditModelKey, IDataModel[] paramArrayOfIDataModel, boolean paramBoolean);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\IEditModelMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */