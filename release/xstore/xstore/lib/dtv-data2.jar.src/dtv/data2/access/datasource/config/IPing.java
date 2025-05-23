package dtv.data2.access.datasource.config;

import java.util.Properties;

public interface IPing {
  String getHost();
  
  int getPort();
  
  boolean ping();
  
  void setProperties(Properties paramProperties);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\datasource\config\IPing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */