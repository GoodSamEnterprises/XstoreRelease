/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import java.io.StringReader;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.ProcessingInstruction;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlDomParser
/*     */   implements IDocXmlStringParser
/*     */ {
/*     */   private static final String DOCUMENT_PREFIX = "<TEMP xmlns:dtv=\"http://www.micros-retail.com\">";
/*     */   private static final String DOCUMENT_SUFFIX = "</TEMP>";
/*     */   private static final String NAMESPACE_PREFIX = "xmlns";
/*     */   
/*     */   public DocXmlRootElement convertXml(String argXml) {
/*     */     try {
/*  36 */       Document doc = createXmlDocument(argXml);
/*  37 */       DocXmlRootElement element = convertRoot(doc);
/*  38 */       return element;
/*     */     }
/*  40 */     catch (Throwable t) {
/*  41 */       throw new ConfigException(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlAttribute convert(Attr argAttr) {
/*  52 */     return new DocXmlAttribute(argAttr.getLocalName(), StringUtils.trimToEmpty(argAttr.getPrefix()), argAttr.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlElement convert(Element argElement) {
/*  62 */     DocXmlElement elem = new DocXmlElement(argElement.getLocalName(), getNamespace(argElement));
/*  63 */     elem.setNamespaceDeclarations(getNamespaceDecls(argElement));
/*  64 */     elem.setAttributes(getAttributes(argElement));
/*  65 */     String value = DomUtils.getElementValue(argElement);
/*  66 */     elem.setText((value != null) ? value.trim() : null);
/*  67 */     elem.setChildren(getChildren(argElement));
/*  68 */     return elem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlInstruction convert(ProcessingInstruction argInstruc) {
/*  79 */     DocXmlInstruction instr = new DocXmlInstruction(argInstruc.getTarget());
/*  80 */     String data = argInstruc.getData().trim();
/*     */ 
/*     */ 
/*     */     
/*  84 */     if (data.length() > 0) {
/*  85 */       StringBuilder key = new StringBuilder(8);
/*  86 */       StringBuilder value = new StringBuilder(8);
/*  87 */       int parsingSegment = 0;
/*  88 */       for (char character : data.toCharArray()) {
/*  89 */         if (parsingSegment == 0) {
/*  90 */           if (key.length() >= 0 && !Character.isWhitespace(character) && character != '=') {
/*     */             
/*  92 */             key.append(character);
/*  93 */           } else if (key.length() > 0 && (Character.isWhitespace(character) || character == '=')) {
/*     */             
/*  95 */             parsingSegment = 1;
/*     */           } 
/*     */         }
/*     */         
/*  99 */         if (parsingSegment == 1) {
/* 100 */           if (value.length() >= 0 && !Character.isWhitespace(character) && character != '=' && character != '\'' && character != '"') {
/*     */             
/* 102 */             value.append(character);
/* 103 */           } else if (value.length() > 0 && (Character.isWhitespace(character) || character != '=' || character != '\'' || character != '"')) {
/*     */             
/* 105 */             parsingSegment = 0;
/* 106 */             instr.setAttribute(key.toString(), value.toString());
/* 107 */             key.setLength(0);
/* 108 */             value.setLength(0);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 113 */     return instr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlRootElement convertRoot(Document argDocument) {
/* 122 */     return new DocXmlRootElement(getChildren(argDocument.getDocumentElement()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Document createXmlDocument(String argXml) throws Exception {
/* 137 */     String wrappedXml = "<TEMP xmlns:dtv=\"http://www.micros-retail.com\">" + argXml + "</TEMP>";
/* 138 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 139 */     factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
/* 140 */     factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
/* 141 */     factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
/* 142 */     factory.setIgnoringElementContentWhitespace(true);
/* 143 */     factory.setNamespaceAware(true);
/* 144 */     DocumentBuilder builder = factory.newDocumentBuilder();
/* 145 */     return builder.parse(new InputSource(new StringReader(wrappedXml)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<DocXmlAttribute> getAttributes(Element argElement) {
/* 154 */     Collection<Attr> attributeCollection = DomUtils.getAttributes(argElement);
/* 155 */     Set<DocXmlAttribute> attributes = (attributeCollection.size() == 0) ? null : new HashSet<>();
/*     */     
/* 157 */     if (attributes != null) {
/* 158 */       for (Attr attr : attributeCollection) {
/* 159 */         DocXmlAttribute convertedAttribute = convert(attr);
/*     */         
/* 161 */         if (!"xmlns".equals(convertedAttribute.getNamespacePrefix())) {
/* 162 */           attributes.add(convertedAttribute);
/*     */         }
/*     */       } 
/*     */     }
/* 166 */     return attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IDocXmlSimpleElement> getChildren(Element argElement) {
/* 176 */     List<IDocXmlSimpleElement> children = new LinkedList<>();
/* 177 */     NodeList nodes = argElement.getChildNodes();
/* 178 */     for (int i = 0; i < nodes.getLength(); i++) {
/* 179 */       Node obj = nodes.item(i);
/* 180 */       if (obj instanceof ProcessingInstruction) {
/* 181 */         children.add(convert((ProcessingInstruction)obj));
/*     */       }
/* 183 */       else if (obj instanceof Element) {
/* 184 */         children.add(convert((Element)obj));
/*     */       } 
/*     */     } 
/* 187 */     return children;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DocXmlNamespace getNamespace(Element argElement) {
/* 196 */     return new DocXmlNamespace(StringUtils.trimToEmpty(argElement.getPrefix()), StringUtils.trimToEmpty(argElement.getNamespaceURI()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<DocXmlNamespace> getNamespaceDecls(Element argElement) {
/* 207 */     Set<DocXmlNamespace> namespaceDecls = (argElement.getAttributes().getLength() == 0) ? null : new HashSet<>();
/*     */ 
/*     */     
/* 210 */     if (namespaceDecls != null) {
/* 211 */       for (Attr attr : DomUtils.getAttributes(argElement)) {
/* 212 */         String name = attr.getName();
/* 213 */         String value = attr.getValue();
/* 214 */         if (name != null && value != null && name.startsWith("xmlns") && !value.equals(argElement.getNamespaceURI())) {
/* 215 */           String prefix = name.equals("xmlns") ? "" : name.replaceFirst("xmlns:", "");
/* 216 */           namespaceDecls.add(new DocXmlNamespace(prefix, value));
/*     */         } 
/*     */       } 
/*     */     }
/* 220 */     return namespaceDecls;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlDomParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */