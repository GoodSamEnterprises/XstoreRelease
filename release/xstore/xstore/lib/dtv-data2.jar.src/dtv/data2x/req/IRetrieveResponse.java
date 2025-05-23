package dtv.data2x.req;

import dtv.service.req.IServiceResponse;

public interface IRetrieveResponse<M extends dtv.data2.access.IDataModel> extends IServiceResponse {
  M getResult();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\req\IRetrieveResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */