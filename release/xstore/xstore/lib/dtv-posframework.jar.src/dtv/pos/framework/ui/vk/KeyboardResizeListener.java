/*    */ package dtv.pos.framework.ui.vk;
/*    */ 
/*    */ import java.awt.Window;
/*    */ import java.awt.event.ComponentEvent;
/*    */ import java.awt.event.ComponentListener;
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
/*    */ public class KeyboardResizeListener
/*    */   implements ComponentListener
/*    */ {
/*    */   public void componentHidden(ComponentEvent argE) {
/* 23 */     OnScreenKeyboard.getInstance().repaintImpl();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void componentMoved(ComponentEvent argE) {
/* 29 */     IOnScreenKeyboard keyboard = OnScreenKeyboard.getInstance();
/* 30 */     keyboard.ownerBoundsChangedImpl(((Window)argE.getSource()).getBounds());
/* 31 */     keyboard.repaintImpl();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void componentResized(ComponentEvent argE) {
/* 37 */     IOnScreenKeyboard keyboard = OnScreenKeyboard.getInstance();
/* 38 */     keyboard.ownerBoundsChangedImpl(((Window)argE.getSource()).getBounds());
/* 39 */     keyboard.repaintImpl();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void componentShown(ComponentEvent argE) {
/* 45 */     OnScreenKeyboard.getInstance().repaintImpl();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardResizeListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */