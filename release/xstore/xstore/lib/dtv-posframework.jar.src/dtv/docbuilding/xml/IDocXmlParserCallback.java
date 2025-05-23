package dtv.docbuilding.xml;

import dtv.docbuilding.IDocBuilderSectionMember;
import dtv.docbuilding.IDocElementFactory;
import java.util.List;

public interface IDocXmlParserCallback extends IDocXmlHasFacilities {
  void addRootMember(IDocBuilderSectionMember paramIDocBuilderSectionMember);
  
  List<IDocBuilderSectionMember> parse(IDocXmlSimpleElement paramIDocXmlSimpleElement, Object paramObject, IDocElementFactory paramIDocElementFactory);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlParserCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */