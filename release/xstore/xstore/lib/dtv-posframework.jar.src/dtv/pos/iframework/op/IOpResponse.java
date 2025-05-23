package dtv.pos.iframework.op;

import dtv.pos.iframework.op.req.IOpRequest;
import java.util.List;

public interface IOpResponse {
  void appendOpRequest(IOpRequest paramIOpRequest);
  
  IOpResponse derive(OpStatus paramOpStatus);
  
  List<IOpRequest> getOpRequests();
  
  OpStatus getOpStatus();
  
  void insertOpRequest(IOpRequest paramIOpRequest);
  
  boolean hasRequests();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\op\IOpResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */