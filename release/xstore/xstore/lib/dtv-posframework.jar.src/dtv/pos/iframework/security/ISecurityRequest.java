package dtv.pos.iframework.security;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.op.req.IOpRequest;
import java.util.List;

public interface ISecurityRequest extends IOpRequest {
  ISecureAction getAction();
  
  int getActionType();
  
  IFormattable getMessage();
  
  IOpRequest getPostSuccessRequest();
  
  List<String> getPrivilegeTypes();
  
  void setMessage(IFormattable paramIFormattable);
  
  void setPostSuccessRequest(IOpRequest paramIOpRequest);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */