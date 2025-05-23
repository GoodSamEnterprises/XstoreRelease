package dtv.pos.iframework.security;

import dtv.util.security.ISecured;

public interface ISecureAction extends ISecured {
  void addPrivilege(String paramString);
  
  void clearPrivilege();
  
  String[] getPrivileges();
  
  void notifyAccessDenied(ISecurityResponse paramISecurityResponse);
  
  void notifyAccessGranted(ISecurityResponse paramISecurityResponse);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecureAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */