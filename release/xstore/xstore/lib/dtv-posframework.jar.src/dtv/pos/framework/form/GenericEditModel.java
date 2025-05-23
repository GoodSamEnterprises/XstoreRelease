/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.framework.form.config.DataObjectDefinitionConfig;
/*    */ import dtv.pos.framework.form.config.GenericEditModelConfigHelper;
/*    */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
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
/*    */ public class GenericEditModel
/*    */   extends BasicEditModel
/*    */ {
/*    */   public GenericEditModel() {
/* 22 */     super(null, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigFile(String argConfigFile) {
/* 33 */     GenericEditModelConfigHelper configHelper = new GenericEditModelConfigHelper(argConfigFile);
/* 34 */     configHelper.initialize();
/* 35 */     DataObjectDefinitionConfig config = configHelper.getDefinitionConfig();
/* 36 */     IDataEditFieldConfig[] keyFields = config.getKeyFields().getFieldConfigs();
/* 37 */     IDataEditFieldConfig[] otherFields = config.getOtherFields().getFieldConfigs();
/*    */     
/* 39 */     for (IDataEditFieldConfig keyField : keyFields) {
/* 40 */       addField(new GenericEditModelFieldDefinition(this, keyField));
/*    */     }
/* 42 */     for (IDataEditFieldConfig otherField : otherFields) {
/* 43 */       addField(new GenericEditModelFieldDefinition(this, otherField));
/*    */     }
/* 45 */     initializeFieldState();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\GenericEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */