/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.pos.iframework.form.config.IDaoEditMappingConfig;
/*    */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*    */ import javax.inject.Inject;
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
/*    */ public abstract class BasicAddressDaoEditModel
/*    */   extends DaoEditModel
/*    */   implements IHasAddressFields
/*    */ {
/*    */   @Inject
/*    */   private IAddressFieldServiceFactory _addressFieldFactory;
/*    */   
/*    */   public BasicAddressDaoEditModel(IDataModel[] argDaos, IDaoEditMappingConfig argConfig, Boolean argIsNew) {
/* 34 */     super(argDaos, argConfig, argIsNew);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasicAddressDaoEditModel(IDataModel[] argDaos, IDaoEditMappingConfig argConfig, Boolean argIsNew, IDataObjectDefinitionConfig argSelfFieldConfig) {
/* 46 */     super(argDaos, argConfig, argIsNew, argSelfFieldConfig);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAddressField(String argValue) {
/* 52 */     if ("city".equals(argValue)) {
/* 53 */       return "city";
/*    */     }
/* 55 */     if ("state".equals(argValue)) {
/* 56 */       return "state";
/*    */     }
/* 58 */     if ("postalCode".equals(argValue)) {
/* 59 */       return "postalCode";
/*    */     }
/* 61 */     if ("country".equals(argValue)) {
/* 62 */       return "country";
/*    */     }
/* 64 */     if ("neighborhood".equals(argValue)) {
/* 65 */       return "neighborhood";
/*    */     }
/* 67 */     if ("county".equals(argValue)) {
/* 68 */       return "county";
/*    */     }
/*    */     
/* 71 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAddressMode() {
/* 78 */     return "DEFAULT";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void initializeFieldValues() {
/* 84 */     super.initializeFieldValues();
/* 85 */     this._addressFieldFactory.createAddressFieldService(getAddressMode()).registerModel(this, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isDynamicFieldCapable() {
/* 91 */     return true;
/*    */   }
/*    */   
/*    */   protected IAddressFieldServiceFactory getAddressFieldServiceFactory() {
/* 95 */     return this._addressFieldFactory;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\BasicAddressDaoEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */