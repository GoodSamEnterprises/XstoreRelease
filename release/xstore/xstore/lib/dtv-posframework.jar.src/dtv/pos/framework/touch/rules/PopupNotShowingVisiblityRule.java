/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.framework.action.access.AbstractVisibilityRule;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*    */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
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
/*    */ public class PopupNotShowingVisiblityRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   protected IAccessLevel checkVisibilityImpl() throws Exception {
/* 26 */     if (!((IModeController)this._modeProvider.get()).getUiController().isPopupShowing()) {
/* 27 */       return (IAccessLevel)AccessLevel.GRANTED;
/*    */     }
/*    */     
/* 30 */     return (IAccessLevel)AccessLevel.DENIED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\PopupNotShowingVisiblityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */