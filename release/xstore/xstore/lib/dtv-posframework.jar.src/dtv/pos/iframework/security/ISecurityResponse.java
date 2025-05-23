package dtv.pos.iframework.security;

import dtv.i18n.IFormattable;
import dtv.pos.iframework.op.req.IOpRequest;
import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.daocommon.ISystemUser;

public interface ISecurityResponse {
  IAccessLevel getAccessToken();
  
  IFormattable getFailureReason();
  
  IOpRequest getRequest();
  
  ISystemUser getSystemUser();
  
  boolean successful();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */