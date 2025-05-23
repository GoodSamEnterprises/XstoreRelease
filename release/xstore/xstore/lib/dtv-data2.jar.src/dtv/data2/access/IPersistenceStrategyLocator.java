package dtv.data2.access;

import dtv.data2.access.impl.IPersistenceStrategy;

public interface IPersistenceStrategyLocator {
  IPersistenceStrategy createStrategy(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\IPersistenceStrategyLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */