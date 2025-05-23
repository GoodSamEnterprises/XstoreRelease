package dtv.data2.access.status;

import java.util.Map;

public interface IStatusMgr {
  int getOfflineCount();
  
  int getOfflineCount(String paramString);
  
  Map<String, Integer> getOfflineCountMap();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\status\IStatusMgr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */