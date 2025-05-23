/*    */ package dtv.pos.framework.touch.rules;
/*    */ 
/*    */ import dtv.ui.touch.animation.IHasHiddenButton;
/*    */ import java.awt.Component;
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
/*    */ 
/*    */ 
/*    */ public class HiddenButtonNotShowingResponsivenessRule
/*    */   extends AbstractTouchResponsivenessRule
/*    */ {
/*    */   protected boolean isResponsiveImpl(MouseEvent argE) {
/* 24 */     Component c = (Component)argE.getSource();
/* 25 */     while (c != null && !(c instanceof IHasHiddenButton)) {
/* 26 */       c = c.getParent();
/*    */     }
/*    */     
/* 29 */     if (c != null) {
/* 30 */       return !((IHasHiddenButton)c).getHiddenButton().isInside();
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\touch\rules\HiddenButtonNotShowingResponsivenessRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */