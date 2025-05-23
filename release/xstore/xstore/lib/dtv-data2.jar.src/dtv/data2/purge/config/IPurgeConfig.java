package dtv.data2.purge.config;

import dtv.data2.purge.PurgeMetaData;
import dtv.util.config.IConfigObject;
import dtv.util.config.IHasConfigParameters;
import java.util.concurrent.Callable;

public interface IPurgeConfig extends IConfigObject, IHasConfigParameters, Callable<PurgeMetaData>, Comparable<IPurgeConfig> {
  String getDescription();
  
  String getName();
  
  int getOrder();
  
  IConfigObject getParameterValue(String paramString);
  
  boolean isEnabled();
  
  void setEnabled(boolean paramBoolean);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\IPurgeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */