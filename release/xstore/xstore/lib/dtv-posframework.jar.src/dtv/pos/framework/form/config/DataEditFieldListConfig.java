/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.IDataEditFieldConfig;
/*    */ import dtv.pos.iframework.form.config.IDataEditFieldListConfig;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
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
/*    */ public class DataEditFieldListConfig
/*    */   extends AbstractParentConfig
/*    */   implements IDataEditFieldListConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private List<IDataEditFieldConfig> fieldList_ = new ArrayList<>();
/*    */   
/*    */   private IDataEditFieldConfig[] fieldArray_;
/*    */   
/*    */   private Map<String, IDataEditFieldConfig> fieldMap_;
/*    */   
/*    */   public IDataEditFieldConfig getFieldConfig(String argFieldKey) {
/* 31 */     if (this.fieldMap_ == null) {
/* 32 */       this.fieldMap_ = new HashMap<>();
/* 33 */       IDataEditFieldConfig[] a = getFieldConfigs();
/* 34 */       for (IDataEditFieldConfig element : a) {
/* 35 */         this.fieldMap_.put(element.getFieldKey(), element);
/*    */       }
/*    */     } 
/* 38 */     return this.fieldMap_.get(argFieldKey);
/*    */   }
/*    */ 
/*    */   
/*    */   public IDataEditFieldConfig[] getFieldConfigs() {
/* 43 */     if (this.fieldArray_ == null) {
/* 44 */       this.fieldArray_ = this.fieldList_.<IDataEditFieldConfig>toArray((IDataEditFieldConfig[])new DataEditFieldConfig[0]);
/* 45 */       this.fieldList_ = null;
/*    */     } 
/* 47 */     return this.fieldArray_;
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
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 59 */     if (argValue instanceof IDataEditFieldConfig) {
/* 60 */       this.fieldList_.add((IDataEditFieldConfig)argValue);
/*    */     } else {
/*    */       
/* 63 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\DataEditFieldListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */