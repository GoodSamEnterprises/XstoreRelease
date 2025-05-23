/*    */ package dtv.pos.framework.form.design.text;
/*    */ 
/*    */ import dtv.pos.iframework.ui.config.IDataFieldConfig;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.JTree;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ import javax.swing.tree.TreeCellRenderer;
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
/*    */ public class DataFieldConfigCellRenderer
/*    */   extends JLabel
/*    */   implements TableCellRenderer, TreeCellRenderer
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
/* 30 */     IDataFieldConfig config = (IDataFieldConfig)value;
/* 31 */     setText(config);
/* 32 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
/* 39 */     IDataFieldConfig config = (IDataFieldConfig)value;
/* 40 */     setText(config);
/* 41 */     return this;
/*    */   }
/*    */   
/*    */   private void setText(IDataFieldConfig argConfig) {
/* 45 */     if (argConfig == null) {
/* 46 */       setText("");
/*    */     } else {
/*    */       
/* 49 */       setText(argConfig.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\text\DataFieldConfigCellRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */