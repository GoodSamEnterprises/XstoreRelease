package dtv.pos.iframework.visibilityrules;

public interface ISecuredAccessCheck {
  IAccessLevel evaluateVisibility();
  
  IAccessLevel getVisibility();
  
  void setVisibility(IAccessLevel paramIAccessLevel);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\visibilityrules\ISecuredAccessCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */