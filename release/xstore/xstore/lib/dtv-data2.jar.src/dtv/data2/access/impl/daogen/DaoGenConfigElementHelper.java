/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DaoGenConfigElementHelper
/*    */ {
/*    */   private static final String CONFIG_ELEMENT_FIELD = "configElement";
/*    */   
/*    */   static void ensureNonNullConfigElement(DtxDefinition.DtxDaoField argDtxField, StringBuilder out) {
/* 38 */     if ("configElement".equalsIgnoreCase(argDtxField.getName())) {
/* 39 */       String codeField = DaoGenUtils.getFieldNameForField(argDtxField);
/* 40 */       out.append("dtv.util.ObjectUtils.coalesce(" + codeField + ", \"*\")");
/*    */     } 
/*    */   }
/*    */   
/*    */   static final boolean isConfigElementField(DtxDefinition.DtxDaoField argField) {
/* 45 */     return "configElement".equalsIgnoreCase(argField.getName());
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DaoGenConfigElementHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */