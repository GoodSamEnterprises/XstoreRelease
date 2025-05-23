/*    */ package dtv.pos.framework.form;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModelFieldValidationInfo;
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
/*    */ public class EditModelFieldValidationInfo
/*    */   implements IEditModelFieldValidationInfo
/*    */ {
/*    */   private boolean valid_ = true;
/*    */   
/*    */   public boolean isValid() {
/* 22 */     return this.valid_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValid(boolean argValid) {
/* 31 */     this.valid_ = argValid;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelFieldValidationInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */