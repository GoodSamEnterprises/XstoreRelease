package dtv.data2x.req;

import dtv.service.req.IServiceResponse;
import java.util.List;

public interface IQueryResponse<R extends dtv.data2.access.IQueryResult> extends IServiceResponse {
  List<? extends R> getResults();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\req\IQueryResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */