/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public final class DaoGenUtils
/*     */ {
/*  24 */   private static final Logger logger_ = Logger.getLogger(DaoGenUtils.class);
/*     */   
/*     */   public static final String TYPE_STRING = "String";
/*     */   public static final String TYPE_CLASS = "Class";
/*     */   public static final String TYPE_CLOB = "Clob";
/*     */   public static final String TYPE_DATE = "Date";
/*     */   public static final String TYPE_LONG = "Long";
/*     */   public static final String TYPE_INTEGER = "Integer";
/*     */   public static final String TYPE_OBJECT = "Object";
/*     */   public static final String TYPE_BIG_DECIMAL = "BigDecimal";
/*     */   public static final String TYPE_BOOLEAN = "Boolean";
/*     */   public static final String RELATIONSHIP_DBA = "RelationshipDBA";
/*     */   
/*     */   public static void appendGetterForField(Appendable argAppendable, DtxDefinition.DtxDaoField argField) {
/*     */     try {
/*  39 */       String name = getGetterNameForField(argField);
/*  40 */       String type = getRawDataType(argField.getType());
/*  41 */       String field = getFieldNameForField(argField);
/*     */       
/*  43 */       argAppendable.append("  public ").append(type).append(" ").append(name).append("() {\n");
/*  44 */       argAppendable.append("    return ").append(field).append(";\n");
/*  45 */       argAppendable.append("  }\n\n");
/*     */     }
/*  47 */     catch (IOException ex) {
/*  48 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void appendSetterForField(Appendable argAppendable, DtxDefinition.DtxDaoField argField, boolean checkChanged, boolean filterData) {
/*     */     try {
/*  55 */       String name = getSetterNameForField(argField);
/*  56 */       String type = getRawDataType(argField.getType());
/*  57 */       String arg = getArgNameForField(argField);
/*  58 */       String field = getFieldNameForField(argField);
/*     */ 
/*     */       
/*  61 */       argAppendable.append("  public void ").append(name).append("(").append(type).append(" ").append(arg)
/*  62 */         .append(") {\n");
/*     */ 
/*     */       
/*  65 */       if (checkChanged) {
/*  66 */         argAppendable.append("    if (changed(").append(arg).append(", ").append(field).append(", \"")
/*  67 */           .append(argField.getName()).append("\")) {\n");
/*     */       }
/*     */ 
/*     */       
/*  71 */       String baseIndent = checkChanged ? "      " : "    ";
/*  72 */       argAppendable.append(baseIndent).append(field).append(" = ");
/*  73 */       if ("Date".equalsIgnoreCase(argField.getType()) && filterData) {
/*     */         
/*  75 */         argAppendable.append("(").append(arg).append(" == null || ").append(arg)
/*  76 */           .append(" instanceof dtv.util.DtvDate) ? \n");
/*     */         
/*  78 */         argAppendable.append(baseIndent).append("    (dtv.util.DtvDate) ").append(arg).append(" : ");
/*     */         
/*  80 */         argAppendable.append("new dtv.util.DtvDate(").append(arg).append(");\n");
/*     */       }
/*  82 */       else if ("String".equalsIgnoreCase(argField.getType()) && argField.isPrimaryKey() && filterData) {
/*     */ 
/*     */         
/*  85 */         argAppendable.append("(").append(arg).append(" != null && MANAGE_CASE) ? ").append(arg)
/*  86 */           .append(".toUpperCase() : ").append(arg).append(";\n");
/*     */       }
/*     */       else {
/*     */         
/*  90 */         argAppendable.append(arg).append(";\n");
/*     */       } 
/*     */ 
/*     */       
/*  94 */       if (checkChanged) {
/*  95 */         argAppendable.append("    }\n");
/*     */       }
/*     */ 
/*     */       
/*  99 */       argAppendable.append("  }\n\n");
/*     */     }
/* 101 */     catch (IOException ex) {
/* 102 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getAdderNameForRelationship(DtxRelationship argRel) {
/* 107 */     String elementName = getBaseNameForRelationshipAddRemove(argRel);
/* 108 */     return "add" + elementName;
/*     */   }
/*     */   
/*     */   public static String getArgNameForField(DtxDefinition.DtxDaoField argField) {
/* 112 */     return getArgNameForString(argField.getName());
/*     */   }
/*     */   
/*     */   public static String getArgNameForRelationship(DtxRelationship argRel) {
/* 116 */     return getArgNameForString(argRel.getName());
/*     */   }
/*     */   
/*     */   public static String getArgNameForRelationshipAddRemove(DtxRelationship argRel) {
/* 120 */     String elementName = getBaseNameForRelationshipAddRemove(argRel);
/* 121 */     return getArgNameForString(elementName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getClassForType(String argFieldType) {
/* 131 */     if ("String".equalsIgnoreCase(argFieldType) || "Clob".equalsIgnoreCase(argFieldType) || "Class"
/* 132 */       .equalsIgnoreCase(argFieldType)) {
/* 133 */       return String.class;
/*     */     }
/* 135 */     if ("Integer".equalsIgnoreCase(argFieldType)) {
/* 136 */       return int.class;
/*     */     }
/* 138 */     if ("Date".equalsIgnoreCase(argFieldType)) {
/* 139 */       return Date.class;
/*     */     }
/* 141 */     if ("BigDecimal".equalsIgnoreCase(argFieldType)) {
/* 142 */       return BigDecimal.class;
/*     */     }
/* 144 */     if ("Long".equalsIgnoreCase(argFieldType)) {
/* 145 */       return long.class;
/*     */     }
/* 147 */     if ("Boolean".equalsIgnoreCase(argFieldType)) {
/* 148 */       return boolean.class;
/*     */     }
/* 150 */     if ("Object".equalsIgnoreCase(argFieldType)) {
/* 151 */       return Object.class;
/*     */     }
/*     */     
/* 154 */     logger_.error("getVariableType()::UNKNOWN TYPE : " + argFieldType);
/* 155 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getConcreteDataType(String argType) {
/* 160 */     return "Date".equalsIgnoreCase(argType) ? "dtv.util.DtvDate" : getRawDataType(argType);
/*     */   }
/*     */   
/*     */   public static String getEtter(String argFieldType, int argIndex) {
/* 164 */     if ("Class".equalsIgnoreCase(argFieldType)) {
/* 165 */       return "etString(" + argIndex + ")";
/*     */     }
/* 167 */     if ("Integer".equalsIgnoreCase(argFieldType)) {
/* 168 */       return "etInt(" + argIndex + ")";
/*     */     }
/* 170 */     if ("Object".equalsIgnoreCase(argFieldType)) {
/* 171 */       return "etBytes(" + argIndex + ")";
/*     */     }
/*     */     
/* 174 */     return "et" + argFieldType + "(" + argIndex + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getEtterInputObject(String argFieldType, int argIndex, String argAddIn) {
/* 181 */     if ("Class".equalsIgnoreCase(argFieldType)) {
/* 182 */       return "etString(" + argIndex + ", " + argAddIn + ")";
/*     */     }
/* 184 */     if ("Integer".equalsIgnoreCase(argFieldType)) {
/* 185 */       return "etInt(" + argIndex + ", " + argAddIn + ")";
/*     */     }
/* 187 */     if ("Date".equalsIgnoreCase(argFieldType)) {
/*     */       
/* 189 */       String ss = "etTimestamp(${argIndex}, new java.sql.Timestamp(${argAddIn}.getTime()))";
/*     */       
/* 191 */       Map<String, String> params = new HashMap<>(2);
/* 192 */       params.put("argIndex", String.valueOf(argIndex));
/* 193 */       params.put("argAddIn", argAddIn);
/* 194 */       return StringUtils.replaceVariables(ss, params);
/*     */     } 
/*     */     
/* 197 */     return "et" + argFieldType + "(" + argIndex + ", " + argAddIn + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getFieldNameForField(DtxDefinition.DtxDaoField argField) {
/* 202 */     return getFieldNameForString(argField.getName());
/*     */   }
/*     */   
/*     */   public static String getFieldNameForRelationship(DtxRelationship argRel) {
/* 206 */     return getFieldNameForString(argRel.getName());
/*     */   }
/*     */   
/*     */   public static String getGetterNameForField(DtxDefinition.DtxDaoField argField) {
/* 210 */     return getGetterNameForString(argField.getName());
/*     */   }
/*     */   
/*     */   public static String getGetterNameForRelationship(DtxRelationship argRel) {
/* 214 */     return getGetterNameForString(argRel.getName());
/*     */   }
/*     */   
/*     */   public static String getRawDataType(String type) {
/* 218 */     if (type.equals("Class")) {
/* 219 */       return "String";
/*     */     }
/* 221 */     if (type.equals("Clob")) {
/* 222 */       return "String";
/*     */     }
/* 224 */     if (type.equals("BigDecimal")) {
/* 225 */       return "java.math.BigDecimal";
/*     */     }
/* 227 */     if (type.equals("Date")) {
/* 228 */       return "java.util.Date";
/*     */     }
/*     */     
/* 231 */     return type;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getRemoverNameForRelationship(DtxRelationship argRel) {
/* 236 */     String elementName = getBaseNameForRelationshipAddRemove(argRel);
/* 237 */     return "remove" + elementName;
/*     */   }
/*     */   
/*     */   public static String getSetterNameForField(DtxDefinition.DtxDaoField argField) {
/* 241 */     return getSetterNameForString(argField.getName());
/*     */   }
/*     */   
/*     */   public static String getSetterNameForRelationship(DtxRelationship argRel) {
/* 245 */     return getSetterNameForString(argRel.getName());
/*     */   }
/*     */   
/*     */   public static int getTypeForField(DtxDefinition.DtxDaoField argField) {
/* 249 */     String type = argField.getType();
/*     */     
/* 251 */     if ("String".equalsIgnoreCase(type)) {
/* 252 */       return 12;
/*     */     }
/* 254 */     if ("Clob".equalsIgnoreCase(type)) {
/* 255 */       return 2005;
/*     */     }
/* 257 */     if ("Integer".equalsIgnoreCase(type)) {
/* 258 */       return 4;
/*     */     }
/* 260 */     if ("Date".equalsIgnoreCase(type)) {
/* 261 */       return 91;
/*     */     }
/* 263 */     if ("Class".equalsIgnoreCase(type)) {
/* 264 */       return 12;
/*     */     }
/* 266 */     if ("BigDecimal".equalsIgnoreCase(type)) {
/* 267 */       return 3;
/*     */     }
/* 269 */     if ("Long".equalsIgnoreCase(type)) {
/* 270 */       return -5;
/*     */     }
/* 272 */     if ("Boolean".equalsIgnoreCase(type))
/*     */     {
/* 274 */       return -7;
/*     */     }
/* 276 */     if ("Object".equalsIgnoreCase(type)) {
/* 277 */       return -4;
/*     */     }
/*     */     
/* 280 */     logger_.error("getTypeForField()::UNKNOWN TYPE: " + type);
/* 281 */     return 1111;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTypeForRelationship(DtxRelationship argRel, boolean isCleanBean) {
/* 287 */     String type = isCleanBean ? getRawDataType(argRel.getChild().getCleanbeanClassname()) : argRel.getChild().getInterface();
/* 288 */     if (DtxRelationship.ONE_MANY.equalsIgnoreCase(argRel.getType()) || DtxRelationship.MANY_MANY
/* 289 */       .equalsIgnoreCase(argRel.getType())) {
/* 290 */       type = "java.util.List<" + type + ">";
/*     */     }
/* 292 */     return type;
/*     */   }
/*     */   
/*     */   public static String getVariableType(String argFieldType) {
/* 296 */     if ("String".equalsIgnoreCase(argFieldType) || "Clob".equalsIgnoreCase(argFieldType)) {
/* 297 */       return "String";
/*     */     }
/* 299 */     if ("Integer".equalsIgnoreCase(argFieldType)) {
/* 300 */       return "int";
/*     */     }
/* 302 */     if ("Date".equalsIgnoreCase(argFieldType)) {
/* 303 */       return "Date";
/*     */     }
/* 305 */     if ("Class".equalsIgnoreCase(argFieldType)) {
/* 306 */       return "String";
/*     */     }
/* 308 */     if ("BigDecimal".equalsIgnoreCase(argFieldType)) {
/* 309 */       return "java.math.BigDecimal";
/*     */     }
/* 311 */     if ("Long".equalsIgnoreCase(argFieldType)) {
/* 312 */       return "long";
/*     */     }
/* 314 */     if ("Boolean".equalsIgnoreCase(argFieldType)) {
/* 315 */       return "boolean";
/*     */     }
/* 317 */     if ("Object".equalsIgnoreCase(argFieldType)) {
/* 318 */       return "Object";
/*     */     }
/*     */     
/* 321 */     logger_.error("getVariableType()::UNKNOWN TYPE : " + argFieldType);
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getXmlTypeForField(DtxDefinition.DtxDaoField argField) {
/* 327 */     String type = argField.getType();
/*     */     
/* 329 */     if ("String".equalsIgnoreCase(type)) {
/* 330 */       return "string";
/*     */     }
/* 332 */     if ("Clob".equalsIgnoreCase(type)) {
/* 333 */       return "string";
/*     */     }
/* 335 */     if ("Integer".equalsIgnoreCase(type)) {
/* 336 */       return "int";
/*     */     }
/* 338 */     if ("Date".equalsIgnoreCase(type)) {
/* 339 */       return "dateTime";
/*     */     }
/* 341 */     if ("Class".equalsIgnoreCase(type)) {
/* 342 */       return "string";
/*     */     }
/* 344 */     if ("BigDecimal".equalsIgnoreCase(type)) {
/* 345 */       return "decimal";
/*     */     }
/* 347 */     if ("Long".equalsIgnoreCase(type)) {
/* 348 */       return "long";
/*     */     }
/* 350 */     if ("Boolean".equalsIgnoreCase(type)) {
/* 351 */       return "boolean";
/*     */     }
/* 353 */     if ("Object".equalsIgnoreCase(type)) {
/* 354 */       return "base64Binary";
/*     */     }
/*     */     
/* 357 */     logger_.error("getTypeForField()::UNKNOWN TYPE: " + type);
/* 358 */     return "anyType";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String toPrimitive(DtxDefinition.DtxDaoField argField) {
/* 363 */     String type = argField.getType();
/*     */     
/* 365 */     if ("Integer".equalsIgnoreCase(type)) {
/* 366 */       return argField.getName() + "().intValue()";
/*     */     }
/* 368 */     if ("Long".equalsIgnoreCase(type)) {
/* 369 */       return argField.getName() + "().longValue()";
/*     */     }
/* 371 */     if ("Boolean".equalsIgnoreCase(type)) {
/* 372 */       return argField.getName() + "().booleanValue()";
/*     */     }
/*     */     
/* 375 */     return argField.getName() + "()";
/*     */   }
/*     */   
/*     */   public static String toPrimitive(String argtType) {
/* 379 */     String type = argtType;
/*     */     
/* 381 */     if ("Integer".equalsIgnoreCase(type)) {
/* 382 */       return ".intValue()";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 387 */     if ("Long".equalsIgnoreCase(type)) {
/* 388 */       return ".longValue()";
/*     */     }
/* 390 */     if ("Boolean".equalsIgnoreCase(type)) {
/* 391 */       return ".booleanValue()";
/*     */     }
/*     */     
/* 394 */     return "";
/*     */   }
/*     */   
/*     */   public static String wrapStatementWithObject(String argToWrap, String type) {
/* 398 */     if ("Integer".equalsIgnoreCase(type)) {
/* 399 */       return "Integer.valueOf(" + argToWrap + ")";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 405 */     if ("Long".equalsIgnoreCase(type)) {
/* 406 */       return "Long.valueOf(" + argToWrap + ")";
/*     */     }
/* 408 */     if ("Boolean".equalsIgnoreCase(type)) {
/* 409 */       return "Boolean.valueOf(" + argToWrap + ")";
/*     */     }
/*     */     
/* 412 */     return argToWrap;
/*     */   }
/*     */   
/*     */   private static String getArgNameForString(String argString) {
/* 416 */     String elementName = StringUtils.ensureFirstUpperCase(argString);
/* 417 */     return "arg" + elementName;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getBaseNameForRelationshipAddRemove(DtxRelationship argRel) {
/* 422 */     String elementName = (argRel.getElementName() != null && argRel.getElementName().length() > 0) ? argRel.getElementName() : argRel.getChildName();
/* 423 */     return StringUtils.ensureFirstUpperCase(elementName);
/*     */   }
/*     */   
/*     */   private static String getFieldNameForString(String argString) {
/* 427 */     return "_" + StringUtils.ensureFirstLowerCase(argString);
/*     */   }
/*     */   
/*     */   private static String getGetterNameForString(String argString) {
/* 431 */     String proper = StringUtils.ensureFirstUpperCase(argString);
/* 432 */     return "get" + proper;
/*     */   }
/*     */   
/*     */   private static String getSetterNameForString(String argString) {
/* 436 */     String proper = StringUtils.ensureFirstUpperCase(argString);
/* 437 */     return "set" + proper;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */