package dtv.docbuilding.xml;

import java.util.List;

public interface IDocXmlTextFactory {
  List<DocXmlText> createExpressionTexts(String paramString);
  
  DocXmlText createLiteralName(String paramString1, String paramString2);
  
  DocXmlText createLiteralValue(String paramString);
  
  void initialize(DocXmlFacilities paramDocXmlFacilities);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlTextFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */