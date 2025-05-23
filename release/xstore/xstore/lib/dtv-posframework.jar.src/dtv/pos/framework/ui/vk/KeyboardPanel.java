/*    */ package dtv.pos.framework.ui.vk;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.swing.JPanel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class KeyboardPanel
/*    */   extends JPanel
/*    */   implements IKeyboardPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int x_;
/*    */   private int y_;
/*    */   private int width_;
/*    */   private int height_;
/*    */   List<IKeyboardButtonPanel> keyboardButtonPanels_;
/*    */   
/*    */   public KeyboardPanel() {
/* 37 */     setLayout(null);
/* 38 */     setOpaque(false);
/*    */     
/* 40 */     this.keyboardButtonPanels_ = new ArrayList<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean addPanels(IKeyboardButtonPanel panel) {
/* 49 */     return this.keyboardButtonPanels_.add(panel);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IKeyboardButtonPanel> getButtonPanels() {
/* 55 */     return this.keyboardButtonPanels_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSlidingHeight() {
/* 61 */     return this.height_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSlidingWidth() {
/* 67 */     return this.width_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSlidingX() {
/* 73 */     return this.x_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSlidingY() {
/* 79 */     return this.y_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSlidingRectangle(int argX, int argY, int argWidth, int argHeight) {
/* 85 */     this.x_ = argX;
/* 86 */     this.y_ = argY;
/* 87 */     this.width_ = argWidth;
/* 88 */     this.height_ = argHeight;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\vk\KeyboardPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */