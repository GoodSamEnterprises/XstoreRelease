/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.data2.access.IDataModelRelationship;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
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
/*     */ public class GenerateRelationships
/*     */   implements Callable<Void>
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(GenerateRelationships.class);
/*     */   
/*     */   private final DaoGenHelper helper_;
/*     */   
/*     */   private boolean orgHierarchyJoinRequired_ = false;
/*     */   
/*     */   GenerateRelationships(DaoGenHelper argHelper) {
/*  34 */     this.helper_ = argHelper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  42 */     logger_.info("Generating relationships");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     for (DtxDefinition dtx : this.helper_.getDtxDefinitions()) {
/*     */ 
/*     */       
/*  50 */       if (dtx.isCustomerExtension()) {
/*  51 */         dtx.getRelationships().add(getCustomerOverrideRelationship(dtx));
/*     */       }
/*     */       
/*  54 */       for (DtxRelationship rel : dtx.getRelationships()) {
/*  55 */         if (dtx.needsGeneration(null) || rel.getChild().needsGeneration(null)) {
/*  56 */           StringBuilder w = new StringBuilder(5120);
/*  57 */           getRelationshipDBAHeader(w, dtx, rel);
/*  58 */           getRelationshipSelect(w, dtx, rel);
/*  59 */           getRelationshipParent(w, dtx, rel);
/*  60 */           getIsOrgHierarchyJoinRequired(w);
/*  61 */           getRelationshipDBAFooter(w, dtx, rel);
/*     */           
/*  63 */           File f = new File(this.helper_.getOutPath() + this.helper_.getFilePath(dtx) + dtx.getName() + rel.getName() + "RelationshipDBA.java");
/*     */           
/*  65 */           this.helper_.getWriter().write(f, w.toString());
/*     */         } 
/*     */       } 
/*     */       
/*  69 */       if (dtx.isCustomerExtension()) {
/*  70 */         dtx.getRelationships().remove(dtx.getRelationships().size() - 1);
/*     */       }
/*     */     } 
/*  73 */     return null;
/*     */   }
/*     */   
/*     */   private DtxRelationship getCustomerOverrideRelationship(DtxDefinition dtx) {
/*  77 */     DtxRelationship rel = new DtxRelationship();
/*  78 */     rel.setChild(dtx);
/*  79 */     rel.setParent(dtx.getExtends());
/*  80 */     rel.setDependent(true);
/*  81 */     rel.setName(dtx.getExtends().getName() + "Extension");
/*  82 */     rel.setType("One-One");
/*     */ 
/*     */ 
/*     */     
/*  86 */     DtxDefinition.DtxDaoField[] pk = dtx.getPrimaryKeyFieldsRaw();
/*     */     
/*  88 */     for (DtxDefinition.DtxDaoField field : pk) {
/*  89 */       rel.getClass(); DtxRelationship.DtxRelationshipField relField = new DtxRelationship.DtxRelationshipField(rel);
/*  90 */       relField.setParent(field.getName());
/*  91 */       relField.setChild(field.getName());
/*  92 */       rel.addField(relField);
/*     */ 
/*     */       
/*  95 */       if (dtx.getExtends().findField(field.getName()) == null) {
/*  96 */         dtx.getExtends().addField(field);
/*     */       }
/*     */     } 
/*     */     
/* 100 */     return rel;
/*     */   }
/*     */   
/*     */   private void getIsOrgHierarchyJoinRequired(StringBuilder w) {
/* 104 */     w.append("  @Override\n");
/* 105 */     w.append("  public boolean isOrgHierarchyJoinRequired() {\n    return ");
/*     */     
/* 107 */     w.append(this.orgHierarchyJoinRequired_);
/* 108 */     w.append(";\n");
/* 109 */     w.append("  }\n\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private void getRelationshipDBAFooter(StringBuilder w, DtxDefinition argDtx, DtxRelationship argRelationship) {
/* 114 */     w.append("  public List getParameterList() {\n    return _parameterList;\n  }\n\n");
/*     */ 
/*     */ 
/*     */     
/* 118 */     w.append("  public dtv.data2.access.IObjectId getChildObjectId() {\n");
/*     */     
/* 120 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString()
/* 121 */       .equalsIgnoreCase(argRelationship.getType())) {
/* 122 */       w.append("    return _childObjectId;\n");
/*     */     }
/*     */     else {
/*     */       
/* 126 */       w.append("    throw new dtv.data2.access.exception.DtxException(\"getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: \" + this.getClass().getName());\n");
/*     */     } 
/*     */ 
/*     */     
/* 130 */     w.append("  }\n");
/* 131 */     w.append("}\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void getRelationshipDBAHeader(StringBuilder w, DtxDefinition argDtx, DtxRelationship argRelationship) {
/* 137 */     w.append("package ");
/* 138 */     w.append(argDtx.getPackage());
/* 139 */     w.append(";\n\nimport java.util.ArrayList;\nimport java.util.List;\n\nimport dtv.data2.access.IDataAccessObject;\nimport dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     w.append(this.helper_.getClassCommentWithSuppressWarnings("Auto-generated DBA \n * DO NOT MANUALLY MODIFY THIS FILE.\n * ANY CHANGES WILL BE OVERWRITTEN BY REGENERATION!!"));
/*     */ 
/*     */ 
/*     */     
/* 150 */     w.append("public class ");
/* 151 */     w.append(argDtx.getName());
/* 152 */     w.append(argRelationship.getName());
/* 153 */     w.append("RelationshipDBA");
/* 154 */     w.append(" implements IJDBCRelationshipAdapter {\n\n");
/*     */     
/* 156 */     w.append(" private List<Object> _parameterList = new ArrayList<Object>(" + argRelationship
/* 157 */         .getFields().size() + ");\n\n");
/*     */     
/* 159 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString()
/* 160 */       .equalsIgnoreCase(argRelationship.getType())) {
/* 161 */       w.append("  " + argRelationship.getChild().getId() + " _childObjectId = null;\n\n");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getRelationshipParent(StringBuilder w, DtxDefinition argDtx, DtxRelationship argRelationship) {
/* 171 */     this.orgHierarchyJoinRequired_ = DaoGenOrgHierarchyHelper.isOrgHierarchical(argRelationship.getChild());
/*     */     
/* 173 */     w.append("  public void setParent(IDataAccessObject argDAO) {\n    ");
/*     */ 
/*     */     
/* 176 */     if (argDtx.isCustomerExtension()) {
/* 177 */       String parent = argDtx.getExtends().getPackage() + "." + argDtx.getExtends().getName() + "DAO";
/* 178 */       w.append(parent + " dao = (" + parent + ")argDAO;\n");
/*     */     } else {
/*     */       
/* 181 */       w.append(argDtx.getName() + "DAO dao = (" + argDtx.getName() + "DAO)argDAO;\n");
/*     */     } 
/*     */     
/* 184 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString()
/* 185 */       .equalsIgnoreCase(argRelationship.getType()))
/*     */     {
/* 187 */       w.append("    _childObjectId = new " + argRelationship.getChild().getId() + "();\n");
/*     */     }
/*     */     
/* 190 */     for (DtxRelationship.DtxRelationshipField field : argRelationship.getFields()) {
/* 191 */       if (!StringUtils.isEmpty(field.getParent())) {
/* 192 */         String fieldName = StringUtils.ensureFirstUpperCase(field.getParent());
/* 193 */         String childFieldName = StringUtils.ensureFirstUpperCase(field.getChild());
/*     */         
/* 195 */         if (this.orgHierarchyJoinRequired_ && DaoGenOrgHierarchyHelper.isOrgHierarchyRelationshipJoin(field))
/*     */         {
/*     */ 
/*     */           
/* 199 */           this.orgHierarchyJoinRequired_ = false;
/*     */         }
/*     */ 
/*     */         
/* 203 */         boolean isCharacterNonPkToPk = false;
/* 204 */         for (DtxDefinition.DtxDaoField childPkField : argRelationship.getChild().getPrimaryKeyFields()) {
/* 205 */           for (DtxDefinition.DtxDaoField parentNonPkField : argRelationship.getParent().getNonPkFields()) {
/* 206 */             if ("String".equalsIgnoreCase(parentNonPkField.getType()) && parentNonPkField
/* 207 */               .getName().equals(field.getParent()) && childPkField
/* 208 */               .getName().equals(field.getChild())) {
/* 209 */               isCharacterNonPkToPk = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 216 */         String getterCall = "dao.get" + fieldName + "()";
/* 217 */         if (isCharacterNonPkToPk) {
/* 218 */           w.append("    _parameterList.add(").append(getterCall)
/* 219 */             .append(" != null && dtv.data2.access.impl.PersistenceConstants.MANAGE_CASE ? ")
/* 220 */             .append(getterCall).append(".toUpperCase() : ").append(getterCall).append(");\n");
/*     */         } else {
/*     */           
/* 223 */           w.append("    _parameterList.add(").append(getterCall).append(");\n");
/*     */         } 
/*     */         
/* 226 */         if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString()
/* 227 */           .equalsIgnoreCase(argRelationship.getType()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 238 */           if (!argDtx.getName().equalsIgnoreCase("SaleReturnLineItem") || 
/* 239 */             !argRelationship.getName().equalsIgnoreCase("inventoryDocumentLineItem"))
/*     */           {
/* 241 */             w.append("    _childObjectId.set" + childFieldName + "(dao.get" + fieldName + "());\n");
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 247 */     w.append("  }\n\n");
/*     */   }
/*     */   
/*     */   private void getRelationshipSelect(StringBuilder w, DtxDefinition argDtx, DtxRelationship argRelationship) {
/* 251 */     w.append("  public String getSelect() {\n    return \"SELECT ");
/*     */ 
/*     */     
/* 254 */     if (IDataModelRelationship.RelationshipType.ONE_TO_ONE.toString()
/* 255 */       .equalsIgnoreCase(argRelationship.getType()) || IDataModelRelationship.RelationshipType.ONE_TO_MANY
/* 256 */       .toString()
/* 257 */       .equalsIgnoreCase(argRelationship.getType())) {
/*     */ 
/*     */ 
/*     */       
/* 261 */       DtxDefinition.DtxDaoField[] fields = argRelationship.getChild().getTopMostParent().getFields();
/*     */       
/* 263 */       for (int ii = 0; ii < fields.length; ii++) {
/* 264 */         w.append(fields[ii].getColumn());
/* 265 */         if (ii < fields.length - 1) {
/* 266 */           w.append(", ");
/*     */         }
/*     */       } 
/*     */       
/* 270 */       w.append(" FROM ");
/* 271 */       w.append(argRelationship.getChild().getTopMostParent().getTable());
/*     */       
/* 273 */       boolean whereWritten = false;
/*     */       
/* 275 */       for (DtxRelationship.DtxRelationshipField relField : argRelationship.getFields()) {
/* 276 */         if (whereWritten) {
/* 277 */           w.append(" AND ");
/*     */         } else {
/*     */           
/* 280 */           w.append(" WHERE ");
/* 281 */           whereWritten = true;
/*     */         } 
/*     */         
/* 284 */         w.append(argRelationship.getChild().getTopMostParent().getColumnForFieldName(relField.getChild()));
/* 285 */         w.append(" = ?");
/*     */       } 
/* 287 */       w.append("\";\n");
/*     */     }
/* 289 */     else if (DtxRelationship.ONE_ONE.equalsIgnoreCase(argRelationship.getType())) {
/*     */       
/* 291 */       DtxDefinition.DtxDaoField[] fields = argRelationship.getChild().getTopMostParent().getFields();
/*     */       
/* 293 */       for (int ii = 0; ii < fields.length; ii++) {
/* 294 */         w.append("a.");
/* 295 */         w.append(fields[ii].getColumn());
/* 296 */         if (ii < fields.length - 1) {
/* 297 */           w.append(", ");
/*     */         }
/*     */       } 
/* 300 */       w.append(" FROM ");
/* 301 */       w.append(argRelationship.getChild().getTopMostParent().getTable());
/* 302 */       w.append(" a, ");
/* 303 */       w.append(argRelationship.getTable());
/* 304 */       w.append(" b");
/*     */       
/* 306 */       boolean whereWritten = false;
/* 307 */       for (Iterator<?> iter = argRelationship.getFields().iterator(); iter.hasNext(); iter.next()) {
/* 308 */         if (whereWritten) {
/* 309 */           w.append(" AND ");
/*     */         } else {
/*     */           
/* 312 */           w.append(" WHERE ");
/* 313 */           whereWritten = true;
/*     */         } 
/*     */       } 
/* 316 */       w.append("\";\n");
/*     */     }
/* 318 */     else if (IDataModelRelationship.RelationshipType.MANY_TO_MANY.toString()
/* 319 */       .equalsIgnoreCase(argRelationship.getType())) {
/*     */ 
/*     */       
/* 322 */       DtxDefinition.DtxDaoField[] fields = argRelationship.getChild().getTopMostParent().getFields();
/*     */       
/* 324 */       for (int ii = 0; ii < fields.length; ii++) {
/* 325 */         w.append("a.");
/* 326 */         w.append(fields[ii].getColumn());
/* 327 */         if (ii < fields.length - 1) {
/* 328 */           w.append(", ");
/*     */         }
/*     */       } 
/* 331 */       w.append(" FROM ");
/* 332 */       w.append(argRelationship.getChild().getTopMostParent().getTable());
/* 333 */       w.append(" a, ");
/* 334 */       w.append(argRelationship.getTable());
/* 335 */       w.append(" b, ");
/* 336 */       w.append(argDtx.getTable());
/* 337 */       w.append(" c ");
/*     */       
/* 339 */       boolean whereWritten = false; int i;
/* 340 */       for (i = 0; i < argRelationship.getFields().size(); i++) {
/* 341 */         DtxRelationship.DtxRelationshipField relField = argRelationship.getField(i);
/*     */         
/* 343 */         if (whereWritten) {
/* 344 */           w.append(" AND ");
/*     */         } else {
/*     */           
/* 347 */           w.append(" WHERE ");
/* 348 */           whereWritten = true;
/*     */         } 
/* 350 */         if (relField.getChild() == null || relField.getChild().length() == 0) {
/* 351 */           w.append("c.");
/* 352 */           w.append(argDtx.getColumnForFieldName(relField.getParent()));
/* 353 */           w.append(" = ");
/*     */         } else {
/*     */           
/* 356 */           w.append("a.");
/* 357 */           w.append(argRelationship.getChild().getTopMostParent().getColumnForFieldName(relField.getChild()));
/* 358 */           w.append(" = ");
/*     */         } 
/*     */         
/* 361 */         if (relField.getValue() == null || relField.getValue().length() == 0) {
/* 362 */           w.append("b.");
/* 363 */           w.append(relField.getXrefField());
/*     */         } else {
/*     */           
/* 366 */           w.append("'");
/* 367 */           w.append(relField.getValue());
/* 368 */           w.append("'");
/*     */         } 
/*     */       } 
/*     */       
/* 372 */       for (i = 0; i < argRelationship.getFields().size(); i++) {
/* 373 */         DtxRelationship.DtxRelationshipField relField = argRelationship.getField(i);
/*     */         
/* 375 */         if (relField.getParent() != null && relField.getParent().length() > 0) {
/* 376 */           if (whereWritten) {
/* 377 */             w.append(" AND ");
/*     */           } else {
/*     */             
/* 380 */             w.append(" WHERE ");
/* 381 */             whereWritten = true;
/*     */           } 
/*     */           
/* 384 */           w.append("c.");
/* 385 */           w.append(argDtx.getColumnForFieldName(relField.getParent()));
/* 386 */           w.append(" = ?");
/*     */         } 
/*     */       } 
/*     */       
/* 390 */       w.append("\";\n");
/*     */     } else {
/*     */       
/* 393 */       logger_.error(argDtx.getSourceDtxFile().getName() + " ERROR: UNKNOWN RELATIONSHIP TYPE " + argRelationship
/* 394 */           .getType());
/*     */     } 
/*     */     
/* 397 */     w.append("\n  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateRelationships.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */