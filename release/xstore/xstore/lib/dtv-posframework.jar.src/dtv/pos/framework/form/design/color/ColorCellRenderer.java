/*    */ package dtv.pos.framework.form.design.color;
/*    */ 
/*    */ import java.awt.Color;
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
/*    */ public class ColorCellRenderer
/*    */   extends JLabel
/*    */   implements TableCellRenderer, TreeCellRenderer
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
/* 29 */     Color c = (Color)value;
/* 30 */     setIcon(c, table.getRowHeight(row));
/* 31 */     setText(c);
/* 32 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
/* 39 */     Color c = (value == null) ? Color.white : (Color)value;
/* 40 */     setIcon(c, tree.getRowHeight());
/* 41 */     setText(c);
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   private void setIcon(Color c, int size) {
/* 46 */     if (c == null) {
/* 47 */       setIcon(null);
/*    */     } else {
/*    */       
/* 50 */       setIcon(new ColorIcon(c, size));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void setText(Color c) {
/* 56 */     if (c == null) {
/* 57 */       setText("");
/*    */     } else {
/*    */       
/* 60 */       setText("[r=" + c.getRed() + ",g=" + c.getGreen() + ",b=" + c.getBlue() + "]");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\color\ColorCellRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */