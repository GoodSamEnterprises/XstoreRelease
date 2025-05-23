/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
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
/*    */ public class FormRule<T extends IFormModel>
/*    */   extends AbstractFormComponent<T>
/*    */ {
/*    */   private final PosRule rule_;
/*    */   
/*    */   public FormRule() {
/* 22 */     this.rule_ = new PosRule();
/* 23 */     setComponent(this.rule_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Object getComponentValue() {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   protected void setComponentValue(Object value) {}
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */