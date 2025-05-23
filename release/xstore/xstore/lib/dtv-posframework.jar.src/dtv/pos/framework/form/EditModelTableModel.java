/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.FormatterFactory;
/*     */ import dtv.i18n.IFormatter;
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.iframework.form.IEditModelTableModelAdapter;
/*     */ import dtv.pos.ui.model.IExtendedTableModel;
/*     */ import dtv.pos.ui.text.TextFieldInputType;
/*     */ import java.util.Date;
/*     */ import java.util.EventListener;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import javax.swing.event.TableModelEvent;
/*     */ import javax.swing.event.TableModelListener;
/*     */ import javax.swing.table.TableModel;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EditModelTableModel
/*     */   implements IExtendedTableModel
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(EditModelTableModel.class);
/*     */ 
/*     */   
/*  30 */   protected final EventListenerList listenerList_ = new EventListenerList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Map<Class<?>, TextFieldInputType> editFormatMap_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Map<Class<?>, IFormatter> viewFormatMap_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IEditModelTableModelAdapter adapter_;
/*     */ 
/*     */ 
/*     */   
/*     */   private int rowCount_;
/*     */ 
/*     */ 
/*     */   
/*     */   private int columnCount_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EditModelTableModel(IEditModelTableModelAdapter argAdapter) {
/*  57 */     if (argAdapter == null) {
/*  58 */       throw new NullPointerException();
/*     */     }
/*  60 */     this.adapter_ = argAdapter;
/*  61 */     updateColumnCount();
/*  62 */     updateRowCount();
/*  63 */     this.editFormatMap_ = makeEditFormatMap();
/*  64 */     this.viewFormatMap_ = makeViewFormatMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow() {
/*  72 */     logger_.debug("adding row...");
/*  73 */     if (!this.adapter_.isRowAddingAllowed()) {
/*  74 */       if (logger_.isDebugEnabled()) {
/*  75 */         logger_.debug("row adding not allowed", new Throwable("STACK TRACE"));
/*     */       }
/*     */     } else {
/*     */       
/*  79 */       int newRowIndex = this.adapter_.addRow();
/*  80 */       if (newRowIndex > -1) {
/*  81 */         fireTableRowsInserted(newRowIndex, newRowIndex);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTableModelListener(TableModelListener l) {
/*  96 */     this.listenerList_.add(TableModelListener.class, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableCellUpdated(int row, int column) {
/* 108 */     fireTableChanged(new TableModelEvent((TableModel)this, row, row, column));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableChanged(TableModelEvent e) {
/* 122 */     updateRowCount();
/* 123 */     updateColumnCount();
/*     */     
/* 125 */     TableModelListener[] listeners = getTableModelListeners();
/*     */     
/* 127 */     if (listeners != null) {
/* 128 */       for (TableModelListener listener : listeners) {
/* 129 */         listener.tableChanged(e);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableDataChanged() {
/* 144 */     fireTableChanged(new TableModelEvent((TableModel)this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableRowsDeleted(int firstRow, int lastRow) {
/* 158 */     fireTableChanged(new TableModelEvent((TableModel)this, firstRow, lastRow, -1, -1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableRowsInserted(int firstRow, int lastRow) {
/* 174 */     fireTableChanged(new TableModelEvent((TableModel)this, firstRow, lastRow, -1, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableRowsUpdated(int firstRow, int lastRow) {
/* 189 */     fireTableChanged(new TableModelEvent((TableModel)this, firstRow, lastRow, -1, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireTableStructureChanged() {
/* 204 */     fireTableChanged(new TableModelEvent((TableModel)this, -1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCellClass(int rowIndex, int columnIndex) {
/* 217 */     return this.adapter_.getColumnClass(columnIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getColumnClass(int columnIndex) {
/* 222 */     return this.adapter_.getColumnClass(columnIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 234 */     return this.columnCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumnName(int columnIndex) {
/* 246 */     return this.adapter_.getColumnName(columnIndex).toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextFieldInputType getEditFormat(int rowIndex, int columnIndex) {
/* 259 */     Class<?> c = getCellClass(rowIndex, columnIndex);
/* 260 */     TextFieldInputType ft = this.editFormatMap_.get(c);
/* 261 */     if (ft != null) {
/* 262 */       return ft;
/*     */     }
/* 264 */     if (!c.equals(Object.class)) {
/* 265 */       ft = this.editFormatMap_.get(c.getSuperclass());
/*     */     }
/* 267 */     if (ft != null) {
/* 268 */       return ft;
/*     */     }
/*     */     
/* 271 */     return TextFieldInputType.SIMPLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getEnumeratedPossibleValues(int rowIndex, int columnIndex) {
/* 285 */     return this.adapter_.getEnumeratedPossibleValuesAt(columnIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventListener[] getListeners(Class<? extends EventListener> listenerType) {
/* 316 */     return this.listenerList_.getListeners((Class)listenerType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 328 */     return this.rowCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableModelListener[] getTableModelListeners() {
/* 341 */     return this.listenerList_.<TableModelListener>getListeners(TableModelListener.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex) {
/* 353 */     return this.adapter_.getValueAt(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFormatter getViewFormatter(int rowIndex, int columnIndex) {
/* 366 */     Class<?> c = getCellClass(rowIndex, columnIndex);
/* 367 */     IFormatter formatter = this.viewFormatMap_.get(c);
/* 368 */     if (formatter != null) {
/* 369 */       return formatter;
/*     */     }
/* 371 */     if (!c.equals(Object.class)) {
/* 372 */       formatter = this.viewFormatMap_.get(c.getSuperclass());
/*     */     }
/* 374 */     if (formatter != null) {
/* 375 */       return formatter;
/*     */     }
/*     */     
/* 378 */     return IFormatter.DEFAULT_FORMATTER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 397 */     return this.adapter_.isCellEditable(rowIndex, columnIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRowAddingAllowed() {
/* 407 */     return this.adapter_.isRowAddingAllowed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTableModelListener(TableModelListener l) {
/* 417 */     this.listenerList_.remove(TableModelListener.class, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
/*     */     try {
/* 432 */       this.adapter_.setValueAt(aValue, rowIndex, columnIndex);
/*     */       
/* 434 */       fireTableCellUpdated(rowIndex, columnIndex);
/*     */     }
/* 436 */     catch (Exception ex) {
/* 437 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<Class<?>, TextFieldInputType> makeEditFormatMap() {
/* 448 */     Map<Class<?>, TextFieldInputType> m = new HashMap<>();
/* 449 */     m.put(Date.class, TextFieldInputType.DATE);
/*     */     
/* 451 */     m.put(Number.class, TextFieldInputType.DECIMAL);
/* 452 */     return m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<Class<?>, IFormatter> makeViewFormatMap() {
/* 462 */     Map<Class<?>, IFormatter> m = new HashMap<>();
/* 463 */     m.put(Date.class, FormatterFactory.getInstance().getDateMediumFormatter());
/*     */     
/* 465 */     m.put(Number.class, FormatterFactory.getInstance().getDecimalFormatter());
/* 466 */     return m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateColumnCount() {
/* 474 */     this.columnCount_ = this.adapter_.getColumnCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateRowCount() {
/* 482 */     this.rowCount_ = this.adapter_.getValues().size();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\EditModelTableModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */