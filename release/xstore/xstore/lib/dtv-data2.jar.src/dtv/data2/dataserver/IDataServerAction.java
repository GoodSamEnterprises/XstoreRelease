package dtv.data2.dataserver;

import dtv.util.IHasParameters;
import java.util.Map;

public interface IDataServerAction extends Comparable<IDataServerAction>, IHasParameters {
  int getOrder();
  
  String getValue();
  
  ActionResult process(Map<String, String> paramMap);
  
  void setOrder(int paramInt);
  
  void setOwnerId(String paramString);
  
  void setParameter(String paramString, Object paramObject);
  
  void setType(String paramString);
  
  void setValue(String paramString);
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\IDataServerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */