package dtv.data2.dataserver.config;

import dtv.data2.dataserver.IDataServerAction;

public interface IActionConfig {
  IDataServerAction getAction() throws Exception;
  
  String getType();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\IActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */