package dtv.pos.iframework.security;

import dtv.pos.iframework.visibilityrules.IAccessLevel;
import dtv.xst.daocommon.ISystemUser;

public interface IAcl {
  void addAccessEntry(IAclEntry paramIAclEntry);
  
  boolean authorize(ISystemUser paramISystemUser, AccessType paramAccessType);
  
  IAccessLevel getAccessLevel(AccessType paramAccessType, ISystemUser paramISystemUser);
  
  ISecuredObjectID getSecuredObjectID();
  
  boolean isAuthenticationRequired();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\IAcl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */