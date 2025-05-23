/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.Callable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenerateIds
/*     */   implements Callable<Void>
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(GenerateIds.class);
/*     */   
/*     */   private final DaoGenHelper helper_;
/*     */   
/*     */   GenerateIds(DaoGenHelper argHelper) {
/*  32 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  40 */     logger_.info("Generating id classes");
/*     */     
/*  42 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/*     */       
/*  44 */       if (dtx.isExtended() || !dtx.needsGeneration(null)) {
/*     */         continue;
/*     */       }
/*  47 */       StringBuilder w = new StringBuilder(5120);
/*     */       
/*  49 */       getIdHeader(w, dtx);
/*  50 */       getIdConstuctors(w, dtx);
/*  51 */       getIdFields(w, dtx);
/*  52 */       getIdMethods(w, dtx);
/*  53 */       getIdEquals(w, dtx);
/*  54 */       getIdHashCode(w, dtx);
/*  55 */       getIdDtxTypeName(w, dtx);
/*  56 */       getIdToString(w, dtx);
/*  57 */       getIdValidate(w, dtx);
/*  58 */       getIdFooter(w);
/*     */ 
/*     */       
/*  61 */       String daiPath = (this.helper_.getOutPath() + this.helper_.getFilePath(dtx)).replaceAll("impl\\" + File.separator, "");
/*  62 */       File f = new File(daiPath + dtx.getIdType() + ".java");
/*  63 */       this.helper_.getWriter().write(f, w.toString());
/*     */     } 
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   private void getIdConstuctors(StringBuilder w, DtxDefinition argDtx) {
/*  69 */     String constructorName = argDtx.getIdType();
/*     */     
/*  71 */     w.append("  public " + constructorName + "() {\n");
/*  72 */     w.append("    super();");
/*  73 */     w.append("    // default\n");
/*  74 */     w.append("  }\n\n");
/*  75 */     w.append("  public " + constructorName + "(String argObjectIdValue) {\n");
/*  76 */     w.append("    setValue(argObjectIdValue);\n");
/*  77 */     w.append("  }\n\n");
/*     */   }
/*     */   
/*     */   private void getIdDtxTypeName(StringBuilder w, DtxDefinition argDtx) {
/*  81 */     w.append("  public String getDtxTypeName() {\n");
/*  82 */     w.append("    return \"" + argDtx.getName() + "\";\n");
/*  83 */     w.append("  }\n\n");
/*     */   }
/*     */   
/*     */   private void getIdEquals(StringBuilder w, DtxDefinition argDtx) {
/*  87 */     String idName = argDtx.getIdType();
/*     */     
/*  89 */     w.append("  @Override\n  public boolean equals(Object ob) {\n");
/*     */     
/*  91 */     if ((argDtx.getPrimaryKeyFields()).length == 0) {
/*  92 */       w.append("    return false;");
/*  93 */       w.append("  }\n\n");
/*     */       
/*     */       return;
/*     */     } 
/*  97 */     w.append("    if (this == ob) {\n");
/*  98 */     w.append("      return true;\n");
/*  99 */     w.append("    }\n");
/* 100 */     w.append("    if (!(ob instanceof " + idName + ")) {\n");
/* 101 */     w.append("      return false;\n");
/* 102 */     w.append("    }\n");
/* 103 */     w.append("    " + idName + " other = (" + idName + ") ob;\n");
/*     */     
/* 105 */     boolean first = true;
/* 106 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 107 */       if (first) {
/* 108 */         w.append("    return\n          ");
/* 109 */         first = false;
/*     */       } else {
/*     */         
/* 112 */         w.append("        && ");
/*     */       } 
/* 114 */       String fieldName = DaoGenUtils.getFieldNameForField(field);
/* 115 */       w.append("((" + fieldName + " == null && other." + fieldName + " == null) ||\n");
/* 116 */       w.append("            (this." + fieldName + " != null &&\n");
/* 117 */       if (field.getType().equals("Date")) {
/* 118 */         w.append("             this." + fieldName + ".equals((Object)other." + fieldName + ")))\n");
/*     */       } else {
/*     */         
/* 121 */         w.append("             this." + fieldName + ".equals(other." + fieldName + ")))\n");
/*     */       } 
/*     */     } 
/* 124 */     w.append("          ;\n  }\n\n");
/*     */   }
/*     */   
/*     */   private void getIdFields(StringBuilder w, DtxDefinition argDtx) {
/* 128 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 129 */       if (!field.getName().equalsIgnoreCase("organizationId")) {
/* 130 */         w.append("  private " + 
/* 131 */             DaoGenUtils.getConcreteDataType(field.getType()) + " " + DaoGenUtils.getFieldNameForField(field) + ";\n");
/*     */       }
/*     */     } 
/* 134 */     w.append("\n");
/*     */   }
/*     */   
/*     */   private void getIdFooter(StringBuilder w) {
/* 138 */     w.append("} ");
/*     */   }
/*     */   
/*     */   private void getIdHashCode(StringBuilder w, DtxDefinition argDtx) {
/* 142 */     w.append("  @Override\n  public int hashCode() {\n");
/*     */ 
/*     */     
/* 145 */     if ((argDtx.getPrimaryKeyFields()).length == 0) {
/* 146 */       w.append("    return 0;\n");
/* 147 */       w.append("  }\n\n");
/*     */       return;
/*     */     } 
/* 150 */     w.append("    return (\n");
/*     */     
/* 152 */     boolean first = true;
/* 153 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 154 */       w.append("        ");
/* 155 */       if (first) {
/* 156 */         first = false;
/*     */       } else {
/*     */         
/* 159 */         w.append("+ ");
/*     */       } 
/* 161 */       w.append("((" + DaoGenUtils.getFieldNameForField(field) + " == null) ? 0 : " + DaoGenUtils.getFieldNameForField(field) + ".hashCode())\n");
/*     */     } 
/*     */     
/* 164 */     w.append("        );\n  }\n\n");
/*     */   }
/*     */   
/*     */   private void getIdHeader(StringBuilder w, DtxDefinition argDtx) {
/* 168 */     w.append("package " + argDtx.getInterfacePackage() + ";\n\n");
/*     */     
/* 170 */     DtxDefinition.DtxDaoField[] primaryKeyFields = argDtx.getPrimaryKeyFields();
/* 171 */     boolean keyHasConfigElement = false;
/*     */     
/* 173 */     for (DtxDefinition.DtxDaoField primaryKeyField : primaryKeyFields) {
/* 174 */       if (primaryKeyField.getType().equals("Date")) {
/* 175 */         w.append("import java.util.Date;\n\n");
/*     */       }
/* 177 */       else if (primaryKeyField.getType().equals("BigDecimal")) {
/* 178 */         w.append("import java.math.BigDecimal;\n\n");
/*     */       } 
/*     */       
/* 181 */       if (DaoGenConfigElementHelper.isConfigElementField(primaryKeyField)) {
/* 182 */         keyHasConfigElement = true;
/*     */       }
/*     */     } 
/*     */     
/* 186 */     w.append("import dtv.util.common.CommonConstants;\n\n");
/*     */     
/* 188 */     w.append(this.helper_.getClassCommentWithSuppressWarnings("Auto generated Id Object for " + argDtx.getName()));
/*     */     
/* 190 */     w.append("public class ");
/* 191 */     w.append(argDtx.getIdType());
/*     */     
/* 193 */     w.append("\n    extends dtv.data2.access.AbstractObjectId");
/*     */     
/* 195 */     if (keyHasConfigElement) {
/* 196 */       w.append("\n    implements dtv.data2.access.IHasConfigElement");
/*     */     }
/*     */     
/* 199 */     w.append(" {\n\n");
/*     */     
/* 201 */     w.append("  // Fix serialization compatability based on the name of the DAO\n");
/* 202 */     w.append("  private static final long serialVersionUID = ");
/* 203 */     w.append(String.valueOf(argDtx.getName().hashCode()));
/* 204 */     w.append("L;\n\n");
/*     */     
/* 206 */     if (keyHasConfigElement) {
/* 207 */       w.append("  @Override\n");
/* 208 */       w.append("  public dtv.data2.access.IObjectId getObjectId() {\n");
/* 209 */       w.append("    return this;\n");
/* 210 */       w.append("  }\n\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getIdMethods(StringBuilder w, DtxDefinition argDtx) {
/* 215 */     DtxDefinition.DtxDaoField[] primaryKeyFields = argDtx.getPrimaryKeyFields();
/*     */     
/* 217 */     for (DtxDefinition.DtxDaoField field : primaryKeyFields) {
/* 218 */       if (!field.getName().equalsIgnoreCase("organizationId")) {
/*     */         
/* 220 */         DaoGenUtils.appendGetterForField(w, field);
/*     */ 
/*     */         
/* 223 */         DaoGenUtils.appendSetterForField(w, field, false, true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     w.append("  public void setValue(String argObjectIdValue) {\n");
/* 232 */     w.append("    String str = argObjectIdValue;\n");
/* 233 */     w.append("    if (dtv.util.StringUtils.isEmpty(str)) {\n");
/* 234 */     w.append("      throw new dtv.data2.access.exception.DtxException(\"argument passed to setValue() is null or empty - a valid value must be passed\");\n");
/*     */     
/* 236 */     w.append("    }\n");
/*     */     
/* 238 */     w.append("    try {\n");
/*     */     
/* 240 */     w.append("      String[] tokens = str.split(\"::\");\n");
/*     */     
/* 242 */     int ii = 0;
/* 243 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 244 */       w.append("      str = tokens[" + ii++ + "];\n\n");
/*     */       
/* 246 */       String fieldNameForField = DaoGenUtils.getFieldNameForField(field);
/* 247 */       String setterNameForField = DaoGenUtils.getSetterNameForField(field);
/* 248 */       if (field.getType().equals("Date")) {
/* 249 */         w.append("      if (\"null\".equals(str)) {\n");
/* 250 */         w.append("        " + setterNameForField + "(null);\n");
/* 251 */         w.append("      }\n");
/* 252 */         w.append("      else {\n");
/* 253 */         w.append("        " + setterNameForField + "(new dtv.util.DtvDate());\n");
/* 254 */         w.append("        " + fieldNameForField + ".setTimeFromSerialization(Long.parseLong(str));\n");
/* 255 */         w.append("      }\n");
/*     */       }
/* 257 */       else if (field.getType().equals("Long")) {
/* 258 */         w.append("      " + setterNameForField + "(java.lang.Long.valueOf(str));\n");
/*     */       }
/* 260 */       else if (field.getType().equals("Integer")) {
/* 261 */         w.append("      " + setterNameForField + "(java.lang.Integer.valueOf(str));\n");
/*     */       }
/* 263 */       else if (field.getType().equals("BigDecimal")) {
/* 264 */         w.append("      " + setterNameForField + "(new java.math.BigDecimal(str));\n");
/*     */       } else {
/*     */         
/* 267 */         w.append("      if (\"null\".equals(str)) {\n");
/* 268 */         w.append("        " + setterNameForField + "(null);\n");
/* 269 */         w.append("      }\n");
/* 270 */         w.append("      else {\n");
/* 271 */         w.append("        " + setterNameForField + "(str);\n");
/* 272 */         w.append("      }\n");
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     w.append("    }\n");
/* 277 */     w.append("    catch (Exception ee) {\n");
/* 278 */     w.append("      throw new dtv.data2.access.exception.DtxException(\"An exception occured while parsing object id string: \" + argObjectIdValue, ee);\n");
/*     */ 
/*     */     
/* 281 */     w.append("    }\n");
/* 282 */     w.append("  }\n");
/* 283 */     w.append("\n");
/*     */   }
/*     */   
/*     */   private void getIdToString(StringBuilder w, DtxDefinition argDtx) {
/* 287 */     w.append("  @Override\n  public String toString() {\n");
/*     */ 
/*     */     
/* 290 */     if ((argDtx.getPrimaryKeyFields()).length == 0) {
/* 291 */       w.append("    return \"" + argDtx.getName() + " does not define primary key fields.\";\n");
/* 292 */       w.append("  }\n\n");
/*     */       
/*     */       return;
/*     */     } 
/* 296 */     w.append("    StringBuilder buff = new StringBuilder(12 * " + (argDtx
/* 297 */         .getPrimaryKeyFields()).length + ");\n\n");
/* 298 */     w.append("    return buff.append(\n");
/*     */     
/* 300 */     int count = 0;
/*     */     
/* 302 */     boolean first = true;
/* 303 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/*     */       
/* 305 */       count++;
/*     */       
/* 307 */       if (!first) {
/* 308 */         w.append("      append(\"::\").append(");
/*     */       } else {
/*     */         
/* 311 */         w.append("      ");
/* 312 */         first = false;
/*     */       } 
/*     */       
/* 315 */       if (field.getType().equals("Date")) {
/* 316 */         w.append(DaoGenUtils.getFieldNameForField(field));
/* 317 */         w.append(" == null ? \"null\" ");
/* 318 */         w.append(": String.valueOf(");
/* 319 */         w.append(DaoGenUtils.getFieldNameForField(field));
/* 320 */         w.append(".getTimeSerializable())).");
/*     */       } else {
/*     */         
/* 323 */         String fieldName = DaoGenUtils.getFieldNameForField(field);
/* 324 */         if (field.getType().equals("String")) {
/* 325 */           w.append(fieldName + ").");
/*     */         }
/* 327 */         else if (field.getType().equals("BigDecimal")) {
/*     */ 
/*     */           
/* 330 */           w.append("new java.text.DecimalFormat(\"0.000000\").format(" + fieldName + ")).");
/*     */         } else {
/*     */           
/* 333 */           w.append("String.valueOf(" + fieldName + ")).");
/*     */         } 
/*     */       } 
/* 336 */       w.append("\n");
/*     */     } 
/*     */ 
/*     */     
/* 340 */     if (count == 0) {
/* 341 */       w.append("      super.toString()\n");
/*     */     }
/*     */     
/* 344 */     w.append("    toString();\n  }\n\n");
/*     */   }
/*     */   
/*     */   private void getIdValidate(StringBuilder w, DtxDefinition argDtx) {
/* 348 */     boolean orgNoded = argDtx.isOrgHierarchical();
/*     */     
/* 350 */     w.append("  public boolean validate() {\n");
/*     */     
/* 352 */     for (DtxDefinition.DtxDaoField field : argDtx.getPrimaryKeyFields()) {
/* 353 */       if (!field.getName().equalsIgnoreCase("organizationId") && (!orgNoded || 
/* 354 */         !DaoGenOrgHierarchyHelper.isOrgHierarchyField(field))) {
/*     */         
/* 356 */         w.append("    if (" + DaoGenUtils.getFieldNameForField(field) + " == null) {\n");
/* 357 */         w.append("      return false;\n");
/* 358 */         w.append("    }\n");
/*     */       } 
/*     */     } 
/* 361 */     w.append("    return true;\n");
/* 362 */     w.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateIds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */