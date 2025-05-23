package dtv.pos.iframework.security;

import dtv.i18n.IFormattable;

public interface ISecurityCallback {
  int getChallengingQuestionRetryCount();
  
  String getLoginFailureReasonCode();
  
  int getRetryCount();
  
  void setLoginFailureMessage(IFormattable paramIFormattable);
  
  void setLoginFailureReasonCode(String paramString);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */