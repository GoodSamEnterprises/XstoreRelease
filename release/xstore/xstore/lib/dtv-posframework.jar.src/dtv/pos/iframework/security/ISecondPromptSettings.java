package dtv.pos.iframework.security;

public interface ISecondPromptSettings extends Comparable<ISecondPromptSettings> {
  int getLevel();
  
  String getName();
  
  boolean isAnyEmpOk();
  
  boolean isPrompt();
  
  boolean isRequireGroupMembership();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecondPromptSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */