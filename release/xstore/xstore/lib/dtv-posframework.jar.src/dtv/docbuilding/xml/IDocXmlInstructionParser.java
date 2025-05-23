package dtv.docbuilding.xml;

import dtv.docbuilding.IDocBuilderSectionMember;
import dtv.docbuilding.IDocElementFactory;
import java.util.List;

public interface IDocXmlInstructionParser {
  void initialize(DocXmlFacilities paramDocXmlFacilities);
  
  List<IDocBuilderSectionMember> parse(Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void setContentHandler(IDocXmlContentHandler paramIDocXmlContentHandler);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlInstructionParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */