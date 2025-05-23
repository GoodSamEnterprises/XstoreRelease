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
/*    */ public class GenerateDataModelFactoryOverride
/*    */   extends GenerateDataModelFactoryImpl
/*    */ {
/*    */   protected String getFileName() {
/* 21 */     return "DataModelFactory" + this.helper_.getOverrideType() + "Impl.java";
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
/*    */   protected void writeClassName(Writer buf) throws IOException {
/* 35 */     buf.append("public class DataModelFactory" + this.helper_.getOverrideType());
/* 36 */     buf.append("Impl extends dtv.data2.access.impl.DataModelFactory");
/* 37 */     buf.append(!this.helper_.doesExtendsEqualType() ? this.helper_.getOverrideExtends() : "");
/* 38 */     buf.append("Impl {\n");
/*    */   }
/*    */   
/*    */   protected void writeVariableDeclaration(Writer argW) throws IOException {}
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\GenerateDataModelFactoryOverride.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */