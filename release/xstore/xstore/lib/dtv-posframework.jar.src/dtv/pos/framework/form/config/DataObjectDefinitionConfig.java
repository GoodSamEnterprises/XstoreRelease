/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.framework.form.ListFieldElementDescr;
/*    */ import dtv.pos.iframework.form.IDataModelFactory;
/*    */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*    */ import dtv.pos.iframework.form.config.IDataEditFieldListConfig;
/*    */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.ClassConfig;
/*    */ import dtv.util.config.ConfigUtils;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class DataObjectDefinitionConfig
/*    */   extends AbstractParentConfig
/*    */   implements IDataObjectDefinitionConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String mappingId_;
/*    */   private ClassConfig<IDataModelFactory> factoryClassConfig_;
/*    */   private IDataEditFieldListConfig keyFields_;
/*    */   private IDataEditFieldListConfig otherFields_;
/*    */   
/*    */   public Class<IDataModelFactory> getFactoryClass() {
/* 34 */     return (this.factoryClassConfig_ == null) ? null : this.factoryClassConfig_.getValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public IDataEditFieldListConfig getKeyFields() {
/* 39 */     if (this.keyFields_ == null) {
/* 40 */       this.keyFields_ = new DataEditFieldListConfig();
/*    */     }
/* 42 */     return this.keyFields_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMappingId() {
/* 47 */     return this.mappingId_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IDataEditFieldListConfig getOtherFields() {
/* 52 */     return this.otherFields_;
/*    */   }
/*    */ 
/*    */   
/*    */   public IListFieldElementDescr makeFieldElementDescriptor() {
/* 57 */     return (IListFieldElementDescr)new ListFieldElementDescr(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 64 */     if ("mapping_id".equalsIgnoreCase(argKey) || "name".equalsIgnoreCase(argKey)) {
/* 65 */       this.mappingId_ = argValue.toString();
/*    */     }
/* 67 */     else if ("factory_class".equalsIgnoreCase(argKey) || "factoryClass".equalsIgnoreCase(argKey)) {
/* 68 */       this.factoryClassConfig_ = ConfigUtils.toClassConfig(argValue);
/*    */     }
/* 70 */     else if (argValue instanceof IDataEditFieldListConfig && ("keyFields"
/* 71 */       .equalsIgnoreCase(argKey) || "key_fields".equalsIgnoreCase(argKey))) {
/*    */       
/* 73 */       this.keyFields_ = (IDataEditFieldListConfig)argValue;
/*    */     }
/* 75 */     else if (argValue instanceof IDataEditFieldListConfig && ("dataEditFieldList"
/* 76 */       .equalsIgnoreCase(argKey) || "fields".equalsIgnoreCase(argKey))) {
/*    */       
/* 78 */       this.otherFields_ = (IDataEditFieldListConfig)argValue;
/*    */     } else {
/*    */       
/* 81 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DataObjectDefinitionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */