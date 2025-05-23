package dtv.pos.iframework.form.config;

import dtv.pos.iframework.form.mapping.IEditModelKey;
import dtv.util.config.IConfigObject;
import java.util.Map;

public interface IDaoEditMappingListConfig extends IConfigObject {
  Map<IEditModelKey, IDaoEditMappingConfig> getMappingsMap();
  
  Map<String, IDataObjectDefinitionConfig> getObjectMap();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IDaoEditMappingListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */