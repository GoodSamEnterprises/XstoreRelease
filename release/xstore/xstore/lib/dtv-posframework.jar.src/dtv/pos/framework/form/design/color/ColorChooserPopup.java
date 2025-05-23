/*    */ package dtv.pos.framework.form.design.color;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.AbstractAction;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JColorChooser;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JPopupMenu;
/*    */ import javax.swing.colorchooser.ColorSelectionModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorChooserPopup
/*    */   extends JPopupMenu
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private static JColorChooser chooser_ = new JColorChooser();
/*    */   
/*    */   protected ColorSelectionModel model_;
/*    */   protected ChangeListener listener_;
/* 31 */   private final Action okAction_ = new AbstractAction("OK")
/*    */     {
/*    */       private static final long serialVersionUID = 1L;
/*    */       
/*    */       public void actionPerformed(ActionEvent actionEvent) {
/* 36 */         ColorChooserPopup.this.listener_.stateChanged(new ChangeEvent(this));
/* 37 */         ColorChooserPopup.this.setVisible(false);
/*    */       }
/*    */     };
/*    */   
/* 41 */   private final Action clearAction_ = new AbstractAction("Clear")
/*    */     {
/*    */       private static final long serialVersionUID = 1L;
/*    */       
/*    */       public void actionPerformed(ActionEvent actionEvent) {
/* 46 */         ColorChooserPopup.this.model_ = null;
/* 47 */         ColorChooserPopup.this.listener_.stateChanged(new ChangeEvent(this));
/* 48 */         ColorChooserPopup.this.setVisible(false);
/*    */       }
/*    */     };
/*    */   
/*    */   public ColorChooserPopup(Color selectedColor) {
/* 53 */     chooser_.setColor(selectedColor);
/* 54 */     this.model_ = chooser_.getSelectionModel();
/* 55 */     add(chooser_);
/*    */     
/* 57 */     JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
/* 58 */     buttonPanel.add(new JButton(this.okAction_));
/* 59 */     buttonPanel.add(new JButton(this.clearAction_));
/* 60 */     add(buttonPanel);
/*    */     
/* 62 */     pack();
/*    */   }
/*    */   
/*    */   public void addColorChangeListener(ChangeListener argListener) {
/* 66 */     this.listener_ = argListener;
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 70 */     if (this.model_ == null) {
/* 71 */       return null;
/*    */     }
/* 73 */     return this.model_.getSelectedColor();
/*    */   }
/*    */   
/*    */   public void setColor(Color c) {
/* 77 */     if (this.model_ == null) {
/* 78 */       this.model_ = chooser_.getSelectionModel();
/*    */     }
/* 80 */     this.model_.setSelectedColor(c);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\color\ColorChooserPopup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */