/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.pos.framework.ui.listview.config.ViewElementFactory;
/*    */ import dtv.ui.model.DefaultCombinedTableModel;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import javax.swing.table.TableCellRenderer;
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
/*    */ 
/*    */ public class DefaultXstTableModel
/*    */   extends DefaultCombinedTableModel
/*    */ {
/*    */   public DefaultXstTableModel() {
/* 25 */     this(0, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DefaultXstTableModel(int argRows, int argColumns) {
/* 35 */     super(argRows, argColumns);
/*    */     
/* 37 */     setCellRenderer((TableCellRenderer)ViewElementFactory.getInstance(), 0, 0);
/* 38 */     setRowHeaderCellRenderer((ListCellRenderer)ViewElementFactory.getInstance());
/* 39 */     setColumnHeaderCellRenderer((TableCellRenderer)ViewElementFactory.getInstance());
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValues(Object[][] values, Object[] columnHeaders) {
/* 44 */     super.setValues(values, columnHeaders);
/* 45 */     setColumnHeaderCellRenderer((TableCellRenderer)ViewElementFactory.getInstance());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\DefaultXstTableModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */