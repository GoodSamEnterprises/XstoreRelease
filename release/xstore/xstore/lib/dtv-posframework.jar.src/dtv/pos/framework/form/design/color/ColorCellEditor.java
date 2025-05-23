/*    */ package dtv.pos.framework.form.design.color;
/*    */ 
/*    */ import dtv.ui.UIServices;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.AbstractCellEditor;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorCellEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor, ChangeListener
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private ColorChooserPopup chooser_;
/* 26 */   private final JLabel label_ = new JLabel();
/*    */ 
/*    */   
/*    */   public Object getCellEditorValue() {
/* 30 */     return this.chooser_.getColor();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
/* 36 */     this.chooser_ = new ColorChooserPopup((value == null) ? Color.BLACK : (Color)value);
/* 37 */     this.chooser_.addColorChangeListener(this);
/* 38 */     Rectangle rect = table.getCellRect(row, col, false);
/* 39 */     this.chooser_.show(table, (int)rect.getX(), (int)rect.getY());
/*    */     
/* 41 */     final ColorChooserPopup chooser = this.chooser_;
/* 42 */     UIServices.invoke(new Runnable()
/*    */         {
/*    */           public void run() {
/* 45 */             chooser.setVisible(true);
/*    */           }
/*    */         },  false, false);
/* 48 */     return this.label_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void stateChanged(ChangeEvent evt) {
/* 53 */     stopCellEditing();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\color\ColorCellEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */