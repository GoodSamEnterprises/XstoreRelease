/*     */ package dtv.pos.framework.form.component;
/*     */ 
/*     */ import com.micros.xstore.config.form.field.FormParameterTypeEnumeration;
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.form.DefaultEditModelTableModelAdapter;
/*     */ import dtv.pos.framework.form.EditModelTableModel;
/*     */ import dtv.pos.framework.ui.component.XstTable;
/*     */ import dtv.pos.framework.ui.config.ResolvedFieldConfig;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelTableModelAdapter;
/*     */ import dtv.pos.iframework.form.IListFieldElementDescr;
/*     */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*     */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*     */ import dtv.pos.iframework.form.config.ITableColumnsConfig;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.pos.iframework.ui.ScrollingPolicy;
/*     */ import dtv.pos.iframework.ui.config.IRendererDefConfig;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.ui.swing.DtvScrollTable;
/*     */ import dtv.ui.swing.DtvTable;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.ListSelectionModel;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormTable<T extends IFormModel>
/*     */   extends AbstractFormComponent<T>
/*     */ {
/*  44 */   private static final Logger logger_ = Logger.getLogger(FormTable.class);
/*     */   
/*     */   protected final DtvScrollTable scrollTable_;
/*     */   
/*     */   protected DtvTable table_;
/*     */   
/*     */   protected XstTable xstTable_;
/*     */   protected EditModelTableModel tableModel_;
/*     */   private TableColumnModel columnModel_;
/*     */   private IEditModelTableModelAdapter modelAdapter_;
/*  54 */   int lastSelectedRow_ = -1;
/*  55 */   int lastSelectedColumn_ = -1;
/*     */   
/*     */   boolean everFocused_ = false;
/*     */   private RendererDef ulCornerDef_;
/*     */   
/*  60 */   private final ListSelectionListener rowSelectionListener_ = new ListSelectionListener()
/*     */     {
/*     */       public void valueChanged(ListSelectionEvent argEvent)
/*     */       {
/*  64 */         if (!argEvent.getValueIsAdjusting()) {
/*  65 */           FormTable.this.lastSelectedRow_ = ((ListSelectionModel)argEvent.getSource()).getLeadSelectionIndex();
/*  66 */           if (FormTable.this.lastSelectedRow_ < 0)
/*  67 */             FormTable.this.lastSelectedRow_ = argEvent.getLastIndex(); 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*  72 */   private final ListSelectionListener columnSelectionListener_ = new ListSelectionListener()
/*     */     {
/*     */       public void valueChanged(ListSelectionEvent argEvent)
/*     */       {
/*  76 */         if (!argEvent.getValueIsAdjusting()) {
/*  77 */           FormTable.this.lastSelectedColumn_ = ((ListSelectionModel)argEvent.getSource()).getLeadSelectionIndex();
/*  78 */           if (FormTable.this.lastSelectedColumn_ < 0) {
/*  79 */             FormTable.this.lastSelectedColumn_ = argEvent.getLastIndex();
/*     */           }
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public FormTable() {
/*  87 */     this.xstTable_ = new XstTable();
/*  88 */     this.scrollTable_ = this.xstTable_.getScrollTableComponent();
/*  89 */     this.scrollTable_.setVerticalScrollBarPolicy(20);
/*  90 */     this.table_ = this.scrollTable_.getTableComponent();
/*     */     
/*  92 */     this.table_.setRowSelectionAllowed(true);
/*  93 */     this.table_.setColumnSelectionAllowed(true);
/*  94 */     this.table_.setSelectionMode(0);
/*     */     
/*  96 */     setComponent((JComponent)this.scrollTable_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/* 102 */     return (JComponent)this.table_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(IFormComponentConfig<?> argCfg) {
/* 109 */     super.init(argCfg);
/*     */     
/* 111 */     this.table_.setFocusable(!this.readOnly_);
/*     */ 
/*     */     
/* 114 */     IFormViewCellConfig config = (IFormViewCellConfig)argCfg;
/*     */     
/* 116 */     ScrollingPolicy policy = config.getHorizontalScrollingPolicy();
/* 117 */     if (policy != null) {
/* 118 */       this.scrollTable_.setHorizontalScrollBarPolicy(policy.getHorizontalValue());
/*     */     }
/* 120 */     policy = config.getVerticalScrollingPolicy();
/* 121 */     if (policy != null) {
/* 122 */       this.scrollTable_.setVerticalScrollBarPolicy(policy.getVerticalValue());
/*     */     }
/* 124 */     ITableColumnsConfig columnConfig = config.getTableColumnsConfig();
/*     */     
/* 126 */     if (columnConfig == null) {
/* 127 */       IRendererDefConfig cellDef = config.getRendererDef("Cell");
/* 128 */       IRendererDefConfig alternateCellDef = config.getRendererDef("AlternateCell");
/* 129 */       IRendererDefConfig columnHeaderDef = config.getRendererDef("ColumnHeader");
/* 130 */       IRendererDefConfig rowHeaderDef = config.getRendererDef("RowHeader");
/* 131 */       IRendererDefConfig uppperLeftDef = config.getRendererDef("UpperLeft");
/*     */       
/* 133 */       if (cellDef != null) {
/* 134 */         this.xstTable_.setCellRendererDef(cellDef.toRendererDef());
/*     */       }
/* 136 */       if (alternateCellDef != null) {
/* 137 */         this.xstTable_.setAlternateCellRendererDef(alternateCellDef.toRendererDef());
/*     */       }
/* 139 */       if (columnHeaderDef != null) {
/* 140 */         this.xstTable_.setColumnHeaderRendererDef(columnHeaderDef.toRendererDef());
/*     */       }
/* 142 */       if (rowHeaderDef != null) {
/* 143 */         this.xstTable_.setRowHeaderRendererDef(rowHeaderDef.toRendererDef());
/*     */       }
/* 145 */       if (uppperLeftDef != null) {
/* 146 */         this.ulCornerDef_ = uppperLeftDef.toRendererDef();
/* 147 */         this.xstTable_.setCornerRendererDef("UPPER_LEFT_CORNER", this.ulCornerDef_);
/*     */       } 
/*     */     } else {
/*     */       
/* 151 */       this.columnModel_ = columnConfig.getTableColumnModel();
/* 152 */       DtvTable table = this.scrollTable_.getTableComponent();
/* 153 */       setColumns((JTable)table);
/* 154 */       table.setRowHeight(table.getRowHeight() * 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ResolvedFieldConfig argFieldDef) {
/* 161 */     super.init(argFieldDef);
/*     */     
/* 163 */     this.table_.setFocusable(!this.readOnly_);
/*     */     
/* 165 */     String cellType = argFieldDef.getParameter(FormParameterTypeEnumeration.CELL_TYPE.value());
/* 166 */     String cellRuleList = argFieldDef.getParameter(FormParameterTypeEnumeration.CELL_RULE_SET.value());
/* 167 */     if (!StringUtils.isEmpty(cellType) || !StringUtils.isEmpty(cellRuleList)) {
/* 168 */       RendererDef renderer = new RendererDef(false, cellRuleList, ViewElementType.valueOf(cellType));
/* 169 */       this.xstTable_.setCellRendererDef(renderer);
/*     */     } 
/*     */ 
/*     */     
/* 173 */     String alternativeCellType = argFieldDef.getParameter(FormParameterTypeEnumeration.ALTERNATE_CELL_TYPE.value());
/* 174 */     if (!StringUtils.isEmpty(alternativeCellType)) {
/* 175 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(alternativeCellType));
/* 176 */       this.xstTable_.setAlternateCellRendererDef(renderer);
/*     */     } 
/*     */ 
/*     */     
/* 180 */     String columnHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.COLUMN_HEADER_TYPE.value());
/* 181 */     if (!StringUtils.isEmpty(columnHeaderType)) {
/* 182 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(columnHeaderType));
/* 183 */       this.xstTable_.setColumnHeaderRendererDef(renderer);
/*     */     } 
/*     */     
/* 186 */     String rowHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.ROW_HEADER_TYPE.value());
/* 187 */     if (!StringUtils.isEmpty(rowHeaderType)) {
/* 188 */       RendererDef renderer = new RendererDef(false, null, ViewElementType.valueOf(rowHeaderType));
/* 189 */       this.xstTable_.setRowHeaderRendererDef(renderer);
/*     */     } 
/*     */ 
/*     */     
/* 193 */     String upperLeftHeaderType = argFieldDef.getParameter(FormParameterTypeEnumeration.UPPER_LEFT_CELL_TYPE.value());
/* 194 */     if (!StringUtils.isEmpty(upperLeftHeaderType)) {
/* 195 */       this.ulCornerDef_ = new RendererDef(false, null, ViewElementType.valueOf(upperLeftHeaderType));
/* 196 */       this.xstTable_.setCornerRendererDef("UPPER_LEFT_CORNER", this.ulCornerDef_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getComponentValue() {
/* 203 */     if (this.modelAdapter_ != null) {
/* 204 */       return this.modelAdapter_.getValues();
/*     */     }
/* 206 */     return this.scrollTable_.getTableComponent().getModel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initNewModelState(T argOldModel, T argNewModel) {
/* 212 */     super.initNewModelState(argOldModel, argNewModel);
/* 213 */     ensureSingleSelection();
/*     */ 
/*     */     
/* 216 */     if (argOldModel != argNewModel) {
/* 217 */       this.table_.getSelectionModel().removeListSelectionListener(this.rowSelectionListener_);
/* 218 */       this.table_.getColumnModel().getSelectionModel().removeListSelectionListener(this.columnSelectionListener_);
/*     */       
/* 220 */       this.table_.getSelectionModel().addListSelectionListener(this.rowSelectionListener_);
/* 221 */       this.table_.getColumnModel().getSelectionModel().addListSelectionListener(this.columnSelectionListener_);
/* 222 */       this.lastSelectedRow_ = -1;
/* 223 */       this.lastSelectedColumn_ = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setComponentValue(Object value) {
/* 230 */     if (this.modelAdapter_ == null) {
/* 231 */       if (value instanceof TableModel) {
/* 232 */         this.xstTable_.setModel((TableModel)value);
/*     */         
/* 234 */         if (this.ulCornerDef_ != null) {
/* 235 */           this.xstTable_.setCornerRendererDef("UPPER_LEFT_CORNER", this.ulCornerDef_);
/*     */         }
/*     */       } else {
/*     */         
/* 239 */         logger_.warn("unexpected value " + value);
/*     */       }
/*     */     
/* 242 */     } else if (!(value instanceof List)) {
/*     */ 
/*     */ 
/*     */       
/* 246 */       logger_.warn("unexpected value " + value);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setModelImpl(T argOldModel, T argNewModel) {
/* 254 */     super.setModelImpl(argOldModel, argNewModel);
/*     */     
/* 256 */     IEditModel em = argNewModel.getEditModel();
/* 257 */     if (em != null) {
/* 258 */       Object o = em.getValue(this.fieldKey_);
/* 259 */       if (o instanceof TableModel) {
/* 260 */         this.xstTable_.setModel((TableModel)o);
/*     */       }
/* 262 */       else if (o instanceof List) {
/* 263 */         IListFieldElementDescr fed = em.getFieldElementDescriptor(this.fieldKey_);
/* 264 */         this.modelAdapter_ = (IEditModelTableModelAdapter)new DefaultEditModelTableModelAdapter(em, this.fieldKey_, (List)o, fed);
/* 265 */         this.modelAdapter_.setRowAddingAllowed((!this.readOnly_ && argNewModel.isEditable(this.fieldKey_)));
/*     */         
/* 267 */         this.tableModel_ = new EditModelTableModel(this.modelAdapter_);
/* 268 */         this.xstTable_.setModel((TableModel)this.tableModel_);
/*     */       } else {
/*     */         
/* 271 */         logger_.warn("bad field value " + o + " ... should implement " + List.class.getName());
/*     */       } 
/*     */     } else {
/*     */       
/* 275 */       logger_.warn("BAD MODEL??... null edit model");
/*     */     } 
/*     */     
/* 278 */     if (this.columnModel_ != null) {
/* 279 */       setColumns((JTable)this.table_);
/*     */     }
/*     */   }
/*     */   
/*     */   private void ensureSingleSelection() {
/* 284 */     if (this.table_.getColumnCount() > 0 && this.table_.getRowCount() > 0) {
/* 285 */       this.table_.addRowSelectionInterval(0, 0);
/* 286 */       this.table_.addColumnSelectionInterval(0, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setColumns(JTable table) {
/* 291 */     TableColumnModel m = table.getColumnModel();
/* 292 */     if (m == null) {
/* 293 */       table.setColumnModel(this.columnModel_);
/*     */     } else {
/*     */       
/* 296 */       while (m.getColumnCount() > 0) {
/* 297 */         m.removeColumn(m.getColumn(0));
/*     */       }
/* 299 */       for (Enumeration<TableColumn> e = this.columnModel_.getColumns(); e.hasMoreElements(); ) {
/* 300 */         TableColumn c = e.nextElement();
/* 301 */         m.addColumn(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class FormTableFocusListener
/*     */     extends FocusAdapter
/*     */   {
/*     */     public void focusGained(FocusEvent focusEvent) {
/* 312 */       int columnIndex = 0;
/* 313 */       int rowIndex = 0;
/* 314 */       FormTable.this.everFocused_ = true;
/*     */ 
/*     */       
/* 317 */       if (FormTable.this.lastSelectedRow_ >= 0 && FormTable.this.lastSelectedColumn_ >= 0) {
/* 318 */         rowIndex = FormTable.this.lastSelectedRow_;
/* 319 */         columnIndex = FormTable.this.lastSelectedColumn_;
/*     */       }
/* 321 */       else if (FormTable.this.tableModel_ != null) {
/* 322 */         if (FormTable.this.tableModel_.isRowAddingAllowed() && !FormTable.this.table_.isEditing()) {
/* 323 */           rowIndex = FormTable.this.table_.getRowCount() - 1;
/*     */           
/* 325 */           if (rowIndex >= 0) {
/* 326 */             for (columnIndex = 0; columnIndex < FormTable.this.table_.getColumnCount(); columnIndex++) {
/* 327 */               if (FormTable.this.table_.isCellEditable(rowIndex, columnIndex)) {
/* 328 */                 FormTable.this.table_.editCellAt(rowIndex, columnIndex);
/* 329 */                 if (FormTable.this.table_.getEditorComponent() != null) {
/* 330 */                   FormTable.this.table_.getEditorComponent().requestFocus();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/* 339 */       } else if (FormTable.this.table_.getColumnCount() > 0) {
/* 340 */         columnIndex = FormTable.this.table_.getCombinedModel().getColumnSelectionModel().getAnchorSelectionIndex();
/* 341 */         rowIndex = FormTable.this.table_.getCombinedModel().getRowSelectionModel().getAnchorSelectionIndex();
/*     */       } 
/*     */ 
/*     */       
/* 345 */       if (columnIndex < 0) {
/* 346 */         columnIndex = 0;
/*     */       }
/* 348 */       if (rowIndex < 0) {
/* 349 */         rowIndex = 0;
/*     */       }
/* 351 */       FormTable.this.table_.requestFocusInWindow();
/*     */       
/* 353 */       if (rowIndex < FormTable.this.table_.getRowCount()) {
/* 354 */         FormTable.this.table_.addRowSelectionInterval(rowIndex, rowIndex);
/*     */       }
/* 356 */       if (columnIndex < FormTable.this.table_.getColumnCount()) {
/* 357 */         FormTable.this.table_.addColumnSelectionInterval(columnIndex, columnIndex);
/*     */       }
/* 359 */       FormTable.this.table_.scrollRectToVisible(FormTable.this.table_.getCellRect(rowIndex, columnIndex, true));
/*     */       
/* 361 */       FormTable.this.lastSelectedRow_ = rowIndex;
/* 362 */       FormTable.this.lastSelectedColumn_ = columnIndex;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\component\FormTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */