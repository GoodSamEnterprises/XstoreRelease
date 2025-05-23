/*    */ package dtv.data2.access.impl.daogen;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
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
/*    */ public class GenerateOrgHierarchyTableListOverride
/*    */   extends GenerateOrgHierarchyTableList
/*    */ {
/*    */   protected String getFileName() {
/* 21 */     return "OrgHierarchyTableList" + this.helper_.getOverrideType() + ".java";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void writeAdditionalMethods(Writer argW) throws IOException {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void writeClassDeclaration(Writer argW) throws IOException {
/* 35 */     argW.append(this.helper_
/* 36 */         .getClassCommentWithSuppressWarnings("An auto-generated list of tables whose rows are qualified by a node in the organizational hierarchy."));
/* 37 */     argW.append("public class OrgHierarchyTableList" + this.helper_.getOverrideType());
/* 38 */     argW.append(" extends dtv.xst.dao.OrgHierarchyTableList");
/* 39 */     argW.append(!this.helper_.doesExtendsEqualType() ? this.helper_.getOverrideExtends() : "");
/* 40 */     argW.append(" {\n");
/*    */   }
/*    */   
/*    */   protected void writeImportDeclaration(Writer argW) throws IOException {}
/*    */   
/*    */   protected void writeVariableDeclaration(Writer argW) throws IOException {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateOrgHierarchyTableListOverride.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */