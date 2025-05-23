package dtv.pos.iframework.visibilityrules;

public interface IAccessLevel extends Comparable<IAccessLevel> {
  int getLevel();
  
  String getName();
  
  boolean isGranted();
  
  boolean isPrivilegeBased();
  
  boolean isViewable();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\visibilityrules\IAccessLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */