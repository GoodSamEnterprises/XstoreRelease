/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DAOParser
/*     */ {
/*  25 */   private static final Logger logger_ = Logger.getLogger(DAOParser.class);
/*     */   
/*     */   private static final String NAME = "NAME";
/*     */   
/*     */   private static final String ID = "ID";
/*     */   
/*     */   private static final String PACKAGE = "PACKAGE";
/*     */   
/*     */   private static final String EXTENSIBLE = "EXTENSIBLE";
/*     */   
/*     */   private static final String EXTENDS = "EXTENDS";
/*     */   
/*     */   private static final String CUSTOMER_EXTENSION = "customer-extension-of";
/*     */   
/*     */   private static final String IS_PROPERTIES = "is-properties";
/*     */   
/*     */   private static final String TABLE = "TABLE";
/*     */   
/*     */   private static final String COLUMN = "COLUMN";
/*     */   private static final String KEY = "KEY";
/*     */   private static final String TYPE = "TYPE";
/*     */   private static final String SENSITIVE = "sensitive";
/*     */   private static final String ENCRYPT = "encrypt";
/*     */   private static final String ELEMENT_NAME = "ELEMENT-NAME";
/*     */   private static final String PARENT = "PARENT";
/*     */   private static final String CHILD = "CHILD";
/*     */   private static final String USEPARENTPM = "useParentPm";
/*     */   private static final String IMPLEMENTS = "implements";
/*     */   private static final String MODEL_GENERATOR = "model-generator";
/*     */   private static final String XREF_FIELD = "XREF-FIELD";
/*     */   private static final String VALUE = "VALUE";
/*     */   private static final String EXPORT = "export";
/*     */   private static final String DEPENDENT = "dependent";
/*     */   private static final String INCREMENT_FIELD = "incrementField";
/*     */   private static final String DEFAULT_VALUE = "defaultValue";
/*     */   private static final String EVENT_SUPRRESSION = "suppress-event";
/*     */   private static final String TRANSIENT = "transient";
/*     */   
/*     */   public DtxDefinition parse(File argDtxFile) {
/*  64 */     if (argDtxFile == null) {
/*  65 */       logger_.error("We cannot parse a null file", new Throwable("STACK TRACE"));
/*  66 */       return null;
/*     */     } 
/*  68 */     if (!argDtxFile.exists()) {
/*  69 */       logger_.error("File " + argDtxFile.getName() + " does not exist.", new FileNotFoundException(argDtxFile
/*  70 */             .toString()));
/*  71 */       return null;
/*     */     } 
/*     */     
/*  74 */     Document doc = null;
/*     */     try {
/*  76 */       doc = DomUtils.parseXml(argDtxFile, new DomUtils.ParseOption[0]);
/*     */     }
/*  78 */     catch (Exception ee) {
/*  79 */       logger_.error("A problem occurred while parsing: " + argDtxFile.getAbsolutePath(), ee);
/*  80 */       return null;
/*     */     } 
/*     */     
/*  83 */     Collection<Element> fields = DomUtils.getChildElements(doc.getDocumentElement());
/*     */ 
/*     */ 
/*     */     
/*  87 */     DtxDefinition dtx = new DtxDefinition();
/*  88 */     dtx.setSourceDtxFile(argDtxFile);
/*  89 */     parseDao(fields, dtx);
/*  90 */     dtx.setRelationships(parseRelationships(fields));
/*  91 */     dtx.setInverseRelationships(parseInverseRelationships(fields));
/*  92 */     return dtx;
/*     */   }
/*     */   
/*     */   private void parseDao(Collection<Element> argDtxFields, DtxDefinition argDtxDef) {
/*  96 */     for (Element element : argDtxFields) {
/*  97 */       String fieldName = element.getNodeName();
/*     */       
/*  99 */       if ("DAO".equals(fieldName)) {
/* 100 */         for (Attr att : DomUtils.getAttributes(element)) {
/* 101 */           String name = att.getName();
/* 102 */           String value = att.getValue();
/*     */           
/* 104 */           if (name.equalsIgnoreCase("NAME")) {
/* 105 */             argDtxDef.setName(value); continue;
/*     */           } 
/* 107 */           if (name.equalsIgnoreCase("ID")) {
/* 108 */             throw new RuntimeException("ID is no longer supported.  Remove id attribute from dtx file.");
/*     */           }
/* 110 */           if (name.equalsIgnoreCase("PACKAGE")) {
/* 111 */             argDtxDef.setPackage(value); continue;
/*     */           } 
/* 113 */           if (name.equalsIgnoreCase("TABLE")) {
/* 114 */             argDtxDef.setTable(value); continue;
/*     */           } 
/* 116 */           if (name.equalsIgnoreCase("EXTENSIBLE")) {
/* 117 */             argDtxDef.setExtensible(Boolean.valueOf(value).booleanValue()); continue;
/*     */           } 
/* 119 */           if (name.equalsIgnoreCase("is-properties")) {
/* 120 */             argDtxDef.setIsProperties(Boolean.valueOf(value).booleanValue()); continue;
/*     */           } 
/* 122 */           if (name.equalsIgnoreCase("implements")) {
/* 123 */             argDtxDef.setImplements(value); continue;
/*     */           } 
/* 125 */           if (name.equalsIgnoreCase("model-generator")) {
/* 126 */             argDtxDef.setModelGenerator(value); continue;
/*     */           } 
/* 128 */           if (name.equalsIgnoreCase("EXTENDS")) {
/* 129 */             if (argDtxDef.isCustomerExtension()) {
/* 130 */               throw new RuntimeException("A DTX cannot both extend a dao and be a customer-extension-of a dao - it must be one or or the other.");
/*     */             }
/*     */             
/* 133 */             argDtxDef.setExtendsString(value); continue;
/*     */           } 
/* 135 */           if (name.equalsIgnoreCase("customer-extension-of")) {
/* 136 */             if (argDtxDef.isExtended()) {
/* 137 */               throw new RuntimeException("A DTX cannot both extend a dao and be a customer-extension-of a dao - it must be one or or the other.");
/*     */             }
/*     */             
/* 140 */             argDtxDef.setExtendsString(value);
/* 141 */             argDtxDef.setCustomerExtension(true);
/*     */           } 
/*     */         } 
/*     */         
/* 145 */         for (Element field : DomUtils.getChildElements(element)) {
/*     */           
/* 147 */           DtxDefinition.DtxDaoField newField = new DtxDefinition.DtxDaoField();
/*     */           
/* 149 */           for (Attr att : DomUtils.getAttributes(field)) {
/* 150 */             String attName = att.getName();
/* 151 */             String value = att.getValue();
/*     */             
/* 153 */             if (attName.equalsIgnoreCase("NAME")) {
/* 154 */               newField.setName(value); continue;
/*     */             } 
/* 156 */             if (attName.equalsIgnoreCase("COLUMN")) {
/* 157 */               newField.setColumn(value); continue;
/*     */             } 
/* 159 */             if (attName.equalsIgnoreCase("TYPE")) {
/* 160 */               newField.setType(value); continue;
/*     */             } 
/* 162 */             if (attName.equalsIgnoreCase("sensitive")) {
/* 163 */               newField.setSensitive(Boolean.valueOf(value).booleanValue()); continue;
/*     */             } 
/* 165 */             if (attName.equalsIgnoreCase("encrypt")) {
/* 166 */               newField.setEncrypt(value); continue;
/*     */             } 
/* 168 */             if (attName.equalsIgnoreCase("KEY")) {
/* 169 */               newField.setPrimaryKey(Boolean.valueOf(value).booleanValue()); continue;
/*     */             } 
/* 171 */             if (attName.equalsIgnoreCase("export")) {
/* 172 */               newField.setExported(Boolean.valueOf(value).booleanValue()); continue;
/*     */             } 
/* 174 */             if (attName.equalsIgnoreCase("incrementField")) {
/* 175 */               newField.setIncrementField(Boolean.valueOf(value).booleanValue()); continue;
/*     */             } 
/* 177 */             if (attName.equalsIgnoreCase("defaultValue")) {
/* 178 */               newField.setDefaultValueIfNull(value); continue;
/*     */             } 
/* 180 */             if (attName.equalsIgnoreCase("suppress-event") && 
/* 181 */               Boolean.parseBoolean(value)) {
/* 182 */               newField.setSuppressed(true);
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 188 */           newField.setComment(DomUtils.getElementValue(field));
/*     */           
/* 190 */           argDtxDef.addField(newField);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<DtxInverseRelationship> parseInverseRelationships(Collection<Element> argDtxFields) {
/* 197 */     List<DtxInverseRelationship> inverseRelationships = new ArrayList<>();
/*     */     
/* 199 */     for (Element element : argDtxFields) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       if ("InverseRelationship".equals(element.getNodeName())) {
/* 206 */         DtxInverseRelationship rel = new DtxInverseRelationship();
/*     */         
/* 208 */         for (Attr att : DomUtils.getAttributes(element)) {
/* 209 */           String name = att.getName();
/* 210 */           String value = att.getValue();
/*     */           
/* 212 */           if (name.equalsIgnoreCase("NAME")) {
/* 213 */             rel.setName(StringUtils.ensureFirstUpperCase(value)); continue;
/*     */           } 
/* 215 */           if (name.equalsIgnoreCase("PARENT")) {
/* 216 */             rel.setParentType(value);
/*     */           }
/*     */         } 
/*     */         
/* 220 */         inverseRelationships.add(rel);
/*     */       } 
/*     */     } 
/* 223 */     return inverseRelationships;
/*     */   }
/*     */   
/*     */   private List<DtxRelationship> parseRelationships(Collection<Element> argDtxFields) {
/* 227 */     List<DtxRelationship> relationships = new ArrayList<>();
/*     */     
/* 229 */     for (Element element : argDtxFields) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       if ("Relationship".equals(element.getNodeName())) {
/* 236 */         DtxRelationship relationship = new DtxRelationship();
/*     */         
/* 238 */         for (Attr att : DomUtils.getAttributes(element)) {
/* 239 */           String name = att.getName();
/* 240 */           String value = att.getValue();
/*     */           
/* 242 */           if (name.equalsIgnoreCase("NAME")) {
/* 243 */             relationship.setName(StringUtils.ensureFirstUpperCase(value)); continue;
/*     */           } 
/* 245 */           if (name.equalsIgnoreCase("TYPE")) {
/* 246 */             relationship.setType(StringUtils.ensureFirstUpperCase(value)); continue;
/*     */           } 
/* 248 */           if (name.equalsIgnoreCase("PARENT")) {
/* 249 */             relationship.setParentType(value); continue;
/*     */           } 
/* 251 */           if (name.equalsIgnoreCase("CHILD")) {
/* 252 */             relationship.setChildName(value); continue;
/*     */           } 
/* 254 */           if (name.equalsIgnoreCase("TABLE")) {
/* 255 */             relationship.setTable(value); continue;
/*     */           } 
/* 257 */           if (name.equalsIgnoreCase("ELEMENT-NAME")) {
/* 258 */             relationship.setElementName(value); continue;
/*     */           } 
/* 260 */           if (name.equalsIgnoreCase("export")) {
/* 261 */             relationship.setExported(Boolean.valueOf(value).booleanValue()); continue;
/*     */           } 
/* 263 */           if (name.equalsIgnoreCase("dependent")) {
/* 264 */             relationship.setDependent(Boolean.valueOf(value).booleanValue()); continue;
/*     */           } 
/* 266 */           if (name.equalsIgnoreCase("useParentPm")) {
/* 267 */             relationship.setUseParentPm(Boolean.valueOf(value).booleanValue()); continue;
/*     */           } 
/* 269 */           if (name.equalsIgnoreCase("transient")) {
/* 270 */             relationship.setTransient(Boolean.valueOf(value).booleanValue());
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 278 */         for (Element field : DomUtils.getChildElements(element)) {
/*     */           
/* 280 */           relationship.getClass(); DtxRelationship.DtxRelationshipField relationshipField = new DtxRelationship.DtxRelationshipField(relationship);
/*     */           
/* 282 */           for (Attr att : DomUtils.getAttributes(field)) {
/* 283 */             String fieldName = att.getName();
/* 284 */             String fieldValue = att.getValue();
/*     */             
/* 286 */             if (fieldName.equalsIgnoreCase("PARENT")) {
/* 287 */               relationshipField.setParent(fieldValue); continue;
/*     */             } 
/* 289 */             if (fieldName.equalsIgnoreCase("CHILD")) {
/* 290 */               relationshipField.setChild(fieldValue); continue;
/*     */             } 
/* 292 */             if (fieldName.equalsIgnoreCase("XREF-FIELD")) {
/* 293 */               relationshipField.setXrefField(fieldValue); continue;
/*     */             } 
/* 295 */             if (fieldName.equalsIgnoreCase("VALUE")) {
/* 296 */               relationshipField.setValue(fieldValue);
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 304 */           relationship.addField(relationshipField);
/*     */         } 
/* 306 */         relationships.add(relationship);
/*     */       } 
/*     */     } 
/*     */     
/* 310 */     return relationships;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DAOParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */