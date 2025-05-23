package dtv.data2x.req;

import dtv.service.req.IServiceRequest;
import java.util.Collection;

public interface IPersistRequest<M extends dtv.data2.access.IPersistable> extends IServiceRequest {
  Collection<? extends M> getModelsToPersist();
}


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2x\req\IPersistRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */