/*    */ package dtv.pos.framework.touch;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.ui.config.ITouchConfig;
/*    */ import dtv.pos.ui.component.PosTransactionListCell;
/*    */ import dtv.ui.touch.TouchHelper;
/*    */ import dtv.util.temp.InjectionHammer;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.util.Collection;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
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
/*    */ public class TouchTransactionListCell
/*    */   extends PosTransactionListCell
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */   
/*    */   public TouchTransactionListCell() {
/* 35 */     InjectionHammer.forceAtInjectProcessing(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isColumnTouchResponsive(ITouchConfig config, MouseEvent event) {
/* 40 */     return (actionAllowedForCurrentPrompt(TouchConfig.getTouchAction(config)) && 
/* 41 */       TouchHelper.isTouchResponsive(TouchConfig.getRules(config), event));
/*    */   }
/*    */ 
/*    */   
/*    */   public void processTouchConfig(ITouchConfig config, MouseEvent event) {
/* 46 */     if (config != null) {
/* 47 */       IXstAction action = TouchConfig.getTouchAction(config);
/* 48 */       if (TouchHelper.isTouchResponsive(TouchConfig.getRules(config), event) && action != null) {
/* 49 */         action.actionPerformed(TouchHelper.createActionEvent(event));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean actionAllowedForCurrentPrompt(IXstAction argAction) {
/* 56 */     Collection<IXstAction> actions = ((IModeController)this._modeProvider.get()).getStationModel().getPromptActionModel().getActions();
/*    */     
/* 58 */     for (IXstAction action : actions) {
/* 59 */       if (action.getActionKey().equals(argAction.getActionKey())) {
/* 60 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\TouchTransactionListCell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */