/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*    */ import dtv.util.StringUtils;
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
/*    */ public class FormNavigationVisibilityRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   public static final String FORM_NAME_PARAMETER_KEY = "formName";
/*    */   private IFormModel formModel_;
/*    */   private String formName_;
/*    */   
/*    */   public void setFormModel(IFormModel formModel) {
/* 34 */     this.formModel_ = formModel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParameter(String argName, String argValue) {
/* 45 */     if ("formName".equalsIgnoreCase(argName)) {
/* 46 */       this.formName_ = StringUtils.nonNull(argValue);
/*    */     } else {
/*    */       
/* 49 */       super.setParameter(argName, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IAccessLevel checkVisibilityImpl() {
/* 60 */     if (this.formModel_ == null || StringUtils.isEmpty(this.formName_)) {
/* 61 */       return (IAccessLevel)AccessLevel.GRANTED;
/*    */     }
/* 63 */     return (this.formModel_.getSelectionModel() != null && this.formName_.equals(this.formModel_.getSelectedTabKeyName())) ? (IAccessLevel)AccessLevel.DENIED : (IAccessLevel)AccessLevel.GRANTED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\FormNavigationVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */