package dtv.docbuilding.xml;

import dtv.docbuilding.IDocBuilderField;

public interface IDocXmlFieldFactory {
  IDocBuilderField createAttributeField(DocXmlAttribute paramDocXmlAttribute);
  
  IDocBuilderField createElementCloseField(IDocXmlElement paramIDocXmlElement, boolean paramBoolean);
  
  IDocBuilderField createElementOpenField(IDocXmlElement paramIDocXmlElement, boolean paramBoolean);
  
  IDocBuilderField createElementTextField(IDocXmlElement paramIDocXmlElement, boolean paramBoolean);
  
  IDocBuilderField createLiteralField(String paramString);
  
  IDocBuilderField createNamespaceDeclarationField(DocXmlNamespace paramDocXmlNamespace);
  
  void initialize(DocXmlFacilities paramDocXmlFacilities);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\IDocXmlFieldFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */