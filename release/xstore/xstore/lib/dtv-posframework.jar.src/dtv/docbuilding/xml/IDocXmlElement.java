package dtv.docbuilding.xml;

import java.util.List;
import java.util.Set;

public interface IDocXmlElement extends IDocXmlSimpleElement {
  Set<? extends DocXmlAttribute> getAttributes();
  
  List<IDocXmlSimpleElement> getChildren();
  
  String getName();
  
  DocXmlNamespace getNamespace();
  
  Set<? extends DocXmlNamespace> getNamespaceDeclarations();
  
  String getText();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */