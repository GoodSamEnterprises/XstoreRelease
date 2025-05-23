/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ class DaoGenOrgHierarchyHelper
/*     */ {
/*     */   public static final String FIELD_ORG_CODE = "orgCode";
/*     */   public static final String FIELD_ORG_VALUE = "orgValue";
/*  24 */   private static final List<String> _orgHierarchyTables = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void addOrgHierarchyTable(String argTableName) {
/*  33 */     _orgHierarchyTables.add(argTableName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Collection<String> getOrgHierarchyTables() {
/*  44 */     return _orgHierarchyTables;
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
/*     */   static boolean isOrgHierarchical(DtxDefinition argDtxDef) {
/*  56 */     boolean hasOrgCode = false;
/*  57 */     boolean hasOrgValue = false;
/*     */     
/*  59 */     for (DtxDefinition.DtxDaoField field : argDtxDef.getFieldsPlusInheritedPrimaryKeys()) {
/*  60 */       if ("orgCode".equalsIgnoreCase(field.getName())) {
/*  61 */         hasOrgCode = true;
/*     */       }
/*  63 */       else if ("orgValue".equalsIgnoreCase(field.getName())) {
/*  64 */         hasOrgValue = true;
/*     */       } 
/*     */       
/*  67 */       if (hasOrgCode && hasOrgValue) {
/*     */         break;
/*     */       }
/*     */     } 
/*  71 */     return (hasOrgCode && hasOrgValue);
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
/*     */   
/*     */   static boolean isOrgHierarchyField(DtxDefinition.DtxDaoField argDtxField) {
/*  88 */     return ("orgCode".equalsIgnoreCase(argDtxField.getName()) || "orgValue"
/*  89 */       .equalsIgnoreCase(argDtxField.getName()));
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
/*     */   static boolean isOrgHierarchyRelationshipJoin(DtxRelationship.DtxRelationshipField argDtxRelField) {
/* 101 */     boolean isOrgHierarchyJoin = false;
/*     */     
/* 103 */     if ("orgCode".equalsIgnoreCase(argDtxRelField.getParent())) {
/* 104 */       isOrgHierarchyJoin = "orgCode".equalsIgnoreCase(argDtxRelField.getChild());
/*     */     }
/* 106 */     else if ("orgValue".equalsIgnoreCase(argDtxRelField.getParent())) {
/* 107 */       isOrgHierarchyJoin = "orgValue".equalsIgnoreCase(argDtxRelField.getChild());
/*     */     } 
/* 109 */     return isOrgHierarchyJoin;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void writeOrgHierarchyCUDParam(DtxDefinition argDtx, DtxDefinition.DtxDaoField argDtxField, StringBuilder out) {
/* 129 */     String fieldName = argDtxField.getName();
/*     */     
/* 131 */     if ("orgCode".equalsIgnoreCase(fieldName)) {
/* 132 */       String codeField = DaoGenUtils.getFieldNameForField(argDtxField);
/* 133 */       out.append("dtv.util.ObjectUtils.coalesce(" + codeField + ", \"*\")");
/*     */     }
/* 135 */     else if ("orgValue".equalsIgnoreCase(fieldName)) {
/* 136 */       String valueField = DaoGenUtils.getFieldNameForField(argDtxField);
/* 137 */       out.append("dtv.util.ObjectUtils.coalesce(" + valueField + ", \"*\")");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenOrgHierarchyHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */