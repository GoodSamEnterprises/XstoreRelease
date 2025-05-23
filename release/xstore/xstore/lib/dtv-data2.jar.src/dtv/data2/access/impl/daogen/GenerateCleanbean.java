/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class GenerateCleanbean
/*     */   implements Callable<Void>
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(GenerateCleanbean.class);
/*     */ 
/*     */   
/*  31 */   private static final Set<String> _abstractCleanBeanAttrs = new HashSet<String>()
/*     */     {
/*     */     
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static final Set<String> _attrTypesToIgnore = new HashSet<String>()
/*     */     {
/*     */     
/*     */     };
/*     */   
/*     */   private final DaoGenHelper helper_;
/*     */   
/*     */   private final List<DtxDefinition> dtxDefinitions_;
/*  49 */   Map<DtxDefinition, Set<DtxInverseRelationship>> comprehensiveInverseRelationships_ = new HashMap<>();
/*     */ 
/*     */   
/*     */   GenerateCleanbean(DaoGenHelper argHelper) {
/*  53 */     this.helper_ = argHelper;
/*  54 */     this.dtxDefinitions_ = this.helper_.getDtxDefinitions();
/*     */ 
/*     */     
/*  57 */     Map<String, DtxDefinition> dtxDefsByCleanbeanClassname = new HashMap<>();
/*  58 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/*  59 */       dtxDefsByCleanbeanClassname.put(dtx.getCleanbeanClassname(), dtx);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/*  68 */       for (DtxRelationship r : dtx.getRelationships("One-Many")) {
/*  69 */         DtxDefinition childDtx = dtxDefsByCleanbeanClassname.get(r.getChild().getCleanbeanClassname());
/*     */ 
/*     */         
/*  72 */         DtxInverseRelationship invRel = null;
/*  73 */         for (DtxInverseRelationship explicitlyDeclaredInvRel : childDtx.getInverseRelationships()) {
/*  74 */           if (explicitlyDeclaredInvRel.getParent() == dtx) {
/*  75 */             invRel = explicitlyDeclaredInvRel;
/*     */             break;
/*     */           } 
/*     */         } 
/*  79 */         if (invRel == null) {
/*  80 */           invRel = new DtxInverseRelationship();
/*  81 */           invRel.setParentType(dtx.getName());
/*  82 */           invRel.setParent(dtx);
/*  83 */           invRel.setName("parent" + dtx.getName());
/*     */         } 
/*     */         
/*  86 */         Set<DtxInverseRelationship> invRelSet = this.comprehensiveInverseRelationships_.get(childDtx);
/*  87 */         if (invRelSet == null) {
/*  88 */           invRelSet = new HashSet<>();
/*  89 */           this.comprehensiveInverseRelationships_.put(childDtx, invRelSet);
/*     */         } 
/*  91 */         invRelSet.add(invRel);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/* 102 */     logger_.info("Generating cleanbean mappings");
/*     */ 
/*     */     
/* 105 */     Set<String> doNotProcess = new HashSet<String>()
/*     */       {
/*     */       
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 112 */     for (DtxDefinition dtx : this.dtxDefinitions_) {
/* 113 */       if (doNotProcess.contains(dtx.getName())) {
/*     */         continue;
/*     */       }
/*     */       
/* 117 */       if (DaoGenOrgHierarchyHelper.isOrgHierarchical(dtx)) {
/* 118 */         DaoGenOrgHierarchyHelper.addOrgHierarchyTable(dtx.getTable());
/*     */       }
/*     */ 
/*     */       
/* 122 */       File f = new File(this.helper_.getCleanbeanOutPath() + this.helper_.getFilePathCleanbean(dtx) + dtx.getName() + ".java");
/*     */       
/* 124 */       StringBuilder out = new StringBuilder(20480);
/* 125 */       if (dtx.needsGeneration(f)) {
/* 126 */         getCleanbeanHeader(out, dtx);
/* 127 */         getCleanbeanIDMembers(out, dtx);
/* 128 */         getCleanbeanMembers(out, dtx);
/* 129 */         getCleanbeanConstructor(out, dtx);
/* 130 */         getCleanbeanIDMethods(out, dtx);
/* 131 */         getCleanbeanMethods(out, dtx);
/* 132 */         getCleanbeanFooter(out, dtx);
/*     */         
/* 134 */         this.helper_.getWriter().write(f, out.toString());
/*     */       } 
/*     */     } 
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   private void getCleanbeanConstructor(StringBuilder out, DtxDefinition argDtx) {
/* 141 */     out.append("  public ");
/* 142 */     out.append(argDtx.getName());
/* 143 */     out.append("() {}\n\n");
/*     */   }
/*     */   
/*     */   private void getCleanbeanFooter(StringBuilder out, DtxDefinition argDtx) {
/* 147 */     out.append("} ");
/*     */   }
/*     */   
/*     */   private String getCleanbeanHeader(StringBuilder out, DtxDefinition argDtx) {
/* 151 */     out.append("package ");
/* 152 */     out.append(argDtx.getCleanbeanPackageRaw());
/* 153 */     out.append(";\n\n");
/*     */     
/* 155 */     out.append(this.helper_
/* 156 */         .getClassComment("Auto-generated dtx \"Clean Bean\"\n *\n * DO NOT MANUALLY MODIFY THIS FILE."));
/*     */     
/* 158 */     out.append("public class " + argDtx.getName());
/*     */     
/* 160 */     if (argDtx.isExtended()) {
/* 161 */       out.append(" extends ");
/* 162 */       out.append(argDtx.getExtends().getCleanbeanClassname());
/*     */     } else {
/*     */       
/* 165 */       out.append(" extends com.micros_retail.gwt.shared.entity.AbstractCleanBean");
/*     */     } 
/*     */     
/* 168 */     out.append(" {\n\n");
/* 169 */     out.append("  // Fix serialization compatability based on the name of the DAO\n");
/* 170 */     out.append("  private static final long serialVersionUID = " + argDtx.getName().hashCode() + "L;\n");
/*     */     
/* 172 */     out.append("\n");
/* 173 */     return out.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void getCleanbeanIDMembers(StringBuilder out, DtxDefinition argDtx) {
/* 178 */     DtxDefinition.DtxDaoField[] fields = argDtx.getPrimaryKeyFieldsRaw();
/*     */     
/* 180 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 181 */       String fieldType = DaoGenUtils.getRawDataType(field.getType());
/* 182 */       out.append("  private " + fieldType + " " + DaoGenUtils.getFieldNameForField(field));
/*     */       
/* 184 */       if ("Boolean".equals(field.getType()))
/*     */       {
/*     */         
/* 187 */         out.append(" = Boolean.FALSE");
/*     */       }
/* 189 */       out.append(";\n");
/*     */     } 
/*     */     
/* 192 */     out.append("\n");
/*     */   }
/*     */   
/*     */   private void getCleanbeanIDMethods(StringBuilder out, DtxDefinition argDtx) {
/* 196 */     for (DtxDefinition.DtxDaoField f : argDtx.getPrimaryKeyFieldsRaw()) {
/*     */       
/* 198 */       DaoGenUtils.appendGetterForField(out, f);
/*     */ 
/*     */       
/* 201 */       DaoGenUtils.appendSetterForField(out, f, false, false);
/*     */     } 
/*     */     
/* 204 */     out.append("\n");
/*     */   }
/*     */   
/*     */   private void getCleanbeanMembers(StringBuilder out, DtxDefinition argDtx) {
/* 208 */     for (DtxRelationship rel : argDtx.getRelationships()) {
/* 209 */       if (DtxRelationship.MANY_MANY.equalsIgnoreCase(rel.getType())) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 214 */       String memberName = DaoGenUtils.getFieldNameForRelationship(rel);
/* 215 */       String memberType = DaoGenUtils.getTypeForRelationship(rel, true);
/* 216 */       out.append("  private " + memberType + " " + memberName);
/* 217 */       if (DtxRelationship.ONE_MANY.equalsIgnoreCase(rel.getType())) {
/* 218 */         String rawElementType = DaoGenUtils.getRawDataType(rel.getChild().getCleanbeanClassname());
/* 219 */         out.append(" = new java.util.ArrayList<" + rawElementType + ">()");
/*     */       } 
/* 221 */       out.append(";\n");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     Set<DtxInverseRelationship> invRels = this.comprehensiveInverseRelationships_.get(argDtx);
/* 228 */     if (invRels != null) {
/* 229 */       for (DtxInverseRelationship invRel : this.comprehensiveInverseRelationships_.get(argDtx)) {
/* 230 */         String memberName = StringUtils.ensureFirstLowerCase(invRel.getName());
/* 231 */         String memberType = invRel.getParent().getCleanbeanClassname();
/* 232 */         out.append("  private " + memberType + " _" + memberName + ";\n");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 237 */     DtxDefinition.DtxDaoField[] fields = argDtx.getFields();
/*     */     
/* 239 */     for (DtxDefinition.DtxDaoField field : fields) {
/* 240 */       if (!shouldIgnoreField(field)) {
/*     */ 
/*     */ 
/*     */         
/* 244 */         String fieldType = DaoGenUtils.getRawDataType(field.getType());
/* 245 */         out.append("  private " + fieldType + " " + DaoGenUtils.getFieldNameForField(field));
/*     */         
/* 247 */         if ("Boolean".equals(field.getType()))
/*     */         {
/*     */           
/* 250 */           out.append(" = Boolean.FALSE");
/*     */         }
/* 252 */         out.append(";\n");
/*     */       } 
/*     */     } 
/* 255 */     out.append("\n");
/*     */   }
/*     */   
/*     */   private void getCleanbeanMethods(StringBuilder out, DtxDefinition argDtx) {
/* 259 */     for (DtxRelationship relationship : argDtx.getRelationships()) {
/*     */       
/* 261 */       if (DtxRelationship.MANY_MANY.equalsIgnoreCase(relationship.getType())) {
/* 262 */         logger_.warn("Skipping many-many relationship '" + relationship.getName() + "' in " + argDtx.getName() + " because this tool does not support many-many relationships (yet).");
/*     */         
/* 264 */         out.append("  // Many-Many relationship unsupported: ");
/* 265 */         out.append(relationship.getName());
/* 266 */         out.append("\n\n");
/*     */         continue;
/*     */       } 
/* 269 */       if (DtxRelationship.MANY_MANY.equalsIgnoreCase(relationship.getType())) {
/* 270 */         DtxDefinition childDtx = relationship.getChild();
/* 271 */         DtxInverseRelationship invRel = null;
/* 272 */         Set<DtxInverseRelationship> set = this.comprehensiveInverseRelationships_.get(childDtx);
/* 273 */         for (DtxInverseRelationship ir : set) {
/* 274 */           if (ir.getParent().getName().equals(argDtx.getName())) {
/* 275 */             invRel = ir;
/*     */             break;
/*     */           } 
/*     */         } 
/* 279 */         if (invRel == null) {
/*     */           
/* 281 */           logger_.warn("Skipping 1-many relationship '" + relationship.getName() + "' in " + argDtx.getName() + " because there is no InverseRelationship defined in the 'many' side.");
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */       } 
/*     */       
/* 288 */       String argName = DaoGenUtils.getArgNameForRelationship(relationship);
/* 289 */       String typeName = DaoGenUtils.getTypeForRelationship(relationship, true);
/* 290 */       String getterName = DaoGenUtils.getGetterNameForRelationship(relationship);
/* 291 */       String setterName = DaoGenUtils.getSetterNameForRelationship(relationship);
/* 292 */       String fieldName = DaoGenUtils.getFieldNameForRelationship(relationship);
/*     */ 
/*     */       
/* 295 */       out.append("  public " + typeName + " " + getterName + "() {\n");
/* 296 */       out.append("    return " + fieldName + ";\n");
/* 297 */       out.append("  }\n\n");
/*     */ 
/*     */       
/* 300 */       out.append("  public void " + setterName + "(" + typeName + " " + argName + ") {\n");
/* 301 */       out.append("    " + fieldName + " = " + argName + ";\n");
/* 302 */       out.append("  }\n\n");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 308 */     Set<DtxInverseRelationship> invRels = this.comprehensiveInverseRelationships_.get(argDtx);
/* 309 */     if (invRels != null) {
/* 310 */       for (DtxInverseRelationship invRel : this.comprehensiveInverseRelationships_.get(argDtx)) {
/* 311 */         DtxDefinition parentDtx = invRel.getParent();
/*     */ 
/*     */         
/* 314 */         DtxRelationship parentRel = getRelationshipIdentifiedByChildClass(parentDtx, argDtx.getName());
/* 315 */         if (parentRel == null) {
/* 316 */           logger_.warn("Skipping inverse relationship in " + argDtx.getName() + "; \"goofy\" inverse relationships (like the one in TaxRateRuleOverride.dtx) are not supported for Cleanbean code generation.");
/*     */ 
/*     */           
/* 319 */           out.append("  // Relationship unsupported: ");
/* 320 */           out.append(invRel.getName());
/* 321 */           out.append("\n\n");
/*     */           
/*     */           continue;
/*     */         } 
/* 325 */         writeInverseRelationshipGetterAndSetter(out, StringUtils.ensureFirstLowerCase(invRel.getName()), invRel
/* 326 */             .getParent().getCleanbeanClassname());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 331 */     for (DtxDefinition.DtxDaoField field : argDtx.getFields()) {
/* 332 */       if (!shouldIgnoreField(field)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 337 */         DaoGenUtils.appendGetterForField(out, field);
/*     */ 
/*     */         
/* 340 */         DaoGenUtils.appendSetterForField(out, field, false, false);
/*     */       } 
/*     */     } 
/* 343 */     out.append("\n");
/*     */   }
/*     */ 
/*     */   
/*     */   private DtxRelationship getRelationshipIdentifiedByChildClass(DtxDefinition argDtx, String argChildClassName) {
/* 348 */     for (DtxRelationship rel : argDtx.getRelationships()) {
/* 349 */       if (argChildClassName.equals(rel.getChildName())) {
/* 350 */         return rel;
/*     */       }
/*     */     } 
/* 353 */     return null;
/*     */   }
/*     */   
/*     */   private boolean shouldIgnoreField(DtxDefinition.DtxDaoField field) {
/* 357 */     if (field.isPrimaryKey()) {
/* 358 */       return true;
/*     */     }
/*     */     
/* 361 */     if (_abstractCleanBeanAttrs.contains(field.getName())) {
/* 362 */       return true;
/*     */     }
/*     */     
/* 365 */     if (_attrTypesToIgnore.contains(field.getType())) {
/* 366 */       return true;
/*     */     }
/*     */     
/* 369 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeInverseRelationshipGetterAndSetter(StringBuilder out, String memberName, String memberType) {
/* 374 */     String properName = StringUtils.ensureFirstUpperCase(memberName);
/* 375 */     String argName = "arg" + properName;
/* 376 */     String rawType = DaoGenUtils.getRawDataType(memberType);
/*     */ 
/*     */     
/* 379 */     out.append("  public " + rawType + " get" + properName + "() {\n");
/* 380 */     out.append("    return _" + memberName + ";\n");
/* 381 */     out.append("  }\n\n");
/*     */ 
/*     */     
/* 384 */     out.append("  public void set" + properName + "(" + rawType + " " + argName + ") {\n");
/* 385 */     out.append("    _" + memberName + " = " + argName + ";\n");
/* 386 */     out.append("  }\n\n");
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateCleanbean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */