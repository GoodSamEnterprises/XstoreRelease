/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.ui.IMenuItem;
/*    */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*    */ import dtv.pos.iframework.ui.model.IMenuModel;
/*    */ import dtv.pos.iframework.ui.model.IStationModel;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.Collection;
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
/*    */ public class ValidateCurrentPromptResponsivenessRule
/*    */   extends AbstractTouchResponsivenessRule
/*    */ {
/*    */   protected IXstAction getAction(MouseEvent argE) {
/* 26 */     IXstAction action = null;
/* 27 */     ITouchConfig config = getParentConfigObject();
/* 28 */     if (config != null) {
/* 29 */       action = config.getAction();
/*    */     }
/*    */     
/* 32 */     if (action == null && argE.getSource() instanceof IXstAction) {
/* 33 */       action = (IXstAction)argE.getSource();
/*    */     }
/*    */     
/* 36 */     return action;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 42 */     IXstAction action = getAction(argE);
/*    */     
/* 44 */     if (action != null) {
/* 45 */       IStationModel stationModel = ((IModeController)this._modeProvider.get()).getStationModel();
/* 46 */       Collection<IXstAction> actions = stationModel.getPromptActionModel().getActions();
/*    */       
/* 48 */       for (IXstAction a : actions) {
/* 49 */         if (a.getActionKey().equals(action.getActionKey())) {
/* 50 */           return true;
/*    */         }
/*    */       } 
/*    */       
/* 54 */       IMenuModel menuModel = stationModel.getMenuModel();
/*    */       
/* 56 */       if (menuModel != null && menuModel.getCurrentMenu() != null) {
/* 57 */         IMenuItem current = menuModel.getCurrentMenu();
/* 58 */         for (IMenuItem child : current.getChildren()) {
/* 59 */           if (child.getAction() != null && child.getAction().getActionKey().equals(action.getActionKey())) {
/* 60 */             return true;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\ValidateCurrentPromptResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */