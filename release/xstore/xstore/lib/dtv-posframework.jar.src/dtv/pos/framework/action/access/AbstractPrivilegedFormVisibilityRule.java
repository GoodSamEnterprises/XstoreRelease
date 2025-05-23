/*    */ package dtv.pos.framework.action.access;
/*    */ 
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.visibilityrules.IFormVisibilityRule;
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
/*    */ public abstract class AbstractPrivilegedFormVisibilityRule
/*    */   extends AbstractPrivilegedVisibilityRule
/*    */   implements IFormVisibilityRule
/*    */ {
/* 19 */   private IEditModel _editModel = null;
/*    */ 
/*    */   
/*    */   public void setEditModel(IEditModel argEditModel) {
/* 23 */     this._editModel = argEditModel;
/*    */   }
/*    */   
/*    */   protected final IEditModel getCurrentEditModel() {
/* 27 */     return this._editModel;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\AbstractPrivilegedFormVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */