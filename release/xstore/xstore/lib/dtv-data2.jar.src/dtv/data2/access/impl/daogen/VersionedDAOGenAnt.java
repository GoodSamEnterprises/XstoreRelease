/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.FileUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.apache.tools.ant.Task;
/*     */ import org.apache.tools.ant.types.FileSet;
/*     */ import org.apache.tools.ant.types.Resource;
/*     */ import org.apache.tools.ant.types.resources.FileResource;
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
/*     */ public class VersionedDAOGenAnt
/*     */   extends Task
/*     */ {
/*     */   private FileSet _source;
/*     */   private File _destination;
/*     */   private String _version;
/*  34 */   private Map<DtxDefinition, String> _classNameCache = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private Map<String, DtxDefinition> _definitions = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addConfiguredFileset(FileSet argSourceSet) {
/*  49 */     this._source = argSourceSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() throws BuildException {
/*  55 */     if (this._source == null) {
/*  56 */       throw new BuildException("Source directory does not exist!");
/*     */     }
/*     */     
/*  59 */     if (this._destination == null) {
/*  60 */       throw new BuildException("Destination is not set!");
/*     */     }
/*  62 */     if (!this._destination.exists()) {
/*  63 */       throw new BuildException("Destination " + this._destination.getAbsolutePath() + " does not exist!");
/*     */     }
/*  65 */     if (!this._destination.isDirectory()) {
/*  66 */       throw new BuildException("Destination " + this._destination.getAbsolutePath() + " is not a directory!");
/*     */     }
/*     */     
/*     */     try {
/*  70 */       DAOParser parser = new DAOParser();
/*     */       
/*  72 */       for (Resource dtxResource : this._source) {
/*  73 */         FileResource dtxFileResource = (FileResource)dtxResource;
/*  74 */         File dtxFile = dtxFileResource.getFile();
/*     */         
/*  76 */         DtxDefinition dtx = parser.parse(dtxFile);
/*  77 */         this._definitions.put(dtx.getName(), dtx);
/*     */       } 
/*     */       
/*  80 */       for (DtxDefinition dtx : this._definitions.values()) {
/*  81 */         handleDtxDefinition(dtx);
/*     */       }
/*     */     }
/*  84 */     catch (BuildException e) {
/*  85 */       throw e;
/*     */     }
/*  87 */     catch (Exception e) {
/*  88 */       e.printStackTrace();
/*  89 */       throw new BuildException("Error happened during DAO generation:", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestination(File argDestination) {
/*  99 */     this._destination = argDestination.getAbsoluteFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(String argVersion) {
/* 107 */     this._version = argVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateDaoField(Writer out, DtxDefinition.DtxDaoField field) throws IOException {
/* 113 */     String fieldVisibility = getClassFieldVisibility(field);
/* 114 */     String fieldType = getClassFieldType(field);
/* 115 */     String fieldName = getClassFieldName(field);
/* 116 */     out.append("  ").append(fieldVisibility).append(' ').append(fieldType).append(' ').append(fieldName);
/*     */     
/* 118 */     String fieldInitialValue = getClassFieldInitialValue(field);
/* 119 */     if (!fieldInitialValue.isEmpty()) {
/* 120 */       out.append(" = ").append(fieldInitialValue);
/*     */     }
/*     */     
/* 123 */     out.append(";\n");
/*     */ 
/*     */     
/* 126 */     DaoGenUtils.appendGetterForField(out, field);
/*     */ 
/*     */     
/* 129 */     DaoGenUtils.appendSetterForField(out, field, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateDaoFields(Writer out, DtxDefinition argDtx) throws IOException {
/* 138 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 139 */       generateDaoField(out, field);
/*     */     }
/*     */     
/* 142 */     out.append('\n');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateDaoFooter(Writer out, DtxDefinition argDtx) throws IOException {
/* 152 */     if (!argDtx.isExtended() && argDtx.getExtendsStringType() == null) {
/* 153 */       out.append("  public IObjectId getObjectId() {\n");
/* 154 */       String idType = getIdObjectClass(argDtx);
/* 155 */       out.append("    ").append(idType).append(" id = new ").append(idType).append("();\n");
/*     */       
/* 157 */       for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 158 */         out.append("    id.").append(getSetterName(field)).append("(this.").append(getGetterName(field))
/* 159 */           .append("());\n");
/*     */       }
/*     */       
/* 162 */       out.append("    return id;\n");
/* 163 */       out.append("  }\n\n");
/*     */       
/* 165 */       out.append("  public void setObjectId(IObjectId argObjectId) {\n");
/*     */       
/* 167 */       if ((argDtx.getPrimaryKeyFields()).length > 0) {
/* 168 */         for (DtxDefinition.DtxDaoField f : argDtx.getPrimaryKeyFields()) {
/* 169 */           String getterName = getGetterName(f);
/* 170 */           String setterName = getSetterName(f);
/* 171 */           out.append("    ").append(setterName).append("(((").append(idType).append(") argObjectId).")
/* 172 */             .append(getterName).append("());\n");
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 177 */         out.append(String.format("    // %s does not define a primary key.\n", new Object[] { getName(argDtx) }));
/*     */       } 
/*     */       
/* 180 */       out.append("  }\n\n");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     if (argDtx.isExtended()) {
/* 187 */       out.append("  @Override\n");
/*     */     }
/*     */     
/* 190 */     out.append("  public String toXmlString() {\n");
/* 191 */     int buffSize = 50 * (argDtx.getFields()).length;
/* 192 */     DtxDefinition parent = argDtx.getExtends();
/*     */     
/* 194 */     while (parent != null) {
/* 195 */       buffSize += 50 * (parent.getFields()).length;
/* 196 */       parent = parent.getExtends();
/*     */     } 
/*     */     
/* 199 */     out.append("    StringBuilder buf = new StringBuilder(").append(Integer.toString(buffSize))
/* 200 */       .append(");\n");
/* 201 */     out.append("    buf.append(\"<\").append(DAO_ELEMENT_NAME).append(\" name=\\\"").append(getName(argDtx))
/* 202 */       .append("\\\" cmd=\\\"\" + getObjectStateString() + \"\\\">\");\n");
/* 203 */     out.append("    getFieldsAsXml(buf);\n");
/* 204 */     out.append("    buf.append(\"</\").append(DAO_ELEMENT_NAME).append(\">\");\n\n");
/* 205 */     out.append("    return buf.toString();\n");
/* 206 */     out.append("  }\n");
/*     */ 
/*     */     
/* 209 */     out.append("  @Override\n");
/* 210 */     out.append("  public java.util.Map<String, String> getValues() {\n");
/* 211 */     out.append("    java.util.Map<String, String> values = super.getValues();\n");
/*     */     
/* 213 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 214 */       String fieldName = getClassFieldName(field);
/* 215 */       String publicName = getPublicFieldName(field);
/* 216 */       String xmlSafeFieldType = getXmlSafeFieldType(field);
/*     */       
/* 218 */       out.append("    if (").append(fieldName).append(" != null) values.put(").append(publicName)
/* 219 */         .append(", dtv.data2.access.DaoUtils.getXmlSafeFieldValue(").append(xmlSafeFieldType).append(", ")
/* 220 */         .append(fieldName).append("));\n");
/*     */     } 
/* 222 */     out.append("    return values;\n");
/* 223 */     out.append("  }\n\n");
/*     */     
/* 225 */     out.append("  @Override\n");
/* 226 */     out.append("  public void setValues(java.util.Map<String, String> argValues) {\n");
/* 227 */     out.append("    super.setValues(argValues);\n");
/*     */     
/* 229 */     out.append("    for (java.util.Map.Entry<String, String> valueEntry : argValues.entrySet()) {\n");
/*     */     
/* 231 */     out.append("      switch (valueEntry.getKey().hashCode()) {\n");
/*     */     
/* 233 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 234 */       String publicName = StringUtils.ensureFirstUpperCase(field.getName());
/* 235 */       out.append("        case ").append(Integer.toString(publicName.hashCode())).append(": { // ")
/* 236 */         .append(publicName).append('\n');
/* 237 */       out.append("          try {\n");
/* 238 */       out.append("            Object value = dtv.data2.access.DaoUtils.getFieldValueForXmlString(")
/* 239 */         .append(getXmlSafeFieldType(field)).append(", valueEntry.getValue());\n");
/* 240 */       out.append("            ").append(getSetterName(field)).append("(").append(makeCast(field))
/* 241 */         .append("value);\n");
/* 242 */       out.append("          } catch (Exception ee) {\n");
/* 243 */       out.append("            throw new dtv.data2.access.exception.DtxException(\"An exception occurred while calling ")
/*     */         
/* 245 */         .append(getSetterName(field))
/* 246 */         .append("() with \" + valueEntry.getValue() + \" on: \" + this + \" \" + ee.toString(), ee);\n");
/* 247 */       out.append("          }\n");
/* 248 */       out.append("          break;\n");
/* 249 */       out.append("        }\n");
/*     */     } 
/*     */     
/* 252 */     out.append("        default: break;\n");
/* 253 */     out.append("      }\n");
/* 254 */     out.append("    }\n");
/* 255 */     out.append("  }\n");
/* 256 */     out.append('}');
/*     */   }
/*     */ 
/*     */   
/*     */   protected String generateDaoHeader(Writer out, DtxDefinition argDtx) throws IOException {
/* 261 */     String packageName = getDaoPackage(argDtx);
/* 262 */     out.append("package ").append(packageName).append(";\n\n");
/*     */     
/* 264 */     out.append("import java.util.Date;\n");
/* 265 */     out.append("import org.apache.log4j.Logger;\n");
/* 266 */     out.append("import dtv.data2.access.IObjectId;\n\n");
/*     */     
/* 268 */     String className = getDaoClassName(argDtx);
/* 269 */     out.append("public class ").append(className).append('\n');
/*     */     
/* 271 */     String baseClass = getBaseClass(argDtx);
/* 272 */     out.append("    extends ").append(baseClass);
/*     */     
/* 274 */     String interfaces = getInterfaces(argDtx);
/* 275 */     if (!interfaces.isEmpty()) {
/* 276 */       out.append("\n    implements ").append(interfaces);
/*     */     }
/*     */     
/* 279 */     out.append(" {\n\n");
/*     */     
/* 281 */     String serialVersionUID = String.valueOf(getName(argDtx).hashCode());
/* 282 */     out.append("  // Fix serialization compatability based on the name of the DAO\n");
/* 283 */     out.append("  private static final long serialVersionUID = ").append(serialVersionUID).append("L;\n");
/*     */     
/* 285 */     out.append("  private static final Logger logger_ = Logger.getLogger(")
/* 286 */       .append(className)
/* 287 */       .append(".class);\n\n");
/*     */     
/* 289 */     return out.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateIdFields(Writer argWriter, DtxDefinition argDtx) throws IOException {
/* 299 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 300 */       if (!"organizationId".equals(field.getName())) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 305 */         String fieldVisibility = getClassFieldVisibility(field);
/* 306 */         String fieldType = getClassFieldType(field);
/* 307 */         String fieldName = getClassFieldName(field);
/* 308 */         argWriter.append("  ").append(fieldVisibility).append(' ').append(fieldType).append(' ')
/* 309 */           .append(fieldName);
/*     */         
/* 311 */         String fieldInitialValue = getClassFieldInitialValue(field);
/* 312 */         if (!fieldInitialValue.isEmpty()) {
/* 313 */           argWriter.append(" = ").append(fieldInitialValue);
/*     */         }
/*     */         
/* 316 */         argWriter.append(";\n");
/*     */ 
/*     */         
/* 319 */         String getterType = fieldType;
/* 320 */         String getterName = getGetterName(field);
/*     */         
/* 322 */         argWriter.append("  public ").append(getterType).append(' ').append(getterName).append("() {\n");
/* 323 */         argWriter.append("    return ").append(fieldName).append(";\n");
/* 324 */         argWriter.append("  }\n");
/*     */ 
/*     */         
/* 327 */         String setterName = getSetterName(field);
/* 328 */         String setterArgType = getSetterArgType(field);
/* 329 */         String setterArgName = getSetterArgName(field);
/*     */         
/* 331 */         argWriter.append("  public void ").append(setterName).append('(').append(setterArgType).append(' ')
/* 332 */           .append(setterArgName).append(") {\n");
/*     */         
/* 334 */         if ("Date".equalsIgnoreCase(field.getType())) {
/* 335 */           argWriter.append("      if (").append(setterArgName).append(" != null && !(").append(setterArgName)
/* 336 */             .append(" instanceof dtv.util.DtvDate)) {\n");
/* 337 */           argWriter.append("        ").append(setterArgName).append(" = new dtv.util.DtvDate(")
/* 338 */             .append(setterArgName).append(".getTime());\n");
/* 339 */           argWriter.append("      }\n");
/* 340 */           argWriter.append("      ").append(fieldName).append(" = (dtv.util.DtvDate) ").append(setterArgName)
/* 341 */             .append(";\n");
/*     */         } else {
/*     */           
/* 344 */           argWriter.append("      ").append(fieldName).append(" = ").append(setterArgName).append(";\n");
/*     */         } 
/*     */         
/* 347 */         argWriter.append("  }\n\n");
/*     */       } 
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
/*     */   protected void generateIdFooter(Writer argWriter, DtxDefinition argDtx) throws IOException {
/* 360 */     argWriter.append("  @Override\n");
/* 361 */     argWriter.append("  public boolean validate() { return false; }\n\n");
/*     */ 
/*     */     
/* 364 */     String idName = getIdClassName(argDtx);
/* 365 */     argWriter.append("  @Override\n");
/* 366 */     argWriter.append("  public boolean equals(Object ob) {\n");
/* 367 */     argWriter.append("    if (this == ob) {\n");
/* 368 */     argWriter.append("      return true;\n");
/* 369 */     argWriter.append("    }\n");
/* 370 */     argWriter.append("    if (!(ob instanceof ").append(idName).append(")) {\n");
/* 371 */     argWriter.append("      return false;\n");
/* 372 */     argWriter.append("    }\n");
/* 373 */     argWriter.append("    ").append(idName).append(" other = (").append(idName).append(") ob;\n");
/* 374 */     argWriter.append("    return\n");
/*     */ 
/*     */     
/* 377 */     boolean first = true;
/* 378 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 379 */       if (first) {
/* 380 */         argWriter.append("           ");
/* 381 */         first = false;
/*     */       } else {
/*     */         
/* 384 */         argWriter.append("        && ");
/*     */       } 
/*     */       
/* 387 */       String fieldName = getClassFieldName(field);
/* 388 */       argWriter.append("java.util.Objects.equals(").append(fieldName).append(", other.").append(fieldName)
/* 389 */         .append(")\n");
/*     */     } 
/*     */     
/* 392 */     argWriter.append("          ;\n  }\n\n");
/*     */ 
/*     */     
/* 395 */     argWriter.append("  @Override\n");
/* 396 */     argWriter.append("  public int hashCode() {\n");
/* 397 */     argWriter.append("    return (\n");
/*     */     
/* 399 */     first = true;
/* 400 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 401 */       if (first) {
/* 402 */         argWriter.append("           ");
/* 403 */         first = false;
/*     */       } else {
/*     */         
/* 406 */         argWriter.append("         + ");
/*     */       } 
/*     */       
/* 409 */       String fieldName = getClassFieldName(field);
/* 410 */       argWriter.append("java.util.Objects.hashCode(").append(fieldName).append(")\n");
/*     */     } 
/*     */     
/* 413 */     argWriter.append("         );\n  }\n");
/*     */ 
/*     */     
/* 416 */     argWriter.append("  public void setValue(String argObjectIdValue) {\n");
/* 417 */     argWriter.append("    String str = argObjectIdValue;\n");
/* 418 */     argWriter.append("    if (dtv.util.StringUtils.isEmpty(str)) {\n");
/* 419 */     argWriter.append("      throw new dtv.data2.access.exception.DtxException(\"argument ")
/* 420 */       .append("passed to setValue() is null or empty - a valid value must be passed\");\n");
/* 421 */     argWriter.append("    }\n");
/*     */     
/* 423 */     argWriter.append("    try {\n");
/*     */     
/* 425 */     argWriter.append("      String[] tokens = str.split(\"::\");\n");
/*     */     
/* 427 */     int fieldIndex = 0;
/* 428 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 429 */       argWriter.append("      str = tokens[").append(Integer.toString(fieldIndex)).append("];\n\n");
/*     */       
/* 431 */       String fieldName = getClassFieldName(field);
/* 432 */       if (field.getType().equals("Date")) {
/* 433 */         argWriter.append("      if (\"null\".equals(str)) {\n");
/* 434 */         argWriter.append("        ").append(fieldName).append(" = null;\n");
/* 435 */         argWriter.append("      }\n");
/* 436 */         argWriter.append("      else {\n");
/* 437 */         argWriter.append("        ").append(fieldName).append(" = new dtv.util.DtvDate();\n");
/* 438 */         argWriter.append("        ").append(fieldName)
/* 439 */           .append(".setTimeFromSerialization(Long.parseLong(str));\n");
/* 440 */         argWriter.append("      }\n");
/*     */       }
/* 442 */       else if (field.getType().equals("Long")) {
/* 443 */         argWriter.append("      ").append(fieldName).append(" = java.lang.Long.valueOf(str);\n");
/*     */       }
/* 445 */       else if (field.getType().equals("Integer")) {
/* 446 */         argWriter.append("      ").append(fieldName).append(" = java.lang.Integer.valueOf(str);\n");
/*     */       }
/* 448 */       else if (field.getType().equals("BigDecimal")) {
/* 449 */         argWriter.append("      ").append(fieldName).append(" = new java.math.BigDecimal(str);\n");
/*     */       } else {
/*     */         
/* 452 */         argWriter.append("      if (\"null\".equals(str)) {\n");
/* 453 */         argWriter.append("        ").append(fieldName).append(" = null;\n");
/* 454 */         argWriter.append("      }\n");
/* 455 */         argWriter.append("      else {\n");
/* 456 */         argWriter.append("        ").append(fieldName).append(" = str;\n");
/* 457 */         argWriter.append("      }\n");
/*     */       } 
/*     */       
/* 460 */       fieldIndex++;
/*     */     } 
/*     */     
/* 463 */     argWriter.append("    }\n");
/* 464 */     argWriter.append("    catch (Exception ee) {\n");
/* 465 */     argWriter.append("      throw new dtv.data2.access.exception.DtxException(\"An exception occured while parsing object id string: \" + argObjectIdValue, ee);\n");
/*     */ 
/*     */     
/* 468 */     argWriter.append("    }\n");
/* 469 */     argWriter.append("  }\n");
/*     */ 
/*     */     
/* 472 */     argWriter.append("  public String getDtxTypeName() { return \"").append(getName(argDtx))
/* 473 */       .append("\"; }\n\n");
/*     */ 
/*     */     
/* 476 */     argWriter.append("}\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateIdHeader(Writer argWriter, DtxDefinition argDtx) throws IOException {
/* 486 */     argWriter.append("package ").append(getIdPackage(argDtx)).append(";\n\n");
/*     */     
/* 488 */     DtxDefinition.DtxDaoField[] primaryKeyFields = argDtx.getPrimaryKeyFields();
/*     */     
/* 490 */     for (DtxDefinition.DtxDaoField primaryKeyField : primaryKeyFields) {
/* 491 */       if (primaryKeyField.getType().equals("Date")) {
/* 492 */         argWriter.append("import java.util.Date;\n");
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 497 */     for (DtxDefinition.DtxDaoField primaryKeyField : primaryKeyFields) {
/* 498 */       if (primaryKeyField.getType().equals("BigDecimal")) {
/* 499 */         argWriter.append("import java.math.BigDecimal;\n");
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 504 */     argWriter.append("import dtv.util.common.CommonConstants;\n\n");
/*     */     
/* 506 */     argWriter.append("public class ").append(getIdObjectType(argDtx));
/* 507 */     argWriter.append("\n    extends dtv.data2.access.AbstractObjectId {\n\n");
/*     */     
/* 509 */     argWriter.append("  // Fix serialization compatability based on the name of the DAO\n");
/* 510 */     argWriter.append("  private static final long serialVersionUID = ");
/* 511 */     argWriter.append(String.valueOf(getName(argDtx).hashCode()));
/* 512 */     argWriter.append("L;\n\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getBaseClass(DtxDefinition argDtx) {
/* 520 */     if (!StringUtils.isEmpty(argDtx.getExtendsStringType())) {
/* 521 */       return getDaoPackage(argDtx) + '.' + getDaoClassName(this._definitions.get(argDtx.getExtendsStringType()));
/*     */     }
/*     */     
/* 524 */     return "dtv.data2.access.impl.AbstractDAOImpl";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassFieldInitialValue(DtxDefinition.DtxDaoField argField) {
/* 532 */     if ("Boolean".equals(argField.getType()))
/*     */     {
/*     */       
/* 535 */       return "Boolean.FALSE";
/*     */     }
/*     */     
/* 538 */     return "";
/*     */   }
/*     */   
/*     */   protected String getClassFieldName(DtxDefinition.DtxDaoField argField) {
/* 542 */     return DaoGenUtils.getFieldNameForField(argField);
/*     */   }
/*     */   
/*     */   protected String getClassFieldType(DtxDefinition.DtxDaoField argField) {
/* 546 */     return DaoGenUtils.getConcreteDataType(argField.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassFieldVisibility(DtxDefinition.DtxDaoField argField) {
/* 554 */     return "private";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDaoClass(DtxDefinition argDtx) {
/* 562 */     return getDaoPackage(argDtx) + '.' + getName(argDtx);
/*     */   }
/*     */   
/*     */   protected String getDaoClassName(DtxDefinition argDtx) {
/* 566 */     return this._classNameCache.computeIfAbsent(argDtx, k -> getName(k) + "DAO");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDaoFilePath(DtxDefinition argDtx) {
/* 574 */     String className = getDaoPackage(argDtx) + '.' + getDaoClassName(argDtx);
/* 575 */     String classFile = className.replace('.', File.separatorChar) + ".java";
/* 576 */     return classFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDaoPackage(DtxDefinition argDtx) {
/* 584 */     return this._version + '.' + argDtx.getPackage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getFieldName(DtxDefinition.DtxDaoField argField) {
/* 592 */     return argField.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getGetterName(DtxDefinition.DtxDaoField argField) {
/* 600 */     return DaoGenUtils.getGetterNameForField(argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getGetterType(DtxDefinition.DtxDaoField argField) {
/* 608 */     return DaoGenUtils.getRawDataType(argField.getType());
/*     */   }
/*     */   
/*     */   protected String getIdClassFieldType(DtxDefinition.DtxDaoField argField) {
/* 612 */     return DaoGenUtils.getRawDataType(argField.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIdClassName(DtxDefinition argDtx) {
/* 620 */     return this._version + '.' + argDtx.getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIdFilePath(DtxDefinition argDtx) {
/* 628 */     String className = getIdClassName(argDtx);
/* 629 */     String classFile = className.replace('.', File.separatorChar) + ".java";
/* 630 */     return classFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIdObjectClass(DtxDefinition argDtx) {
/* 638 */     return this._version + '.' + argDtx.getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIdObjectType(DtxDefinition argDtx) {
/* 646 */     return argDtx.getIdType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getIdPackage(DtxDefinition argDtx) {
/* 654 */     return this._version + '.' + argDtx.getInterfacePackage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getInterfaces(DtxDefinition argDtx) {
/* 663 */     boolean hasConfigElementField = Arrays.<DtxDefinition.DtxDaoField>stream(argDtx.getFieldsPlusInheritedPrimaryKeys()).anyMatch(DaoGenConfigElementHelper::isConfigElementField);
/* 664 */     if (hasConfigElementField) {
/* 665 */       return "dtv.data2.access.IHasConfigElement";
/*     */     }
/*     */     
/* 668 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getName(DtxDefinition argDtx) {
/* 676 */     return argDtx.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getPublicFieldName(DtxDefinition.DtxDaoField argField) {
/* 684 */     return "\"" + StringUtils.ensureFirstUpperCase(argField.getName()) + "\"";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSetterArgName(DtxDefinition.DtxDaoField argField) {
/* 692 */     return DaoGenUtils.getArgNameForField(argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSetterArgType(DtxDefinition.DtxDaoField argField) {
/* 700 */     return getGetterType(argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSetterName(DtxDefinition.DtxDaoField argField) {
/* 708 */     return DaoGenUtils.getSetterNameForField(argField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getXmlSafeFieldType(DtxDefinition.DtxDaoField argField) {
/* 716 */     return Integer.toString(DaoGenUtils.getTypeForField(argField));
/*     */   }
/*     */   
/*     */   protected void handleDtxDefinition(DtxDefinition argDtx) {
/* 720 */     File daoFile = new File(this._destination, getDaoFilePath(argDtx));
/* 721 */     daoFile.getParentFile().mkdirs();
/*     */     
/* 723 */     try (Writer writer = FileUtils.getFileWriter(daoFile)) {
/* 724 */       generateDaoHeader(writer, argDtx);
/* 725 */       generateDaoFields(writer, argDtx);
/* 726 */       generateDaoFooter(writer, argDtx);
/*     */     }
/* 728 */     catch (IOException e) {
/* 729 */       e.printStackTrace();
/* 730 */       throw new BuildException("Couldn't write to file: " + daoFile, e);
/*     */     } 
/*     */     
/* 733 */     if (!argDtx.isExtended() && (argDtx.getPrimaryKeyFields()).length > 0) {
/* 734 */       File idFile = new File(this._destination, getIdFilePath(argDtx));
/* 735 */       idFile.getParentFile().mkdirs();
/*     */       
/* 737 */       try (Writer writer = FileUtils.getFileWriter(idFile)) {
/* 738 */         generateIdHeader(writer, argDtx);
/* 739 */         generateIdFields(writer, argDtx);
/* 740 */         generateIdFooter(writer, argDtx);
/*     */       }
/* 742 */       catch (IOException e) {
/* 743 */         e.printStackTrace();
/* 744 */         throw new BuildException("Couldn't write to file: " + idFile, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String makeCast(DtxDefinition.DtxDaoField field) {
/* 754 */     String type = DaoGenUtils.getRawDataType(field.getType());
/* 755 */     if ("Object".equals(type)) {
/* 756 */       return "";
/*     */     }
/* 758 */     return '(' + type + ')';
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\VersionedDAOGenAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */