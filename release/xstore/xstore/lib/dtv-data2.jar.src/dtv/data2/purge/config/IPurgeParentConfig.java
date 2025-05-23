package dtv.data2.purge.config;

import java.util.Collection;

public interface IPurgeParentConfig<C extends IPurgeConfig> extends IPurgeConfig {
  C getChild(String paramString);
  
  Collection<? extends C> getPrioritizedChildren();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\purge\config\IPurgeParentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */