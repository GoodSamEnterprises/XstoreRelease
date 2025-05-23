package dtv.docbuilding;

import dtv.docbuilding.types.DocBuilderAlignmentType;

public interface IPictureElement extends IDocElement, IDocBuilderSectionMember {
  DocBuilderAlignmentType getAlignment();
  
  String getFileName();
  
  int getWidth();
  
  boolean isPreload();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IPictureElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */