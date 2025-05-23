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
/*    */ public class GenerateJDBCMappingOverride
/*    */   extends GenerateJDBCMapping
/*    */ {
/*    */   protected String getFileName() {
/* 21 */     return "JDBCAdapterMap" + this.helper_.getOverrideType() + "Impl.java";
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
/*    */   protected void writeClassDeclaration(Writer argWriter) throws IOException {
/* 35 */     argWriter.append("public class JDBCAdapterMap" + this.helper_.getOverrideType());
/* 36 */     argWriter.append("Impl extends dtv.data2.access.impl.jdbc.JDBCAdapterMap");
/* 37 */     argWriter.append(!this.helper_.doesExtendsEqualType() ? this.helper_.getOverrideExtends() : "");
/* 38 */     argWriter.append("Impl {\n");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void writeImportDeclaration(Writer argW) throws IOException {
/* 45 */     argW.append("import dtv.data2.access.AbstractInstanceGenerator;\n\n");
/*    */   }
/*    */   
/*    */   protected void writeVariableDeclaration(Writer argW) throws IOException {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateJDBCMappingOverride.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */