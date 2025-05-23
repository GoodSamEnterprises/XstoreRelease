/*     */ package dtv.pos.framework.form.design;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.RepaintManager;
/*     */ import javax.swing.UIManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GlassPanel
/*     */   extends JComponent
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  23 */   private static final Logger logger_ = Logger.getLogger(GlassPanel.class);
/*     */   
/*  25 */   private static final Dimension DEFAULT_SIZE = new Dimension(0, 0);
/*     */ 
/*     */ 
/*     */   
/*  29 */   private static final Color SELECTION_BORDER_COLOR = UIManager.getColor("EditorPane.selectionBackground");
/*  30 */   private static final Color SELECTION_BOX_COLOR = new Color(SELECTION_BORDER_COLOR
/*  31 */       .getRed(), SELECTION_BORDER_COLOR.getGreen(), SELECTION_BORDER_COLOR
/*  32 */       .getBlue(), 100);
/*     */ 
/*     */   
/*  35 */   private JComponent associate_ = null;
/*  36 */   private Rectangle selectedComponent_ = null;
/*     */   
/*     */   public GlassPanel() {
/*  39 */     setOpaque(false);
/*  40 */     setFocusable(true);
/*     */   }
/*     */   
/*     */   public JComponent getAssociate() {
/*  44 */     return this.associate_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getMaximumSize() {
/*  49 */     return (getAssociate() == null) ? DEFAULT_SIZE : getAssociate().getMaximumSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getMinimumSize() {
/*  54 */     return (getAssociate() == null) ? DEFAULT_SIZE : getAssociate().getMinimumSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getPreferredSize() {
/*  59 */     return (getAssociate() == null) ? DEFAULT_SIZE : getAssociate().getPreferredSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getSize() {
/*  64 */     return (getAssociate() == null) ? DEFAULT_SIZE : getAssociate().getSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  69 */     if (this.selectedComponent_ != null) {
/*  70 */       g.setColor(SELECTION_BORDER_COLOR);
/*  71 */       g.drawRect((int)this.selectedComponent_.getX(), (int)this.selectedComponent_.getY(), 
/*  72 */           (int)this.selectedComponent_.getWidth(), (int)this.selectedComponent_.getHeight());
/*  73 */       g.setColor(SELECTION_BOX_COLOR);
/*  74 */       g.fillRect((int)this.selectedComponent_.getX(), (int)this.selectedComponent_.getY(), 
/*  75 */           (int)this.selectedComponent_.getWidth(), (int)this.selectedComponent_.getHeight());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAssociate(JComponent newValue) {
/*  81 */     this.selectedComponent_ = null;
/*  82 */     this.associate_ = newValue;
/*  83 */     this.associate_.setBounds(getBounds());
/*  84 */     invalidate();
/*  85 */     RepaintManager.currentManager(this).markCompletelyDirty(this);
/*     */   }
/*     */   
/*     */   public void setSelected(Component c) {
/*  89 */     markSelectedDirty();
/*  90 */     this.selectedComponent_ = null;
/*  91 */     if (c != null) {
/*     */       try {
/*  93 */         if (!c.isShowing()) {
/*  94 */           Component parent = c.getParent();
/*  95 */           Component grandpa = parent.getParent();
/*  96 */           if (grandpa instanceof JTabbedPane) {
/*  97 */             ((JTabbedPane)grandpa).setSelectedComponent(parent);
/*     */           }
/*     */         } else {
/*     */           
/* 101 */           Point p1 = getLocationOnScreen();
/* 102 */           Point p2 = c.getLocationOnScreen();
/* 103 */           this
/*     */             
/* 105 */             .selectedComponent_ = new Rectangle((int)p2.getX() - (int)p1.getX(), (int)p2.getY() - (int)p1.getY(), c.getWidth(), c.getHeight());
/*     */         }
/*     */       
/* 108 */       } catch (Exception ex) {
/* 109 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/* 112 */     markSelectedDirty();
/*     */   }
/*     */   
/*     */   private void markSelectedDirty() {
/* 116 */     if (this.selectedComponent_ != null)
/* 117 */       RepaintManager.currentManager(this).addDirtyRegion(this, (int)this.selectedComponent_.getMinX() - 2, 
/* 118 */           (int)this.selectedComponent_.getMinY() - 2, (int)this.selectedComponent_.getWidth() + 5, 
/* 119 */           (int)this.selectedComponent_.getHeight() + 5); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\GlassPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */