/*    */ package dtv.pos.framework.form.design;
/*    */ 
/*    */ import dtv.pos.framework.form.design.model.PropertyEditTableModel;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class PropertyEditTable
/*    */   extends JTable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private static final Logger logger_ = Logger.getLogger(PropertyEditTable.class);
/*    */ 
/*    */   
/*    */   public TableCellEditor getCellEditor(int argRow, int argColumn) {
/* 28 */     if (this.dataModel instanceof PropertyEditTableModel) {
/* 29 */       return getDefaultEditor(((PropertyEditTableModel)this.dataModel).getCellClass(argRow, argColumn));
/*    */     }
/*    */     
/* 32 */     return super.getCellEditor(argRow, argColumn);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TableCellRenderer getCellRenderer(int argRow, int argColumn) {
/*    */     TableCellRenderer renderer;
/* 40 */     if (this.dataModel instanceof PropertyEditTableModel) {
/* 41 */       Class<?> c = ((PropertyEditTableModel)this.dataModel).getCellClass(argRow, argColumn);
/* 42 */       renderer = getDefaultRenderer(c);
/* 43 */       if (renderer == null) {
/* 44 */         logger_.error("renderer is null for " + c);
/*    */       }
/*    */     } else {
/*    */       
/* 48 */       renderer = super.getCellRenderer(argRow, argColumn);
/*    */     } 
/* 50 */     if (renderer == null) {
/* 51 */       logger_.error("renderer is null for row:" + argRow + ", col:" + argColumn + " in " + getClass());
/*    */     }
/* 53 */     return renderer;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\PropertyEditTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */