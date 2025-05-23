/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlElement
/*     */   implements IDocXmlElement, IDocXmlSimpleElement
/*     */ {
/*  19 */   private static final Set<DocXmlAttribute> _noAttributes = Collections.emptySet();
/*  20 */   private static final Set<DocXmlNamespace> _noNamespaceDecls = Collections.emptySet();
/*  21 */   private static final List<IDocXmlSimpleElement> _noChildren = Collections.emptyList();
/*     */   
/*     */   private final String _name;
/*     */   
/*     */   private final DocXmlNamespace _namespace;
/*  26 */   private Set<DocXmlAttribute> _attributes = null;
/*  27 */   private Set<DocXmlNamespace> _namespaceDecls = null;
/*  28 */   private List<IDocXmlSimpleElement> _children = null;
/*  29 */   private String _text = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocXmlElement(String argName) {
/*  36 */     this(argName, DocXmlNamespace.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocXmlElement(String argName, DocXmlNamespace argNamespace) {
/*  47 */     this._name = argName;
/*  48 */     this._namespace = (argNamespace == null) ? DocXmlNamespace.DEFAULT : argNamespace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAttribute(DocXmlAttribute argAttribute) {
/*  56 */     if (argAttribute != null) {
/*  57 */       getAttributesImpl().add(argAttribute);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(IDocXmlSimpleElement argChild) {
/*  66 */     if (argChild != null) {
/*  67 */       getChildrenImpl().add(argChild);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNamespaceDeclaration(DocXmlNamespace argNamespaceDecl) {
/*  76 */     if (argNamespaceDecl != null) {
/*  77 */       getNamespaceDeclarationsImpl().add(argNamespaceDecl);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<? extends DocXmlAttribute> getAttributes() {
/*  87 */     return (this._attributes == null) ? _noAttributes : this._attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IDocXmlSimpleElement> getChildren() {
/*  96 */     return (this._children == null) ? _noChildren : this._children;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 105 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocXmlNamespace getNamespace() {
/* 114 */     return this._namespace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<? extends DocXmlNamespace> getNamespaceDeclarations() {
/* 123 */     return (this._namespaceDecls == null) ? _noNamespaceDecls : this._namespaceDecls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 132 */     return this._text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributes(Set<? extends DocXmlAttribute> argAttributes) {
/* 140 */     getAttributesImpl().clear();
/* 141 */     if (argAttributes != null) {
/* 142 */       getAttributesImpl().addAll(argAttributes);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildren(List<IDocXmlSimpleElement> argChildren) {
/* 151 */     getChildrenImpl().clear();
/* 152 */     if (argChildren != null) {
/* 153 */       getChildrenImpl().addAll(argChildren);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamespaceDeclarations(Set<? extends DocXmlNamespace> argNamespaceDecls) {
/* 162 */     getNamespaceDeclarationsImpl().clear();
/* 163 */     if (argNamespaceDecls != null) {
/* 164 */       getNamespaceDeclarationsImpl().addAll(argNamespaceDecls);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String argText) {
/* 173 */     this._text = argText;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 179 */     String namespacePrefix = getNamespace().getPrefix();
/* 180 */     return (StringUtils.isEmpty(namespacePrefix) ? "" : (namespacePrefix + ":")) + this._name + this._attributes + " = " + this._text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<DocXmlAttribute> getAttributesImpl() {
/* 188 */     if (this._attributes == null) {
/* 189 */       this._attributes = new HashSet<>();
/*     */     }
/* 191 */     return this._attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IDocXmlSimpleElement> getChildrenImpl() {
/* 199 */     if (this._children == null) {
/* 200 */       this._children = new ArrayList<>();
/*     */     }
/* 202 */     return this._children;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<DocXmlNamespace> getNamespaceDeclarationsImpl() {
/* 210 */     if (this._namespaceDecls == null) {
/* 211 */       this._namespaceDecls = new HashSet<>();
/*     */     }
/* 213 */     return this._namespaceDecls;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */