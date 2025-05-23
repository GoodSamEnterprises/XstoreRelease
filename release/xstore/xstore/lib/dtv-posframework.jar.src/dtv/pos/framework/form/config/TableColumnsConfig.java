/*    */ package dtv.pos.framework.form.config;
/*    */ 
/*    */ import dtv.pos.iframework.form.config.ITableColumnConfig;
/*    */ import dtv.pos.iframework.form.config.ITableColumnsConfig;
/*    */ import dtv.pos.ui.component.PosTableColumn;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import dtv.util.config.ISavableConfig;
/*    */ import dtv.util.config.IXmlWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.swing.table.DefaultTableColumnModel;
/*    */ import javax.swing.table.TableColumn;
/*    */ import javax.swing.table.TableColumnModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TableColumnsConfig
/*    */   extends AbstractParentConfig
/*    */   implements ITableColumnsConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String MAIN_TAG = "columns";
/*    */   public static final String MAIN_DTYPE = "TableColumns";
/*    */   
/*    */   private static PosTableColumn makeColumn(ITableColumnConfig config) {
/*    */     int width;
/* 34 */     if (config.getWidth() == null) {
/* 35 */       width = 1000;
/*    */     } else {
/*    */       
/* 38 */       width = config.getWidth().intValue();
/*    */     } 
/* 40 */     return new PosTableColumn(config.getModelColumnIndex().intValue(), width, config.getHeader(), 
/* 41 */         !config.getReadOnly(), config.getViewFormatter(), config.getViewFormatType(), config
/* 42 */         .getEditFormatType());
/*    */   }
/*    */   
/* 45 */   private final List<ITableColumnConfig> columnConfigs_ = new ArrayList<>();
/*    */   
/*    */   public int getColumnCount() {
/* 48 */     return this.columnConfigs_.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public TableColumnModel getTableColumnModel() {
/* 53 */     TableColumnModel m = new DefaultTableColumnModel();
/* 54 */     for (int i = 0; i < this.columnConfigs_.size(); i++) {
/* 55 */       ITableColumnConfig c = this.columnConfigs_.get(i);
/* 56 */       m.addColumn((TableColumn)makeColumn(c));
/*    */     } 
/* 58 */     return m;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 63 */     if (argValue instanceof ITableColumnConfig) {
/* 64 */       this.columnConfigs_.add((ITableColumnConfig)argValue);
/*    */     } else {
/*    */       
/* 67 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(IXmlWriter argWriter) throws IOException {
/* 75 */     argWriter.writeHeader("columns", "TableColumns");
/*    */     
/* 77 */     for (int i = 0; i < this.columnConfigs_.size(); i++) {
/* 78 */       argWriter.writeValue((ISavableConfig)this.columnConfigs_.get(i));
/*    */     }
/*    */     
/* 81 */     argWriter.writeFooter("columns");
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\TableColumnsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */