package dtv.data2x.req;

import dtv.data2.access.IQueryKey;
import dtv.service.req.IServiceRequest;
import java.util.Map;

public interface IUpdateRequest extends IServiceRequest {
  IQueryKey<Object[]> getQueryKey();
  
  Map<String, Object> getQueryParams();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\req\IUpdateRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */