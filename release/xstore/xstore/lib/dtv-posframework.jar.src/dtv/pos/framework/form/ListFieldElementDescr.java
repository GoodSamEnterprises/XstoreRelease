/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.Eventor;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.event.eventor.DefaultEventor;
/*    */ import dtv.pos.iframework.form.IDataModelFactory;
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.IEditModelFieldMetadata;
/*    */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*    */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*    */ import dtv.pos.iframework.form.config.IDataObjectDefinitionConfig;
/*    */ import dtv.util.ReflectionException;
/*    */ import dtv.xst.daocommon.ISystemUser;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ListFieldElementDescr
/*    */   implements IListFieldElementDescr, IEventSource
/*    */ {
/*    */   private final IEditModelFieldMetadata[] fieldMetadata_;
/* 31 */   private final Map<String, IEditModelFieldMetadata> fieldsByName_ = new HashMap<>();
/*    */   
/*    */   private final IDataModelFactory instanceFactory_;
/*    */   
/* 35 */   protected Eventor events_ = (Eventor)new DefaultEventor(this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ListFieldElementDescr(IDataObjectDefinitionConfig argConfig) {
/* 42 */     List<IEditModelFieldMetadata> defs = new ArrayList<>();
/* 43 */     IDataEditFieldConfig[] fieldConfigs = argConfig.getKeyFields().getFieldConfigs();
/* 44 */     for (IDataEditFieldConfig fieldConfig : fieldConfigs) {
/* 45 */       IEditModelFieldMetadata d = new EditModelFieldMetadata(fieldConfig, 4);
/* 46 */       defs.add(d);
/* 47 */       this.fieldsByName_.put(d.getFieldKey(), d);
/*    */     } 
/* 49 */     fieldConfigs = argConfig.getOtherFields().getFieldConfigs();
/* 50 */     for (IDataEditFieldConfig fieldConfig : fieldConfigs) {
/* 51 */       IEditModelFieldMetadata d = new EditModelFieldMetadata(fieldConfig, 0);
/* 52 */       defs.add(d);
/* 53 */       this.fieldsByName_.put(d.getFieldKey(), d);
/*    */     } 
/* 55 */     this.fieldMetadata_ = defs.<IEditModelFieldMetadata>toArray(new IEditModelFieldMetadata[defs.size()]);
/*    */     try {
/* 57 */       this.instanceFactory_ = argConfig.getFactoryClass().newInstance();
/*    */     }
/* 59 */     catch (IllegalAccessException ex) {
/* 60 */       throw new ReflectionException(ex);
/*    */     }
/* 62 */     catch (InstantiationException ex) {
/* 63 */       throw new ReflectionException(ex);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addInstance(IEditModel editModel, List<IDataModel> values) {
/* 70 */     values.add(this.instanceFactory_.makeInstance(editModel));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IEditModelFieldMetadata[] getFieldMetadata() {
/* 77 */     return this.fieldMetadata_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUser(ISystemUser argUser) {
/* 83 */     for (IEditModelFieldMetadata element : this.fieldMetadata_)
/* 84 */       element.setUser(argUser); 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\ListFieldElementDescr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */