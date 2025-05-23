/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import java.awt.event.MouseEvent;
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
/*    */ public class PopupNotShowingResponsivenessRule
/*    */   extends AbstractTouchResponsivenessRule
/*    */ {
/*    */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 21 */     return !((IModeController)this._modeProvider.get()).getUiController().isPopupShowing();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\PopupNotShowingResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */