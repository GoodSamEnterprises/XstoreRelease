package dtv.docbuilding.xml;

import dtv.docbuilding.IDocElementFactory;

public interface IDocXmlContentHandler {
  void handleCall(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleCondition(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleElement(IDocXmlElement paramIDocXmlElement, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleElement(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleIterator(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleLiteral(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void handleSectionRef(DocXmlInstruction paramDocXmlInstruction, Object paramObject, IDocElementFactory paramIDocElementFactory);
  
  void initialize(IDocXmlParserCallback paramIDocXmlParserCallback);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlContentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */