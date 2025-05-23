/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.common.FormKey;
/*    */ import dtv.pos.framework.action.access.AbstractVisibilityRule;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.ui.model.IFormModel;
/*    */ import dtv.pos.iframework.ui.model.IStationModel;
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
/*    */ public class FormInEditModeVisibilityRule
/*    */   extends AbstractVisibilityRule
/*    */ {
/*    */   protected IAccessLevel checkVisibilityImpl() throws Exception {
/* 29 */     IStationModel stationModel = ((IModeController)this._modeProvider.get()).getStationModel();
/* 30 */     FormKey currentPrimaryFormKey = stationModel.getPrimaryFormModelKey();
/* 31 */     IFormModel formModel = stationModel.getFormModel(currentPrimaryFormKey);
/*    */     
/* 33 */     if (formModel.isEditable()) {
/* 34 */       return (IAccessLevel)AccessLevel.GRANTED;
/*    */     }
/*    */     
/* 37 */     return (IAccessLevel)AccessLevel.DENIED;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\FormInEditModeVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */