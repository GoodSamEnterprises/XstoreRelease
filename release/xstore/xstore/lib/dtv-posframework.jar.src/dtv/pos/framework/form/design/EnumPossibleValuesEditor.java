/*    */ package dtv.pos.framework.form.design;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.EnumPossibleValues;
/*    */ import dtv.ui.UIServices;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumPossibleValuesEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor, ChangeListener
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 30 */   private final JLabel label_ = new JLabel();
/*    */   
/*    */   private EnumPossibleValuesPopup popup_;
/*    */ 
/*    */   
/*    */   public Object getCellEditorValue() {
/* 36 */     return this.popup_.getValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row, int col) {
/* 43 */     final Rectangle cellRect = table.getCellRect(row, col, false);
/* 44 */     this.popup_ = new EnumPossibleValuesPopup((EnumPossibleValues)value, cellRect);
/* 45 */     this.popup_.addValueChangeListener(this);
/* 46 */     final EnumPossibleValuesPopup popup = this.popup_;
/*    */     
/* 48 */     UIServices.invoke(new Runnable()
/*    */         {
/*    */           public void run()
/*    */           {
/* 52 */             popup.show(table, cellRect);
/*    */           }
/*    */         }false, false);
/*    */     
/* 56 */     return this.label_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void stateChanged(ChangeEvent evt) {
/* 61 */     stopCellEditing();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\EnumPossibleValuesEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */