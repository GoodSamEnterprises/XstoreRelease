/*    */ package dtv.pos.framework.form.component;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PosRule
/*    */   extends JComponent
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public PosRule() {
/* 20 */     setOpaque(false);
/* 21 */     setFocusable(false);
/*    */   }
/*    */   
/*    */   protected void paintComponent(Graphics g) {
/*    */     int circleSize, height, width, x, y, arc;
/* 26 */     if (g instanceof Graphics2D) {
/* 27 */       ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*    */     }
/* 29 */     Dimension d = getSize();
/* 30 */     g.setColor(getForeground());
/*    */     
/* 32 */     if (d.getHeight() < 10.0D || d.getWidth() < 10.0D) {
/* 33 */       g.fillRect(0, 0, d.width, d.height);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 38 */     if (d.getHeight() > d.getWidth()) {
/* 39 */       circleSize = (int)d.getWidth();
/* 40 */       y = (int)(circleSize * 0.8D);
/* 41 */       width = (int)(d.getWidth() / 2.5D);
/* 42 */       height = (int)d.getHeight() - y;
/* 43 */       x = width;
/* 44 */       arc = x;
/*    */     } else {
/*    */       
/* 47 */       circleSize = (int)d.getHeight();
/* 48 */       x = (int)(circleSize * 0.8D);
/* 49 */       width = (int)d.getWidth() - x;
/* 50 */       height = (int)(d.getHeight() / 2.5D);
/* 51 */       y = height;
/* 52 */       arc = y;
/*    */     } 
/*    */     
/* 55 */     g.fillOval(0, 0, circleSize, circleSize);
/* 56 */     g.fillRoundRect(x, y, width, height, arc, arc);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\PosRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */