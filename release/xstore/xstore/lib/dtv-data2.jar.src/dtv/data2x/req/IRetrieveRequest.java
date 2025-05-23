package dtv.data2x.req;

import dtv.service.req.IServiceRequest;

public interface IRetrieveRequest<I extends dtv.data2.access.IObjectId> extends IServiceRequest {
  I getModelId();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\req\IRetrieveRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */