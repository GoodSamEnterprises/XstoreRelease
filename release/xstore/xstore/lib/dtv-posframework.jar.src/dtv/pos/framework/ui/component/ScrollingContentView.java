/*     */ package dtv.pos.framework.ui.component;
/*     */ 
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosPanel;
/*     */ import dtv.ui.swing.DtvScrollPane;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.Scrollable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScrollingContentView
/*     */   extends PosPanel
/*     */   implements IXstViewComponent, Scrollable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final JScrollPane scrollPane_;
/*     */   private int unitIncrement_;
/*     */   private int blockIncrement_;
/*     */   
/*     */   public ScrollingContentView() {
/*  39 */     this.scrollPane_ = (JScrollPane)new DtvScrollPane();
/*  40 */     this.unitIncrement_ = -1;
/*  41 */     this.blockIncrement_ = -1;
/*     */     
/*  43 */     setLayout(new BoxLayout((Container)this, 1));
/*  44 */     this.scrollPane_.setViewportView((Component)this);
/*  45 */     this.scrollPane_.setVerticalScrollBarPolicy(20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureRowIsVisible(int argRow) {
/*  54 */     Rectangle rowBounds = new Rectangle(0, this.unitIncrement_ * argRow, 0, this.unitIncrement_);
/*  55 */     scrollRectToVisible(rowBounds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  68 */     return this.scrollPane_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  79 */     return (JComponent)this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getPreferredScrollableViewportSize() {
/*  88 */     return getPreferredSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
/* 102 */     return this.blockIncrement_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getScrollableTracksViewportHeight() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getScrollableTracksViewportWidth() {
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
/* 142 */     return this.unitIncrement_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockIncrement(int argBlockIncrement) {
/* 152 */     this.blockIncrement_ = argBlockIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnitIncrement(int argUnitIncrement) {
/* 162 */     this.unitIncrement_ = argUnitIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 171 */     if (this.blockIncrement_ <= 0) {
/* 172 */       this.blockIncrement_ = this.scrollPane_.getViewport().getHeight();
/*     */     }
/* 174 */     super.paintComponent(g);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\component\ScrollingContentView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */