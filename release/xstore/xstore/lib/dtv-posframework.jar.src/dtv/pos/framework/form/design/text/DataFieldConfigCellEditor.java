/*    */ package dtv.pos.framework.form.design.text;
/*    */ 
/*    */ import dtv.pos.framework.ui.config.DataFieldConfig;
/*    */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
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
/*    */ public class DataFieldConfigCellEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor, ChangeListener
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private DataFieldConfigPopup editPanel_;
/* 30 */   private final JLabel label_ = new JLabel();
/*    */ 
/*    */   
/*    */   public Object getCellEditorValue() {
/* 34 */     return this.editPanel_.getDataFieldConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTableCellEditorComponent(JTable table, Object argValue, boolean isSelected, int row, int column) {
/* 40 */     this.editPanel_ = new DataFieldConfigPopup();
/* 41 */     Object value = (argValue == null) ? new DataFieldConfig() : argValue;
/* 42 */     this.editPanel_.setDataFieldConfig((IDataFieldConfig)value);
/* 43 */     this.editPanel_.addChangeListener(this);
/* 44 */     Rectangle rect = table.getCellRect(row, column, false);
/* 45 */     this.editPanel_.show(table, rect);
/* 46 */     return this.label_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void stateChanged(ChangeEvent evt) {
/* 51 */     stopCellEditing();
/* 52 */     this.label_.setText("" + getCellEditorValue());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\text\DataFieldConfigCellEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */