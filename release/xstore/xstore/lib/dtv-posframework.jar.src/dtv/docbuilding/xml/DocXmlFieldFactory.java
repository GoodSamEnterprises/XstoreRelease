/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.docbuilding.AbstractDocBuilderField;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlFieldFactory
/*     */   implements IDocXmlFieldFactory
/*     */ {
/*  24 */   private static final IOutputFormatter _cdataFormatter = new DocXmlCdataFormatter();
/*     */   
/*  26 */   private DocXmlFacilities _facilities = null;
/*  27 */   private IDocXmlTextFactory _textFactory = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createAttributeField(DocXmlAttribute argAttr) {
/*  32 */     DocXmlText name = this._textFactory.createLiteralName(argAttr.getName(), argAttr.getNamespacePrefix());
/*  33 */     DocXmlText value = this._textFactory.createExpressionTexts(argAttr.getValue()).get(0);
/*     */     
/*  35 */     return (IDocBuilderField)new AttributeField(name, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createElementCloseField(IDocXmlElement argElem, boolean argNameIsLiteral) {
/*  42 */     DocXmlText name = createElementName(argElem, argNameIsLiteral);
/*  43 */     return (IDocBuilderField)new ElementCloseField(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createElementOpenField(IDocXmlElement argElem, boolean argNameIsLiteral) {
/*  49 */     DocXmlText name = createElementName(argElem, argNameIsLiteral);
/*     */     
/*  51 */     Set<? extends NamespaceDeclarationField> namespaceDecls = createNamespaceDeclarationsFields(argElem);
/*  52 */     Set<? extends AttributeField> attrs = createAttributeFields(argElem);
/*     */     
/*  54 */     return (IDocBuilderField)new ElementOpenField(name, namespaceDecls, attrs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createElementTextField(IDocXmlElement argElem, boolean argNameIsLiteral) {
/*  60 */     DocXmlText name = createElementName(argElem, argNameIsLiteral);
/*  61 */     List<DocXmlText> values = this._textFactory.createExpressionTexts(argElem.getText());
/*     */     
/*  63 */     Set<? extends NamespaceDeclarationField> namespaceDecls = createNamespaceDeclarationsFields(argElem);
/*  64 */     Set<? extends AttributeField> attrs = createAttributeFields(argElem);
/*     */     
/*  66 */     return (IDocBuilderField)new ElementTextField(name, namespaceDecls, attrs, values);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createLiteralField(String argExpr) {
/*  72 */     DocXmlText text = this._textFactory.createExpressionTexts(argExpr).get(0);
/*  73 */     return (IDocBuilderField)new LiteralField(text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDocBuilderField createNamespaceDeclarationField(DocXmlNamespace argNamespaceDecl) {
/*  79 */     return (IDocBuilderField)new NamespaceDeclarationField(argNamespaceDecl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(DocXmlFacilities argFacilities) {
/*  85 */     this._facilities = argFacilities;
/*  86 */     this._textFactory = createTextFactory(argFacilities);
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
/*     */   protected DocXmlText createElementName(IDocXmlElement argElem, boolean argIsLiteral) {
/* 100 */     DocXmlText name = argIsLiteral ? this._textFactory.createLiteralName(argElem.getName(), argElem.getNamespace().getPrefix()) : this._textFactory.createExpressionTexts(argElem.getName()).get(0);
/*     */     
/* 102 */     return name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlTextFactory createTextFactory(DocXmlFacilities argFacilities) {
/* 112 */     IDocXmlTextFactory factory = new DocXmlTextFactory();
/* 113 */     factory.initialize(argFacilities);
/*     */     
/* 115 */     return factory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<? extends AttributeField> createAttributeFields(IDocXmlElement argElem) {
/* 126 */     Set<AttributeField> attributes = Collections.emptySet();
/*     */     
/* 128 */     if (!argElem.getAttributes().isEmpty()) {
/* 129 */       attributes = new TreeSet<>();
/*     */       
/* 131 */       for (DocXmlAttribute attribute : argElem.getAttributes()) {
/* 132 */         attributes.add((AttributeField)createAttributeField(attribute));
/*     */       }
/*     */     } 
/* 135 */     return attributes;
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
/*     */   private Set<? extends NamespaceDeclarationField> createNamespaceDeclarationsFields(IDocXmlElement argElem) {
/* 147 */     Set<NamespaceDeclarationField> namespaceDecls = Collections.emptySet();
/*     */     
/* 149 */     if (!argElem.getNamespaceDeclarations().isEmpty()) {
/* 150 */       namespaceDecls = new HashSet<>();
/*     */       
/* 152 */       for (DocXmlNamespace namespaceDecl : argElem.getNamespaceDeclarations()) {
/* 153 */         namespaceDecls.add((NamespaceDeclarationField)createNamespaceDeclarationField(namespaceDecl));
/*     */       }
/*     */     } 
/* 156 */     return namespaceDecls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract class AbstractXmlField
/*     */     extends AbstractDocBuilderField
/*     */   {
/*     */     final DocXmlText _name;
/*     */ 
/*     */     
/*     */     final DocXmlText[] _values;
/*     */ 
/*     */ 
/*     */     
/*     */     public AbstractXmlField(DocXmlText argName, DocXmlText... argValues) {
/* 173 */       super(argName.toString(), null, null, DocBuilderAlignmentType.DEFAULT, 0, null);
/* 174 */       this._name = argName;
/* 175 */       this._values = argValues;
/*     */       
/* 177 */       setSourceDescription(DocXmlFieldFactory.this._facilities.getSourceDescription());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AbstractXmlField(DocXmlText argName, List<DocXmlText> argValues) {
/* 187 */       this(argName, (argValues == null) ? null : argValues.<DocXmlText>toArray(new DocXmlText[argValues.size()]));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 193 */       IDocXmlExpressionator expressionator = DocXmlFieldFactory.this._facilities.getExpressionator();
/* 194 */       String finalContents = "";
/*     */       
/* 196 */       String nameText = this._name.evaluateAndFormat(expressionator, argSource, argFactory);
/* 197 */       boolean exclude = StringUtils.isEmpty(nameText);
/*     */ 
/*     */ 
/*     */       
/* 201 */       if (!exclude) {
/*     */ 
/*     */ 
/*     */         
/* 205 */         String valueText = null;
/*     */         
/* 207 */         if (this._values != null && this._values.length > 0) {
/* 208 */           StringBuilder sb = new StringBuilder();
/* 209 */           for (DocXmlText subValue : this._values) {
/* 210 */             sb.append(subValue.evaluateAndFormat(expressionator, argSource, argFactory));
/*     */           }
/* 212 */           valueText = sb.toString();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 217 */           if (StringUtils.isEmpty(valueText)) {
/* 218 */             exclude = true;
/*     */           }
/*     */         } 
/*     */         
/* 222 */         if (!exclude) {
/* 223 */           finalContents = getContentsImpl(argSource, argFactory, nameText, valueText);
/*     */         }
/*     */       } 
/* 226 */       return finalContents;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSourceDescription() {
/* 232 */       return DocXmlFieldFactory.this._facilities.getSourceDescription();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 238 */       return this._name + " = " + Arrays.toString((Object[])this._values);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean excludeEmpty() {
/* 249 */       return true;
/*     */     }
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
/*     */     protected abstract String getContentsImpl(Object param1Object, IDocElementFactory param1IDocElementFactory, String param1String1, String param1String2);
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
/*     */   private class AttributeField
/*     */     extends AbstractXmlField
/*     */     implements Comparable<AttributeField>
/*     */   {
/*     */     public AttributeField(DocXmlText argName, DocXmlText argValue) {
/* 278 */       super(argName, new DocXmlText[] { argValue });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(AttributeField argO) {
/* 284 */       return StringUtils.nonNull(this._name).toString().compareTo(StringUtils.nonNull(argO._name).toString());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getContentsImpl(Object argSource, IDocElementFactory argFactory, String argName, String argValue) {
/* 292 */       return argName + "=\"" + argValue + "\"";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ElementCloseField
/*     */     extends ElementOpenField
/*     */   {
/*     */     public ElementCloseField(DocXmlText argName) {
/* 305 */       super(argName, (Set<? extends DocXmlFieldFactory.NamespaceDeclarationField>)null, (Set<? extends DocXmlFieldFactory.AttributeField>)null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getContentsImpl(Object argSource, IDocElementFactory argFactory, String argName, String argValue) {
/* 313 */       return "</" + argName + ">";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ElementOpenField
/*     */     extends AbstractXmlField
/*     */   {
/*     */     private final Set<? extends DocXmlFieldFactory.NamespaceDeclarationField> _namespaceDecls;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Set<? extends DocXmlFieldFactory.AttributeField> _attrs;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ElementOpenField(DocXmlText argName, Set<? extends DocXmlFieldFactory.NamespaceDeclarationField> argNamespaceDecls, Set<? extends DocXmlFieldFactory.AttributeField> argAttrs) {
/* 334 */       this(argName, argNamespaceDecls, argAttrs, null);
/*     */     }
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
/*     */     protected ElementOpenField(DocXmlText argName, Set<? extends DocXmlFieldFactory.NamespaceDeclarationField> argNamespaceDecls, Set<? extends DocXmlFieldFactory.AttributeField> argAttrs, List<DocXmlText> argValues) {
/* 349 */       super(argName, argValues);
/* 350 */       this._namespaceDecls = argNamespaceDecls;
/* 351 */       this._attrs = argAttrs;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getContentsImpl(Object argSource, IDocElementFactory argFactory, String argName, String argValue) {
/* 359 */       StringBuilder sb = new StringBuilder("<");
/* 360 */       sb.append(argName);
/*     */       
/* 362 */       if (this._namespaceDecls != null) {
/* 363 */         for (DocXmlFieldFactory.NamespaceDeclarationField namespaceDecl : this._namespaceDecls) {
/* 364 */           sb.append(" ").append(namespaceDecl.getContents(argSource, argFactory, null));
/*     */         }
/*     */       }
/*     */       
/* 368 */       if (this._attrs != null) {
/* 369 */         for (DocXmlFieldFactory.AttributeField attr : this._attrs) {
/* 370 */           sb.append(" ").append(attr.getContents(argSource, argFactory, (Locale)null));
/*     */         }
/*     */       }
/* 373 */       sb.append(">");
/* 374 */       return sb.toString();
/*     */     }
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
/*     */   
/*     */   private class ElementTextField
/*     */     extends ElementOpenField
/*     */   {
/*     */     public ElementTextField(DocXmlText argName, Set<? extends DocXmlFieldFactory.NamespaceDeclarationField> argNamespaceDecls, Set<? extends DocXmlFieldFactory.AttributeField> argAttrs, List<DocXmlText> argValues) {
/* 394 */       super(argName, argNamespaceDecls, argAttrs, argValues);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getContentsImpl(Object argSource, IDocElementFactory argFactory, String argName, String argValue) {
/* 404 */       String value = DocXmlFieldFactory._cdataFormatter.format(argValue.trim(), null);
/*     */       
/* 406 */       StringBuilder sb = new StringBuilder(super.getContentsImpl(argSource, argFactory, argName, argValue));
/* 407 */       sb.append(value).append("</").append(argName).append(">");
/*     */       
/* 409 */       return sb.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class LiteralField
/*     */     extends AbstractXmlField
/*     */   {
/*     */     public LiteralField(DocXmlText argContent) {
/* 422 */       super(argContent, new DocXmlText[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getContentsImpl(Object argSource, IDocElementFactory argFactory, String argName, String argValue) {
/* 430 */       return argName;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class NamespaceDeclarationField
/*     */     extends AbstractDocBuilderField
/*     */   {
/*     */     public NamespaceDeclarationField(DocXmlNamespace argNamespaceDecl) {
/* 439 */       super(argNamespaceDecl.toDeclaration(), null, null, DocBuilderAlignmentType.DEFAULT, 0, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 445 */       return getContents();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlFieldFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */