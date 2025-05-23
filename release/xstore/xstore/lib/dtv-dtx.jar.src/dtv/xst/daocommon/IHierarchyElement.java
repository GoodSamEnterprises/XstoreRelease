package dtv.xst.daocommon;

public interface IHierarchyElement extends IHierarchyItem {
  int getDepth();
  
  IHierarchyElement getParentElement();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\IHierarchyElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */