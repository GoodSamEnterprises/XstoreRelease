/*    */ package dtv.pos.framework.form.design.color;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.Icon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorIcon
/*    */   implements Icon
/*    */ {
/*    */   protected static final int DEFAULT_SIZE = 32;
/*    */   protected static final int BORDER_SIZE = 2;
/*    */   protected Color color_;
/*    */   protected Color shadowColor_;
/*    */   protected int width_;
/*    */   protected int height_;
/*    */   protected int borderSize_;
/*    */   protected int fillHeight_;
/*    */   protected int fillWidth_;
/*    */   
/*    */   public ColorIcon(Color color) {
/* 26 */     this(color, 32, 32, 2);
/*    */   }
/*    */   
/*    */   public ColorIcon(Color color, int size) {
/* 30 */     this(color, size, size, 2);
/*    */   }
/*    */   
/*    */   public ColorIcon(Color color, int width, int height, int borderSize) {
/* 34 */     this.color_ = color;
/* 35 */     this.width_ = width;
/* 36 */     this.height_ = height;
/* 37 */     this.borderSize_ = borderSize;
/* 38 */     this.shadowColor_ = Color.black;
/* 39 */     this.fillHeight_ = height - 2 * borderSize;
/* 40 */     this.fillWidth_ = width - 2 * borderSize;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIconHeight() {
/* 46 */     return this.height_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIconWidth() {
/* 51 */     return this.width_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void paintIcon(Component comp, Graphics g, int x, int y) {
/* 56 */     Color c = g.getColor();
/* 57 */     if (this.borderSize_ > 0) {
/* 58 */       g.setColor(this.shadowColor_);
/* 59 */       for (int i = 0; i < this.borderSize_; i++) {
/* 60 */         g.drawRect(x + i, y + i, this.width_ - 2 * i - 1, this.height_ - 2 * i - 1);
/*    */       }
/*    */     } 
/*    */     
/* 64 */     g.setColor(this.color_);
/* 65 */     g.fillRect(x + this.borderSize_, y + this.borderSize_, this.fillWidth_, this.fillHeight_);
/* 66 */     g.setColor(c);
/*    */   }
/*    */   
/*    */   public void setColor(Color c) {
/* 70 */     this.color_ = c;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\color\ColorIcon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */