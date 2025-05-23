package dtv.pos.iframework.form.config;

import dtv.util.config.IConfigObject;

public interface IDataEditFieldListConfig extends IConfigObject {
  IDataEditFieldConfig getFieldConfig(String paramString);
  
  IDataEditFieldConfig[] getFieldConfigs();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\form\config\IDataEditFieldListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */