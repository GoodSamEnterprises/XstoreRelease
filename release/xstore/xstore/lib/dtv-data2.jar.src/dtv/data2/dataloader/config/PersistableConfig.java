/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PersistableConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private static final Collection<String> _ignoredFields = Arrays.asList(new String[] { "incrementalActive" });
/*    */   
/* 24 */   private final List<FieldConfig> fieldList_ = new ArrayList<>(20);
/*    */   
/*    */   private String actionApplicability_;
/* 27 */   private List<DataModifierConfig> applicabilityConditions_ = null;
/*    */   
/*    */   public String getActionType() {
/* 30 */     return this.actionApplicability_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DataModifierConfig> getApplicabilityConditions() {
/* 37 */     return this.applicabilityConditions_;
/*    */   }
/*    */   
/*    */   public List<FieldConfig> getFields() {
/* 41 */     return this.fieldList_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 47 */     if ("Field".equalsIgnoreCase(argKey)) {
/* 48 */       this.fieldList_.add((FieldConfig)argValue);
/*    */     }
/* 50 */     else if ("action".equalsIgnoreCase(argKey)) {
/* 51 */       this.actionApplicability_ = argValue.toString();
/*    */     }
/* 53 */     else if ("ApplicabilityCondition".equalsIgnoreCase(argKey)) {
/* 54 */       if (this.applicabilityConditions_ == null) {
/* 55 */         this.applicabilityConditions_ = new ArrayList<>(2);
/*    */       }
/* 57 */       this.applicabilityConditions_.add((DataModifierConfig)argValue);
/*    */     }
/* 59 */     else if (!_ignoredFields.contains(argKey)) {
/* 60 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\PersistableConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */